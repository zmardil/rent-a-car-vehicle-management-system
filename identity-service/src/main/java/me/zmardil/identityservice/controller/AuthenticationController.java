package me.zmardil.identityservice.controller;

import lombok.RequiredArgsConstructor;
import me.zmardil.identityservice.UserMapper;
import me.zmardil.identityservice.dto.UserRequestDTO;
import me.zmardil.identityservice.dto.UserResponseDTO;
import me.zmardil.identityservice.entity.User;
import me.zmardil.identityservice.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(authenticationService.createUser(userRequestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody UserRequestDTO userRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequestDTO.getUsername(), userRequestDTO.getPassword()));
        if(!authentication.isAuthenticated()) throw new RuntimeException("Invalid access");
        return authenticationService.generateToken(userRequestDTO.getUsername());
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam UserRequestDTO userRequestDTO) {
        authenticationService.validateToken(userRequestDTO.getUsername());
        return "Token is valid";
    }
}
