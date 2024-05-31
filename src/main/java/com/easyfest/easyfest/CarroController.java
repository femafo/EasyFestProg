package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
 * Controlador de la vista del carrito de compras.
 *
 * @author fermin
 */
public class CarroController implements Initializable {
    /**
     * Vista del nombre del producto.
     */
    @javafx.fxml.FXML
    private Label nombrepid;
    /**
     * Vista del producto seleccionado.
     */
    @javafx.fxml.FXML
    private HBox productoelegidoid;
    /**
     * Vista del precio del producto.
     */
    @javafx.fxml.FXML
    private Label preciopid;
    /**
     * Vista de la imagen del producto.
     */
    @javafx.fxml.FXML
    private ImageView imgpid;
    /**
     * Grid donde se mostrarán los productos.
     */
    @javafx.fxml.FXML
    private GridPane grid;

    /**
     * Scroll para el grid de productos.
     */
    @javafx.fxml.FXML
    private ScrollPane scroll;
    /**
     * Modelo de productos.
     */
    public ProductosModel pm = new ProductosModel();
    /**
     * Lista de productos seleccionados.
     */
    private List<Productos>  listaprueba = new ArrayList<Productos>();
    /**
     * Referencia a la lista de productos.
     */
    private MiListaC miLista;
    /**
     * ID del producto seleccionado.
     */
    public int opc;

    /**
     * Vista del ID del producto.
     */
    @javafx.fxml.FXML
    private Label idpid;
    /**
     * Lista de productos seleccionados.
     */
    public static ArrayList<Productos> productoscarroid = new ArrayList<Productos>();
    /**
     * Controlador de la vista de productos.
     */
    MenuproductosController mp = new MenuproductosController();
    /**
     * Botón de eliminar producto.
     */
    @javafx.fxml.FXML
    private Button delbuttonid;
    /**
     * Botón de comprar productos.
     */
    @javafx.fxml.FXML
    private Button comprarbuttonid;
    /**
     * Vista del carrito de compras.
     */
    @javafx.fxml.FXML
    private AnchorPane carroid;
    /**
     * Vista de la compra.
     */
    @javafx.fxml.FXML
    private Pane compraid;

    /**
     * ChoiceBox de tarjetas de crédito.
     */
    @javafx.fxml.FXML
    private ChoiceBox tarjetauser;
    /**
     * Modelo de tarjetas de crédito.
     */
    public TarjetasModel tm = new TarjetasModel();
    /**
     * Botón de añadir tarjeta.
     */
    @javafx.fxml.FXML
    private Button addtarjetabuttonid;
    /**
     * Botón de cerrar la vista de compra.
     */
    @javafx.fxml.FXML
    private Button closebuttonid;
    /**
     * Botón de pagar.
     */
    @javafx.fxml.FXML
    private Button pagarbuttonid;

    /**
     * Indica si el panel de añadir tarjeta está activo.
     */
    private boolean paneaddactivo = false;
    /**
     * Controlador de la vista de login.
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
    int total = 0;
    @javafx.fxml.FXML
    private Label totalid;

    List<Productos>  listaall =new ArrayList<>();


    /**
     * Establece los datos del producto seleccionado.
     *
     * @param productos producto seleccionado
     */
    private void setProductoelegido (Productos productos){
        nombrepid.setText(productos.getNombre());
        preciopid.setText(productos.getPrecio() + "€");
        idpid.setText(String.valueOf(productos.getId()));

    }
    /**
     * Inicializa la vista del carrito de compras.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       mostrar();
    }
    /**
     * Muestra la lista de productos en el carrito.
     */
    public void mostrar(){
        total = 0;
        this.productoscarroid = mp.getIds();
        int column = 0;
        int row = 1;
        grid.getChildren().clear();
        listaall = productoscarroid;
        if (listaall.size() >0 ){
            setProductoelegido(listaall.get(0));
            miLista = new MiListaC() {
                @Override
                public void onClickLista(Productos productos) {
                    setProductoelegido(productos);
                }
            };
        }
        try {
            for (int i = 0; i < listaall.size(); i++) {
                total = (int) (total + listaall.get(i).getPrecio());
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("carroitems.fxml"));

                AnchorPane pane = fxmlLoader.load();


                CarroItemsController carroItemsController = fxmlLoader.getController();
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
            this.totalid.setText(total + "€");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Elimina un producto del carrito.
     *
     * @param actionEvent evento de eliminar producto
     */
    @javafx.fxml.FXML
    public void ondelButton(ActionEvent actionEvent) {
        Integer ide = Integer.valueOf(idpid.getText());
        boolean continua = false;
        for (int i = 0; i<= productoscarroid.size(); i++) {
                if (productoscarroid.get(i).getId() == ide) {
                    productoscarroid.remove(i);
                    i = 100000000;
                }
        }
        mostrar();
    }
    /**
     * Obtiene la lista final de productos en el carrito.
     *
     * @return lista de productos en el carrito
     */
    public static ArrayList<Productos> getfinalProductos(){
        return productoscarroid;
    }
    /**
     * Inicia la compra de productos.
     *
     * @param actionEvent evento de comprar productos
     */
    @javafx.fxml.FXML
    public void onComprarbutton(ActionEvent actionEvent) {
        String correouser = lg.getCorreom();
        int idu = um.getIdUser(correouser);
        ArrayList<Tarjetas> tarjetacompra = tm.getTarjetasUser(idu);
        ArrayList<String> listatarjetas = new ArrayList<String>();
        compraid.setVisible(true);
        for (Tarjetas t : tarjetacompra){
            listatarjetas.add(t.getNum_tarjeta());
        }
        tarjetauser.getItems().addAll(listatarjetas);
    }

    public CarroController() {
    }
    /**
     * Agrega una nueva tarjeta de crédito.
     *
     * @param actionEvent evento de agregar tarjeta
     */
    @javafx.fxml.FXML
    public void onAddtarjeta(ActionEvent actionEvent) {
        try {
            AnchorPane addtarjet = FXMLLoader.load(getClass().getResource("addtarjeta.fxml"));
            this.carroid.getChildren().setAll(addtarjet);
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * pone un boton que cierra.
     * @param actionEvent evento cerrar
     */
    @javafx.fxml.FXML
    public void onClosebutton(ActionEvent actionEvent) {
        compraid.setVisible(false);
    }
    /**
     * pone un boton que sirve para pagar
     * @param actionEvent evento para pagar
     */
    @javafx.fxml.FXML
    public void onPagarbuttonid(ActionEvent actionEvent){
        String tarjetaselected = null;
        for (Productos p : productoscarroid) {
            tarjetaselected = String.valueOf(tarjetauser.getValue());
            System.out.println("+" + tarjetaselected + "+");
            Tarjetas t = tm.getTarjetaByNum(tarjetaselected);
            String correouser = lg.getCorreom();
            System.out.println(correouser + " " + tarjetaselected);
            int idu = um.getIdUser(correouser);
            pem.anadirPedido(t.getId_tarjeta(), idu, p.getId());
        }
        if (tarjetaselected == null && tarjetaselected.equals("")) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Seleccione una tarjeta");
            a.setContentText("Seleccione una tarjeta y si no creala");
            a.showAndWait();
        }else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Productos comprados");
            a.setContentText("Productos comprados correctamente");
            a.showAndWait();
            listaall.clear();
            grid.getChildren().clear();
        }

    }
}