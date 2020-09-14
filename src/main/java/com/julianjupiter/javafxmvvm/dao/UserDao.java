package com.julianjupiter.javafxmvvm.dao;

import com.julianjupiter.javafxmvvm.entity.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> findByUsernameAndPassword(String username, String passwor);
}
