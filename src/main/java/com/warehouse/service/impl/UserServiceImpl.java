package com.warehouse.service.impl;

import com.warehouse.model.user.User;
import com.warehouse.repository.UserRepository;
import com.warehouse.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        return userRepository.updateUser(id, user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.getUser(id);
    }

    @Override
    public User deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

}
