package me.zmardil.bookingservice.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerResponseDTO {
    private String id;
    private String firstName;
    private String lastName;
}
