package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Este es un Controlador para la vista de inicio de sesión.
 *
 * Esta sirve para el inicio de sesion que se comprobara con la base de datos si existen datos de X usuario.
 * si no existen datos este tendra que crear un usuario/registrase.
 */
public class Login implements Initializable {

    @FXML
    private Button loginid;
    @FXML
    private TextField passwordid;
    @FXML
    private Label regisid;
    @FXML
    private TextField usermailid;
    @FXML
    private CheckBox recuerdameid;
    @FXML
    private Label forgotid;
    @FXML
    private AnchorPane LoginPageid;
    UsuariosModel um = new UsuariosModel();

    /**
     * Método para manejar el evento de inicio de sesión.
     * @param actionEvent El evento de acción generado por el botón de inicio de sesión.
     */
    @FXML
    public void login(ActionEvent actionEvent) {
        String correo = usermailid.getText();
        String contrasena = passwordid.getText();
        boolean entra = um.loginusuario(correo, contrasena);
        try {
            AnchorPane login = FXMLLoader.load(getClass().getResource("menuprincipal.fxml"));
            this.LoginPageid.getChildren().setAll(login);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*if (entra == true) {
            try {
                AnchorPane login = FXMLLoader.load(getClass().getResource("menuprincipal.fxml"));
                this.LoginPageid.getChildren().setAll(login);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Vuelva a intentarlo");
            a.setContentText("El usuario o la contraseña pueden ser incorrectos.");
            a.showAndWait();
        }

         */
    }

    /**
     * Método ir a la pagina de olvidar contraseña.
     * @param event hace la acción de olvidar contraseña.
     */
    @FXML
    public void forget(Event event) {
        try {
            AnchorPane forget = FXMLLoader.load(getClass().getResource("forgotpassword.fxml"));
            this.LoginPageid.getChildren().setAll(forget);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para ir a la pantalla de registro.
     * @param event hace la acción de registro.
     */
    @FXML
    public void resgistro(Event event) {
        try {
            AnchorPane registro = FXMLLoader.load(getClass().getResource("registro.fxml"));
            this.LoginPageid.getChildren().setAll(registro);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Este método se llama automáticamente después de que se ha cargado el archivo FXML
        // Aquí puedes realizar inicializaciones adicionales si es necesario
    }
}
