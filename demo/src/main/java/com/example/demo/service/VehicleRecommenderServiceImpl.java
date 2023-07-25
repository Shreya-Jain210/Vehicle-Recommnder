package com.example.demo.service;

import com.example.demo.dto.VehicleDTO;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.vehiclemodel.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class VehicleRecommenderServiceImpl implements VehicleRecommenderService{
    @Autowired
    VehicleRepository repository;

    @Override
    public String createVehicleData() {
        Vehicle vehicle=new Vehicle(100, "HR-26 0091", "car", 4, true, "090909878" );
        Vehicle vehicle1=new Vehicle(201, "HR-26 7896", "auto",2, true, "09876534");
        Vehicle vehicle2=new Vehicle(301, "HR-26 2345", "car", 5, true, "78902564");
        Vehicle vehicle3=new Vehicle(11, "HR-26 8798", "car", 4, false, "987654");
        Vehicle vehicle4=new Vehicle(101, "HR-26 6754", "auto", 2, false, "78990245");
        Vehicle vehicle5=new Vehicle(110, "HR-26 7891", "bike", 1, true, "87902453");
        Vehicle vehicle6=new Vehicle(102, "HR-26 5678", "bike", 1, false, "78902453");
        repository.save(vehicle);
        repository.save(vehicle1);
        repository.save(vehicle2);
        repository.save(vehicle3);
        repository.save(vehicle4);
        repository.save(vehicle5);
        repository.save(vehicle6);
        return "7 entries of data created";
    }

    @Override
    public List<VehicleDTO> findRecommendedVehicle(int locationId, int passengerCount) {
        List<Vehicle> availableVehicles = repository.findAllByIsAvailableTrue();
        PriorityQueue<Vehicle> minHeap = new PriorityQueue<>(Comparator.comparingInt(v -> calculateDistance(v.getLocationId(), locationId)));
        for (Vehicle vehicle : availableVehicles) {
            if (vehicle.getPassengerCapacity() >= passengerCount) {
                minHeap.offer(vehicle);
            }
        }
        List<VehicleDTO> nearestVehicles = new ArrayList<>();
        while (!minHeap.isEmpty() && nearestVehicles.size() < 3) {
            Vehicle vehicle=minHeap.poll();
            VehicleDTO vehicleDTO=new VehicleDTO(vehicle.getLocationId(),vehicle.getVehicleNumber(),vehicle.getVehicleCategory(),vehicle.getDriverContactNo());
            nearestVehicles.add(vehicleDTO);
        }
        return nearestVehicles;
      }

    private int calculateDistance(int locationId1, int locationId2) {
        return (locationId1 - locationId2) * (locationId1 - locationId2);
    }

}
