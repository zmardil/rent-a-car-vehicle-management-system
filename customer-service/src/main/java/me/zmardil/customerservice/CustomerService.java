package me.zmardil.customerservice;

import lombok.RequiredArgsConstructor;
import me.zmardil.customerservice.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerProducer customerProducer;

    private final ModelMapper modelMapper;

    public Customer createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerRepository.save(modelMapper.map(customerRequestDTO, Customer.class));
        customerProducer.sendMessage(modelMapper.map(customer, CustomerEvent.class), "create");
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(UUID id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Customer of Id %s not found.", id)));
    }
}
