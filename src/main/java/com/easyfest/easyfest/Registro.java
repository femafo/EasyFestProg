package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Controlador para la vista de registro.
 *
 * Esta clase maneja la lógica relacionada con la vista de registro de nuevos usuarios.
 */
public class Registro {
    @javafx.fxml.FXML
    private AnchorPane paneregistro;
    @javafx.fxml.FXML
    private TextField passwordid;
    @javafx.fxml.FXML
    private TextField rpasswordid;
    @javafx.fxml.FXML
    private TextField apellidoid;
    @javafx.fxml.FXML
    private DatePicker ndateid;
    @javafx.fxml.FXML
    private TextField emailid;
    @javafx.fxml.FXML
    private TextField nombreid;
    @javafx.fxml.FXML
    private TextField dniid;
    @javafx.fxml.FXML
    private Button registrarsebutton;
    UsuariosModel um = new UsuariosModel();
    @javafx.fxml.FXML
    private Button backid;

    /**
     * Método de inicialización, llamado automáticamente después de que se haya cargado el archivo FXML.
     */
    @javafx.fxml.FXML
    public void initialize() {
        // Puedes realizar inicializaciones adicionales aquí si es necesario
    }

    /**
     * Maneja el evento de registro.
     *
     * @param actionEvent El evento de acción generado por el botón de registro.
     */
    @javafx.fxml.FXML
    public void resgistrarse(ActionEvent actionEvent) {
        // Aquí puedes escribir la lógica para manejar el evento de registro
        String nombre = nombreid.getText();
        String apellidos = apellidoid.getText();
        String dni = dniid.getText();
        String correo = emailid.getText();
        String contrasena = passwordid.getText();
        String rcontrasena = rpasswordid.getText();
        LocalDate fecha_nacimiento = ndateid.getValue();
        if (contrasena.equals(rcontrasena)){
            um.anadirUsurios(nombre, apellidos, dni, correo, contrasena, fecha_nacimiento);
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Vuelva a intentarlo");
            a.setContentText("El usuario o la contraseña pueden ser incorrectos.");
            a.showAndWait();
        }
        try {
            AnchorPane login = FXMLLoader.load(getClass().getResource("login.fxml"));
            this.paneregistro.getChildren().setAll(login);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento de retroceso.
     *
     * @param actionEvent El evento de acción generado por el botón de retroceso.
     */
    @javafx.fxml.FXML
    public void onbackbutton(ActionEvent actionEvent) {
        try {
            AnchorPane back = FXMLLoader.load(getClass().getResource("login.fxml"));
            this.paneregistro.getChildren().setAll(back);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
