/**
 * Controlador para la interfaz de edición de perfil de usuario.
 */
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

    /**
     * Método para manejar el evento de volver a la pantalla de perfil principal.
     * @param actionEvent Evento de acción.
     */
    @javafx.fxml.FXML
    public void onVolver(ActionEvent actionEvent) {
        loadFXMLToAnchorPane("perfil.fxml", contenedoreditId);
    }

    /**
     * Método para manejar el evento de mostrar el selector de imágenes.
     * @param actionEvent Evento de acción.
     */
    @javafx.fxml.FXML
    public void onSubirImagenbutton(ActionEvent actionEvent) {
        selectimageid.setVisible(true);
    }

    /**
     * Método para manejar el evento de actualizar los cambios en el perfil.
     * @param actionEvent Evento de acción.
     */
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

    // Otros métodos manejadores de eventos aquí...

    /**
     * Método de inicialización de la interfaz.
     * @param url URL de la ubicación del archivo FXML.
     * @param resourceBundle ResourceBundle utilizado para localizar objetos específicos.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String correouser = lg.getCorreom();
        int idu = um.getIdUser(correouser);
        String imguser = um.getImgUser(idu);
        loadImageToImageView("/img/" + imguser, imageViewFoto);
    }

    // Otros métodos de utilidad aquí...

    /**
     * Método para cargar un archivo FXML en un AnchorPane.
     * @param fxmlFile Ruta del archivo FXML.
     * @param anchorPane AnchorPane en el que se cargará el archivo FXML.
     */
    private void loadFXMLToAnchorPane(String fxmlFile, AnchorPane anchorPane) {
        try {
            AnchorPane loadedPane = FXMLLoader.load(getClass().getResource(fxmlFile));
            anchorPane.getChildren().setAll(loadedPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para cargar una imagen desde una ruta y mostrarla en un ImageView.
     * @param imgPath Ruta de la imagen.
     * @param imageView ImageView en el que se mostrará la imagen.
     */
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

    // Otros métodos privados aquí...

    /**
     * Método para actualizar la imagen de usuario y refrescar la interfaz.
     * @param imgFileName Nombre del archivo de imagen.
     */
    private void updateUserImageAndRefresh(String imgFileName) {
        selectimageid.setVisible(false);
        String correouser = lg.getCorreom();
        int idu = um.getIdUser(correouser);
        um.actualizarImgUsuario(idu, imgFileName);
        refreshMenuPrincipal();
        loadFXMLToAnchorPane("perfiledit.fxml", contenedoreditId);
    }

    /**
     * Método para refrescar la interfaz del menú principal.
     */
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

    /**
     * Método para mostrar un cuadro de diálogo de alerta.
     * @param header Encabezado del cuadro de diálogo.
     * @param content Contenido del cuadro de diálogo.
     * @param alertType Tipo de alerta.
     */
    private void showAlert(String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
