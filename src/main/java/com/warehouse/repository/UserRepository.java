package com.warehouse.repository;

import com.warehouse.model.user.User;

import java.util.List;

public interface UserRepository {

    void saveUser(User user);

    User updateUser(Long id, User user);

    User getUser(Long id);

    User deleteUser(Long id);

    List<User> getUsers();

}
