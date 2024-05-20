package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AddtarjetaController {
    @javafx.fxml.FXML
    private AnchorPane addtarjetaid;
    @javafx.fxml.FXML
    private TextField cvvid;
    @javafx.fxml.FXML
    private TextField titularid;
    @javafx.fxml.FXML
    private Button backbutton;
    @javafx.fxml.FXML
    private DatePicker dateid;
    @javafx.fxml.FXML
    private TextField numeroid;
    @javafx.fxml.FXML
    private Button anadirbutton;

    @javafx.fxml.FXML
    public void onback(ActionEvent actionEvent) {
        try {
            AnchorPane pagos = FXMLLoader.load(getClass().getResource("pagos.fxml"));
            this.addtarjetaid.getChildren().setAll(pagos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void onanadirtarjeta(ActionEvent actionEvent) {
    }
}
