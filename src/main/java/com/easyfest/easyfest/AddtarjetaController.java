/**
 * Clase AddtarjetaController que controla la interfaz gráfica de usuario para añadir una nueva tarjeta.
 */
package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Controlador para la vista de añadir una nueva tarjeta.
 * esta clase sirve para insertar tarjetas
 */
public class AddtarjetaController {

    @FXML
    private AnchorPane addtarjetaid;
    @FXML
    private TextField cvvid;
    @FXML
    private TextField titularid;
    @FXML
    private Button backbutton;
    @FXML
    private DatePicker dateid;
    @FXML
    private TextField numeroid;
    @FXML
    private Button anadirbutton;

    /**
     * Instancia de la clase TarjetasModel para interactuar con el modelo de tarjetas.
     */
    TarjetasModel tm = new TarjetasModel();

    /**
     * Instancia de la clase Login para obtener el correo electrónico del usuario actual.
     */
    Login lg = new Login();

    /**
     * Instancia de la clase UsuariosModel para interactuar con el modelo de usuarios.
     */
    UsuariosModel um = new UsuariosModel();

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Atrás".
     *
     * @param actionEvent evento de acción del botón "Atrás".
     */
    @FXML
    public void onback(ActionEvent actionEvent) {
        try {
            AnchorPane pagos = FXMLLoader.load(getClass().getResource("carro.fxml"));
            this.addtarjetaid.getChildren().setAll(pagos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Añadir tarjeta".
     *
     * @param actionEvent evento de acción del botón "Añadir tarjeta".
     */
    @FXML
    public void onanadirtarjeta(ActionEvent actionEvent) {

        LocalDate fecha_nacimiento = dateid.getValue();
        Integer cvv = Integer.valueOf(cvvid.getText());
        String num_tarjeta = numeroid.getText();
        String titular = titularid.getText();
        String correouser = lg.getCorreom();
        int idu = um.getIdUser(correouser);

        tm.anadirTarjeta(idu, fecha_nacimiento, cvv, num_tarjeta, titular);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Tarjeta Agregada");
        a.setContentText("Tarjeta agregada correctamente");
        a.showAndWait();
    }
}