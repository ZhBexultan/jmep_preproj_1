package com.java.project.service;

import com.java.project.dao.UserDao;
import com.java.project.dao.UserHibernateDao;
import com.java.project.dao.UserJdbcDao;
import com.java.project.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();

}
