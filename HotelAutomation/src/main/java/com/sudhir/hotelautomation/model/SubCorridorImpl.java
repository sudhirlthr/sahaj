package com.sudhir.hotelautomation.model;

import com.sudhir.hotelautomation.interfaces.Instruments;
import com.sudhir.hotelautomation.interfaces.SubCorridorInterface;

import java.io.Serializable;
import java.util.Objects;

public class SubCorridorImpl implements SubCorridorInterface, Serializable {
    private static final long serialVersionUID = -4981472458019611731L;

    private Integer subcorridorId;
    private Boolean isLight_ON;
    private Boolean isAC_ON;
    private Instruments subcorridor_ac;
    private Instruments subcorridor_light;

    public SubCorridorImpl(Integer subcorridorId) {
        this.subcorridorId = subcorridorId;
        this.isLight_ON = SubCorridorInterface.isLight_ON;
        this.isAC_ON = SubCorridorInterface.isAC_ON;
        this.subcorridor_ac = SubCorridorInterface.subcorridor_ac;
        this. subcorridor_light = SubCorridorInterface.subcorridor_light;
    }

    @Override
    public Integer getSubcorridorId() {
        return subcorridorId;
    }
    @Override
    public void setSubcorridorId(Integer subcorridorId) {
        this.subcorridorId = subcorridorId;
    }
    @Override
    public Boolean getLight_ON() {
        return isLight_ON;
    }
    @Override
    public void setLight_ON(Boolean light_ON) {
        isLight_ON = light_ON;
    }
    @Override
    public Boolean getAC_ON() {
        return isAC_ON;
    }
    @Override
    public void setAC_ON(Boolean AC_ON) {
        isAC_ON = AC_ON;
    }
    @Override
    public Instruments getSubcorridor_ac() {
        return subcorridor_ac;
    }
    @Override
    public void setSubcorridor_ac(Instruments subcorridor_ac) {
        this.subcorridor_ac = subcorridor_ac;
    }
    @Override
    public Instruments getSubcorridor_light() {
        return subcorridor_light;
    }
    @Override
    public void setSubcorridor_light(Instruments subcorridor_light) {
        this.subcorridor_light = subcorridor_light;
    }

    @Override
    public void setSubCorridorState(Integer subcorridorId, Boolean isLight_ON, Boolean isAC_ON, Instruments subcorridor_ac, Instruments subcorridor_light) {
        this.subcorridorId = subcorridorId;
        this.isLight_ON = isLight_ON;
        this.isAC_ON = isAC_ON;
        this.subcorridor_ac = subcorridor_ac;
        this.subcorridor_light = subcorridor_light;
    }
    @Override
    public String toString() {
        return "SubCorridorImpl{" +
                "subcorridorId=" + subcorridorId +
                ", isLight_ON=" + isLight_ON +
                ", isAC_ON=" + isAC_ON +
                ", subcorridor_ac=" + subcorridor_ac +
                ", subcorridor_light=" + subcorridor_light +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCorridorImpl that = (SubCorridorImpl) o;
        return subcorridorId.equals(that.subcorridorId) &&
                isLight_ON.equals(that.isLight_ON) &&
                isAC_ON.equals(that.isAC_ON) &&
                subcorridor_ac == that.subcorridor_ac &&
                subcorridor_light == that.subcorridor_light;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subcorridorId, isLight_ON, isAC_ON, subcorridor_ac, subcorridor_light);
    }
}
