package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Perfil {
    @javafx.fxml.FXML
    private DatePicker dateFechaUsuario;
    @javafx.fxml.FXML
    private Button buttonVolver;
    @javafx.fxml.FXML
    private TextField textFieldCorreoUser;
    @javafx.fxml.FXML
    private Button buttonAcutalizarPerfil;
    @javafx.fxml.FXML
    private Button buttonCambiarFoto;
    @javafx.fxml.FXML
    private TextField textFieldNombreUser;
    @javafx.fxml.FXML
    private TextField textFieldNomUser;
    @javafx.fxml.FXML
    private AnchorPane contenedorId;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void onVolver(ActionEvent actionEvent) {


        try {
            AnchorPane inicio2 = FXMLLoader.load(getClass().getResource("menuproductos.fxml"));
            this.contenedorId.getChildren().setAll(inicio2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void onCambiarFoto(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onActualizarCambios(ActionEvent actionEvent) {
    }
}