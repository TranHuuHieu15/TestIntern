package hieutran.testintern.service.impl;

import hieutran.testintern.dto.UserDTO;
import hieutran.testintern.entity.User;
import hieutran.testintern.exception.ConflictException;
import hieutran.testintern.exception.NotFoundException;
import hieutran.testintern.mapper.UserMapper;
import hieutran.testintern.repository.UserRepository;
import hieutran.testintern.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return userMapper.apply(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.applyToEntity(userDTO);
        User existedUser = userRepository.findByEmail(user.getEmail());
        if (existedUser != null) {
            throw new ConflictException("Email is already taken!");
        }
        User checkPhone = userRepository.findByPhone(user.getPhone());
        if (checkPhone != null) {
            throw new ConflictException("Phone is already taken!");
        }
        User savedUser = userRepository.save(user);
        return userMapper.apply(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        User existedUser = userRepository.findByEmail(userDTO.getEmail());
        if (existedUser != null && !existedUser.getId().equals(id) && !user.getEmail().equals(existedUser.getEmail())) {
            throw new ConflictException("Email is already taken!");
        }
        User checkPhone = userRepository.findByPhone(userDTO.getPhone());
        if (checkPhone != null && !checkPhone.getId().equals(id) && !user.getPhone().equals(checkPhone.getPhone())) {
            throw new ConflictException("Phone is already taken!");
        }

        user.setEmail(userDTO.getEmail());
        user.setFullname(userDTO.getFullname());
        user.setPhone(userDTO.getPhone());
        user.setUsername(userDTO.getUsername());

        User updatedUser = userRepository.save(user);

        return userMapper.apply(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        userRepository.deleteById(user.getId());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> listUserDTO = userRepository.findAll().stream().map(userMapper).toList();
        return listUserDTO;
    }
}
