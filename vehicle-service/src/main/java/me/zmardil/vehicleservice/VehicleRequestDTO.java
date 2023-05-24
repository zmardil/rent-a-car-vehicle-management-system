package me.zmardil.vehicleservice;

import lombok.Builder;
import lombok.Data;

import java.time.Year;

@Data
@Builder
public class VehicleRequestDTO {
    private String brand;
    private String model;
    private Year year;
    private String type;
}
