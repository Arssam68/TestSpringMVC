package ru.arssam.mvctest.service;

import ru.arssam.mvctest.model.User;

import java.util.List;

public interface UserService {
        void addUser(User user);

        void updateUser(User user);

        void removeUser(int id);

        User getUserById(int id);

        User getUserByName(String name);

        List<User> listUsers();
}
