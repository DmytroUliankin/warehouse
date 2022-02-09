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
            try (PreparedStatement preparedStatement = connection.prepareStatement(UserQueryUtil.SAVE_USER)) {
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
            try (PreparedStatement update = connection.prepareStatement(UserQueryUtil.UPDATE_USER)) {
                update.setLong(1, user.getId());
                update.setString(2, String.valueOf(user.getRole()));
                update.setString(3, user.getName());
                update.setString(4, user.getSurname());
                update.setString(5, user.getEmail());
                update.setString(6, user.getYearOfBirth());
                update.setString(7, user.getPlaceOfBirth());
                update.setString(8, user.getCurrentPosition());
                update.setString(9, user.getCurrentPosition());
                int updatedUser = update.executeUpdate();
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
            PreparedStatement get = connection.prepareStatement(UserQueryUtil.SELECT_USER_BY_ID);
            get.setLong(1, id);
            try (ResultSet getUser = get.executeQuery()) {
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
            PreparedStatement preparedStatement = connection.prepareStatement(UserQueryUtil.DELETE_USER);
            preparedStatement.setLong(1, id);
            try (ResultSet deleteUser = preparedStatement.executeQuery()) {
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
            PreparedStatement preparedStatement = connection.prepareStatement(UserQueryUtil.SELECT_ALL_USERS);
            try (ResultSet allUsers = preparedStatement.executeQuery()) {
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
