package com.harishSekar.controller;


import com.harishSekar.entity.Vehicle;
import com.harishSekar.services.VehicleServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
//@Controller    -> same as @Component                          ]
//@ResponseBody  -> convert the O/P into JSON obj using jackson ] ---> @RestController

@CrossOrigin(origins = {"*"},methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},maxAge = 3600)


@RestController
@RequestMapping(value = "/vehicles")   // 'path' variable can be used instead of 'value'
public class VehicleController {

    @Autowired
    VehicleServiceModel vehicleServiceModel;

    @GetMapping
    public List<Vehicle> findAllVehicles(){
        return vehicleServiceModel.findAllVehicles();
    }

    @GetMapping(value = "/vin={vehicleVin}")
    public Vehicle findVehicleById(@PathVariable("vehicleVin") String vin){
        return vehicleServiceModel.findVehicleById(vin);
    }
    
    @PutMapping
    public String createVehicle(@RequestBody List<Vehicle> vehicle){
            String output = "";
            for(Vehicle vehicle1:vehicle){
                output += vehicleServiceModel.createVehicle(vehicle1);
            }
            return output;
    }

    @PostMapping(value = "/updateVin={vehicleVin}")
    public Vehicle updateVehicle(@PathVariable("vehicleVin") String vin, @RequestBody Vehicle vehicle){
        return vehicleServiceModel.updateVehicle(vin,vehicle);
    }

    @DeleteMapping(value = "/delVin={vehicleVin}")
    public void deleteVehicle(@PathVariable("vehicleVin") String vin){
        vehicleServiceModel.deleteVehicle(vin);

    }


}
