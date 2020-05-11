package com.sudhir.hotelautomation.model;

import com.sudhir.hotelautomation.interfaces.CorridorInterface;
import com.sudhir.hotelautomation.interfaces.Instruments;

import java.io.Serializable;

public class CorridorImpl implements CorridorInterface, Serializable {

    private static final long serialVersionUID = -4765727177690299082L;
    Integer corridorId = 0;
    final Boolean isLight_ON = CorridorInterface.isLight_ON;
    final Boolean isAC_ON = CorridorInterface.isAC_ON;
    Instruments corridor_ac = Instruments.AC;
    Instruments corridor_light = Instruments.LIGHT;

    public CorridorImpl(Integer corridorId, Instruments corridor_ac, Instruments corridor_light) {
        this.corridorId = corridorId;
        this.corridor_ac = corridor_ac;
        this.corridor_light = corridor_light;
    }

    public Integer getCorridorId() {
        return corridorId;
    }

    @Override
    public void setCorridorId(Integer corridorId) {
        this.corridorId = corridorId;
    }

    @Override
    public Boolean getLight_ON() {
        return isLight_ON;
    }

    @Override
    public Boolean getAC_ON() {
        return isAC_ON;
    }

    @Override
    public Instruments getCorridor_ac() {
        return corridor_ac;
    }

    @Override
    public void setCorridor_ac(Instruments corridor_ac) {
        this.corridor_ac = corridor_ac;
    }

    @Override
    public Instruments getCorridor_light() {
        return corridor_light;
    }

    @Override
    public void setCorridor_light(Instruments corridor_light) {
        this.corridor_light = corridor_light;
    }

    @Override
    public void setCorridorState(Integer corridorId, Instruments corridor_ac, Instruments corridor_light) {
        this.corridorId = corridorId;
        this.corridor_ac = corridor_ac;
        this.corridor_light = corridor_light;
    }
}