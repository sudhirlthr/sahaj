package com.sudhir.hotelautomation.interfaces;

public interface CorridorInterface {

    Integer corridorId = 0;
    Boolean isLight_ON = Boolean.TRUE;
    Boolean isAC_ON = Boolean.TRUE;
    Instruments corridor_ac = Instruments.AC;
    Instruments corridor_light = Instruments.LIGHT;

    //default void getCorridorDefaultState(){   }

    void setCorridorState(Integer corridorId, Instruments corridor_ac, Instruments corridor_light);

    void setCorridorId(Integer subcorridorId);
    Integer getCorridorId();

    Boolean getLight_ON();

    Boolean getAC_ON();

    void setCorridor_ac(Instruments instruments);
    Instruments getCorridor_ac();

    void setCorridor_light(Instruments instruments);
    Instruments getCorridor_light();
}
