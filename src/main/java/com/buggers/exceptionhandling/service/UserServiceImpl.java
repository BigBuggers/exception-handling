package com.buggers.exceptionhandling.service;

import com.buggers.exceptionhandling.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users;

    UserServiceImpl() {
        users = new ArrayList<>();
    }

    @Override
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean updateUser(String userId, User updatedUser) {

        return users.stream()
                .filter(user -> user.getUserId().equals(updatedUser.getUserId()))
                .findFirst()
                .map(user -> {
                    user.setUserName(updatedUser.getUserName());
                    user.setEmail(updatedUser.getEmail());
                    user.setUserId(updatedUser.getUserId());
                    user.setPassword(updatedUser.getPassword());
                    return true;
                }).orElse(false);
    }

    @Override
    public boolean deleteUser(String userId) {
        return users.removeIf(user -> Objects.equals(user.getUserId(), userId));
    }

}
