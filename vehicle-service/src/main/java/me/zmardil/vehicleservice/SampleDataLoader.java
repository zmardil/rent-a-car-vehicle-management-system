package me.zmardil.vehicleservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SampleDataLoader implements CommandLineRunner {

    private final VehicleService vehicleService;

    @Override
    public void run(String... args) throws Exception {
        List<VehicleRequestDTO> vehicles = List.of(
            VehicleRequestDTO.builder().brand("Toyota").model("Corolla").year(Year.of(2017)).type("Sedan") .build(),
            VehicleRequestDTO.builder().brand("Ford").model("Ranger").year(Year.of(2018)).type("Truck") .build(),
            VehicleRequestDTO.builder().brand("Land Rover").model("Range Rover").year(Year.of(2022)).type("SUV") .build()
        );

        vehicles.forEach(vehicleService::createVehicle);
    }
}
