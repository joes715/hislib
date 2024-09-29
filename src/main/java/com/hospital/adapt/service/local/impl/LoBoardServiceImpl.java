package com.hospital.adapt.service.local.impl;

import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.model.local.*;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.mapper.local.LbnBedMapper;
import com.hospital.adapt.mapper.local.LbnHisWardMapper;
import com.hospital.adapt.mapper.local.LbnPatientMapper;
import com.hospital.adapt.mapper.remote.RbnBoardMapper;
import com.hospital.adapt.model.local.*;
import com.hospital.adapt.model.remote.RbnBoard;
import com.hospital.adapt.service.local.LoBoardService;
import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.utils.U2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LoBoardServiceImpl extends CommonServiceImpl<LbnBoard> implements LoBoardService {
    @Resource
    private RbnBoardMapper rbnBoardMapper = null;
    @Resource
    private LbnHisWardMapper lbnHisWardMapper = null;
    @Resource
    private LbnBedMapper lbnBedMapper = null;
    @Resource
    private LbnPatientMapper lbnPatientMapper = null;
    Logger log = LoggerFactory.getLogger(LoBoardServiceImpl.class);

    @Override
    public String queryStatistic(Map<String, String[]> param) {

        String result = null;
        String localWardsn = U2.get("ward_code", param);
        LocPatientStatistic model = new LocPatientStatistic();
        //	log.info("over0 localWardsn="+localWardsn);
        if (Str2.notNull(localWardsn)) {
            try {
                String localWardId = lbnHisWardMapper.queryLocalWardIdByLocalWardsn(localWardsn);
                if (Str2.notNull(localWardId)) {
                    List<String> hisWardsn = lbnHisWardMapper.queryHisWardsnByLocalWardsn(localWardsn);
                    if (null != hisWardsn && hisWardsn.size() > 0) {
                        Calendar c = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                        String today = sdf.format(c.getTime());

                        c.add(Calendar.DAY_OF_MONTH, 1);
                        String tomorrow = sdf.format(c.getTime());

                        Map<String, Object> params = new HashMap<String, Object>();
                        params.put("hisWardsn", hisWardsn);
                        params.put("patientDate", today);

                        List<RbnBoard> patientIn = rbnBoardMapper.queryPatientIn(params);
                        String patientInBeds = concatBedList(patientIn);

                        List<RbnBoard> patientOutToday = rbnBoardMapper.queryPatientOut(params);
                        String patientOutTodayBeds = concatBedList(patientOutToday);

                        List<RbnBoard> patientOprToday = rbnBoardMapper.queryPatientOpr(params);
                        String patientOprTodayBeds = concatBedList(patientOprToday);

                        params.put("type", 1);
                        List<RbnBoard> patientMvInToday = rbnBoardMapper.queryPatientMv(params);
                        String patientMvInTodayBeds = concatBedList(patientMvInToday);

                        params.replace("type", 2);
                        List<RbnBoard> patientMvOutToday = rbnBoardMapper.queryPatientMv(params);
                        String patientMvOutTodayBeds = concatBedList(patientMvOutToday);

                        params.put("status", 3);
                        List<RbnBoard> patientBz = rbnBoardMapper.queryPatientIllness(params);
                        String patientBzBeds = concatBedList(patientBz);

                        params.replace("status", 4);
                        List<RbnBoard> patientBw = rbnBoardMapper.queryPatientIllness(params);
                        String patientBwBeds = concatBedList(patientBw);

                        params.replace("patientDate", tomorrow);
                        List<RbnBoard> patientOutTomorrow = rbnBoardMapper.queryPatientOut(params);
                        String patientOutTomorrowBeds = concatBedList(patientOutTomorrow);

                        List<RbnBoard> patientOprTomorrow = rbnBoardMapper.queryPatientOpr(params);
                        String patientOprTomorrowBeds = concatBedList(patientOprTomorrow);

                        if (null != patientIn) {
                            model.setTodayIn(queryStatisticByLocalBedIdList(getLocalBedIdList(patientInBeds, localWardId)));
                        }

                        if (null != patientOutToday) {
                            model.setTodayOut(queryStatisticByLocalBedIdList(getLocalBedIdList(patientOutTodayBeds, localWardId)));
                        }

                        if (null != patientOprToday) {
                            model.setTodayOpr(queryStatisticByLocalBedIdList(getLocalBedIdList(patientOprTodayBeds, localWardId)));
                        }

                        if (null != patientMvInToday) {
                            model.setMoveIn(queryStatisticByLocalBedIdList(getLocalBedIdList(patientMvInTodayBeds, localWardId)));
                        }

                        if (null != patientMvOutToday) {
                            model.setMoveOut(queryStatisticByLocalBedIdList(getLocalBedIdList(patientMvOutTodayBeds, localWardId)));
                        }

                        if (null != patientBz) {
                            model.setSeriously(queryStatisticByLocalBedIdList(getLocalBedIdList(patientBzBeds, localWardId)));
                        }

                        if (null != patientBw) {
                            model.setCritically(queryStatisticByLocalBedIdList(getLocalBedIdList(patientBwBeds, localWardId)));
                        }

                        if (null != patientOutTomorrow) {
                            model.setTomorrowOut(queryStatisticByLocalBedIdList(getLocalBedIdList(patientOutTomorrowBeds, localWardId)));
                        }

                        if (null != patientOprTomorrow) {
                            model.setTomorrowOpr(queryStatisticByLocalBedIdList(getLocalBedIdList(patientOprTomorrowBeds, localWardId)));
                        }

                        int scTotal = 0;
                        if (null != model.getSeriously() && model.getSeriously().size() > 0) {
                            scTotal += model.getSeriously().size();
                        }
                        if (null != model.getCritically() && model.getCritically().size() > 0) {
                            scTotal += model.getCritically().size();
                        }
                        model.setScTotal(scTotal);

                    } else {
                        log.warn("Local ward code: " + localWardsn);
                    }

                    statisticOther(model, localWardId);
                } else {
                    log.warn("Local ward code: " + localWardsn);
                }
            } catch (Exception e) {
                log.error("LoBoardServiceImpl queryStatistic exception:", e);
            }
        }

        result = toJSON(model);

        return result;
    }

    private void statisticOther(LocPatientStatistic model, String localWardId) {
        if (Str2.notNull(localWardId)) {
            model.setTotal(lbnPatientMapper.getTotal(localWardId));
            //	model.setScTotal(lbnPatientMapper.getScTotal(localWardId));

            model.setCountNoLevels(lbnPatientMapper.countNoLevels(localWardId));
            model.setCountLevels(lbnPatientMapper.countLevels(localWardId));
            model.setChaperonage(lbnPatientMapper.getChaperonage(localWardId));
            Map<String, Object> qparams = new HashMap<>();
            qparams.put("ward_id", localWardId);
            qparams.put("safe_type", 1);
            model.setSafeBed(lbnPatientMapper.getSafeIsolate(qparams));
            qparams.replace("safe_type", 2);
            model.setIsolateBed(lbnPatientMapper.getSafeIsolate(qparams));
            model.setLevelBed(lbnPatientMapper.getLevelBed(qparams));
            model.setPieChartModel(getPieChartModel(model));
            model.setBarChartModel(getBarChartModel(model));
        }
    }

    private String getLocalBedIdList(String hisBedList, String localWardId) {
        String result = null;

        try {
            if (Str2.notNull(hisBedList)) {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("hisBedList", hisBedList);
                params.put("localWardId", localWardId);
                result = lbnBedMapper.queryLocalBedIdsByHisBeds(params);
                //	log.info("localBedIdList="+result);
            } else {
                //	log.info("...hisBedList is empty...");
            }
        } catch (Exception e) {
            log.error("LoBoardServiceImpl getLocalBedIdList exception:", e);
        }

        return result;
    }

    private List<LocPatientStatisticMap> queryStatisticByLocalBedIdList(String localBedIdList) {
        List<LocPatientStatisticMap> result = null;

        try {
            if (Str2.notNull(localBedIdList)) {
                result = lbnPatientMapper.queryStatisticByLocalBedIdList(localBedIdList);
            } else {
                //	log.info("..localBedIdList is empty...");
            }
        } catch (Exception e) {
            log.error("LoBoardServiceImpl queryStatisticByLocalBedIdList exception:", e);
        }

        return result;
    }

    private ChartModel getPieChartModel(LocPatientStatistic ps) {
        ChartModel pieChart = new ChartModel();
        pieChart.setTotal(ps.getTotal());
        pieChart.setChartName("Total");
        List<String> legends = new ArrayList<String>();
        legends.add("Other");
        legends.add("Danger");
        legends.add("With");
        pieChart.setChartLegends(legends);

        List<ChartDataModel> pieChartData = new ArrayList<ChartDataModel>();
        ChartDataModel cdm = new ChartDataModel();
        cdm.setName("Danger");
        cdm.setValue(ps.getScTotal());
        pieChartData.add(cdm);

        cdm = new ChartDataModel();
        cdm.setName("With");
        cdm.setValue(ps.getChaperonage().size());
        pieChartData.add(cdm);

        cdm = new ChartDataModel();
        cdm.setName("Other");
        cdm.setValue(ps.getTotal() - ps.getScTotal() - ps.getChaperonage().size());
        pieChartData.add(cdm);

        pieChart.setChartData((List<Object>) (List) pieChartData);

        return pieChart;
    }

    private ChartModel getBarChartModel(LocPatientStatistic ps) {
        ChartModel barChart = new ChartModel();
        barChart.setTotal(ps.getTotal());
        barChart.setChartName("Careful Total");
        List<String> legends = new ArrayList<String>();
        List<JSONObject> data = new ArrayList<JSONObject>();
        List<Integer> markData = new ArrayList<Integer>();
        for (LbnNursLvl bnl : ps.getCountLevels()) {
            legends.add(bnl.getlevel_name());
            markData.add(bnl.getNursing_count());
            JSONObject d = new JSONObject();
            d.put("value", bnl.getNursing_count());
            JSONObject style = new JSONObject();
            style.put("color", bnl.getlevel_color());
            d.put("itemStyle", style);
            data.add(d);
        }

        legends.add("Other");
        JSONObject d = new JSONObject();
        d.put("value", ps.getCountNoLevels());
        JSONObject style = new JSONObject();
        style.put("color", "#f2f2f2");
        d.put("itemStyle", style);
        data.add(d);
        markData.add(ps.getCountNoLevels());

        barChart.setChartLegends(legends);
        barChart.setChartData((List<Object>) (List) data);

        return barChart;
    }

    private String concatBedList(List<RbnBoard> rBoards) {
        String result = "";

        if (null != rBoards && rBoards.size() > 0) {
            for (RbnBoard rBoard : rBoards) {
                if (Str2.notNull(rBoard.getPatient_beds())) {
                    result += rBoard.getPatient_beds() + ",";
                }
            }
            if (Str2.notNull(result)) {
                result = result.substring(0, result.length() - 1);
            }
        }

        return Str2.chkNull(result);
    }
}
