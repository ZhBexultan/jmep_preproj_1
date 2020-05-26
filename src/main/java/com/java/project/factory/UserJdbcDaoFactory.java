package com.java.project.factory;

import com.java.project.dao.UserDao;
import com.java.project.dao.UserJdbcDao;

public class UserJdbcDaoFactory implements UserDaoFactory {
    @Override
    public UserDao getUserDao() {
        return new UserJdbcDao();
    }
}
