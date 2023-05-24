package me.zmardil.vehicleservice;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.UUID;

@Data
@NoArgsConstructor
public class VehicleEvent {
    private UUID id;
    private String brand;
    private String model;
    private Year year;
    private String type;
}
