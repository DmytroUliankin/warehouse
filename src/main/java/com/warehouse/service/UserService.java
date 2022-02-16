package com.warehouse.service;

import com.warehouse.model.user.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User updateUser(User user);

    User getUser(Long id);

    User deleteUser(Long id);

    List<User> getUsers();

}
