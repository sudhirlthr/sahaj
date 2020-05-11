package com.sudhir.hotelautomation;

import com.sudhir.hotelautomation.controller.InstrumentControllerImpl;
import com.sudhir.hotelautomation.helpers.ControllerHelperImpl;
import com.sudhir.hotelautomation.interfaces.ControllerHelperInterface;
import com.sudhir.hotelautomation.interfaces.Floor;
import com.sudhir.hotelautomation.interfaces.SubCorridorInterface;
import com.sudhir.hotelautomation.interfaces.TotalPowerConsumption;
import com.sudhir.hotelautomation.util.InstrumentInputConfiguration;
import com.sudhir.hotelautomation.util.PropertyFileUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class MainController {
    public static void main(String[] args) throws IOException, InterruptedException {
        //System.out.println("number of Floor: "+PropertyFileUtility.getEnumParameterValue("number_of_foors"));

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of Floors");
        Integer numberOfFloor = Integer.parseInt(inputReader.readLine());
        System.out.println("Enter number of Corridor in each floor");
        Integer numberOfCorridor = Integer.parseInt(inputReader.readLine());
        System.out.println("Enter number of Sub-corridor in each floor");
        Integer numberOfSubCorridor = Integer.parseInt(inputReader.readLine());

        // input to Instrument
        InstrumentInputConfiguration inputConfiguration = new InstrumentInputConfiguration();
        inputConfiguration.setInstrumentInput(numberOfSubCorridor, numberOfCorridor, numberOfFloor);

        //print default configuration
        inputConfiguration.printDefaultInstrumentState();

        //get maximum power consumption for each formula as per given constrains
        Integer maxPowerConsumption = TotalPowerConsumption.getMaxPowerConsumption(numberOfCorridor, numberOfSubCorridor);

        // Check if given input does not cross maximum power consumption
        // if max power limit cross then minimize consumption by switching off instruments
        InstrumentControllerImpl instrumentController = new InstrumentControllerImpl();


        long subCorridorStateChangedSince = 0;
        while (true){
            //print default configuration
            inputConfiguration.printDefaultInstrumentState();

            Integer currentPowerConsumption = instrumentController.getCurrentPowerConsumption(inputConfiguration.getFloorList());
            if (currentPowerConsumption > maxPowerConsumption) {
                instrumentController.minimizePowerConsumption(inputConfiguration.getFloorList(), currentPowerConsumption);
            }


            //movement in any floors sub-corridor
            // create random number to set movement in a floor and and respective sub-corridor
            Integer moverment_in_floorNumber = ThreadLocalRandom.current().nextInt(1, numberOfFloor);
            Integer moverment_in_subCorridor = ThreadLocalRandom.current().nextInt(1, numberOfSubCorridor);
            ControllerHelperInterface controllerHelper = new ControllerHelperImpl();
            SubCorridorInterface subCorridorInterface = controllerHelper.minimisePowerConsumption(moverment_in_floorNumber, moverment_in_subCorridor, inputConfiguration);

            // get the current time and count if no movement in 60 Seconds then set instruments to default
            subCorridorStateChangedSince = System.currentTimeMillis();

            // generate any number assuming if any movement(randomw number get generated within 60 seconds)
            // then again wait for 60 seconds to make Subcorridor idol
            long movementInSameCorridor = ThreadLocalRandom.current().nextLong(1, 100);
            if (movementInSameCorridor < 60)
                subCorridorStateChangedSince = System.currentTimeMillis();
            else if (movementInSameCorridor >= 60) //change SubCoriidor state to default
                controllerHelper.changeSubCorridorStateToDefault(subCorridorInterface);
        }
    }
}
