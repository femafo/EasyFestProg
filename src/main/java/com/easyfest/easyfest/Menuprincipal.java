package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Menuprincipal
{
    @javafx.fxml.FXML
    private Button mensajesId;
    @javafx.fxml.FXML
    private Button ayudaId;
    @javafx.fxml.FXML
    private Button ajustesId;
    @javafx.fxml.FXML
    private ChoiceBox chbUsuario;
    @javafx.fxml.FXML
    private Button busquedaId;
    @javafx.fxml.FXML
    private Button inicioId;
    @javafx.fxml.FXML
    private Button pagosId;
    @javafx.fxml.FXML
    private Button sobreNosotrosId;
    @javafx.fxml.FXML
    private AnchorPane contenedorId;

    @javafx.fxml.FXML
    public void initialize() {
        try {
            AnchorPane inicio = FXMLLoader.load(getClass().getResource("inicio.fxml"));
            this.contenedorId.getChildren().setAll(inicio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void ajustesbutton(ActionEvent actionEvent) {
        try {
            AnchorPane ajustes = FXMLLoader.load(getClass().getResource("ajustes.fxml"));
            this.contenedorId.getChildren().setAll(ajustes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void pagosbutton(ActionEvent actionEvent) {
        try {
            AnchorPane pagos = FXMLLoader.load(getClass().getResource("pagos.fxml"));
            this.contenedorId.getChildren().setAll(pagos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void ayudabutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sobrenosotrosbutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void mensajesbutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void busquedabutton(ActionEvent actionEvent) {
    }
}