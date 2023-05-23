package me.zmardil.vehicleservice;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.zmardil.vehicleservice.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(UUID id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Vehicle of Id %s not found.", id)));
    }
}
