package hieutran.testintern.service;

import hieutran.testintern.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUserById(Long id);
    List<UserDTO> getAllUsers();
}
