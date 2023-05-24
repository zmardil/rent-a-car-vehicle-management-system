package me.zmardil.bookingservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.zmardil.bookingservice.dto.CustomerResponseDTO;
import me.zmardil.bookingservice.dto.VehicleResponseDTO;
import me.zmardil.bookingservice.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class BookingService {
    private final BookingRepository bookingRepository;
    private final WebClient.Builder webClientBuilder;

    public Booking createBooking(Booking booking) {
        VehicleResponseDTO vehicle = webClientBuilder.build().get()
                .uri("http://VEHICLE-SERVICE/api/v1/vehicles/{vehicleId}", booking.getVehicleId())
                .retrieve()
                .bodyToMono(VehicleResponseDTO.class)
                .block();

        CustomerResponseDTO customer = webClientBuilder.build().get()
                .uri("http://CUSTOMER-SERVICE/api/v1/customers/{customerId}", booking.getCustomerId())
                .retrieve()
                .bodyToMono(CustomerResponseDTO.class)
                .block();

        if(customer == null || vehicle == null) throw new IllegalArgumentException("Invalid vehicle or customer details");

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(UUID id) {
        return bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Booking of Id %s not found.", id)));
    }
}
