
package com.hospital.adapt.model.local;

import com.hospital.adapt.utils.Str2;

import java.util.List;

public class LocPatientStatistic {
    private Integer total = 0;
    private Integer scTotal = 0;
    private String dutyDoctor = null;
    private String dutyNurse = null;
    private Integer countNoLevels = 0;
    private List<LbnNursLvl> countLevels = null;
    private List<LocDataModel> deptPatientCount = null;

    private List<LocPatientStatisticMap> todayIn = null;
    private List<LocPatientStatisticMap> todayOut = null;
    private List<LocPatientStatisticMap> tomorrowOut = null;
    private List<LocPatientStatisticMap> todayOpr = null;
    private List<LocPatientStatisticMap> tomorrowOpr = null;
    private List<LocPatientStatisticMap> moveIn = null;
    private List<LocPatientStatisticMap> moveOut = null;
    private List<LocPatientStatisticMap> seriously = null;
    private List<LocPatientStatisticMap> critically = null;
    private List<LocPatientStatisticMap> chaperonage = null;
    private List<LocPatientStatisticMap> patientCare = null;

    private List<LocPatientStatisticMap> yestodayIn = null;
    private List<LocPatientStatisticMap> yestodayOut = null;
    private List<LocPatientStatisticMap> yestodayOpr = null;
    private List<LocPatientStatisticMap> ystMoveIn = null;
    private List<LocPatientStatisticMap> ystMoveOut = null;

    private List<StatisticModel> safeBed = null;
    private List<StatisticModel> isolateBed = null;
    private List<StatisticModel> levelBed = null;

    private ChartModel pieChartModel = null;
    private ChartModel barChartModel = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getScTotal() {
        return scTotal;
    }

    public void setScTotal(Integer scTotal) {
        this.scTotal = scTotal;
    }

    public String getDutyDoctor() {
        return dutyDoctor;
    }

    public void setDutyDoctor(String dutyDoctor) {
        this.dutyDoctor = Str2.chkNull(dutyDoctor);
    }

    public String getDutyNurse() {
        return dutyNurse;
    }

    public void setDutyNurse(String dutyNurse) {
        this.dutyNurse = Str2.chkNull(dutyNurse);
    }

    public Integer getCountNoLevels() {
        return countNoLevels;
    }

    public void setCountNoLevels(Integer countNoLevels) {
        this.countNoLevels = countNoLevels;
    }

    public List<LbnNursLvl> getCountLevels() {
        return countLevels;
    }

    public void setCountLevels(List<LbnNursLvl> countLevels) {
        this.countLevels = countLevels;
    }

    public List<LocDataModel> getDeptPatientCount() {
        return deptPatientCount;
    }

    public void setDeptPatientCount(List<LocDataModel> deptPatientCount) {
        this.deptPatientCount = deptPatientCount;
    }

    public List<LocPatientStatisticMap> getTodayIn() {
        return todayIn;
    }

    public void setTodayIn(List<LocPatientStatisticMap> todayIn) {
        this.todayIn = todayIn;
    }

    public List<LocPatientStatisticMap> getTodayOut() {
        return todayOut;
    }

    public void setTodayOut(List<LocPatientStatisticMap> todayOut) {
        this.todayOut = todayOut;
    }

    public List<LocPatientStatisticMap> getTomorrowOut() {
        return tomorrowOut;
    }

    public void setTomorrowOut(List<LocPatientStatisticMap> tomorrowOut) {
        this.tomorrowOut = tomorrowOut;
    }

    public List<LocPatientStatisticMap> getTodayOpr() {
        return todayOpr;
    }

    public void setTodayOpr(List<LocPatientStatisticMap> todayOpr) {
        this.todayOpr = todayOpr;
    }

    public List<LocPatientStatisticMap> getTomorrowOpr() {
        return tomorrowOpr;
    }

    public void setTomorrowOpr(List<LocPatientStatisticMap> tomorrowOpr) {
        this.tomorrowOpr = tomorrowOpr;
    }

    public List<LocPatientStatisticMap> getMoveIn() {
        return moveIn;
    }

    public void setMoveIn(List<LocPatientStatisticMap> moveIn) {
        this.moveIn = moveIn;
    }

    public List<LocPatientStatisticMap> getMoveOut() {
        return moveOut;
    }

    public void setMoveOut(List<LocPatientStatisticMap> moveOut) {
        this.moveOut = moveOut;
    }

    public List<LocPatientStatisticMap> getSeriously() {
        return seriously;
    }

    public void setSeriously(List<LocPatientStatisticMap> seriously) {
        this.seriously = seriously;
    }

    public List<LocPatientStatisticMap> getCritically() {
        return critically;
    }

    public void setCritically(List<LocPatientStatisticMap> critically) {
        this.critically = critically;
    }

    public List<LocPatientStatisticMap> getChaperonage() {
        return chaperonage;
    }

    public void setChaperonage(List<LocPatientStatisticMap> chaperonage) {
        this.chaperonage = chaperonage;
    }

    public List<LocPatientStatisticMap> getPatientCare() {
        return patientCare;
    }

    public void setPatientCare(List<LocPatientStatisticMap> patientCare) {
        this.patientCare = patientCare;
    }

    public List<LocPatientStatisticMap> getYestodayIn() {
        return yestodayIn;
    }

    public void setYestodayIn(List<LocPatientStatisticMap> yestodayIn) {
        this.yestodayIn = yestodayIn;
    }

    public List<LocPatientStatisticMap> getYestodayOut() {
        return yestodayOut;
    }

    public void setYestodayOut(List<LocPatientStatisticMap> yestodayOut) {
        this.yestodayOut = yestodayOut;
    }

    public List<LocPatientStatisticMap> getYestodayOpr() {
        return yestodayOpr;
    }

    public void setYestodayOpr(List<LocPatientStatisticMap> yestodayOpr) {
        this.yestodayOpr = yestodayOpr;
    }

    public List<LocPatientStatisticMap> getYstMoveIn() {
        return ystMoveIn;
    }

    public void setYstMoveIn(List<LocPatientStatisticMap> ystMoveIn) {
        this.ystMoveIn = ystMoveIn;
    }

    public List<LocPatientStatisticMap> getYstMoveOut() {
        return ystMoveOut;
    }

    public void setYstMoveOut(List<LocPatientStatisticMap> ystMoveOut) {
        this.ystMoveOut = ystMoveOut;
    }

    public ChartModel getPieChartModel() {
        return pieChartModel;
    }

    public void setPieChartModel(ChartModel chartModel) {
        this.pieChartModel = chartModel;
    }

    public ChartModel getBarChartModel() {
        return barChartModel;
    }

    public void setBarChartModel(ChartModel barChartModel) {
        this.barChartModel = barChartModel;
    }

    public List<StatisticModel> getSafeBed() {
        return safeBed;
    }

    public void setSafeBed(List<StatisticModel> safeBed) {
        this.safeBed = safeBed;
    }

    public List<StatisticModel> getIsolateBed() {
        return isolateBed;
    }

    public void setIsolateBed(List<StatisticModel> isolateBed) {
        this.isolateBed = isolateBed;
    }

    public List<StatisticModel> getLevelBed() {
        return levelBed;
    }

    public void setLevelBed(List<StatisticModel> levelBed) {
        this.levelBed = levelBed;
    }
}
