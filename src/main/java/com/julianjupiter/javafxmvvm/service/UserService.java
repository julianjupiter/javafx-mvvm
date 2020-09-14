package com.julianjupiter.javafxmvvm.service;

import com.julianjupiter.javafxmvvm.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> login(String username, String password);
}
