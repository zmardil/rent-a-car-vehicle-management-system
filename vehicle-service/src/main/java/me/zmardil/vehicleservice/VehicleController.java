package me.zmardil.vehicleservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Vehicle> post(@RequestBody VehicleRequestDTO vehicleRequestDTO) {
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> get() {
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> get(@PathVariable UUID id) {
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.FOUND);
    }

}
