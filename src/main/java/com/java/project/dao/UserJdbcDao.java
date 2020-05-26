package com.java.project.dao;

import com.java.project.model.User;
import com.java.project.util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao {

    private Connection connection = DBHelper.getConnection();

    @Override
    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO user(name, email) VALUES(?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, user.getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE user SET name = ?, email = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setLong(3, user.getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public User getUserById(Long id) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM user WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            String name = result.getString("name");
            String email = result.getString("email");
            user = new User(id, name, email);
        }
        statement.close();
        return user;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM user");
        while (result.next()) {
            Long id = result.getLong("id");
            String name = result.getString("name");
            String email = result.getString("email");
            users.add(new User(id, name, email));
        }
        statement.close();
        return users;
    }

}
