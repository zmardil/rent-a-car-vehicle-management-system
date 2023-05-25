package me.zmardil.customerservice;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer map(CustomerRequestDTO customerRequestDTO);

    void updateCustomerFromDTO(@MappingTarget Customer customer, CustomerRequestDTO customerRequestDTO);
}
