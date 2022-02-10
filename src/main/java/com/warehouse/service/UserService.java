package com.warehouse.service;

import com.warehouse.model.user.User;
import com.warehouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserOperations {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public User getUser(Long id) {
        return userRepository.getUser(id);
    }

    public User deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

}
