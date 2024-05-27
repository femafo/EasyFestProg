package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Perfil implements Initializable {
    @javafx.fxml.FXML
    private DatePicker dateFechaUsuario;
    @javafx.fxml.FXML
    private Button buttonVolver;
    @javafx.fxml.FXML
    private TextField textFieldCorreoUser;
    @javafx.fxml.FXML
    private Button buttonAcutalizarPerfil;
    @javafx.fxml.FXML
    private Button buttonCambiarFoto;
    @javafx.fxml.FXML
    private TextField textFieldNombreUser;
    @javafx.fxml.FXML
    private TextField textFieldNomUser;
    @javafx.fxml.FXML
    private AnchorPane contenedorId;
    @javafx.fxml.FXML
    private ImageView imageViewFoto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadUsuarioData();
    }

    private void loadUsuarioData() {
        UserHolder usuarioHolder = UserHolder.getInstance();
        Usuario usuario = usuarioHolder.getUser();
        if (usuario != null) {
            textFieldNombreUser.setText(usuario.getNombre());
            textFieldNomUser.setText(usuario.getNombre());
            textFieldCorreoUser.setText(usuario.getCorreo());
            dateFechaUsuario.setValue(usuario.getFecha_nacimiento());
        }
    }

    @javafx.fxml.FXML
    public void onVolver(ActionEvent actionEvent) {
        try {
            AnchorPane inicio2 = FXMLLoader.load(getClass().getResource("menuproductos.fxml"));
            this.contenedorId.getChildren().setAll(inicio2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void onCambiarFoto(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Imagen de Perfil");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de Imagen", "*.png", "*.jpg", "*.jpeg")
        );

        Stage stage = (Stage) contenedorId.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageViewFoto.setImage(image);
        }
    }

    @javafx.fxml.FXML
    public void onActualizarCambios(ActionEvent actionEvent) {
        // Actualizar la información del usuario aquí
    }
}
