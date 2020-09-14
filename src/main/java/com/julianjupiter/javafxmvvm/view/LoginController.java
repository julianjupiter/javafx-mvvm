package com.julianjupiter.javafxmvvm.view;

import com.julianjupiter.javafxmvvm.viewmodel.LoginViewModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button loginButton;

    private final LoginViewModel loginViewModel;

    public LoginController() {
        this.loginViewModel = new LoginViewModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.usernameTextField.textProperty().bindBidirectional(this.loginViewModel.usernameProperty());
        this.passwordTextField.textProperty().bindBidirectional(this.loginViewModel.passwordProperty());
        this.loginButton.disableProperty().bind(this.loginViewModel.loginPossibleProperty().not());
    }

    @FXML
    private void onLoginButtonPressed() {
        this.loginViewModel.login();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Login");
        alert.setContentText(this.loginViewModel.getMessage());
        alert.showAndWait();
    }

    @FXML
    private void onCloseButtonPressed() {
        Platform.exit();
    }
}
