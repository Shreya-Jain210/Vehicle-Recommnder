package com.example.demo.controller;

import com.example.demo.service.VehicleRecommenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {
    @Autowired
    VehicleRecommenderService service;
    @PostMapping("/dataentry")
    public ResponseEntity<?> dataEntry(){
        return ResponseEntity.status(HttpStatus.OK).body(service.createVehicleData());

    }
    @GetMapping("/recommender")
    public ResponseEntity<?> find(@RequestParam("locId") int locId, @RequestParam("count") int count){
        return ResponseEntity.status(HttpStatus.OK).body(service.findRecommendedVehicle(locId,count));
    }

}
