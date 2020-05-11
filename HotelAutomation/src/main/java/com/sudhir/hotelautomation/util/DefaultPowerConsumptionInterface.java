package com.sudhir.hotelautomation.util;

import com.sudhir.hotelautomation.interfaces.Instruments;

public interface DefaultPowerConsumptionInterface {

    public default Integer getDefaultPowerConsumptionUnit(Instruments instruments){
        Integer defaultValue = null;
        String instrumentPrefix = "instruments";
        if (instruments.equals(Instruments.AC)){
            defaultValue = PropertyFileUtility.getEnumParameterValue(instrumentPrefix + "." + Instruments.AC.toString());
        }
        else if (instruments.equals(Instruments.LIGHT)){
            defaultValue = PropertyFileUtility.getEnumParameterValue(instrumentPrefix + "." + Instruments.LIGHT.toString());
        }

        return defaultValue;
    }

    //public Integer getIntrumentPowerConsumptionUnit(Instruments instruments);
}