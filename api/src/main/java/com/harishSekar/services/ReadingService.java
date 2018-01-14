package com.harishSekar.services;

import com.harishSekar.Repository.ReadingsRepositoryModel;
import com.harishSekar.Repository.VehicleRepositoryModel;
import com.harishSekar.entity.Readings;
import com.harishSekar.entity.Vehicle;
import com.harishSekar.exceptions.BadRequestException;
import com.harishSekar.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;



@Service

public class ReadingService implements ReadingsServiceModel {

    public enum Level {
        HIGH,
        MEDIUM,
        LOW
    }

    /*
    Create alerts with given priority when following rules are triggered
        Rule: engineRpm > readlineRpm, Priority: HIGH
        Rule: fuelVolume < 10% of maxFuelVolume, Priority: MEDIUM
        Rule: tire pressure of any tire < 32psi || > 36psi , Priority: LOW
        Rule: engineCoolantLow = true || checkEngineLightOn = true, Priority: LOW
     */

    @Autowired
    ReadingsRepositoryModel readingsRepositoryModel;
    @Autowired
    VehicleRepositoryModel vehicleRepository;

    @Transactional(readOnly = true)
    public List<Readings> findReadings() {
        return readingsRepositoryModel.findReadings();
    }

    @Transactional(readOnly = true)
    public Readings findReadingById(String ID) {
        Readings foundReading = readingsRepositoryModel.findReadingById(ID);
        if(foundReading == null){
            throw new BadRequestException("Invalid Reading ID");
        }
        return foundReading;
    }

    @Transactional
    public String postReading(Readings reading) {
        Vehicle vehicle_existing = vehicleRepository.findVehicleById(reading.getVin());

        if (vehicle_existing.getVin()!= null) {

            readingsRepositoryModel.postReading(reading);
            // Rule: engineRpm > readlineRpm, Priority: HIGH

            if(reading.getEngineRpm() > vehicle_existing.getRedlineRpm()){
                JOptionPane.showMessageDialog(null, Level.HIGH+"engineRpm > readlineRpm");


            }

            // Rule: fuelVolume < 10% of maxFuelVolume, Priority: MEDIUM
            if(reading.getFuelVolume() < (0.1 * vehicle_existing.getMaxFuelVolume())){
//                JOptionPane.showMessageDialog(null, "Priority: MEDIUM, Fuel less the 10% !!");

            }
            // Rule: tire pressure of any tire < 32psi || > 36psi , Priority: LOW

            if((reading.getFrontLeft() + reading.getFrontRight() + reading.getRearLeft()+ reading.getRearRight()) < 124 ||
                    ((reading.getFrontLeft() + reading.getFrontRight() + reading.getRearLeft()+ reading.getRearRight())>124)){
//                JOptionPane.showMessageDialog(null, "Priority: LOW, Check tire Pressure !!");

            }
            // Rule: engineCoolantLow = true || checkEngineLightOn = true, Priority: LOW
            if(reading.isCheckEngineLightOn() || reading.isCheckEngineLightOn()){
//                JOptionPane.showMessageDialog(null, "Priority: LOW, Service Engine !!");

            }

            return "Reading with ID "+reading.getReadingID()+" posted into DB";
        } else {
            throw new ResourceNotFoundException("Vehicle with VIN: " + reading.getVin() + " does't exist");

        }
    }
}
