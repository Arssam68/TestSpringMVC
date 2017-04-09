package ru.arssam.mvctest.service;

import ru.arssam.mvctest.model.User;

import java.util.List;

public interface UserService {
        void addUser(User user);

        void updateUser(User user);

        void removeUser(int id);

        User getUserById(int id);

        List<User> getUsersByName(String name);

        List<User> listUsers(int firstResult, int maxResult);

        int count();
}
