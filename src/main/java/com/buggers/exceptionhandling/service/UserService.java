package com.buggers.exceptionhandling.service;



import com.buggers.exceptionhandling.dto.User;

import java.util.List;


public interface UserService {
    User addUser(User user);

    List<User> getUsers();

    boolean updateUser(String userId, User user);

    boolean deleteUser(String userId);
}
