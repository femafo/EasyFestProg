package com.easyfest.easyfest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Aplicación JavaFX para EasyFest.
 *
 * @author Antonio
 */
public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1530, 780);
        Image image = null;
        String imgPath = "/img/logoEasyFest (1).png";
        try {
            image = new Image(getClass().getResourceAsStream(imgPath));
            if (image.isError()) {
                throw new Exception("Error loading image: " + image.getException());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Image not found or failed to load: " + imgPath);
        }

        if (image != null) {
            stage.getIcons().add(image);
        }
        stage.getIcons().add(image);
        stage.setTitle("EasyFest");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Inicia la aplicación JavaFX.
     *
     * @param args los argumentos de línea de comandos
     */
    public static void main(String[] args) {
        launch();
    }
}