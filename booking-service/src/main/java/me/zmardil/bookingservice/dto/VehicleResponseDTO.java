package me.zmardil.bookingservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import me.zmardil.bookingservice.shared.Status;

import java.time.Year;
import java.util.UUID;

@Data
@ToString
public class VehicleResponseDTO {
    private UUID id;
    private String brand;
    private String model;
    private Year year;
    private String type;
    private Status status;
}
