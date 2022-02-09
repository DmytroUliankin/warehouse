package com.warehouse.service.jdbc;

import com.warehouse.model.user.User;
import com.warehouse.repository.UserRepository;
import com.warehouse.util.UserQueryUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Profile("jdbc")
@Slf4j
public class UserJdbcImplementation implements UserRepository {

    @Autowired
    private DataSource dataSource;

    @Override
    public void saveUser(User user) {
        log.info("Starting saving user");
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement saveUserPreparedStatement = connection.prepareStatement(UserQueryUtil.INSERT_USER)) {
                saveUserPreparedStatement.setString(2, "user_role");
                saveUserPreparedStatement.setString(3, "user_name");
                saveUserPreparedStatement.setString(4, "surname");
                saveUserPreparedStatement.setString(5, "email");
                saveUserPreparedStatement.setString(6, "year_of_birth");
                saveUserPreparedStatement.setString(7, "place_of_birth");
                saveUserPreparedStatement.setString(8, "current_position");
                saveUserPreparedStatement.setString(9, "address_of_living");
                saveUserPreparedStatement.execute();
                log.info("User saved. User role: {}, name: {}, surname: {}, email: {}, yearOfBirth:{}," +
                                " placeOfBirth: {}, currentPosition: {}, addressOfLiving:{}",
                        user.getRole(), user.getName(), user.getSurname(), user.getEmail(), user.getYearOfBirth(),
                        user.getPlaceOfBirth(), user.getCurrentPosition(), user.getAddressOfLiving());
            } catch (SQLException e) {
                log.error("Can't save user", e);
                log.error("Can't prepare statement", e);
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            log.error("Can't open connection", e);
            throw new RuntimeException();
        }
    }

    @Override
    public User updateUser(User user) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement updateUserPreparedStatement = connection.prepareStatement(UserQueryUtil.UPDATE_USER)) {
                updateUserPreparedStatement.setLong(1, user.getId());
                updateUserPreparedStatement.setString(2, String.valueOf(user.getRole()));
                updateUserPreparedStatement.setString(3, user.getName());
                updateUserPreparedStatement.setString(4, user.getSurname());
                updateUserPreparedStatement.setString(5, user.getEmail());
                updateUserPreparedStatement.setString(6, user.getYearOfBirth());
                updateUserPreparedStatement.setString(7, user.getPlaceOfBirth());
                updateUserPreparedStatement.setString(8, user.getCurrentPosition());
                updateUserPreparedStatement.setString(9, user.getCurrentPosition());
                int updatedUser = updateUserPreparedStatement.executeUpdate();
                if (updatedUser > 0) {
                    log.info("User updated. User role: {}, name: {}, surname: {}, email: {}, yearOfBirth:{}," +
                                    " placeOfBirth: {}, currentPosition: {}, addressOfLiving:{}",
                            user.getRole(), user.getName(), user.getSurname(), user.getEmail(), user.getYearOfBirth(),
                            user.getPlaceOfBirth(), user.getCurrentPosition(), user.getAddressOfLiving());
                }
            } catch (SQLException e) {
                log.error("Can't update user", e);
                log.error("Can't prepare statement", e);
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            log.error("Can't open connection", e);
            throw new RuntimeException();
        }
        return user;
    }

    @Override
    public User getUser(Long id) {
        log.info("Start finding user by id");
        User user = new User();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement getUserPreparedStatement = connection.prepareStatement(UserQueryUtil.SELECT_USER_BY_ID);
            getUserPreparedStatement.setLong(1, id);
            try (ResultSet getUser = getUserPreparedStatement.executeQuery()) {
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
            } catch (SQLException e) {
                log.error("Can't find user", e);
                log.error("Can't prepare statement", e);
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            log.error("Can't open connection", e);
            throw new RuntimeException();
        }
        log.info("End finding user by id ");
        return user;
    }

    @Override
    public User deleteUser(Long id) {
        log.info("Start deleting user by id");
        User user = new User();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement deleteUserPreparedStatement = connection.prepareStatement(UserQueryUtil.DELETE_USER);
            deleteUserPreparedStatement.setLong(1, id);
            try (ResultSet deleteUser = deleteUserPreparedStatement.executeQuery()) {
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
            } catch (SQLException e) {
                log.error("Can't delete user", e);
                log.error("Can't prepare statement", e);
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            log.error("Can't open connection", e);
            throw new RuntimeException();
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
            PreparedStatement getAllUsersPreparedStatement = connection.prepareStatement(UserQueryUtil.SELECT_ALL_USERS);
            try (ResultSet allUsers = getAllUsersPreparedStatement.executeQuery()) {
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
            } catch (SQLException e) {
                log.error("Can't find users", e);
                log.error("Can't prepare statement", e);
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            log.error("Can't open connection", e);
            throw new RuntimeException();
        }
        log.info("End finding users");
        return users;
    }

}
