package com.java.project.service;

import com.java.project.dao.UserDao;
import com.java.project.factory.UserDaoFactory;
import com.java.project.factory.UserHibernateDaoFactory;
import com.java.project.factory.UserJdbcDaoFactory;
import com.java.project.model.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl userService;
    private UserDao userDao;

    private UserServiceImpl(UserDaoFactory userDaoFactory) {
        userDao = userDaoFactory.getUserDao();
    }

    public static UserServiceImpl getInstance(){
        if (userService == null) {
            userService = new UserServiceImpl(getUserDaoFactoryByDaotype());
        }
        return userService;
    }

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

    private static String getPropertyValue() {
        Properties property = new Properties();
        String daotype = "";
        try (FileInputStream fis = new FileInputStream("C:/Users/Beksultan/Desktop/Temp/test_pros/jmep_preproj_1/src/main/resources/db.properties")) {
            property.load(fis);
            daotype =  property.getProperty("daotype");
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return daotype;
    }

    private static UserDaoFactory getUserDaoFactoryByDaotype() {
        String daotype = getPropertyValue();
        if (daotype.equalsIgnoreCase("jdbc")) {
            return new UserJdbcDaoFactory();
        } else if (daotype.equalsIgnoreCase("hibernate")) {
            return new UserHibernateDaoFactory();
        } else {
            throw new RuntimeException(daotype + " is unknown daotype.");
        }
    }
}
