package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Controlador para la vista de cambio de contraseña en el proceso de recuperación.
 *
 * Esta clase te pide que escribas una nueva contraña y la repitas para tener una mayor seguridad.
 */
public class Forgotpassword2 {
    @javafx.fxml.FXML
    private Button changebid;
    @javafx.fxml.FXML
    private TextField newcontr2;
    @javafx.fxml.FXML
    private TextField newcontr1;
    @javafx.fxml.FXML
    private AnchorPane forgotpassword2;
    @javafx.fxml.FXML
    private Button backid;
    String correo = null;
    Forgotpassword fg = new Forgotpassword();
    UsuariosModel um = new UsuariosModel();

    /**
     * Método de inicialización, llamado automáticamente después de que se haya cargado el archivo FXML.
     */
    @javafx.fxml.FXML
    public void initialize() {
        // Puedes realizar inicializaciones adicionales aquí si es necesario
        correo = fg.getCorreoRecup();
    }

    /**
     * Método para manejar de cambio de contraseña.
     * @param actionEvent El evento de acción generado por el botón de cambio de contraseña.
     */
    @javafx.fxml.FXML
    public void changecontrbutton(ActionEvent actionEvent) {
        String contr1 = newcontr1.getText();
        String contr2 = newcontr2.getText();
        if (contr1.equals(contr2)) {
            um.actualizarContrUsuario(correo, newcontr1.getText());
            try {
                // Cargar la vista de inicio de sesión después de cambiar la contraseña
                AnchorPane login = FXMLLoader.load(getClass().getResource("login.fxml"));
                this.forgotpassword2.getChildren().setAll(login);
            } catch (IOException e) {
                // Manejar cualquier excepción de carga de FXML
                throw new RuntimeException(e);
            }
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Vuelva a intentarlo");
            a.setContentText("Revise si las contraseñas introducidas son iguales.");
            a.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void onbackbutton(ActionEvent actionEvent) {
        try {
            AnchorPane back = FXMLLoader.load(getClass().getResource("forgotpassword.fxml"));
            this.forgotpassword2.getChildren().setAll(back);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
