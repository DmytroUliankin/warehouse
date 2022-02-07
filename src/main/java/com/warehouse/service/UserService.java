package com.warehouse.service;

import com.warehouse.model.user.User;
import com.warehouse.model.user.UserRole;
import com.warehouse.repository.UserRepository;
import com.warehouse.util.QueryUtil;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("jdbc")
@Slf4j
public class UserService implements UserRepository {

    @Autowired
    private HikariDataSource dataSource;

    @Override
    public void saveUser(User user) {
        log.info("Starting saving user");
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.SAVE)) {
                preparedStatement.setString(2, "user_role");
                preparedStatement.setString(3, "user_name");
                preparedStatement.setString(4, "surname");
                preparedStatement.setString(5, "email");
                preparedStatement.setString(6, "year_of_birth");
                preparedStatement.setString(7, "place_of_birth");
                preparedStatement.setString(8, "current_position");
                preparedStatement.setString(9, "address_of_living");
                preparedStatement.execute();
                log.info("User saved. User role: {}, name: {}, surname: {}, email: {}, yearOfBirth:{}," +
                                " placeOfBirth: {}, currentPosition: {}, addressOfLiving:{}",
                        user.getRole(), user.getName(), user.getSurname(), user.getEmail(), user.getYearOfBirth(),
                        user.getPlaceOfBirth(), user.getCurrentPosition(), user.getAddressOfLiving());
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public User updateUser(User user) {
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet update = statement.executeQuery(QueryUtil.UPDATE);
                while (update.next()) {
                    user.setRole(UserRole.valueOf(update.getString("user_role")));
                    user.setName(update.getString("user_name"));
                    user.setSurname(update.getString("surname"));
                    user.setEmail(update.getString("email"));
                    user.setYearOfBirth(update.getString("year_of_birth"));
                    user.setPlaceOfBirth(update.getString("place_of_birth"));
                    user.setCurrentPosition(update.getString("current_position"));
                    user.setCurrentPosition(update.getString("address_of_living"));
                    log.info("User updated. User role: {}, name: {}, surname: {}, email: {}, yearOfBirth:{}," +
                                    " placeOfBirth: {}, currentPosition: {}, addressOfLiving:{}",
                            user.getRole(), user.getName(), user.getSurname(), user.getEmail(), user.getYearOfBirth(),
                            user.getPlaceOfBirth(), user.getCurrentPosition(), user.getAddressOfLiving());
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return user;
    }

    @Override
    public User getUser(Long id) {
        log.info("Start finding user by id");
        User user = new User();
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.SELECT_BY_ID)) {
                preparedStatement.setLong(1, id);
                ResultSet getUser = preparedStatement.executeQuery();
                while (getUser.next()) {
                    user.setId(getUser.getLong("id"));
                    user.setName(getUser.getString("user_name"));
                    user.setSurname(getUser.getString("surname"));
                    user.setEmail(getUser.getString("email"));
                    user.setYearOfBirth(getUser.getString("year_of_birth"));
                    user.setPlaceOfBirth(getUser.getString("place_of_birth"));
                    user.setCurrentPosition(getUser.getString("current_position"));
                    user.setCurrentPosition(getUser.getString("address_of_living"));
                    log.info("User founded. User role: {}, name: {}, surname: {}, email: {}, yearOfBirth:{}," +
                                    " placeOfBirth: {}, currentPosition: {}, addressOfLiving:{}",
                            user.getRole(), user.getName(), user.getSurname(), user.getEmail(), user.getYearOfBirth(),
                            user.getPlaceOfBirth(), user.getCurrentPosition(), user.getAddressOfLiving());
                }
                getUser.close();
                connection.commit();
            } catch (SQLException e) {
                log.error(String.valueOf(e));
                connection.rollback();
            }
        } catch (SQLException e) {
            log.error(String.valueOf(e));
        }
        log.info("End finding user by id ");
        return user;
    }

    @Override
    public User deleteUser(Long id) {
        log.info("Start deleting user by id");
        User user = new User();
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.DELETE)) {
                preparedStatement.setLong(1, id);
                ResultSet deleteUser = preparedStatement.executeQuery();
                while (deleteUser.next()) {
                    user.setId(deleteUser.getLong("id"));
                    user.setName(deleteUser.getString("user_name"));
                    user.setSurname(deleteUser.getString("surname"));
                    user.setEmail(deleteUser.getString("email"));
                    user.setYearOfBirth(deleteUser.getString("year_of_birth"));
                    user.setPlaceOfBirth(deleteUser.getString("place_of_birth"));
                    user.setCurrentPosition(deleteUser.getString("current_position"));
                    user.setCurrentPosition(deleteUser.getString("address_of_living"));
                    log.info("User deleted. User role: {}, name: {}, surname: {}, email: {}, yearOfBirth:{}," +
                                    " placeOfBirth: {}, currentPosition: {}, addressOfLiving:{}",
                            user.getRole(), user.getName(), user.getSurname(), user.getEmail(), user.getYearOfBirth(),
                            user.getPlaceOfBirth(), user.getCurrentPosition(), user.getAddressOfLiving());
                }
                deleteUser.close();
                connection.commit();
            } catch (SQLException e) {
                log.error(String.valueOf(e));
                connection.rollback();
            }
        } catch (SQLException e) {
            log.error(String.valueOf(e));
        }
        log.info("End finding user by id ");
        return user;
    }

    @Override
    public List<User> getUsers() {
        log.info("Start finding all users");
        User user = new User();
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.DELETE)) {
                ResultSet allUsers = preparedStatement.executeQuery();
                while (allUsers.next()) {
                    user.setId(allUsers.getLong("id"));
                    user.setName(allUsers.getString("user_name"));
                    user.setSurname(allUsers.getString("surname"));
                    user.setEmail(allUsers.getString("email"));
                    user.setYearOfBirth(allUsers.getString("year_of_birth"));
                    user.setPlaceOfBirth(allUsers.getString("place_of_birth"));
                    user.setCurrentPosition(allUsers.getString("current_position"));
                    user.setCurrentPosition(allUsers.getString("address_of_living"));
                    log.info("Users found. User role: {}, name: {}, surname: {}, email: {}, yearOfBirth:{}," +
                                    " placeOfBirth: {}, currentPosition: {}, addressOfLiving:{}",
                            user.getRole(), user.getName(), user.getSurname(), user.getEmail(), user.getYearOfBirth(),
                            user.getPlaceOfBirth(), user.getCurrentPosition(), user.getAddressOfLiving());
                }
                users.add(user);
                allUsers.close();
                connection.commit();
            } catch (SQLException e) {
                log.error(String.valueOf(e));
                connection.rollback();
            }
        } catch (SQLException e) {
            log.error(String.valueOf(e));
        }
        log.info("End finding user by id ");
        return users;
    }

}
