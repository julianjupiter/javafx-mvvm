package com.julianjupiter.javafxmvvm.dao;

import com.julianjupiter.javafxmvvm.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "jrizal", "password", "Jose Rizal"));
        users.add(new User(2, "abonifacio", "password", "Andres Bonifacio"));
        users.add(new User(3, "maquino", "password", "Melchora Aquino"));
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String passwor) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(passwor))
                .findFirst();
    }
}
