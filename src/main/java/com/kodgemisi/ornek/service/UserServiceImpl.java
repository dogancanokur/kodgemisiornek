package com.kodgemisi.ornek.service;

import com.kodgemisi.ornek.model.User;
import com.kodgemisi.ornek.repository.ItemRepository;
import com.kodgemisi.ornek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ItemRepository itemRepository) {
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

    @Override
    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<String>();
        Iterator iterator = getUsers().iterator();
        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            usernames.add(user.getUsername());
        }
        return usernames;
    }

    public User getUserByUsername(String username) {

        return userRepository.getUserByUsername(username);
    }
}
