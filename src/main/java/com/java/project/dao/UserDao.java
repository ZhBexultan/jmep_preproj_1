package com.java.project.dao;

import com.java.project.model.User;

import java.sql.*;
import java.util.List;

public interface UserDao {

    void addUser(User user) throws SQLException;

    void deleteUser(User user) throws SQLException;

    void updateUser(User user) throws SQLException;

    User getUserById(Long id) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    User getUserByLoginAndPassword(String email, String password) throws SQLException;

    boolean isUserExist(String email, String password) throws SQLException;

}
