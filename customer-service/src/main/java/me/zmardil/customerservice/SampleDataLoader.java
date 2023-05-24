package me.zmardil.customerservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SampleDataLoader implements CommandLineRunner {

    private final CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        List<CustomerRequestDTO> customers = List.of(
            CustomerRequestDTO.builder().firstName("John").lastName("Doe").build(),
            CustomerRequestDTO.builder().firstName("Jane").lastName("Doe").build()
        );

        customers.forEach(customerService::createCustomer);
    }
}
