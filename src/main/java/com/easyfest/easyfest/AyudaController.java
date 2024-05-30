package com.easyfest.easyfest;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    private TextArea textAreaProblema;

    private void mostrarPane(String texto, boolean incluirBotonEnviar) {
        // Crear un nuevo Pane con BorderPane para permitir mejor organización
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color:  white; -fx-background-radius: 30px;");
        borderPane.setPrefSize(600, 400);

        // Crear una VBox para el texto y centrarlo
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new javafx.geometry.Insets(20));

        Label label = new Label(texto);
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setMaxHeight(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        vbox.getChildren().add(label);

        if (incluirBotonEnviar) {
            textAreaProblema = new TextArea();
            textAreaProblema.setPromptText("Escribe tu problema aquí...");
            textAreaProblema.setWrapText(true);
            vbox.getChildren().add(textAreaProblema);
        }

        // Añadir VBox al centro del BorderPane
        borderPane.setCenter(vbox);

        // Crear y añadir el botón de cerrar
        Button closeButton = new Button("Cerrar");
        closeButton.setOnAction(e -> ((Pane)borderPane.getParent()).getChildren().remove(borderPane));
        closeButton.setLayoutX(10);
        closeButton.setLayoutY(10);
        StackPane topPane = new StackPane(closeButton);
        StackPane.setAlignment(closeButton, Pos.TOP_LEFT);
        borderPane.setTop(topPane);
        closeButton.setStyle("-fx-background-radius: 30px;");

        if (incluirBotonEnviar) {
            // Crear botón de enviar y añadirlo a la parte inferior derecha del BorderPane
            Button sendButton = new Button("Enviar");
            sendButton.setOnAction(e -> enviarProblema());
            sendButton.setStyle("-fx-background-radius: 30px;");

            // Crear un StackPane para alinear el botón en la parte inferior derecha
            StackPane stackPane = new StackPane(sendButton);
            StackPane.setAlignment(sendButton, Pos.BOTTOM_RIGHT);
            stackPane.setPadding(new javafx.geometry.Insets(10));
            borderPane.setBottom(stackPane);
        }

        // Posicionar el BorderPane en el centro del AnchorPane
        double centerX = (ayudaid.getWidth() - borderPane.getPrefWidth()) / 2;
        double centerY = (ayudaid.getHeight() - borderPane.getPrefHeight()) / 2;
        borderPane.setLayoutX(centerX);
        borderPane.setLayoutY(centerY);

        // Añadir el BorderPane al AnchorPane principal
        ayudaid.getChildren().add(borderPane);
    }

    // Método para mostrar la alerta y enviar el problema a la base de datos
    private void enviarProblema() {
        String problema = textAreaProblema.getText();
        if (problema.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("El campo de problema no puede estar vacío.");
            alert.showAndWait();
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyfest", "root", "1234")) {
            String query = "INSERT INTO problemas (descripcion) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, problema);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Hubo un error al enviar el problema.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText("El mensaje se ha enviado correctamente.");
        alert.showAndWait();
    }

    @FXML
    private void ButtonAyudaPedidos() {
        mostrarPane("Cuando se realiza el pago, llega de forma automática a tu correo indicado en tu perfil tanto las entradas como la reserva del hotel (Si es que usted ha reservado). En caso de fallo contacte con el servicio de ayuda.", false);

    }

    @FXML
    private void ButtonDevoluciones() {
        mostrarPane("La devolución se podrá realizar cuando queden menos de 48h para la actividad reservada, tanto para el festival como para el hotel (En caso de reserva). En caso de duda contacte con el servicio de ayuda.", false);
    }

    @FXML
    private void ButtonRedactarProblema() {
        mostrarPane("Texto de ayuda para Redactar Problema", true);
    }

    @FXML
    private void ButtonInfTransporte() {
        mostrarPane("Cuando se realize la compra, en caso de que usted haya reservado alojamiento, se le enviará automáticamente las credenciales necesarias en forma de PDF a su correo electrónico indicado en la aplicación. En el correo se encontrará un código QR que escaneará el establecimiento con toda la información de su reserva. En caso de duda contacte con el servicio de ayuda.", false);
    }
}
