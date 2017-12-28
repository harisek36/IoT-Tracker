package com.harishSekar.Repository;

import com.harishSekar.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepositoryModel {
    List<Vehicle> findAllVehicles();

    Vehicle findVehicleById(String vin);

    void createVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle);

    void deleteVehicle(Vehicle vehicle);

}
