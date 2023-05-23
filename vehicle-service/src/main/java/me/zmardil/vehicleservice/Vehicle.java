package me.zmardil.vehicleservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.Year;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private UUID id;
    private String brand;
    private String model;
    private Year year;
    private String type;
}
