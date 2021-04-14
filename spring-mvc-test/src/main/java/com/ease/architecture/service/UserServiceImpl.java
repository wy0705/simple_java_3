package com.ease.architecture.service;

import com.ease.architecture.dao.mapper.UserMapper;
import com.ease.architecture.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl {

//    @Autowired
//    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

//    public User findUserById(String id) {
//        return userMapper.findByUserId(id);
//    }

    public User findUserByName(String username) {
        return userMapper.findByName(username);
    }

    public User findUserByNameAndPassword(String username, String password) {
        return userMapper.findByNameAndPassword(username, password);
    }

//    public User login(String username, String password) {
//        return findUserByNameAndPassword(username, password);
//    }

    public boolean register(User user) {
        User userByName = findUserByName(user.getName());
        if (userByName != null && userByName.getName() != null && userByName.getName().equals(user.getName())) {
            return true;
        }
        if (user.getId() == null || user.getId().equals("")) {
            user.setId(UUID.randomUUID().toString());
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        return userMapper.insertUser(user) != 0;
    }
}
