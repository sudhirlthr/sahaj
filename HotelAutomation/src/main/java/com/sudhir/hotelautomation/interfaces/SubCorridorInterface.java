package com.sudhir.hotelautomation.interfaces;

public interface SubCorridorInterface {

    Integer subcorridorId = 0;
    Boolean isLight_ON = Boolean.FALSE;
    Boolean isAC_ON = Boolean.TRUE;
    Instruments subcorridor_ac = Instruments.AC;
    Instruments subcorridor_light = Instruments.LIGHT;

    default void getSubcorridorDefaultState(){   }

    void setSubCorridorState(Integer subcorridorId, Boolean isLight_ON, Boolean isAC_ON,
                                                    Instruments subcorridor_ac, Instruments subcorridor_light);

    void setSubcorridorId(Integer subcorridorId);
    Integer getSubcorridorId();

    void setLight_ON(Boolean light_on);
    Boolean getLight_ON();

    void setAC_ON(Boolean isAC_ON);
    Boolean getAC_ON();

    void setSubcorridor_ac(Instruments instruments);
    Instruments getSubcorridor_ac();

    void setSubcorridor_light(Instruments instruments);
    Instruments getSubcorridor_light();
}
