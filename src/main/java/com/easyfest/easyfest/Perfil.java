/**
 * Controlador para la interfaz de perfil de usuario.
 */
package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Perfil implements Initializable {
    @javafx.fxml.FXML
    private Button buttonVolver;
    @javafx.fxml.FXML
    private Button buttonAcutalizarPerfil;
    @javafx.fxml.FXML
    private AnchorPane contenedorId;
    @javafx.fxml.FXML
    private ImageView imageViewFoto;

    private File file;
    Login lg = new Login();
    UsuariosModel um = new UsuariosModel();
    @javafx.fxml.FXML
    private Label prefechanazid;
    @javafx.fxml.FXML
    private Label prenombreid;
    @javafx.fxml.FXML
    private Label precorreoid;
    Usuario u = new Usuario();
    @javafx.fxml.FXML
    private Label preapellidosid;


    /**
     * Inicializa la interfaz del perfil de usuario.
     * @param location Ubicación del archivo FXML.
     * @param resources ResourceBundle utilizado para localizar objetos específicos.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        anyadirDatos();
         */
        String correouser = um.getCorreoUser(lg.getIdUser());
        String imguser = um.getImgUser(lg.getIdUser());

        String imgPath = "/img/" + imguser;

        Image image = null;
        try {
            image = new Image(getClass().getResourceAsStream(imgPath));
            if (image.isError()) {
                throw new Exception("Error loading image: " + image.getException());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Image not found or failed to load: " + imgPath);
        }

        if (image != null) {
            imageViewFoto.setImage(image);
        }
        u = um.buscarUsuariolog(correouser);
        this.precorreoid.setText(correouser);
        this.prenombreid.setText(u.getNombre());
        this.preapellidosid.setText(u.getApellidos());
        this.prefechanazid.setText(String.valueOf(u.getFecha_nacimiento()));
        System.out.println(precorreoid + " " + prenombreid);

    }

    /**
     * Maneja el evento de volver a la pantalla principal.
     * @param actionEvent Evento de acción.
     */
    @javafx.fxml.FXML
    public void onVolver(ActionEvent actionEvent) {
        try {
            AnchorPane inicio2 = FXMLLoader.load(getClass().getResource("menuproductos.fxml"));
            this.contenedorId.getChildren().setAll(inicio2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento de actualizar los cambios en el perfil.
     * @param actionEvent Evento de acción.
     * @throws SQLException Si ocurre un error de SQL.
     */
    @javafx.fxml.FXML
    public void onActualizarCambios(ActionEvent actionEvent) throws SQLException {
        try {
            AnchorPane perfiledit = FXMLLoader.load(getClass().getResource("perfiledit.fxml"));
            this.contenedorId.getChildren().setAll(perfiledit);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
