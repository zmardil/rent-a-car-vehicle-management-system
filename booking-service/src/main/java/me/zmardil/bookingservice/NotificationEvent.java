package me.zmardil.bookingservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationEvent {
    @Builder.Default
    private LocalTime time = LocalTime.now();
    private String message;
}
