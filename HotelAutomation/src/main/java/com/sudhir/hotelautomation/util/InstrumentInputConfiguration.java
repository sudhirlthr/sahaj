package com.sudhir.hotelautomation.util;

import com.sudhir.hotelautomation.interfaces.CorridorInterface;
import com.sudhir.hotelautomation.interfaces.Floor;
import com.sudhir.hotelautomation.interfaces.Instruments;
import com.sudhir.hotelautomation.interfaces.SubCorridorInterface;
import com.sudhir.hotelautomation.model.CorridorImpl;
import com.sudhir.hotelautomation.model.FloorImpl;
import com.sudhir.hotelautomation.model.SubCorridorImpl;

import java.util.ArrayList;
import java.util.List;

public class InstrumentInputConfiguration {
    /*static {
        // get number of floors from properties file
        String number_of_foors = "number_of_foors";
        final Integer numberOfFloors = PropertyFileUtility.getEnumParameterValue(number_of_foors);
        final ArrayList<Floor> floors = new ArrayList<>(numberOfFloors);
    }*/
    static List<SubCorridorInterface> subCorridorList = null;
    static List<CorridorInterface> corridorList = null;
    static List<Floor> floors = null;
    public void setInstrumentInput(Integer numberOfSubCorridor, Integer numberOfCorridor, Integer numberOfFloor){
        subCorridorList = new ArrayList<SubCorridorInterface>(numberOfSubCorridor);
        for (int i = 0; i < numberOfSubCorridor; i++) {
            SubCorridorImpl subCorridor = new SubCorridorImpl(i+1);
            subCorridorList.add(subCorridor);
        }


        corridorList = new ArrayList<CorridorInterface>(numberOfCorridor);
        for (int i = 0; i < numberOfCorridor; i++) {
            CorridorImpl corridor = new CorridorImpl(i+1, Instruments.AC, Instruments.LIGHT);
            corridorList.add(corridor);
        }

        floors = new ArrayList<Floor>(numberOfFloor);
        for (int i = 0; i < numberOfFloor; i++) {
            FloorImpl floor = new FloorImpl(i+1, corridorList, subCorridorList);
            floors.add(floor);
        }
    }

    public void printDefaultInstrumentState(){
        for (int i = 0; i < floors.size(); i++) {
            System.out.println("For floor: "+(i+1));
            Floor floor = floors.get(i);
            Floor floorState = floor.getFloorState(i);

            // for Corridor
            List<CorridorInterface> floorCorridorList = floorState.getCorridorList(i);
            for (int j = 0; j < floorCorridorList.size() ; j++) {
                System.out.println("\tFor Corridor: "+(j+1));
                System.out.println("\t\tLight: "+floorCorridorList.get(j).getLight_ON()+", "+
                        "\t\tAC: "+floorCorridorList.get(j).getAC_ON());
            }

            // for Sub-Corridor
            List<SubCorridorInterface> floorSubCorridorList = floorState.getSubCorridorList(i);
            for (int j = 0; j < floorSubCorridorList.size() ; j++) {
                System.out.println("\tFor SubCorridor: "+(j+1));
                System.out.println("\t\tLight: "+floorSubCorridorList.get(j).getLight_ON()+", "+
                        "\t\tAC: "+floorSubCorridorList.get(j).getAC_ON());
            }
        }
    }

    public List<Floor> getFloorList(){
        return floors;
    }
}
