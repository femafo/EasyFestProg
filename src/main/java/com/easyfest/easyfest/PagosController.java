package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Controlador para la vista de pagos de la aplicación EasyFest.
 * Gestiona las acciones relacionadas con la visualización de más detalles de pagos y la adición de nuevas tarjetas.
 *
 * @autor TuNombre
 */
public class PagosController implements Initializable {

    @javafx.fxml.FXML
    private AnchorPane pagosid;  // Panel principal de pagos

    @javafx.fxml.FXML
    private Button vermasid;  // Botón para ver más detalles de los pagos
    TarjetasModel tm = new TarjetasModel();
    @javafx.fxml.FXML
    private GridPane grid;
    @javafx.fxml.FXML
    private Pane pane;

    /**
     * Maneja el evento de clic del botón "Ver más".
     * Carga y muestra la vista "mostrarallhistorial.fxml" en el panel principal.
     *
     * @param actionEvent El evento de acción que dispara este método.
     */
    @javafx.fxml.FXML
    public void vermasbutton(ActionEvent actionEvent) {
        try {
            // Cargar la vista de "mostrarallhistorial.fxml"
            AnchorPane vermas = FXMLLoader.load(getClass().getResource("mostrarallhistorial.fxml"));
            // Reemplazar el contenido del panel principal con la nueva vista
            this.pagosid.getChildren().setAll(vermas);
        } catch (IOException e) {
            // Manejar cualquier excepción de entrada/salida
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento de clic del botón "Añadir tarjeta".
     * Carga y muestra la vista "addtarjeta.fxml" en el panel principal.
     *
     * @param actionEvent El evento de acción que dispara este método.
     */
    @Deprecated
    public void anadirbutton(ActionEvent actionEvent) {
        try {
            // Cargar la vista de "addtarjeta.fxml"
            AnchorPane anadirt = FXMLLoader.load(getClass().getResource("addtarjeta.fxml"));
            // Reemplazar el contenido del panel principal con la nueva vista
            this.pagosid.getChildren().setAll(anadirt);
        } catch (IOException e) {
            // Manejar cualquier excepción de entrada/salida
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


}
