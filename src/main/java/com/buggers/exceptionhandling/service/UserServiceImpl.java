package com.buggers.exceptionhandling.service;

import com.buggers.exceptionhandling.dto.UserDTO;
import com.buggers.exceptionhandling.exception.ErrorMessage;
import com.buggers.exceptionhandling.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final List<UserDTO> userDTOS;

    UserServiceImpl() {
        userDTOS = new ArrayList<>();
    }

    @Override
    public void addUser(UserDTO userDTO) {
        userDTOS.add(userDTO);

    }

    @Override
    public List<UserDTO> getUsers() {
        return userDTOS;
    }

    @Override
    public void updateUser(String userId, UserDTO updatedUserDTO) {

         userDTOS.stream()
                .filter(userDTO -> userDTO.getUserId().equals(updatedUserDTO.getUserId()))
                .findFirst()
                .map(userDTO -> {
                    userDTO.setUsername(updatedUserDTO.getUsername());
                    userDTO.setEmail(updatedUserDTO.getEmail());
                    userDTO.setUserId(updatedUserDTO.getUserId());
                    userDTO.setPassword(updatedUserDTO.getPassword());
                    return  userDTO;
                }).orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.NOT_FOUND));
    }

    @Override
    public void deleteUser(String userId) {
        var isRemoved = userDTOS.removeIf(userDTO -> Objects.equals(userDTO.getUserId(), userId));
        if (!isRemoved) {
            throw new ResourceNotFoundException(ErrorMessage.NOT_FOUND);
        }

    }

}
