package com.warehouse.repository.impl;

import com.warehouse.model.user.User;
import com.warehouse.repository.UserRepository;
import com.warehouse.util.UserQueryUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Profile("jdbc")
@Slf4j
public class UserJdbcRepositoryImpl implements UserRepository {

    private final DataSource dataSource;

    @Override
    public void saveUser(User user) {
        log.info("Starting saving user");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement saveUserPreparedStatement = connection.prepareStatement(UserQueryUtil.INSERT_USER)) {
            populateParams(user, saveUserPreparedStatement);
            saveUserPreparedStatement.execute();
            log.info("User saved. User role: {}, name: {}, surname: {}, email: {}, yearOfBirth:{}," +
                            " placeOfBirth: {}, currentPosition: {}, addressOfLiving:{}",
                    user.getRole(), user.getName(), user.getSurname(), user.getEmail(), user.getYearOfBirth(),
                    user.getPlaceOfBirth(), user.getCurrentPosition(), user.getAddressOfLiving());
        } catch (SQLException e) {
            log.error("Can't prepare statement to save user: ", e);
            throw new RuntimeException();
        }
        log.info("End inserting user");
    }

    @Override
    public User updateUser(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement updateUserPreparedStatement = connection.prepareStatement(UserQueryUtil.UPDATE_USER)) {
            updateUserPreparedStatement.setLong(1, user.getId());
            populateParams(user, updateUserPreparedStatement);
            int updatedUser = updateUserPreparedStatement.executeUpdate();
            if (updatedUser > 0) {
                log.info("User updated. User role: {}, name: {}, surname: {}, email: {}, yearOfBirth:{}," +
                                " placeOfBirth: {}, currentPosition: {}, addressOfLiving:{}",
                        user.getRole(), user.getName(), user.getSurname(), user.getEmail(), user.getYearOfBirth(),
                        user.getPlaceOfBirth(), user.getCurrentPosition(), user.getAddressOfLiving());
            }
        } catch (SQLException e) {
            log.error("Can't prepare statement to update user: ", e);
            throw new RuntimeException();
        }
        log.info("End updating user");
        return user;
    }

    @Override
    public User getUser(Long id) {
        log.info("Start finding user by id");
        User user = new User();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement getUserPreparedStatement = connection.prepareStatement(UserQueryUtil.SELECT_USER_BY_ID);
             ResultSet getUser = getUserPreparedStatement.executeQuery()) {
            getUserPreparedStatement.setLong(1, id);
            while (getUser.next()) {
                extractUser(user, getUser);
                log.info("User founded. User role: {}, name: {}, surname: {}, email: {}, yearOfBirth:{}," +
                                " placeOfBirth: {}, currentPosition: {}, addressOfLiving:{}",
                        user.getRole(), user.getName(), user.getSurname(), user.getEmail(), user.getYearOfBirth(),
                        user.getPlaceOfBirth(), user.getCurrentPosition(), user.getAddressOfLiving());
            }
        } catch (SQLException e) {
            log.error("Can't prepare statement to find user by id: ", e);
            throw new RuntimeException();
        }
        log.info("End finding user by id");
        return user;
    }

    @Override
    public User deleteUser(Long id) {
        log.info("Start deleting user by id");
        User user = new User();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement deleteUserPreparedStatement = connection.prepareStatement(UserQueryUtil.DELETE_USER);
             ResultSet deleteUser = deleteUserPreparedStatement.executeQuery()) {
            deleteUserPreparedStatement.setLong(1, id);
            while (deleteUser.next()) {
                extractUser(user, deleteUser);
                log.info("User deleted. User role: {}, name: {}, surname: {}, email: {}, yearOfBirth:{}," +
                                " placeOfBirth: {}, currentPosition: {}, addressOfLiving:{}",
                        user.getRole(), user.getName(), user.getSurname(), user.getEmail(), user.getYearOfBirth(),
                        user.getPlaceOfBirth(), user.getCurrentPosition(), user.getAddressOfLiving());
            }
        } catch (SQLException e) {
            log.error("Can't prepare statement to delete user: ", e);
            throw new RuntimeException();
        }
        log.info("End finding user by id");
        return user;
    }

    @Override
    public List<User> getUsers() {
        log.info("Start finding all users");
        User user = new User();
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement getAllUsersPreparedStatement = connection.prepareStatement(UserQueryUtil.SELECT_ALL_USERS);
             ResultSet allUsers = getAllUsersPreparedStatement.executeQuery()) {
            while (allUsers.next()) {
                extractUser(user, allUsers);
                log.info("Users found. User role: {}, name: {}, surname: {}, email: {}, yearOfBirth:{}," +
                                " placeOfBirth: {}, currentPosition: {}, addressOfLiving:{}",
                        user.getRole(), user.getName(), user.getSurname(), user.getEmail(), user.getYearOfBirth(),
                        user.getPlaceOfBirth(), user.getCurrentPosition(), user.getAddressOfLiving());
            }
            users.add(user);
        } catch (SQLException e) {
            log.error("Can't prepare statement to find all users: ", e);
            throw new RuntimeException(e);
        }
        log.info("End finding users");
        return users;
    }

    private void extractUser(User user, ResultSet allUsers) throws SQLException {
        user.setId(allUsers.getLong("user_id"));
        user.setName(allUsers.getString("user_name"));
        user.setSurname(allUsers.getString("surname"));
        user.setEmail(allUsers.getString("email"));
        user.setYearOfBirth(allUsers.getString("year_of_birth"));
        user.setPlaceOfBirth(allUsers.getString("place_of_birth"));
        user.setCurrentPosition(allUsers.getString("current_position"));
        user.setCurrentPosition(allUsers.getString("address_of_living"));
    }

    private void populateParams(User user, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(2, String.valueOf(user.getRole()));
        preparedStatement.setString(3, user.getName());
        preparedStatement.setString(4, user.getSurname());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.setString(6, user.getYearOfBirth());
        preparedStatement.setString(7, user.getPlaceOfBirth());
        preparedStatement.setString(8, user.getCurrentPosition());
        preparedStatement.setString(9, user.getAddressOfLiving());
    }

}
