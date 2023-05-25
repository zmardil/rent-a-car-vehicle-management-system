package me.zmardil.vehicleservice;

import jakarta.persistence.*;
import lombok.*;
import me.zmardil.vehicleservice.shared.Status;

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
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status = Status.AVAILABLE;
}
