package com.buggers.exceptionhandling.service;



import com.buggers.exceptionhandling.dto.UserDTO;

import java.util.List;


public interface UserService {
    void addUser(UserDTO userDTO);

    List<UserDTO> getUsers();

    void updateUser(String userId, UserDTO userDTO);

    void deleteUser(String userId);
}
