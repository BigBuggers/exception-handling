package com.buggers.exceptionhandling.controller;


import com.buggers.exceptionhandling.dto.UserDTO;
import com.buggers.exceptionhandling.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        var responseBody = userService.getUsers();
        return ResponseEntity.ok(responseBody);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable("userId") String userId, @Valid @RequestBody UserDTO userDTO) {
        userService.updateUser(userId, userDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

}
