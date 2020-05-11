package com.sudhir.hotelautomation.helpers;

import com.sudhir.hotelautomation.interfaces.ControllerHelperInterface;
import com.sudhir.hotelautomation.interfaces.Floor;
import com.sudhir.hotelautomation.interfaces.SubCorridorInterface;
import com.sudhir.hotelautomation.util.InstrumentInputConfiguration;

import java.io.Serializable;
import java.util.List;

public class ControllerHelperImpl implements ControllerHelperInterface, Serializable {
    private static final long serialVersionUID = -3547282987359451169L;

    @Override
    public SubCorridorInterface minimisePowerConsumption(Integer floorNumber, Integer subCorridorNunmber, InstrumentInputConfiguration inputConfiguration) {

        List<Floor> floorList = inputConfiguration.getFloorList();
        Floor floor = floorList.get(floorNumber-1);
        List<SubCorridorInterface> subCorridorList = floor.getSubCorridorList(floorNumber);
        SubCorridorInterface subCorridor = subCorridorList.get(subCorridorNunmber);

        //choose randomly to switch off AC of any subcorridor where there is no movement
        // flag_1 to update choosen subcorridor where movement is there
        // flag_2 to switch off the AC on other than subcorridor where movement is there
        boolean flag_1 = true, flag_2 = true;
        // flag change 2 times, first time to
        subCorridorList.stream().forEach(subCorridor_update -> {
            if (subCorridor.equals(subCorridor_update) && flag_1){
                subCorridor_update.setLight_ON(Boolean.TRUE);
            }else if (flag_2){
                subCorridor_update.setAC_ON(Boolean.FALSE);
            }

        });
        return subCorridor;
    }

    @Override
    public void changeSubCorridorStateToDefault(SubCorridorInterface subCorridorInterface) {
        synchronized (this){
            subCorridorInterface.setLight_ON(Boolean.FALSE);
            subCorridorInterface.setAC_ON(Boolean.TRUE);
        }
    }
}
