package com.sudhir.hotelautomation.controller;

import com.sudhir.hotelautomation.interfaces.*;
import com.sudhir.hotelautomation.util.DefaultPowerConsumptionImpl;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class InstrumentControllerImpl implements InstrumentControllerInterface, Serializable {

    private static final long serialVersionUID = -6206039545273241598L;


    @Override
    public void minimizePowerConsumption(List<Floor> floors, Integer currentConsumption) {
        synchronized (this){
            floors.forEach(floor -> {
                floor.getSubCorridorList(0).forEach(subCorridor -> {
                    subCorridor.setAC_ON(Boolean.FALSE);
                    subCorridor.setLight_ON(Boolean.FALSE);
                });
            });

            if (currentConsumption > getCurrentPowerConsumption(floors)){
                minimizePowerConsumption(floors, currentConsumption);
            }
        }
    }

    @Override
    public Integer getCurrentPowerConsumption(List<Floor> floors) {
        AtomicReference<Integer> currentConsumption = new AtomicReference<>(0);
        Integer dummyFloorIndex = 0;
        DefaultPowerConsumptionImpl consumption = new DefaultPowerConsumptionImpl();

        floors.forEach(floor -> {
            // for corridor pwer consumption
            List<CorridorInterface> corridorList = floor.getCorridorList(dummyFloorIndex);
            corridorList.forEach(corridor -> {
                if (corridor.getAC_ON() && corridor.getCorridor_ac().equals(Instruments.AC)){
                    currentConsumption.updateAndGet(v -> v + consumption.getDefaultPowerConsumptionUnit(corridor.getCorridor_ac()));
                }
                if (corridor.getLight_ON() && corridor.getCorridor_light().equals(Instruments.LIGHT)){
                    currentConsumption.updateAndGet(v -> v + consumption.getDefaultPowerConsumptionUnit(corridor.getCorridor_light()));
                }
            });

            // for sub-corridor pwer consumption
            List<SubCorridorInterface> subCorridorList = floor.getSubCorridorList(dummyFloorIndex);
            subCorridorList.forEach(subCorridor -> {
                if (subCorridor.getAC_ON() && subCorridor.getSubcorridor_ac().equals(Instruments.AC)){
                    currentConsumption.updateAndGet(v -> v + consumption.getDefaultPowerConsumptionUnit(subCorridor.getSubcorridor_ac()));
                }
                if (subCorridor.getLight_ON() && subCorridor.getSubcorridor_light().equals(Instruments.LIGHT)){
                    currentConsumption.updateAndGet(value -> value + consumption.getDefaultPowerConsumptionUnit(subCorridor.getSubcorridor_light()));
                }
            });
        });
        return currentConsumption.get();
    }
}
