package com.warehouse.repository;

import com.warehouse.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    void saveUser(User user);

    User updateUser(User user);

    User getUser(Long id);

    User deleteUser(Long id);

    List<User> getUsers();

}
