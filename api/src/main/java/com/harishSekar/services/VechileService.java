package com.harishSekar.services;

import com.harishSekar.Repository.VehicleRepositoryModel;
import com.harishSekar.entity.Vehicle;
import com.harishSekar.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // Bussiness Logic
public class VechileService implements VehicleServiceModel {

    @Autowired
    VehicleRepositoryModel vehicleRepository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAllVehicles();
    }

    @Transactional(readOnly = true)
    public Vehicle findVehicleById(String vin) {
        Vehicle vehicle = vehicleRepository.findVehicleById(vin);

        if(vehicle == null){
            throw new ResourceNotFoundException("Vehicle with VIN: "+vin +" does't exist");
        }
        return vehicle;
    }

    @Transactional
    public String createVehicle(Vehicle vehicle) {

        if(vehicleRepository.findVehicleById(vehicle.getVin()) == null){
            vehicleRepository.createVehicle(vehicle);
            return  vehicle.getVin() + " -> Created in DB\n";
        }else{
            vehicleRepository.updateVehicle(vehicle);

            return vehicle.getVin() +" -> Updated in DB \n";
        }
    }

    @Transactional
    public Vehicle updateVehicle(String vin, Vehicle vehicle) {
        Vehicle vehicle_existing = vehicleRepository.findVehicleById(vin);
        if(vehicle_existing == null){
            // throw 404
        }
        return vehicleRepository.updateVehicle(vehicle);
    }

    @Transactional
    public void deleteVehicle(String vin) {
        Vehicle vehicle_ = vehicleRepository.findVehicleById(vin);
        if(vehicle_ == null){
            // throw 400
        }
        vehicleRepository.deleteVehicle(vehicle_);
    }
}
