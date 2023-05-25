package me.zmardil.vehicleservice;

import lombok.RequiredArgsConstructor;
import me.zmardil.vehicleservice.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public Vehicle createVehicle(VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = vehicleRepository.save(vehicleMapper.map(vehicleRequestDTO));
        return vehicle;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(UUID id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Vehicle of Id %s not found.", id)));
    }

    public Vehicle putVehicleById(UUID id, VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Vehicle of Id %s not found.", id)));
        vehicleMapper.updateVehicleFromDTO(vehicle, vehicleRequestDTO);
        return vehicleRepository.save(vehicle);
    }

}
