package com.harishSekar.controller;


import com.harishSekar.entity.Vehicle;
import com.harishSekar.services.VehicleServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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






    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAllVehicles(){
        return vehicleServiceModel.findAllVehicles();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/vin={vehicleVin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findVehicleById(@PathVariable("vehicleVin") String vin){
        return vehicleServiceModel.findVehicleById(vin);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public String createVehicle(@RequestBody List<Vehicle> vehicle){
            String output = "";
            for(Vehicle vehicle1:vehicle){
                output += vehicleServiceModel.createVehicle(vehicle1);
            }
            return output;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateVin={vehicleVin}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle updateVehicle(@PathVariable("vehicleVin") String vin, @RequestBody Vehicle vehicle){
        return vehicleServiceModel.updateVehicle(vin,vehicle);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delVin={vehicleVin}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteVehicle(@PathVariable("vehicleVin") String vin){
        vehicleServiceModel.deleteVehicle(vin);

    }


}
