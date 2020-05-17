package com.sudhir.hotelautomation.model;

import com.sudhir.hotelautomation.interfaces.CorridorInterface;
import com.sudhir.hotelautomation.interfaces.Floor;
import com.sudhir.hotelautomation.interfaces.Instruments;
import com.sudhir.hotelautomation.interfaces.SubCorridorInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FloorJunitTest {

    private Integer floorNumber;
    private List<CorridorInterface> corridorList;
    private List<SubCorridorInterface> subCorridorList;
    private Floor floor;
    @Before
    public void init(){
        // assuming 1 corridor and 2 subcorridor
        floorNumber = new Random().nextInt();
        corridorList = new ArrayList<>();
        corridorList.add(new CorridorImpl(new Random().nextInt(), Instruments.AC, Instruments.LIGHT));
        subCorridorList = new ArrayList<>();
        subCorridorList.add(new SubCorridorImpl(new Random().nextInt()));
        subCorridorList.add(new SubCorridorImpl(new Random().nextInt()));
        floor = new FloorImpl(new Random().nextInt(), corridorList, subCorridorList);
    }

    @Test
    public void testTwoFloorByEqual(){
        Assert.assertFalse(floor.equals(new FloorImpl(1, new ArrayList<CorridorInterface>(), new ArrayList<SubCorridorInterface>())));
    }

    @Test
    public void testTwoFloorHashCode(){
        FloorImpl otherFloor = new FloorImpl(1, new ArrayList<CorridorInterface>(), new ArrayList<SubCorridorInterface>());
        Assert.assertFalse(floor.hashCode() != otherFloor.hashCode());
    }

    @Test
    public  void testIfCorridorNotNull(){
        Assert.assertNotNull(floor.getCorridorList(floorNumber));
    }

    @Test
    public  void testIfSubCorridorNotNull(){
        Assert.assertNotNull(floor.getSubCorridorList(floorNumber));
    }
}
