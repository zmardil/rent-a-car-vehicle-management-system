package me.zmardil.vehicleservice;

import lombok.RequiredArgsConstructor;
import me.zmardil.vehicleservice.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    private final VehicleProducer vehicleProducer;
    private final ModelMapper modelMapper;

    public Vehicle createVehicle(VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = vehicleRepository.save(modelMapper.map(vehicleRequestDTO, Vehicle.class));
        vehicleProducer.sendMessage(modelMapper.map(vehicle, VehicleEvent.class), "create");
        return vehicle;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(UUID id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Vehicle of Id %s not found.", id)));
    }
}
