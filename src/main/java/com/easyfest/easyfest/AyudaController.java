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
/**
 * Controlador para la pantalla de ayuda.
 *
 * @author antonio
 */
public class AyudaController {
    /**
     * Pane principal de la pantalla de ayuda.
     */
    @FXML
    private AnchorPane ayudaid;

    /**
     * Botón para mostrar ayuda sobre pedidos.
     */
    @FXML
    private Button buttonAyudaPedidos;
    /**
     * Botón para mostrar ayuda sobre devoluciones.
     */
    @FXML
    private Button buttonDevoluciones;
    /**
     * Botón para redactar un problema.
     */
    @FXML
    private Button buttonRedactarProblema;
    /**
     * Botón para mostrar información sobre transporte.
     */
    @FXML
    private Button buttonInfTransporte;
    /**
     * TextArea para escribir un problema.
     */
    private TextArea textAreaProblema;
    /**
     * Muestra un pane con un texto y un botón de cerrar.
     *
     * @param texto el texto a mostrar
     * @param incluirBotonEnviar si se debe incluir un botón de enviar.
     */
    private void mostrarPane(String texto, boolean incluirBotonEnviar) {
        // Crear un nuevo Pane con BorderPane para permitir mejor organización
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: linear-gradient(to right, #FFB6C1, #FFCC99); -fx-background-radius: 30px;");
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
        label.setStyle("-fx-font-size: 18px;"); // Aumentar tamaño del texto
        vbox.getChildren().add(label);

        if (incluirBotonEnviar) {
            textAreaProblema = new TextArea();
            textAreaProblema.setPromptText("Escribe tu problema aquí...");
            textAreaProblema.setWrapText(true);
            textAreaProblema.setStyle("-fx-font-size: 16px;"); // Aumentar tamaño del texto del TextArea
            vbox.getChildren().add(textAreaProblema);
        }

        // Añadir VBox al centro del BorderPane
        borderPane.setCenter(vbox);

        // Crear y añadir el botón de cerrar
        Button closeButton = new Button("Cerrar");
        closeButton.setOnAction(e -> ((Pane)borderPane.getParent()).getChildren().remove(borderPane));
        closeButton.setStyle("-fx-background-color: #DACAFB; -fx-background-radius: 30px; -fx-border-radius: 30px; -fx-font-size: 11px;");
        closeButton.setPrefSize(60, 20); // Establecer tamaño adecuado para que sea redondo

        // Posicionar el botón de cerrar en la parte superior izquierda del BorderPane
        Pane topPane = new Pane(closeButton);
        closeButton.setLayoutX(10); // Ajusta la posición según sea necesario
        closeButton.setLayoutY(10); // Ajusta la posición según sea necesario
        borderPane.setTop(topPane);

        if (incluirBotonEnviar) {
            // Crear botón de enviar y añadirlo a la parte inferior derecha del BorderPane
            Button sendButton = new Button("Enviar");
            sendButton.setOnAction(e -> enviarProblema());
            sendButton.setStyle("-fx-background-color: #DACAFB; -fx-background-radius: 30px; -fx-border-radius: 30px; -fx-font-size: 11px;");
            sendButton.setPrefSize(60, 20); // Establecer tamaño adecuado para que sea redondo

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
    /**
     * Maneja el evento de clic en el botón de ayuda sobre pedidos.
     */
    @FXML
    private void ButtonAyudaPedidos() {
        mostrarPane("Cuando se realiza el pago, llega de forma automática a tu correo indicado en tu perfil tanto las entradas como la reserva del hotel (Si es que usted ha reservado). En caso de fallo contacte con el servicio de ayuda.", false);
    }

    /**
     * Maneja el evento de clic en el botón de ayuda sobre devoluciones.
     */
    @FXML
    private void ButtonDevoluciones() {
        mostrarPane("La devolución se podrá realizar cuando queden menos de 48h para la actividad reservada, tanto para el festival como para el hotel (En caso de reserva). En caso de duda contacte con el servicio de ayuda.", false);
    }
    /**
     * Maneja el evento de clic en el botón de redactar un problema.
     */
    @FXML
    private void ButtonRedactarProblema() {
        mostrarPane("Texto de ayuda para Redactar Problema", true);
    }
    /**
     * Maneja el evento de clic en el botón de información sobre transporte.
     */
    @FXML
    private void ButtonInfTransporte() {
        mostrarPane("Cuando se realize la compra, en caso de que usted haya reservado alojamiento, se le enviará automáticamente las credenciales necesarias en forma de PDF a su correo electrónico indicado en la aplicación. En el correo se encontrará un código QR que escaneará el establecimiento con toda la información de su reserva. En caso de duda contacte con el servicio de ayuda.", false);
    }
}




