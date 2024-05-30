package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Es la Clase controladora para el menú principal de la aplicación EasyFest.
 * Esta clase te permite ir a otras paginas de la web siendo este el menu principal.
 */
public class Menuprincipal {
    @FXML
    private Button ayudaId;
    @FXML
    private Button ajustesId;
    @FXML
    private ChoiceBox<String> chbUsuario;
    @FXML
    private Button busquedaId;
    @FXML
    private Button inicioId;
    @FXML
    private Button pagosId;
    @FXML
    private Button sobreNosotrosId;
    @FXML
    private AnchorPane contenedorId;
    private String[] opcusuario = {"Perfil", "Cerrar Sesión"};
    @FXML
    private AnchorPane menuprincipalid;
    @FXML
    private Button carritoId;
    private MenuproductosController mp = new MenuproductosController();
    public static int admin;
    private Login lg = new Login();
    @FXML
    private ImageView imguserid;
    private UsuariosModel um = new UsuariosModel();
    @FXML
    private Label usuarioid;

    @FXML
    public void initialize() {
        admin = lg.getAdmin();
        System.out.println(admin);
        if (admin == 1) {
            busquedaId.setVisible(true);
        }
        try {
            AnchorPane inicio = FXMLLoader.load(getClass().getResource("menuproductos.fxml"));
            this.contenedorId.getChildren().setAll(inicio);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        chbUsuario.getItems().addAll(opcusuario);
        chbUsuario.setOnAction(this::opcionuser);
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
            imguserid.setImage(image);
        }
        String nombre = um.getNombreUser(idu);
        System.out.println(nombre);
        usuarioid.setText(nombre);
        updateUserImage();
    }

    public void opcionuser(ActionEvent event) {
        String selectedOption = chbUsuario.getValue();
        if ("Perfil".equals(selectedOption)) {
            applyStyleToButtons();
            try {
                AnchorPane perfil = FXMLLoader.load(getClass().getResource("perfil.fxml"));
                this.contenedorId.getChildren().setAll(perfil);
            } catch (IOException e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            }
        }
        if ("Cerrar Sesión".equals(selectedOption)) {
            try {
                AnchorPane login = FXMLLoader.load(getClass().getResource("login.fxml"));
                this.menuprincipalid.getChildren().setAll(login);
            } catch (IOException e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            }
        }
        chbUsuario.setValue(null);
    }

    private void applyStyleToButtons() {
        inicioId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        busquedaId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        pagosId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        ayudaId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        sobreNosotrosId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        carritoId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
    }

    @FXML
    public void pagosbutton(ActionEvent actionEvent) {
        applyStyleToButtons();
        pagosId.setStyle("-fx-background-color: #A8C6FA;");
        loadFXMLToContainer("pagos.fxml");
    }

    @FXML
    public void ayudabutton(ActionEvent actionEvent) {
        applyStyleToButtons();
        ayudaId.setStyle("-fx-background-color: #A8C6FA;");
        loadFXMLToContainer("ayuda.fxml");
    }

    @FXML
    public void sobrenosotrosbutton(ActionEvent actionEvent) {
        applyStyleToButtons();
        sobreNosotrosId.setStyle("-fx-background-color: #A8C6FA;");
        loadFXMLToContainer("sobrenosotros.fxml");
    }

    @FXML
    public void busquedabutton(ActionEvent actionEvent) {
        applyStyleToButtons();
        busquedaId.setStyle("-fx-background-color: #A8C6FA;");
        loadFXMLToContainer("adminmenu.fxml");
    }

    @FXML
    public void iniciobutton(ActionEvent actionEvent) {
        applyStyleToButtons();
        inicioId.setStyle("-fx-background-color: #A8C6FA;");
        loadFXMLToContainer("menuproductos.fxml");
    }

    @FXML
    public void carritobutton(ActionEvent actionEvent) {
        applyStyleToButtons();
        carritoId.setStyle("-fx-background-color: #A8C6FA;");
        loadFXMLToContainer("carro.fxml");
    }

    private void loadFXMLToContainer(String fxmlFile) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(fxmlFile));
            this.contenedorId.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void refrescarmenuprin() {
        // Refresh logic for the menu principal
    }

    public void updateUserImage() {
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
            imguserid.setImage(image);
        }
    }

    public Menuprincipal() {
    }
}
