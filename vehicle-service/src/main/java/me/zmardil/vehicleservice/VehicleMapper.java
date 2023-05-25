package me.zmardil.vehicleservice;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    Vehicle map(VehicleRequestDTO vehicleRequestDTO);
    void updateVehicleFromDTO(@MappingTarget Vehicle vehicle, VehicleRequestDTO vehicleRequestDTO);
}
