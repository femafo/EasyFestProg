package com.easyfest.easyfest;

import javafx.css.StyleClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Es la Clase controladora para el menú principal de la aplicación EasyFest.
 * Esta clase te permite ir a otras paginas de la web siendo este el menu principal.
 */
public class Menuprincipal {
    @javafx.fxml.FXML
    private Button mensajesId;
    @javafx.fxml.FXML
    private Button ayudaId;
    @javafx.fxml.FXML
    private Button ajustesId;
    @javafx.fxml.FXML
    private ChoiceBox <String> chbUsuario;
    @javafx.fxml.FXML
    private Button busquedaId;
    @javafx.fxml.FXML
    private Button inicioId;
    @javafx.fxml.FXML
    private Button pagosId;
    @javafx.fxml.FXML
    private Button sobreNosotrosId;
    @javafx.fxml.FXML
    private AnchorPane contenedorId;
    private String [] opcusuario = {"Perfil", "Carrito", "Mis pedidos", "Cerrar Sesión" };
    @javafx.fxml.FXML
    private AnchorPane menuprincipalid;


    /**
     * Inicializa la clase controladora.
     * Este método se llama automáticamente después de que el archivo FXML ha sido cargado.
     */
    @javafx.fxml.FXML
    public void initialize() {
        try {
            AnchorPane inicio = FXMLLoader.load(getClass().getResource("inicio.fxml"));
            this.contenedorId.getChildren().setAll(inicio);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        chbUsuario.getItems().addAll(opcusuario);
        chbUsuario.setOnAction(this::opcionuser);

    }

    public void opcionuser(ActionEvent event) {
        String selectedOption = chbUsuario.getValue();
        if ("Perfil".equals(selectedOption)) {
            inicioId.setStyle("-fx-background-color:   linear-gradient(to right, #A8C6FA, #936EF5);");
            busquedaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            pagosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            mensajesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            ajustesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            ayudaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            sobreNosotrosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            try {
                AnchorPane perfil = FXMLLoader.load(getClass().getResource("perfil.fxml"));
                this.contenedorId.getChildren().setAll(perfil);
            } catch (IOException e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            }
        }
        if ("Carrito".equals(selectedOption)) {
            inicioId.setStyle("-fx-background-color:   linear-gradient(to right, #A8C6FA, #936EF5);");
            busquedaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            pagosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            mensajesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            ajustesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            ayudaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            sobreNosotrosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            try {
                AnchorPane carro = FXMLLoader.load(getClass().getResource("carro.fxml"));
                this.contenedorId.getChildren().setAll(carro);
            } catch (IOException e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            }
        }
        if ("Mis pedidos".equals(selectedOption)) {
            inicioId.setStyle("-fx-background-color:   linear-gradient(to right, #A8C6FA, #936EF5);");
            busquedaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            pagosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            mensajesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            ajustesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            ayudaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            sobreNosotrosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
            try {
                AnchorPane pedidos = FXMLLoader.load(getClass().getResource("pedidos.fxml"));
                this.contenedorId.getChildren().setAll(pedidos);
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
     * Maneja el evento de acción para el botón "Ajustes".
     * Carga el archivo "ajustes.fxml" y lo establece en el contenedor principal.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void ajustesbutton(ActionEvent actionEvent) {
        inicioId.setStyle("-fx-background-color:   linear-gradient(to right, #A8C6FA, #936EF5);");
        busquedaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        pagosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        mensajesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        ajustesId.setStyle("-fx-background-color:  A8C6FA;");
        ayudaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        sobreNosotrosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        try {
            AnchorPane ajustes = FXMLLoader.load(getClass().getResource("ajustes.fxml"));
            this.contenedorId.getChildren().setAll(ajustes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento de acción para el botón "Pagos".
     * Carga el archivo "pagos.fxml" y lo establece en el contenedor principal.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void pagosbutton(ActionEvent actionEvent) {
        inicioId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        busquedaId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        pagosId.setStyle("-fx-background-color:  A8C6FA;");
        mensajesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        ajustesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        ayudaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        sobreNosotrosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");

        try {
            AnchorPane pagos = FXMLLoader.load(getClass().getResource("pagos.fxml"));
            this.contenedorId.getChildren().setAll(pagos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento de acción para el botón "Ayuda".
     * Carga el archivo "ayuda.fxml" y lo establece en el contenedor principal.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void ayudabutton(ActionEvent actionEvent) {
        inicioId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        busquedaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        pagosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        mensajesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        ajustesId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        ayudaId.setStyle("-fx-background-color:  A8C6FA;");
        sobreNosotrosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");

        try {
            AnchorPane ayuda = FXMLLoader.load(getClass().getResource("ayuda.fxml"));
            this.contenedorId.getChildren().setAll(ayuda);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento de acción para el botón "Sobre Nosotros".
     * Carga el archivo "sobrenosotros.fxml" y lo establece en el contenedor principal.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void sobrenosotrosbutton(ActionEvent actionEvent) {
        inicioId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        busquedaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        pagosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        mensajesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        ajustesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        ayudaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        sobreNosotrosId.setStyle("-fx-background-color:  A8C6FA;");

        try {
            AnchorPane sobrenosotros = FXMLLoader.load(getClass().getResource("sobrenosotros.fxml"));
            this.contenedorId.getChildren().setAll(sobrenosotros);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento de acción para el botón "Mensajes".
     * Carga el archivo "mensajes.fxml" y lo establece en el contenedor principal.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void mensajesbutton(ActionEvent actionEvent) {
        inicioId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        busquedaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        pagosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        mensajesId.setStyle("-fx-background-color:  A8C6FA;");
        ajustesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        ayudaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        sobreNosotrosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");

        try {
            AnchorPane mensajes = FXMLLoader.load(getClass().getResource("mensajes.fxml"));
            this.contenedorId.getChildren().setAll(mensajes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento de acción para el botón "Busqueda".
     * Carga el archivo "busqueda.fxml" y lo establece en el contenedor principal.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void busquedabutton(ActionEvent actionEvent) {
        inicioId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        busquedaId.setStyle("-fx-background-color:  A8C6FA;");
        pagosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        mensajesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        ajustesId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        ayudaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        sobreNosotrosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");

        try {
            AnchorPane busqueda = FXMLLoader.load(getClass().getResource("busqueda.fxml"));
            this.contenedorId.getChildren().setAll(busqueda);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento de acción para el botón "Inicio".
     * Carga el archivo "inicio.fxml" y lo establece en el contenedor principal.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void iniciobutton(ActionEvent actionEvent) {
        inicioId.setStyle("-fx-background-color:  A8C6FA;");
        busquedaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        pagosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        mensajesId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        ajustesId.setStyle("-fx-background-color: linear-gradient(to right, #A8C6FA, #936EF5);");
        ayudaId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");
        sobreNosotrosId.setStyle("-fx-background-color:  linear-gradient(to right, #A8C6FA, #936EF5);");

        try {
            AnchorPane inicio2 = FXMLLoader.load(getClass().getResource("inicio.fxml"));
            this.contenedorId.getChildren().setAll(inicio2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
