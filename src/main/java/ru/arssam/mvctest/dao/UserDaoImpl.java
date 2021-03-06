package ru.arssam.mvctest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.arssam.mvctest.model.User;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully saved. User details: " + user);
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully update. User details: " + user);
    }

    @Override
    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);

        if(user != null){
            session.delete(user);
        }
        logger.info("User successfully removed. User details: " + user);
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        logger.info("User successfully loaded. User details: " + user);
        return user;
    }

    @Override
    public List<User> getUsersByName(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query userNameQuery = session.createQuery("from User WHERE name = :paramName");
        userNameQuery.setParameter("paramName", username);
        userNameQuery.setFirstResult(0);
        userNameQuery.setMaxResults(3);

        List<User> users = userNameQuery.getResultList();

        for(User user: users){
            logger.info("Users find list: " + user);
        }

        return users;
    }

    @Override
    public List<User> listUsers(int firstResult, int maxResult) {

        Session session = sessionFactory.getCurrentSession();

        //Query countQuery = session.createQuery("from User");
        //Long countResults = (Long) countQuery.uniqueResult();

        Query selectQuery = session.createQuery("from User");
        selectQuery.setFirstResult(firstResult);
        selectQuery.setMaxResults(maxResult);
        List<User> userList = selectQuery.getResultList();

        //List<User> userList = session.createQuery("from User").list();

        for(User user: userList){
            logger.info("User list: " + user);
        }

        return userList;
    }

    @Override
    public int count(){
        return sessionFactory.getCurrentSession().createQuery("from User").list().size();
    }
}
