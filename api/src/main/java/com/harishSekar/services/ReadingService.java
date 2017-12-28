package com.harishSekar.services;

import com.harishSekar.Repository.ReadingsRepositoryModel;
import com.harishSekar.entity.Readings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class ReadingService implements ReadingsServiceModel {

    @Autowired
    ReadingsRepositoryModel readingsRepositoryModel;

    @Transactional(readOnly = true)
    public List<Readings> findReadings() {
        return readingsRepositoryModel.findReadings();
    }

    @Transactional(readOnly = true)
    public Readings findReadingById(String ID) {
        return readingsRepositoryModel.findReadingById(ID);
    }

    @Transactional
    public String postReading(Readings reading) {
        return readingsRepositoryModel.postReading(reading);
    }
}
