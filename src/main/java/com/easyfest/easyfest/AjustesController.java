package com.easyfest.easyfest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class AjustesController implements Initializable {
    @javafx.fxml.FXML
    private ToggleGroup toggleTamañoLetra;
    @javafx.fxml.FXML
    private ToggleGroup toggleTema;
    @javafx.fxml.FXML
    private RadioButton radioButtonTextoMediano;
    @javafx.fxml.FXML
    private RadioButton radioButtonTemaClaro;
    @javafx.fxml.FXML
    private RadioButton radioButtonTextoPequeño;
    @javafx.fxml.FXML
    private ChoiceBox idiomaChoiceBox;
    @javafx.fxml.FXML
    private RadioButton radioButtonTemaOscuro;
    @javafx.fxml.FXML
    private RadioButton radioButtonTextoGrande;
    @javafx.fxml.FXML
    private ImageView imageViewOscuro;
    @javafx.fxml.FXML
    private ImageView imageViewClaro;
    @javafx.fxml.FXML
    private AnchorPane ajustesid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> idiomas = FXCollections.observableArrayList("Español", "Inglés");

        idiomaChoiceBox.setItems(idiomas);

        idiomaChoiceBox.setValue("Español");

        radioButtonTextoPequeño.setOnAction(event -> cambiarTamañoLetra(12));
        radioButtonTextoMediano.setOnAction(event -> cambiarTamañoLetra(18));
        radioButtonTextoGrande.setOnAction(event -> cambiarTamañoLetra(24));

        cambiarTamañoLetra(18);
    }

    private void cambiarTamañoLetra(int tamaño) {
        for (javafx.scene.Node node : ajustesid.getChildren()) {
            if (node instanceof Label && node.getStyleClass().contains("labelTextoTamaño")) {
                ((Label) node).setFont(new Font(tamaño));
            }
        }
    }

}
