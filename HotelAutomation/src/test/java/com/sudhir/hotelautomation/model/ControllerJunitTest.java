package com.sudhir.hotelautomation.model;

import com.sudhir.hotelautomation.helpers.ControllerHelperImpl;
import com.sudhir.hotelautomation.interfaces.*;
import com.sudhir.hotelautomation.util.InstrumentInputConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ControllerJunitTest {

    Integer numberOfFloors;
    Integer numberofCorridor;
    Integer numberOfSubCorridor;
    private Integer floorNumber;
    private List<CorridorInterface> corridorList;
    private List<SubCorridorInterface> subCorridorList;
    private List<Floor> floors;
    ControllerHelperInterface controllerHelper = new ControllerHelperImpl();

    @Before
    public void init(){
        numberOfFloors = 2;
        numberofCorridor = 1;
        numberOfSubCorridor = 2;

        floors = new ArrayList<>();
        for (int i = 0; i<numberOfFloors;i++){
            corridorList = new ArrayList<>(numberofCorridor);
            for (int j=0; j< numberofCorridor;j++){
                corridorList.add(new CorridorImpl(j+1, Instruments.AC, Instruments.LIGHT));
            }
            subCorridorList = new ArrayList<>(numberOfSubCorridor);
            for (int j=0; j< numberOfSubCorridor;j++){
                subCorridorList.add(new SubCorridorImpl(j+1));
            }
            floors.add(new FloorImpl(i, corridorList, subCorridorList));
        }

    }

    @Test
    public void defaultCaseForCorridor(){
        for (int i = 0; i < numberOfFloors; i++) {
            // for corridor defaultcase
            for (int j = 0; j < numberofCorridor; j++) {
                Assert.assertTrue(corridorList.get(j).getAC_ON());
                Assert.assertTrue(corridorList.get(j).getLight_ON());
            }

            // for SubCorridor default case
            for (int j = 0; j < numberOfSubCorridor; j++) {
                Assert.assertTrue(subCorridorList.get(j).getAC_ON());
                Assert.assertFalse(subCorridorList.get(j).getLight_ON());
            }
        }
    }

    @Test
    public void caseForAnyMovementinSubCorridor(){
        InstrumentInputConfiguration inputConfiguration = new InstrumentInputConfiguration();
        inputConfiguration.setInstrumentInput(numberOfSubCorridor, numberofCorridor, numberOfFloors);
        Integer moverment_in_floorNumber = ThreadLocalRandom.current().nextInt(1, numberOfFloors);
        Integer moverment_in_subCorridor = ThreadLocalRandom.current().nextInt(1, numberOfSubCorridor);
        ControllerHelperInterface controllerHelper = new ControllerHelperImpl();
        SubCorridorInterface subCorridorInterface = controllerHelper.minimisePowerConsumption(moverment_in_floorNumber, moverment_in_subCorridor, inputConfiguration);

        // Light should be On for curent Sub Corriodr
        Assert.assertTrue(subCorridorInterface.getLight_ON());

        //check for others instruments

        for (int i = 0; i < numberOfFloors; i++) {
            // for corridor defaultcase
            for (int j = 0; j < numberofCorridor; j++) {
                Assert.assertTrue(corridorList.get(j).getAC_ON());
                Assert.assertTrue(corridorList.get(j).getLight_ON());
            }

            // for SubCorridor default case
            for (int j = 0; j < numberOfSubCorridor; j++) {
                if (subCorridorInterface.equals(subCorridorList.get(j))){
                    // Ac Could be off or ON
                    Assert.assertTrue(subCorridorList.get(j).getLight_ON());
                }else {
                    Assert.assertTrue(subCorridorList.get(j).getAC_ON());
                    Assert.assertFalse(subCorridorList.get(j).getLight_ON());
                }
            }
        }
    }


    @Test
    public void caseForIdleAfterMovementinSubCorridor() throws InterruptedException {
        InstrumentInputConfiguration inputConfiguration = new InstrumentInputConfiguration();
        inputConfiguration.setInstrumentInput(numberOfSubCorridor, numberofCorridor, numberOfFloors);
        Integer moverment_in_floorNumber = ThreadLocalRandom.current().nextInt(1, numberOfFloors);
        Integer moverment_in_subCorridor = ThreadLocalRandom.current().nextInt(1, numberOfSubCorridor);
        ControllerHelperInterface controllerHelper = new ControllerHelperImpl();
        SubCorridorInterface subCorridorInterface = controllerHelper.minimisePowerConsumption(moverment_in_floorNumber, moverment_in_subCorridor, inputConfiguration);
        long timeOfLastStateChange = System.currentTimeMillis() / 1000;
        // Light should be On for curent Sub Corriodr
        Assert.assertTrue(subCorridorInterface.getLight_ON());

        //check for others instruments

        for (int i = 0; i < numberOfFloors; i++) {
            // for corridor defaultcase
            for (int j = 0; j < numberofCorridor; j++) {
                Assert.assertTrue(corridorList.get(j).getAC_ON());
                Assert.assertTrue(corridorList.get(j).getLight_ON());
            }

            // for SubCorridor default case
            for (int j = 0; j < numberOfSubCorridor; j++) {
                if (subCorridorInterface.equals(subCorridorList.get(j))){
                    // Ac Could be off or ON
                    Assert.assertTrue(subCorridorList.get(j).getLight_ON());
                }else {
                    Assert.assertTrue(subCorridorList.get(j).getAC_ON());
                    Assert.assertFalse(subCorridorList.get(j).getLight_ON());
                }
            }
        }

        //wait for 60 seconds to change to default state
        Thread.sleep(60000l);
        controllerHelper.changeSubCorridorStateToDefault(subCorridorInterface);

        // now check if instrument  goes to default state
        for (int i = 0; i < numberOfFloors; i++) {
            // for corridor defaultcase
            for (int j = 0; j < numberofCorridor; j++) {
                Assert.assertTrue(corridorList.get(j).getAC_ON());
                Assert.assertTrue(corridorList.get(j).getLight_ON());
            }

            // for SubCorridor default case
            for (int j = 0; j < numberOfSubCorridor; j++) {
                Assert.assertTrue(subCorridorList.get(j).getAC_ON());
                Assert.assertFalse(subCorridorList.get(j).getLight_ON());
            }
        }
    }
}
