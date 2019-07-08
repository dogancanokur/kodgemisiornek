package com.kodgemisi.ornek.service;

import com.kodgemisi.ornek.model.User;
import com.kodgemisi.ornek.repository.ItemRepository;
import com.kodgemisi.ornek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSeviceImpl implements UserService {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public UserSeviceImpl(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
