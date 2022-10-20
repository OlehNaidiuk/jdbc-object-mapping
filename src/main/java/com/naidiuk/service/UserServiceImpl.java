package com.naidiuk.service;

import com.naidiuk.entity.Gender;
import com.naidiuk.entity.User;
import com.naidiuk.util.JdbcConstants;
import com.naidiuk.util.SqlQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void printAllYoungerEighteen() {
        try {
            Connection connection = getConnection();
            List<User> users = getUsersFromDB(connection, SqlQueries.FIND_ALL_YOUNGER_EIGHTEEN);
            printAll(users);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void printAllWhoseNameEndsWithO() {
        try {
            Connection connection = getConnection();
            List<User> users = getUsersFromDB(connection, SqlQueries.FIND_ALL_WHOSE_NAME_END_WITH_O);
            printAll(users);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void printAllWhoseAgeBetweenEighteenAndSixty() {
        try {
            Connection connection = getConnection();
            List<User> users = getUsersFromDB(connection, SqlQueries.FIND_ALL_WHOSE_AGE_BETWEEN_EIGHTEEN_AND_SIXTY);
            printAll(users);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void printNumberOfUsersWhoseNameContainsA() {
        try {
            Connection connection = getConnection();
            List<User> users = getUsersFromDB(connection, SqlQueries.FIND_ALL_WHOSE_NAME_CONTAINS_A);
            System.out.println(users.size());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void printNumberOfAdultUsers() {
        try {
            Connection connection = getConnection();
            List<User> users = getUsersFromDB(connection, SqlQueries.FIND_ALL_ADULT);
            System.out.println(users.size());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME, JdbcConstants.PASSWORD);
    }

    private List<User> getUsersFromDB(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<User> users = new ArrayList<>();

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setFirstName(resultSet.getString(2));
            user.setLastName(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));
            user.setGender(Gender.valueOf(resultSet.getString(5)));
            users.add(user);
        }

        connection.close();
        return users;
    }

    private void printAll(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }
}