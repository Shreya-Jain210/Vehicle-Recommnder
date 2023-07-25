package com.example.demo.vehiclemodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(force = true)
@Data
@Table(name="Vehicle")
@AllArgsConstructor
public class Vehicle {
    @Id
    @Column(unique = true)
    private int locationId;
    private String vehicleNumber;
    private String vehicleCategory;
    private int passengerCapacity;
    private boolean isAvailable;
    private String driverContactNo;
}
