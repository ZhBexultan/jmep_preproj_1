package com.java.project.factory;

import com.java.project.dao.UserDao;
import com.java.project.dao.UserHibernateDao;

public class UserHibernateDaoFactory implements UserDaoFactory {
    @Override
    public UserDao getUserDao() {
        return new UserHibernateDao();
    }
}
