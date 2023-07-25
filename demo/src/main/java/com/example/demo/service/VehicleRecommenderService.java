package com.example.demo.service;

import com.example.demo.dto.VehicleDTO;

import java.util.List;

public interface VehicleRecommenderService {

    public String createVehicleData();
    public List<VehicleDTO> findRecommendedVehicle(int locationId, int passengerCount);

}
