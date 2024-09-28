package hieutran.testintern.controller;

import hieutran.testintern.dto.UserDTO;
import hieutran.testintern.dto.response.ResponseSuccess;
import hieutran.testintern.entity.User;
import hieutran.testintern.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseSuccess<UserDTO> getUserById(@PathVariable("userId") Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return new ResponseSuccess<>(LocalDateTime.now(), HttpStatus.OK.value(), "Get user by id successfully", userDTO);
    }

    @PostMapping
    public ResponseSuccess<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseSuccess<>(LocalDateTime.now(), HttpStatus.CREATED.value(), "Create user successfully", createdUser);
    }

    @PutMapping("/{userId}")
    public ResponseSuccess<UserDTO> updateUser(@PathVariable("userId") Long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        return new ResponseSuccess<>(LocalDateTime.now(), HttpStatus.OK.value(), "Update user successfully", updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseSuccess<Void> deleteUserById(@PathVariable("userId") Long id) {
        userService.deleteUserById(id);
        return new ResponseSuccess<>(LocalDateTime.now(), HttpStatus.OK.value(), "Delete user successfully", null);
    }

    @GetMapping
    public ResponseSuccess<List<UserDTO>> getAllUsers() {
        List<UserDTO> list = userService.getAllUsers();
        return new ResponseSuccess<>(LocalDateTime.now(), HttpStatus.OK.value(), "Get all users successfully", list);
    }
}
