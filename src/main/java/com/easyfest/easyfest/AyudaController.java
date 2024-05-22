package com.easyfest.easyfest;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;

public class AyudaController {
    @FXML
    private AnchorPane ayudaid;
    @FXML
    private Button buttonAyudaPedidos;
    @FXML
    private Button buttonDevoluciones;
    @FXML
    private Button buttonRedactarProblema;
    @FXML
    private Button buttonInfTransporte;

    private void mostrarPane(String texto) {
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: lightgray; -fx-background-radius: 10;");
        pane.setPrefSize(300, 200);

        Label label = new Label(texto);
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setMaxWidth(280);
        label.setLayoutX(10);
        label.setLayoutY(50);
        pane.getChildren().add(label);

        Button closeButton = new Button("Cerrar");
        closeButton.setOnAction(e -> ((Pane)pane.getParent()).getChildren().remove(pane));
        closeButton.setLayoutX(10);
        closeButton.setLayoutY(10);
        pane.getChildren().add(closeButton);

        double centerX = (ayudaid.getWidth() - pane.getPrefWidth()) / 2;
        double centerY = (ayudaid.getHeight() - pane.getPrefHeight()) / 2;
        pane.setLayoutX(centerX);
        pane.setLayoutY(centerY);

        ayudaid.getChildren().add(pane);
    }

    @FXML
    private void ButtonAyudaPedidos() {
        mostrarPane("Texto de ayuda para Pedidos");
    }

    @FXML
    private void ButtonDevoluciones() {
        mostrarPane("Texto de ayuda para Devoluciones");
    }

    @FXML
    private void ButtonRedactarProblema() {
        mostrarPane("Texto de ayuda para Redactar Problema");
    }

    @FXML
    private void ButtonInfTransporte() {
        mostrarPane("Texto de ayuda para Información de Transporte");
    }
}

