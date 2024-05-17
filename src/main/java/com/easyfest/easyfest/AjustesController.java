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

/**
 * Controlador para la vista de ajustes de la aplicación EasyFest.
 * Gestiona las configuraciones relacionadas con el tamaño de letra y el tema de la aplicación.
 * También permite cambiar el idioma de la interfaz.
 *
 * @autor TuNombre
 */
public class AjustesController implements Initializable {

    @javafx.fxml.FXML
    private ToggleGroup toggleTamañoLetra;  // Grupo de botones de radio para el tamaño de la letra

    @javafx.fxml.FXML
    private ToggleGroup toggleTema;  // Grupo de botones de radio para el tema de la aplicación

    @javafx.fxml.FXML
    private RadioButton radioButtonTextoMediano;  // Botón de radio para texto mediano

    @javafx.fxml.FXML
    private RadioButton radioButtonTemaClaro;  // Botón de radio para el tema claro

    @javafx.fxml.FXML
    private RadioButton radioButtonTextoPequeño;  // Botón de radio para texto pequeño

    @javafx.fxml.FXML
    private ChoiceBox<String> idiomaChoiceBox;  // Caja de selección para el idioma

    @javafx.fxml.FXML
    private RadioButton radioButtonTemaOscuro;  // Botón de radio para el tema oscuro

    @javafx.fxml.FXML
    private RadioButton radioButtonTextoGrande;  // Botón de radio para texto grande

    @javafx.fxml.FXML
    private ImageView imageViewOscuro;  // Imagen para el tema oscuro

    @javafx.fxml.FXML
    private ImageView imageViewClaro;  // Imagen para el tema claro

    @javafx.fxml.FXML
    private AnchorPane ajustesid;  // Panel principal de ajustes

    /**
     * Método de inicialización llamado al cargar la vista.
     * Configura los elementos de la interfaz y establece los valores predeterminados.
     *
     * @param url URL de localización del archivo FXML.
     * @param resourceBundle Recursos de internacionalización.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Crear una lista de idiomas disponibles
        ObservableList<String> idiomas = FXCollections.observableArrayList("Español", "Inglés");

        // Establecer los idiomas en la ChoiceBox
        idiomaChoiceBox.setItems(idiomas);

        // Establecer el idioma predeterminado en Español
        idiomaChoiceBox.setValue("Español");

        // Configurar acciones para los botones de radio de tamaño de texto
        radioButtonTextoPequeño.setOnAction(event -> cambiarTamañoLetra(12));
        radioButtonTextoMediano.setOnAction(event -> cambiarTamañoLetra(18));
        radioButtonTextoGrande.setOnAction(event -> cambiarTamañoLetra(24));

        // Establecer el tamaño de letra predeterminado
        cambiarTamañoLetra(18);
    }

    /**
     * Cambia el tamaño de la letra de todos los Label que tengan la clase CSS 'labelTextoTamaño'.
     *
     * @param tamaño El nuevo tamaño de la letra.
     */
    private void cambiarTamañoLetra(int tamaño) {
        // Iterar sobre todos los hijos del AnchorPane
        for (javafx.scene.Node node : ajustesid.getChildren()) {
            // Verificar si el nodo es un Label y tiene la clase CSS 'labelTextoTamaño'
            if (node instanceof Label && node.getStyleClass().contains("labelTextoTamaño")) {
                // Cambiar la fuente del Label al nuevo tamaño
                ((Label) node).setFont(new Font(tamaño));
            }
        }
    }
}
