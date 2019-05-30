package com.harishSekar.Repository;

import com.harishSekar.entity.Readings;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReadingsRepository implements ReadingsRepositoryModel {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Readings> findReadings() {
        TypedQuery<Readings> query = entityManager.createNamedQuery("Readings.findAll",Readings.class);
        return query.getResultList();

    }

    public Readings findReadingById(String ID) {
         return entityManager.find(Readings.class,ID) ;
    }


    public List<Readings> findReadingByVin(String vin) {
        return entityManager.createNamedQuery("Readings.findbyVin",Readings.class).setParameter("vin",vin).getResultList();
    }

    public String postReading(Readings reading) {
        entityManager.merge(reading);
        return reading.getReadingID()+" -> Posted in DB ";
    }
}
