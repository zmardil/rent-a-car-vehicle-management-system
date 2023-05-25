package me.zmardil.identityservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.zmardil.identityservice.UserMapper;
import me.zmardil.identityservice.dto.UserRequestDTO;
import me.zmardil.identityservice.dto.UserResponseDTO;
import me.zmardil.identityservice.entity.User;
import me.zmardil.identityservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.mapToUser(userRequestDTO);
        log.info(user.getUsername(), user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.mapToResponseDTO(user);
    }
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
