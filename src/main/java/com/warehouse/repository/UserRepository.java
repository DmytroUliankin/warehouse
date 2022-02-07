package com.warehouse.repository;

import com.warehouse.model.user.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("jdbc")
public interface UserRepository {

    void saveUser(User user);

    User updateUser(User user);

    User getUser(Long id);

    User deleteUser(Long id);

    List<User> getUsers();

}
