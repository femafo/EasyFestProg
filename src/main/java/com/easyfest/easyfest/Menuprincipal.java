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
    /**
     * Botón Ayuda.
     */
    @FXML
    private Button ayudaId;
    /**
     * Botón Ajustes.
     */
    @FXML
    private Button ajustesId;
    /**
     * ChoiceBox para seleccionar el usuario.
     */
    @FXML
    private ChoiceBox<String> chbUsuario;
    /**
     * Botón Busqueda.
     */
    @FXML
    private Button busquedaId;
    /**
     * Botón Inicio.
     */
    @FXML
    private Button inicioId;

    /**
     * Botón Pagos.
     */
    @FXML
    private Button pagosId;
    /**
     * Botón Sobre Nosotros.
     */
    @FXML
    private Button sobreNosotrosId;
    /**
     * AnchorPane contenedor.
     */
    @FXML
    private AnchorPane contenedorId;
    /**
     * Opciones del usuario.
     */
    private String[] opcusuario = {"Perfil", "Cerrar Sesión"};
    /**
     * AnchorPane menú principal.
     */
    @FXML
    private AnchorPane menuprincipalid;
    /**
     * Botón Carrito.
     */
    @FXML
    private Button carritoId;
    /**
     * Controlador de menú productos.
     */
    private MenuproductosController mp = new MenuproductosController();
    /**
     * Indica si el usuario es administrador.
     */
    public static int admin;
    /**
     * Controlador de login.
     */
    private Login lg = new Login();
    /**
     * Imagen de usuario.
     */
    @FXML
    private ImageView imguserid;
    /**
     * Modelo de usuarios.
     */
    private UsuariosModel um = new UsuariosModel();
    /**
     * Etiqueta de usuario.
     */
    @FXML
    private Label usuarioid;
    /**
     * Inicializa el menú principal.
     */
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
    /**
     * Maneja la opción seleccionada en el ChoiceBox de usuario.
     *
     * @param event evento de selección
     */
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
    /**
     * Aplica estilo a los botones.
     */
    private void applyStyleToButtons() {
        inicioId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        busquedaId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        pagosId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        ayudaId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        sobreNosotrosId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        carritoId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
    }
    /**
     * Maneja el evento de clic en el botón de pagos.
     *
     * @param actionEvent evento de clic
     */
    @FXML
    public void pagosbutton(ActionEvent actionEvent) {
        applyStyleToButtons();
        pagosId.setStyle("-fx-background-color: #A8C6FA;");
        loadFXMLToContainer("pagos.fxml");
    }
    /**
     * Maneja el evento de clic en el botón de ayuda.
     *
     * @param actionEvent evento de clic
     */
    @FXML
    public void ayudabutton(ActionEvent actionEvent) {
        applyStyleToButtons();
        ayudaId.setStyle("-fx-background-color: #A8C6FA;");
        loadFXMLToContainer("ayuda.fxml");
    }
    /**
     * Maneja el evento de clic en el botón de sobre nosotros.
     *
     * @param actionEvent evento de clic
     */
    @FXML
    public void sobrenosotrosbutton(ActionEvent actionEvent) {
        applyStyleToButtons();
        sobreNosotrosId.setStyle("-fx-background-color: #A8C6FA;");
        loadFXMLToContainer("sobrenosotros.fxml");
    }
    /**
     * Maneja el evento de clic en el botón de busqueda.
     *
     * @param actionEvent evento de clic
     */
    @FXML
    public void busquedabutton(ActionEvent actionEvent) {
        applyStyleToButtons();
        busquedaId.setStyle("-fx-background-color: #A8C6FA;");
        loadFXMLToContainer("adminmenu.fxml");
    }
    /**
     * Maneja el evento de clic en el botón de inicio.
     *
     * @param actionEvent evento de clic
     */
    @FXML
    public void iniciobutton(ActionEvent actionEvent) {
        applyStyleToButtons();
        inicioId.setStyle("-fx-background-color: #A8C6FA;");
        loadFXMLToContainer("menuproductos.fxml");
    }
    /**
     * Maneja el evento de clic en el botón de carrito.
     *
     * @param actionEvent evento de clic
     */
    @FXML
    public void carritobutton(ActionEvent actionEvent) {
        applyStyleToButtons();
        carritoId.setStyle("-fx-background-color: #A8C6FA;");
        loadFXMLToContainer("carro.fxml");
    }
    /**
     * Carga un FXML en el contenedor.
     *
     * @param fxmlFile nombre del archivo FXML
     */
    private void loadFXMLToContainer(String fxmlFile) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(fxmlFile));
            this.contenedorId.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } /**
     * Refresca el menú principal.
     */
    public void refrescarmenuprin() {
        // Refresh logic for the menu principal
    }
    /**
     * Actualiza la imagen de usuario.
     */

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
    /**
     * Constructor de la clase.
     */
    public Menuprincipal() {
    }
}
