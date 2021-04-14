package com.ease.architecture.service;

import com.ease.architecture.dao.UserDao;
import com.ease.architecture.entity.User;

import java.util.UUID;

public class UserServiceImpl {

    private UserDao userDao = new UserDao();

    public User findUserById(String id) {
        return userDao.findByUserId(id);
    }

    public User findUserByName(String username) {
        return userDao.findByName(username);
    }

    public User findUserByNameAndPassword(String username, String password) {
        return userDao.findByNameAndPassword(username, password);
    }

//    public User login(String username, String password) {
//        return findUserByNameAndPassword(username, password);
//    }

    public boolean register(User user) {
        if (findUserByName(user.getName()) != null) {
            return true;
        }
        if (user.getId() == null || user.getId().equals("")) {
            user.setId(UUID.randomUUID().toString());
        }
        return userDao.insertUser(user) != 0;
    }
}
