package com.harishSekar.controller;

import com.harishSekar.entity.Readings;
import com.harishSekar.services.ReadingsServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"},methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},maxAge = 3600)


@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    ReadingsServiceModel readingsServiceModel;

    @RequestMapping(method = RequestMethod.GET)
    public List<Readings> findReadings(){
        return readingsServiceModel.findReadings();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/id={readingID}")
    public Readings findReadingById(@PathVariable("readingID") String ID){
        return readingsServiceModel.findReadingById(ID);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/vin={vinID}")
    public List<Readings> findReadingByVin(@PathVariable("vinID") String vin){
        return readingsServiceModel.findReadingByVin(vin);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postReading(@RequestBody Readings reading) {

        return readingsServiceModel.postReading(reading);

    }



}
