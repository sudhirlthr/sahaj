package com.sudhir.hotelautomation.interfaces;

import java.util.List;

public interface InstrumentControllerInterface {
    void minimizePowerConsumption(List<Floor> floors, Integer currentConsumption);
    Integer getCurrentPowerConsumption(List<Floor> floors);
}
