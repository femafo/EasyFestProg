package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador de la pantalla de pago.
 *
 * @author [Tu nombre]
 */
public class PagoController implements Initializable {
    /**
     * Etiqueta que muestra el nombre del producto seleccionado.
     */
    @javafx.fxml.FXML
    private Label nombrepid;
    /**
     * HBox que contiene la información del producto seleccionado.
     */
    @javafx.fxml.FXML
    private HBox productoelegidoid;
    /**
     * Etiqueta que muestra el precio del producto seleccionado.
     */
    @javafx.fxml.FXML
    private Label preciopid;
    /**
     * ImageView que muestra la imagen del producto seleccionado.
     */
    @javafx.fxml.FXML
    private ImageView imgpid;
    /**
     * GridPane que contiene la lista de productos en el carrito.
     */
    @javafx.fxml.FXML
    private GridPane grid;
    /**
     * ScrollPane que contiene el GridPane.
     */
    @javafx.fxml.FXML
    private ScrollPane scroll;
    /**
     * Modelo de productos.
     */
    public ProductosModel pm = new ProductosModel();
    /**
     * Lista de productos en el carrito.
     */
    private List<Productos>  listaprueba = new ArrayList<Productos>();
    /**
     * Instancia de la interfaz MiListaP.
     */
    private MiListaP miLista;
    /**
     * Opción seleccionada.
     */
    public int opc;
    /**
     * Etiqueta que muestra el ID del producto seleccionado.
     */
    @javafx.fxml.FXML
    private Label idpid;
    /**
     * Lista de productos históricos del usuario.
     */

    public static ArrayList<Productos> productohistorialid = new ArrayList<Productos>();
    /**
     * Controlador del menú de productos.
     */
    MenuproductosController mp = new MenuproductosController();
    /**
     * Botón para eliminar un producto del carrito.
     */
    @javafx.fxml.FXML
    private Button delbuttonid;
    /**
     * Botón para comprar los productos en el carrito.
     */
    @javafx.fxml.FXML
    private Button comprarbuttonid;
    /**
     * AnchorPane que contiene la pantalla de pago.
     */
    @javafx.fxml.FXML
    private AnchorPane carroid;
    /**
     * Pane que contiene la pantalla de selección de tarjeta.
     */
    @javafx.fxml.FXML
    private Pane compraid;
    /**
     * ChoiceBox que muestra las tarjetas del usuario.
     */
    @javafx.fxml.FXML
    private ChoiceBox tarjetauser;
    /**
     * Modelo de tarjetas.
     */
    public TarjetasModel tm = new TarjetasModel();
    /**
     * Botón para agregar una tarjeta.
     */
    @javafx.fxml.FXML
    private Button addtarjetabuttonid;
    /**
     * Botón para cerrar la pantalla de selección de tarjeta.
     */
    @javafx.fxml.FXML
    private Button closebuttonid;
    /**
     * Botón para pagar los productos en el carrito.
     */
    @javafx.fxml.FXML
    private Button pagarbuttonid;
    /**
     * Bandera que indica si el pane de agregar tarjeta está activo.
     */
    private boolean paneaddactivo = false;
    /**
     * Instancia de la clase Login.
     */
    public Login lg = new Login();
    /**
     * Modelo de usuarios.
     */
    private UsuariosModel um = new UsuariosModel();
    /**
     * Modelo de pedidos.
     */
    private PedidoModel pem = new PedidoModel();
    /**
     * Establece el producto seleccionado.
     *
     * @param productos producto seleccionado
     */


    private void setProductoelegido (Productos productos){
        nombrepid.setText(productos.getNombre());
        preciopid.setText(productos.getPrecio() + "€");
        idpid.setText(String.valueOf(productos.getId()));

    }

    /**
     * Inicializa el controlador.
     *
     * @param url            URL de la ubicación de los recursos
     * @param resourceBundle bundle de recursos
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       mostrar();
    }
    /**
     * Muestra la lista de productos en el carrito.
     */
    public void mostrar(){
        String correouser = lg.getCorreom();
        int idu = um.getIdUser(correouser);
        this.productohistorialid = pem.getPedidosbyId(idu);
        int column = 0;
        int row = 1;
        grid.getChildren().clear();
        List<Productos>  listaall = productohistorialid;
        if (listaall.size() >0 ){
            setProductoelegido(listaall.get(0));
            miLista = new MiListaP() {
                @Override
                public void onClickLista(Productos productos) {
                    setProductoelegido(productos);
                }
            };
        }
        try {
            for (int i = 0; i < listaall.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("pagoitems.fxml"));

                AnchorPane pane = fxmlLoader.load();

                PagoItemsController carroItemsController = fxmlLoader.getController();
                carroItemsController.setData(listaall.get(i), miLista);

                if (column == 1){
                    column = 0;
                    row++;
                }

                grid.add(pane, column++, row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(pane, new Insets(10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Elimina un producto del carrito.
     *
     * @param actionEvent evento de acción
     */
    @javafx.fxml.FXML
    public void ondelButton(ActionEvent actionEvent) {
        Integer id = Integer.valueOf(idpid.getText());
        boolean continua = false;
        int i = 0;
        do {
            if (productohistorialid.get(i).getId() == id){
                productohistorialid.remove(i);
                continua = true;
            }
            i++;
        }while (i < productohistorialid.size() && continua == false);
        mostrar();
    }
    /**
     * Obtiene la lista final de productos.
     *
     * @return lista final de productos
     */
    public static ArrayList<Productos> getfinalProductos(){
        return productohistorialid;
    }
    /**
     * Muestra la pantalla de selección de tarjeta.
     *
     * @param actionEvent evento de acción
     */
    @javafx.fxml.FXML
    public void onComprarbutton(ActionEvent actionEvent) {
        ArrayList<Tarjetas> tarjetacompra = tm.getTarjetasUser(1);
        ArrayList<String> listatarjetas = new ArrayList<String>();
        compraid.setVisible(true);
        for (Tarjetas t : tarjetacompra){
            listatarjetas.add(t.getNum_tarjeta());
        }
        tarjetauser.getItems().addAll(listatarjetas);
    }
    /**
     * Constructor por defecto.
     */
    public PagoController() {
    }
    /**
     * Muestra la pantalla de agregar tarjeta.
     *
     * @param actionEvent evento de acción
     */
    @javafx.fxml.FXML
    public void onAddtarjeta(ActionEvent actionEvent) {
        try {
            AnchorPane addtarjeta = FXMLLoader.load(getClass().getResource("addtarjeta.fxml"));
            this.carroid.getChildren().setAll(addtarjeta);
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }
    /**
     * Cierra la pantalla de pago.
     *
     * @param actionEvent evento de acción
     */

    @javafx.fxml.FXML
    public void onClosebutton(ActionEvent actionEvent) {
        compraid.setVisible(false);
    }
    /**
     * Procesa el pago y agrega la venta al historial.
     *
     * @param actionEvent evento de acción
     */

    @javafx.fxml.FXML
    public void onPagarbuttonid(ActionEvent actionEvent) {
        for (Productos p : productohistorialid) {
            String tarjetaselected = String.valueOf(tarjetauser.getValue());
            Tarjetas t = tm.getTarjetaByNum(tarjetaselected);
            String correouser = lg.getCorreom();
            System.out.println(correouser + " " + tarjetaselected);
            int idu = um.getIdUser(correouser);
            pem.anadirPedido(t.getId_tarjeta(), idu, p.getId());
        }

    }
}