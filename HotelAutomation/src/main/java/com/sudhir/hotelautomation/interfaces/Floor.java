package com.sudhir.hotelautomation.interfaces;

import com.sudhir.hotelautomation.model.CorridorImpl;
import com.sudhir.hotelautomation.model.SubCorridorImpl;

import java.util.ArrayList;
import java.util.List;

public interface Floor {

    Integer floorNumber = 0;
    List<CorridorInterface> corridorList = new ArrayList<>();
    List<SubCorridorInterface> subCorridorList = new ArrayList<>();

    Floor getFloorState(Integer floorNumber);

    List<CorridorInterface> getCorridorList(Integer floorNumber);
    void setCorridorList(List<CorridorInterface> corridorList);

    List<SubCorridorInterface> getSubCorridorList(Integer floorNumber);
    void setSubCorridorList(List<SubCorridorInterface> subCorridorList);
}
