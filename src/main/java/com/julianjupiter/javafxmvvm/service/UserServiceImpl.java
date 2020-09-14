package com.julianjupiter.javafxmvvm.service;

import com.julianjupiter.javafxmvvm.dao.UserDao;
import com.julianjupiter.javafxmvvm.dao.UserDaoImpl;
import com.julianjupiter.javafxmvvm.entity.User;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public Optional<User> login(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}
