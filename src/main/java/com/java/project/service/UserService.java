package com.java.project.service;

import com.java.project.dao.UserDao;
import com.java.project.dao.UserHibernateDao;
import com.java.project.dao.UserJdbcDao;
import com.java.project.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDao userDao = new UserHibernateDao();

    public UserService() {}

    public void createUser(User user) {
        try {
            userDao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            userDao.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Long id) {
        try {
            User user = userDao.getUserById(id);
            userDao.deleteUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(Long id) {
        User user = null;
        try {
            user = userDao.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            users = userDao.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
