package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Perfil implements Initializable {
    @javafx.fxml.FXML
    private Button buttonVolver;
    @javafx.fxml.FXML
    private Button buttonAcutalizarPerfil;
    @javafx.fxml.FXML
    private Button buttonCambiarFoto;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        anyadirDatos();
         */
        String correouser = lg.getCorreom();
        int idu = um.getIdUser(correouser);
        String imguser = um.getImgUser(idu);

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

    @javafx.fxml.FXML
    private void onSubirImagenbutton(ActionEvent actionEvent) {
        /*
        // Subir la imagen
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Imagen de Perfil");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de Imagen", "*.png", "*.jpg", "*.jpeg")
        );

        Stage stage = (Stage) imageViewFoto.getScene().getWindow();
        file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageViewFoto.setImage(image);

            // Añadir imagen seleccionada a la base de datos
            UsuarioHolder holder = UsuarioHolder.getInstance();
            Usuario u = holder.getUsuario();

            String correo = u.getCorreo();

            UsuariosModel us = new UsuariosModel();
            us.anyadirImagen(correo, file);
            System.out.println("Imagen actualizada en la base de datos.");
        }

         */

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

    public void anyadirDatos() {
        /*
        UsuarioHolder holder = UsuarioHolder.getInstance();
        Usuario u = holder.getUsuario();

        if (u != null) {
            textFieldNombreUser.setText(u.getNombre());
            textFieldNomUser.setText(u.getApellidos());
            textFieldCorreoUser.setText(u.getCorreo());
            dateFechaUsuario.setValue(u.getFecha_nacimiento());
            imageViewFoto.setImage(u.getImagen());
        } else {
            System.out.println("Usuario no encontrado en el UsuarioHolder");
            // Puedes agregar manejo de errores o redireccionamiento aquí
        }
         */
    }


    @javafx.fxml.FXML
    public void onActualizarCambios(ActionEvent actionEvent) throws SQLException {
        try {
            AnchorPane perfiledit = FXMLLoader.load(getClass().getResource("perfiledit.fxml"));
            this.contenedorId.getChildren().setAll(perfiledit);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        PerfilModel pm = new PerfilModel();
        UsuarioHolder holder = UsuarioHolder.getInstance();
        Usuario u = holder.getUsuario();

        if (u != null) {
            // Obtener la imagen seleccionada
            Image imagenSeleccionada = imageViewFoto.getImage();
            String imageURL = imagenSeleccionada.getUrl().replace("file:", "");
            File imagen = new File(imageURL);

            // Obtener los demás datos del formulario
            String nombre = textFieldNombreUser.getText();
            String apellidos = textFieldNomUser.getText();
            String correo = textFieldCorreoUser.getText();
            LocalDate fechaSeleccionada = dateFechaUsuario.getValue();

            // Llamar al método para actualizar los datos
            pm.actualizarDatos(nombre, apellidos, correo, fechaSeleccionada, imageURL, u.getId());

            // Actualizar el usuario en el holder
            u.setNombre(nombre);
            u.setApellidos(apellidos);
            u.setCorreo(correo);
            u.setFecha_nacimiento(fechaSeleccionada);
            u.setImagen(imagenSeleccionada);

            UsuariosModel um = new UsuariosModel();
            um.anyadirImagen(u.getCorreo(),file);

        } else {
            System.out.println("Usuario no encontrado en el UsuarioHolder");
            // Puedes agregar manejo de errores o redireccionamiento aquí
        }
         */

    }
}



