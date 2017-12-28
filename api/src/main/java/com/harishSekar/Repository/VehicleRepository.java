package com.harishSekar.Repository;

import com.harishSekar.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepository implements VehicleRepositoryModel {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Vehicle> findAllVehicles() {

        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll",Vehicle.class);
        return query.getResultList();

    }

    public Vehicle findVehicleById(String vin) {
        return entityManager.find(Vehicle.class,vin) ;
    }

    public void createVehicle(Vehicle vehicle) {
         entityManager.persist(vehicle);
    }

    public Vehicle updateVehicle(Vehicle vehicle) {

        return entityManager.merge(vehicle);
    }

    public void deleteVehicle(Vehicle vehicle) {
        entityManager.remove(vehicle);

    }
}
