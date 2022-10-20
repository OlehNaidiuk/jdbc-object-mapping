package com.naidiuk.repository;

import com.naidiuk.entity.Gender;
import com.naidiuk.entity.User;
import com.naidiuk.util.JdbcConstants;
import com.naidiuk.util.SqlQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> findAllYoungerEighteen() {
        return getUsersFromDB(SqlQueries.FIND_ALL_YOUNGER_EIGHTEEN);
    }

    @Override
    public List<User> findAllWhoseNameEndsWithO() {
        return getUsersFromDB(SqlQueries.FIND_ALL_WHOSE_NAME_END_WITH_O);
    }

    @Override
    public List<User> findAllWhoseAgeBetweenEighteenAndSixty() {
        return getUsersFromDB(SqlQueries.FIND_ALL_WHOSE_AGE_BETWEEN_EIGHTEEN_AND_SIXTY);
    }

    @Override
    public List<User> findAllWhoseNameContainsA() {
        return getUsersFromDB(SqlQueries.FIND_ALL_WHOSE_NAME_CONTAINS_A);
    }

    @Override
    public List<User> findAllAdult() {
        return getUsersFromDB(SqlQueries.FIND_ALL_ADULT);
    }

    private List<User> getUsersFromDB(String query) {
        try (Connection connection =
                     DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME, JdbcConstants.PASSWORD)) {

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
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
