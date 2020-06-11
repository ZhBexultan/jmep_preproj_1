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
        String sql = "INSERT INTO user(name, email, password, role) VALUES(?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getRole());
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
        String sql = "UPDATE user SET name = ?, email = ?, password = ?, role = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getRole());
        statement.setLong(5, user.getId());
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
            String password = result.getString("password");
            String role = result.getString("role");
            user = new User(id, name, email, password, role);
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
            String password = result.getString("password");
            String role = result.getString("role");
            users.add(new User(id, name, email, password, role));
        }
        statement.close();
        return users;
    }

    @Override
    public User getUserByLoginAndPassword(String email, String password) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            long u_id = result.getLong("id");
            String u_name = result.getString("name");
            String u_email = result.getString("email");
            String u_password = result.getString("password");
            String u_role = result.getString("role");
            user = new User(u_id, u_name, u_email, u_password, u_role);
        }
        statement.close();
        return user;
    }

    @Override
    public boolean isUserExist(String email, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE email = ? and password = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, password);
        ResultSet result = stmt.executeQuery();
        return result.next();
    }
}
