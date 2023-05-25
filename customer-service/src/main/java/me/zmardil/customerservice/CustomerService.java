package me.zmardil.customerservice;

import lombok.RequiredArgsConstructor;
import me.zmardil.customerservice.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public Customer createCustomer(CustomerRequestDTO customerRequestDTO) {
        return customerRepository.save(customerMapper.map(customerRequestDTO));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(UUID id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Customer of Id %s not found.", id)));
    }
}
