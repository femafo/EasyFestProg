package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PerfilEdit implements Initializable {
    @javafx.fxml.FXML
    private DatePicker dateFechaUsuario;
    @javafx.fxml.FXML
    private Button buttonVolver;
    @javafx.fxml.FXML
    private TextField textFieldCorreoUser;
    @javafx.fxml.FXML
    private ImageView imageViewFoto;
    @javafx.fxml.FXML
    private Button buttonActualizarPerfil;
    @javafx.fxml.FXML
    private Button buttonCambiarFoto;
    @javafx.fxml.FXML
    private TextField textFieldNombreUser;
    @javafx.fxml.FXML
    private AnchorPane contenedoreditId;
    @javafx.fxml.FXML
    private TextField textFieldNomUser;
    @javafx.fxml.FXML
    private Pane selectimageid;

    private UsuariosModel um = new UsuariosModel();
    private Login lg = new Login();
    private Menuprincipal mn;

    @javafx.fxml.FXML
    public void onVolver(ActionEvent actionEvent) {
        loadFXMLToAnchorPane("perfil.fxml", contenedoreditId);
    }

    @javafx.fxml.FXML
    public void onSubirImagenbutton(ActionEvent actionEvent) {
        selectimageid.setVisible(true);
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

        showAlert("Cambios realizados", "Cambios realizados correctamente", Alert.AlertType.INFORMATION);
    }

    @javafx.fxml.FXML
    public void onPlanebutton(ActionEvent actionEvent) {
        updateUserImageAndRefresh("avion1.png");
    }

    @javafx.fxml.FXML
    public void onAlertbutton(ActionEvent actionEvent) {
        updateUserImageAndRefresh("signo-de-exclamacion.png");
    }

    @javafx.fxml.FXML
    public void onSzigetbutton(ActionEvent actionEvent) {
        updateUserImageAndRefresh("arcoiris.png");
    }

    @javafx.fxml.FXML
    public void onTomorrowbutton(ActionEvent actionEvent) {
        updateUserImageAndRefresh("mariposa.png");
    }

    @javafx.fxml.FXML
    public void onRockriobutton(ActionEvent actionEvent) {
        updateUserImageAndRefresh("guitarra-electrica.png");
    }

    @javafx.fxml.FXML
    public void onGlastonburybutton(ActionEvent actionEvent) {
        updateUserImageAndRefresh("catrina.png");
    }

    @javafx.fxml.FXML
    public void onFujibutton(ActionEvent actionEvent) {
        updateUserImageAndRefresh("flor.png");
    }

    @javafx.fxml.FXML
    public void onHotelbutton(ActionEvent actionEvent) {
        updateUserImageAndRefresh("hotel1.png");
    }

    @javafx.fxml.FXML
    public void onCoachellaButton(ActionEvent actionEvent) {
        updateUserImageAndRefresh("rueda-del-cielo.png");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String correouser = lg.getCorreom();
        int idu = um.getIdUser(correouser);
        String imguser = um.getImgUser(idu);
        loadImageToImageView("/img/" + imguser, imageViewFoto);
    }

    private void loadFXMLToAnchorPane(String fxmlFile, AnchorPane anchorPane) {
        try {
            AnchorPane loadedPane = FXMLLoader.load(getClass().getResource(fxmlFile));
            anchorPane.getChildren().setAll(loadedPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadImageToImageView(String imgPath, ImageView imageView) {
        try {
            Image image = new Image(getClass().getResourceAsStream(imgPath));
            if (image.isError()) {
                throw new Exception("Error loading image: " + image.getException());
            }
            imageView.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Image not found or failed to load: " + imgPath);
        }
    }

    private void updateUserImageAndRefresh(String imgFileName) {
        selectimageid.setVisible(false);
        String correouser = lg.getCorreom();
        int idu = um.getIdUser(correouser);
        um.actualizarImgUsuario(idu, imgFileName);
        refreshMenuPrincipal();
        loadFXMLToAnchorPane("perfiledit.fxml", contenedoreditId);
    }

    private void refreshMenuPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuprincipal.fxml"));
            loader.load();
            mn = loader.getController();
            mn.refrescarmenuprin();
            mn.updateUserImage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAlert(String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

