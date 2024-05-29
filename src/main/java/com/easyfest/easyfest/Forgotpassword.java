package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Este es un Controlador para la vista de recuperación de contraseña.
 *
 * Esta clase sirve para recuperar la contraseña
 */
public class Forgotpassword {
    @javafx.fxml.FXML
    private AnchorPane forgotontr;
    @javafx.fxml.FXML
    private Button continuarbid;
    @javafx.fxml.FXML
    private TextField correorecupid;
    @javafx.fxml.FXML
    private Button backid;
    private static String correo;

    /**
     * Método de inicialización, llamado automáticamente después de que se haya cargado el archivo FXML.
     */
    @javafx.fxml.FXML
    public void initialize() {
        // Puedes realizar inicializaciones adicionales aquí si es necesario
    }

    /**
     * Método para manejar el evento de continuar con la recuperación de contrasena.
     * @param actionEvent El evento de acción generado por el botón de continuar.
     */
    @javafx.fxml.FXML
    public void continuarbutton(ActionEvent actionEvent) {
        this.correo = correorecupid.getText();
        try {
            // cambiar la siguiente pantalla para recuperar la  contraseña
            AnchorPane forget2 = FXMLLoader.load(getClass().getResource("forgotpassword2.fxml"));
            this.forgotontr.getChildren().setAll(forget2);
        } catch (IOException e) {
            // Manejar cualquier excepción de carga de FXML
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void onbackbutton(ActionEvent actionEvent) {
        try {
            AnchorPane back = FXMLLoader.load(getClass().getResource("login.fxml"));
            this.forgotontr.getChildren().setAll(back);
        } catch (IOException e) {
            // Manejar cualquier excepción de carga de FXML
            throw new RuntimeException(e);
        }
    }

    public static String getCorreoRecup (){
        return correo;
    }

    public Forgotpassword() {
    }
}
