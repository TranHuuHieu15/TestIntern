package hieutran.testintern.mapper;


import hieutran.testintern.dto.UserDTO;
import hieutran.testintern.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserMapper implements Function<User, UserDTO> {
    @Override
    public  UserDTO apply(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .fullname(user.getFullname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    public static User applyToEntity(UserDTO userDTO) {
        return User.builder()
                .username(userDTO.getUsername())
                .fullname(userDTO.getFullname())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .build();
    }
}
