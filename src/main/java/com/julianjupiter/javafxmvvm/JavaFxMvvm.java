package com.julianjupiter.javafxmvvm;

import com.julianjupiter.javafxmvvm.view.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class JavaFxMvvm extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = this.loadFxml(LoginController.class);
        var scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Shutting down");
    }

    private FXMLLoader loadFxml(Class<?> controller) {
        String fxml = controller.getSimpleName() + ".fxml";
        URL fxmlUrl = controller.getResource(fxml);

        return new FXMLLoader(fxmlUrl);
    }

    public static void main(String[] args) {
        launch();
    }
}