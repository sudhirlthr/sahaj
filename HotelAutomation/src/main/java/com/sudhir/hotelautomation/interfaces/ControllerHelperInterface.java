package com.sudhir.hotelautomation.interfaces;

import com.sudhir.hotelautomation.util.InstrumentInputConfiguration;

public interface ControllerHelperInterface {

    //It will SubCorridor which instruments has been switched off
    SubCorridorInterface minimisePowerConsumption(Integer floorNumber, Integer subCorridorNunmber, InstrumentInputConfiguration inputConfiguration);
    void changeSubCorridorStateToDefault(SubCorridorInterface subCorridorInterface);
}
