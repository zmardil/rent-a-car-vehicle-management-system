package me.zmardil.customerservice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequestDTO {
    private String firstName;
    private String lastName;
}
