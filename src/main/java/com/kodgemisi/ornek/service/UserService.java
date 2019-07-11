package com.kodgemisi.ornek.service;

import com.kodgemisi.ornek.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    Iterable<User> getUsers();

    List<String> getUsernames();

    User getUserByUsername(String username);
}
