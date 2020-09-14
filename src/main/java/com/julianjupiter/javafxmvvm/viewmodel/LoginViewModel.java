package com.julianjupiter.javafxmvvm.viewmodel;

import com.julianjupiter.javafxmvvm.service.UserService;
import com.julianjupiter.javafxmvvm.entity.User;
import com.julianjupiter.javafxmvvm.service.UserServiceImpl;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Optional;

public class LoginViewModel {
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final ReadOnlyBooleanWrapper loginPossible = new ReadOnlyBooleanWrapper();
    private final UserService userService;
    private String message;

    public LoginViewModel() {
        this.userService = new UserServiceImpl();
        this.loginPossible.bind(username.isNotEmpty().and(password.isNotEmpty()));
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public boolean isLoginPossible() {
        return loginPossible.get();
    }

    public ReadOnlyBooleanWrapper loginPossibleProperty() {
        return loginPossible;
    }

    public String getMessage() {
        return message;
    }

    public void login() {
        Optional<User> userDtoOptional = this.userService.login(this.getUsername(), this.getPassword());
        userDtoOptional.ifPresentOrElse(user -> {
            this.message = "SUCCESS";
        }, () -> {
            this.message = "FAILED";
        });
    }
}
