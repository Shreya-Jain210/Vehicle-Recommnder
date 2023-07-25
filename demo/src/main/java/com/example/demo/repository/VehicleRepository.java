package com.example.demo.repository;

import com.example.demo.vehiclemodel.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

    public List<Vehicle> findAllByIsAvailableTrue();

}
