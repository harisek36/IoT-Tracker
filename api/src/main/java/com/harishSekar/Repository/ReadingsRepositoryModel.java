package com.harishSekar.Repository;

import com.harishSekar.entity.Readings;

import java.util.List;

public interface ReadingsRepositoryModel {

    public List<Readings> findReadings();

    public Readings findReadingById(String ID);

    public String postReading(Readings reading);
}
