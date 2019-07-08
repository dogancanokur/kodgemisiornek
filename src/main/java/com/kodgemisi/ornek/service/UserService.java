package com.kodgemisi.ornek.service;


import com.kodgemisi.ornek.model.User;

public interface UserService {
    void addUser(User user);

    Iterable<User> getUsers();
}
