package me.zmardil.vehicleservice;

import lombok.Builder;
import lombok.Data;
import me.zmardil.vehicleservice.shared.Status;

import java.time.Year;

@Data
@Builder
public class VehicleRequestDTO {
    private String brand;
    private String model;
    private Year year;
    private String type;
    private Status status;
}
