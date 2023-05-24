package me.zmardil.customerservice;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class CustomerEvent {
    private UUID id;
    private String firstName;
    private String lastName;
}
