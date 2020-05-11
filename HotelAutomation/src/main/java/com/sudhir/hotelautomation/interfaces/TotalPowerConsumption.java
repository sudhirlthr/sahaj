package com.sudhir.hotelautomation.interfaces;

import com.sudhir.hotelautomation.util.PropertyFileUtility;

public interface TotalPowerConsumption {

    // criteria/formula to get power consumption for each floor
    static Integer getMaxPowerConsumption(Integer numberOfCorridor, Integer numberOfSubCorridor){
        Integer main_corridor_multiplier = PropertyFileUtility.getEnumParameterValue("main_corridor_multiplier");
        Integer sub_corridor_multiplier = PropertyFileUtility.getEnumParameterValue("sub_corridor_multiplier");
        return numberOfCorridor * main_corridor_multiplier + numberOfSubCorridor * sub_corridor_multiplier;
    }
}
