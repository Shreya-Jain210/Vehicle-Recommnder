package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Data
@AllArgsConstructor
public class VehicleDTO {
    private int locationId;
    private String vehicleNumber;
    private String vehicleCategory;
    private String driverContactNo;

}
