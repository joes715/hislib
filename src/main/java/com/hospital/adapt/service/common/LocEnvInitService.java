
package com.hospital.adapt.service.common;

public interface LocEnvInitService {
    public static final int AREA = 0;
    public static final int PATIENT = 1;
    public static final int BED = 2;
    public static final int ROOM = 3;
    public static final int NURSING_LEVEL = 4;
    public static final int SAFE_ISOLOATE = 5;
    public static final int SAFE_LEVEL = 6;
    public static final int DOCK_AREA = 7;
    public static final int DOCK_BED = 8;
    public static final int DOCK_EMP = 9;
    public static final int DOCK_DEPT = 10;

    public void initNursingLevelBuff();

    public void initPatientBuff();

    public void initPaymentTypeBuff();

    public void initHisWardCodesBuff();

    public void initDeptCodesBuff();

    public void initDockWardIdBuff();

    public void initDockBedIdBuff();

    public void initDockEmpIdBuff();

    public void initDockDeptIdBuff();

    public void initDockRoomIdBuff();

    public void initSafeIsoIdBuff();

    public void initDockIdBuf();

    public void initDockDataBuff();

    public void initAllBuff();

    public void initSafeLevelIdBuff();
}
