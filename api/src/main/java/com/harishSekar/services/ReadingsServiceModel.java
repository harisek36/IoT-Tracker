package com.harishSekar.services;

import com.harishSekar.entity.Readings;

import java.util.List;

public interface ReadingsServiceModel {
    public List<Readings> findReadings();

    public Readings findReadingById(String ID);

    public List<Readings> findReadingByVin(String ID);

    public String postReading(Readings reading);
}
