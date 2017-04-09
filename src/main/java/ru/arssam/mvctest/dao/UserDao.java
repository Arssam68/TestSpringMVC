package ru.arssam.mvctest.dao;

import ru.arssam.mvctest.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> getUsersByName(String name);

    List<User> listUsers(int firstResult, int maxResult);

    int count();
}
