package com.buggers.exceptionhandling.controller;


import com.buggers.exceptionhandling.dto.User;
import com.buggers.exceptionhandling.service.UserService;
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
    public ResponseEntity<User> addUser(@RequestBody User user) {

        var responseBody = userService.addUser(user);
        var customResponseHeaders = new HttpHeaders();
        customResponseHeaders.add("custom-header", "custom-header-value");

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(customResponseHeaders)
                .body(responseBody);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {

        var responseBody = userService.getUsers();
        return ResponseEntity.ok(responseBody);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable("userId") String userId, @RequestBody User user) {

        var isUpdated = userService.updateUser(userId, user);
        return ResponseEntity.status(isUpdated ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND)
                .build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId) {

        var isDeleted = userService.deleteUser(userId);
        return ResponseEntity.status(isDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND)
                .build();
    }

}
