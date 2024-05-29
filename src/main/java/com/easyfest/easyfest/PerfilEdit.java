package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;

public class PerfilEdit {
    @javafx.fxml.FXML
    private DatePicker dateFechaUsuario;
    @javafx.fxml.FXML
    private Button buttonVolver;
    @javafx.fxml.FXML
    private TextField textFieldCorreoUser;
    @javafx.fxml.FXML
    private ImageView imageViewFoto;
    @javafx.fxml.FXML
    private Button buttonAcutalizarPerfil;
    @javafx.fxml.FXML
    private Button buttonCambiarFoto;
    @javafx.fxml.FXML
    private TextField textFieldNombreUser;
    @javafx.fxml.FXML
    private AnchorPane contenedoreditId;
    @javafx.fxml.FXML
    private TextField textFieldNomUser;
    UsuariosModel um = new UsuariosModel();
    Login lg = new Login();

    @javafx.fxml.FXML
    public void onVolver(ActionEvent actionEvent) {
        try {
            AnchorPane perfil = FXMLLoader.load(getClass().getResource("perfil.fxml"));
            this.contenedoreditId.getChildren().setAll(perfil);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void onSubirImagenbutton(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void onActualizarCambios(ActionEvent actionEvent) {
        String correouser = lg.getCorreom();
        int idu = um.getIdUser(correouser);
        LocalDate fechanaz = dateFechaUsuario.getValue();
        String nombre = textFieldNombreUser.getText();
        String apellidos = textFieldNomUser.getText();
        String correo = textFieldCorreoUser.getText();
        um.actualizarUsuario(idu, fechanaz, nombre, apellidos, correo);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Cambios realizados");
        a.setContentText("Cambios realizados correctamente");
        a.showAndWait();
    }
}
