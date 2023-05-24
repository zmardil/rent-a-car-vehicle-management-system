package me.zmardil.bookingservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class BookingRequestDTO {
    private UUID vehicleId;
    private UUID customerId;
    private LocalTime startTime;
    private LocalTime endTime;
}
