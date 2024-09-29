
package com.hospital.adapt.service.remote.view.impl;


import com.github.pagehelper.Page;
import com.hospital.adapt.mapper.remote.RbnRoomMapper;
import com.hospital.adapt.model.common.MyPage;
import com.hospital.adapt.model.remote.RbnRoom;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.service.local.LoLogService;
import com.hospital.adapt.service.local.LoRoomService;
import com.hospital.adapt.service.remote.view.RviRoomService;
import com.hospital.adapt.utils.U2;
import com.hospital.adapt.utils.Utl2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RviRoomServiceImpl extends CommonServiceImpl<RbnRoom> implements RviRoomService {
    private RbnRoomMapper rbnRoomMapper = null;

    @Resource
    private LoRoomService loRoomService = null;
    @Resource
    private LoLogService loLogService = null;

    Logger log = LoggerFactory.getLogger(RviRoomServiceImpl.class);

    @Resource
    public void setRbnRoomMapper(RbnRoomMapper rbnRoomMapper) {
        this.rbnRoomMapper = rbnRoomMapper;
        this.setMapper(rbnRoomMapper);
    }

    @Override
    public void synAll() {
        try {
            List<RbnRoom> rRooms = rbnRoomMapper.queryAll();
            if (null != rRooms && rRooms.size() > 0) {
                loRoomService.synData(rRooms);
            } else {
                log.warn("");
            }
        } catch (Exception e) {
            log.error("ViRoomServiceImpl synAll exception:", e);
            Utl2.insertLogMsg(loLogService, "ViRoomServiceImpl synAll exception", "adapter", "adapter", e);
        }

    }

    @Override
    public String queryByParam(Map<String, String[]> param) {
        String result = "[]";

        String ward_code = U2.get("ward_code", param);

        MyPage<RbnRoom> mPage = new MyPage<RbnRoom>();
        mPage.setPageNum(parseInt(U2.get("page", param)));
        mPage.setPageSize(parseInt(U2.get("rows", param)));

        Map<String, Object> mparam = new HashMap<String, Object>();
        mparam.put("ward_code", ward_code);
        mPage.setParams(mparam);

        try {
            List<RbnRoom> emps = rbnRoomMapper.queryByParam(mPage);
            Page<RbnRoom> pg = (Page<RbnRoom>) emps;

            mPage.setRows(pg.getResult());
            mPage.setTotal(pg.getTotal());
            pg.close();

            result = toJSON(emps);
        } catch (Exception e) {
            log.error("ViRoomServiceImpl queryByParam exception:", e);
        }

        return result;
    }
}
