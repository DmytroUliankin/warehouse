package com.warehouse.util;

public class QueryUtil {

    public static final String SAVE = "INSERT INTO users (user_role, user_name, surname, email, year_of_birth, " +
            "place_of_birth, current_position, address_of_living) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String UPDATE = "UPDATE users SET user_role = ?, user_name = ?, surname = ?, email = ?, year_of_birth = ?, " +
            "place_of_birth = ?, current_position = ?, address_of_living = ? WHERE user_id = ?";

    public static final String DELETE = "DELETE FROM users WHERE user_id = ";

    public static final String SELECT_ALL = "SELECT * FROM users ";

    public static final String SELECT_BY_ID = "SELECT * FROM users WHERE user_id";


}
