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
        List<Customer> customers = List.of(
            Customer.builder().firstName("John").lastName("Doe").build(),
            Customer.builder().firstName("Jane").lastName("Doe").build()
        );

        customers.forEach(customerService::createCustomer);
    }
}
