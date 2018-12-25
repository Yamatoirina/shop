package com.shop.service;

import com.shop.dao.UserDao;
import com.shop.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public boolean isUserWithUsernameExists(String username){
        return userDao.getUserByUsername(username) !=null;
    }

    public User getUserByUserNameAndPassword ( String username, String password){
        return userDao.getUserByUserNameAndPassword(username,password);
    }

    public boolean isUserExists(User user){
        return user !=null;
    }

    public void createNewUser(String username, String password){
        userDao.createUserBy(username,password);
    }
}
