package com.warehouse.util;

public class UserQueryUtil {

    public static final String INSERT_USER = "INSERT INTO users (user_role, user_name, surname, email, year_of_birth, " +
            "place_of_birth, current_position, address_of_living) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String UPDATE_USER = "UPDATE users SET user_role = ?, user_name = ?, surname = ?, email = ?, year_of_birth = ?, " +
            "place_of_birth = ?, current_position = ?, address_of_living = ? WHERE user_id = ?";

    public static final String DELETE_USER = "DELETE FROM users WHERE user_id = ?";

    public static final String SELECT_ALL_USERS = "SELECT user_id, user_role, user_name, surname, email, year_of_birth, " +
            "place_of_birth, current_position, address_of_living  FROM users";

    public static final String SELECT_USER_BY_ID = "SELECT user_id, user_role, user_name, surname, email, year_of_birth, " +
            "place_of_birth, current_position, address_of_living  FROM users WHERE user_id = ?";

}
