package com.java.project.dao;

import com.java.project.model.User;
import com.java.project.util.DBHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UserHibernateDao implements UserDao {

    private SessionFactory sessionFactory = DBHelper.getSessionFactory();

    @Override
    public void addUser(User user) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User getUserById(Long id) throws SQLException {
        Session session = sessionFactory.openSession();
        String hql = "FROM User WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        User user = (User) query.getSingleResult();
        session.close();
        return user;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        Session session = sessionFactory.openSession();
        List<User> users =session.createQuery("FROM User").list();
        session.close();
        return users;
    }
}
