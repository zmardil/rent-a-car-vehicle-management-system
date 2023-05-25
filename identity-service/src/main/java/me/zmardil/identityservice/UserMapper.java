package me.zmardil.identityservice;

import me.zmardil.identityservice.dto.UserRequestDTO;
import me.zmardil.identityservice.dto.UserResponseDTO;
import me.zmardil.identityservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToUser(UserRequestDTO userRequestDTO);
    UserResponseDTO mapToResponseDTO(User user);
}
