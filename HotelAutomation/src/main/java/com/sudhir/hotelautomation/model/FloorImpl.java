package com.sudhir.hotelautomation.model;

import com.sudhir.hotelautomation.interfaces.CorridorInterface;
import com.sudhir.hotelautomation.interfaces.Floor;
import com.sudhir.hotelautomation.interfaces.SubCorridorInterface;

import java.io.Serializable;
import java.util.List;

public class FloorImpl implements Floor, Serializable {
    private static final long serialVersionUID = 6377504742438990351L;

    Integer floorNumber;
    List<CorridorInterface> corridorList;
    List<SubCorridorInterface> subCorridorList;
    private FloorImpl(){}

    public FloorImpl(Integer floorNumber, List<CorridorInterface> corridorList, List<SubCorridorInterface> subCorridorList) {
        this.floorNumber = floorNumber;
        this.corridorList = corridorList;
        this.subCorridorList = subCorridorList;
    }

    @Override
    public Floor getFloorState(Integer floorNumber) {
        FloorImpl floor = new FloorImpl(floorNumber, getCorridorList(floorNumber), getSubCorridorList(floorNumber));
        return floor;
    }

    @Override
    public List<CorridorInterface> getCorridorList(Integer floorNumber) {
        return corridorList;
    }

    @Override
    public void setCorridorList(List<CorridorInterface> corridorList) {
        this.corridorList = corridorList;
    }

    @Override
    public List<SubCorridorInterface> getSubCorridorList(Integer floorNumber) {
        return subCorridorList;
    }

    @Override
    public void setSubCorridorList(List<SubCorridorInterface> subCorridorList) {
        this.subCorridorList = subCorridorList;
    }
}
