package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * Controlador para la pantalla de inicio.
 *
 * @author fermin
 */
public class HelloController implements Initializable {
    /**
     * VBox que contiene los elementos de la pantalla de inicio.
     */
    @FXML
    private VBox vboxid;
    /**
     * Inicializa el controlador.
     *
     * Carga la pantalla de inicio desde el archivo FXML "login.fxml" y la agrega al VBox.
     *
     * @param url la ubicación del recurso FXML
     * @param resourceBundle el bundle de recursos para la internacionalización
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AnchorPane login = FXMLLoader.load(getClass().getResource("login.fxml"));
            this.vboxid.getChildren().setAll(login);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}