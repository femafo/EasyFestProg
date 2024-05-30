package com.easyfest.easyfest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import org.controlsfx.control.RangeSlider;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
/**
 * Controlador de la pantalla de menú de productos.
 *
 * @author fermin
 */
public class MenuproductosController implements Initializable {
    /**
     * HBox que contiene la información del producto elegido.
     */
    @javafx.fxml.FXML
    private HBox productoelegidoid;
    /**
     * Etiqueta que muestra el precio del producto elegido.
     */
    @javafx.fxml.FXML
    private Label preciopid;

    /**
     * Imagen del producto elegido.
     */
    @javafx.fxml.FXML
    private ImageView imgpid;
    /**
     * GridPane que contiene los productos.
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
     * Lista de productos de prueba.
     */
    private List<Productos>  listaprueba = new ArrayList<Productos>();
    /**
     * Interfaz para manejar el clic en un producto.
     */
    private MiLista miLista;
    /**
     * Opción actual (0: mostrar todos los productos, 5: mostrar productos filtrados).
     */
    public int opc;
    /**
     * Campo de texto para buscar productos.
     */
    @javafx.fxml.FXML
    private TextField textsearchid;
    /**
     * RadioButton para ordenar por precio ascendente.
     */
    @javafx.fxml.FXML
    private RadioButton ascid;
    /**
     * Spinner para seleccionar el precio máximo.
     */
    @javafx.fxml.FXML
    private Spinner preciomaxid;
    /**
     * RadioButton para ordenar por precio descendente.
     */
    @javafx.fxml.FXML
    private RadioButton descid;
    /**
     * Spinner para seleccionar el precio mínimo.
     */
    @javafx.fxml.FXML
    private Spinner preciominid;
    /**
     * Grupo de botones para seleccionar la ordenación por fecha.
     */
    @javafx.fxml.FXML
    private ToggleGroup fecha;
    /**
     * Botón para reiniciar la búsqueda.
     */
    @javafx.fxml.FXML
    private Button reinbuttonid;
    /**
     * Botón para aplicar los filtros.
     */
    @javafx.fxml.FXML
    private Button aplbuttonid;

    /**
     * Pane que contiene los elementos de la pantalla.
     */
    @javafx.fxml.FXML
    private Pane paneid;
    /**
     * Etiqueta que muestra el ID del producto elegido.
     */
    @javafx.fxml.FXML
    private Label idpid;
    /**
     * Lista de productos agregados al carrito.
     */

    public static ArrayList<Productos> productoscarroid = new ArrayList<Productos>();
    /**
     * VBox que contiene los elementos de la pantalla.
     */
    @javafx.fxml.FXML
    private VBox vboxid;
    /**
     * Spinner para seleccionar la cantidad de productos.
     */
    @javafx.fxml.FXML
    private Spinner cantidadid;

    /**
     * Texto que muestra la descripción del producto elegido.
     */
    @javafx.fxml.FXML
    private Text descripid;
    /**
     * Texto que muestra el nombre del producto elegido.
     */
    @javafx.fxml.FXML
    private Text nombrepid;
    /**
     * Establece el producto elegido.
     *
     * @param productos producto elegido
     */

    private void setProductoelegido (Productos productos){
        nombrepid.setText(productos.getNombre());
        preciopid.setText(productos.getPrecio() + "€");
        idpid.setText(String.valueOf(productos.getId()));
        descripid.setText(productos.getDescripcion());
        String imguser = productos.getImg();

        String imgPath = "/img/" + imguser;

        javafx.scene.image.Image image = null;
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
            imgpid.setImage(image);
        }

    }
    /**
     * Inicializa la pantalla.
     *
     * @param url        URL de la pantalla
     * @param resourceBundle recursos de la pantalla
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        opc = 0;
        mostrar(opc);
        SpinnerValueFactory<Integer> minimo =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, 0, 100);
        preciominid.setValueFactory(minimo);
        SpinnerValueFactory<Integer> maximo =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, 0, 100);
        preciomaxid.setValueFactory(maximo);
        SpinnerValueFactory<Integer> cantidad =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50, 1, 1);
        cantidadid.setValueFactory(cantidad);


    }
    /**
     * Muestra los productos según la opción seleccionada.
     *
     * @param opc opción actual (0: mostrar todos los productos, 5: mostrar productos filtrados)
     */
    public void mostrar (int opc){
        int column = 0;
        int row = 1;
        switch (opc){
            case 0:
                grid.getChildren().clear();
                List<Productos>  listaall = new ArrayList<Productos>();
                listaall.addAll(pm.getProductos());
                if (listaall.size() >0 ){
                    setProductoelegido(listaall.get(0));
                    miLista = new MiLista() {

                        @Override
                        public void onClickLista(Productos productos) {
                            setProductoelegido(productos);
                        }
                    };
                }
                try {
                    for (int i = 0; i < listaall.size(); i++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("items.fxml"));

                        AnchorPane pane = fxmlLoader.load();


                        ItemsController itemsController = fxmlLoader.getController();
                        itemsController.setData(listaall.get(i), miLista);

                        if (column == 4){
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
                break;
            case 5:
                grid.getChildren().clear();
                String busqueda1 = textsearchid.getText();
                int minimo1 = (int) preciominid.getValue();
                int maximo1 = (int) preciomaxid.getValue();
                boolean fecha = Boolean.parseBoolean(null);
                if (ascid.isSelected()){
                    fecha = true;
                }
                if (descid.isSelected()){
                    fecha = false;
                }
                List<Productos>  listaf = new ArrayList<Productos>();
                listaf.addAll(pm.getProductosFiltro(busqueda1, minimo1, maximo1, fecha));
                if (listaf.size() >0 ){
                    setProductoelegido(listaf.get(0));
                    miLista = new MiLista() {
                        @Override
                        public void onClickLista(Productos productos) {
                            setProductoelegido(productos);
                        }
                    };
                }
                try {
                    for (int i = 0; i < listaf.size(); i++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("items.fxml"));

                        AnchorPane pane = fxmlLoader.load();


                        ItemsController itemsController = fxmlLoader.getController();
                        itemsController.setData(listaf.get(i), miLista);

                        if (column == 4){
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
                break;
        }


    }
    /**
     * Maneja el evento de clic en el botón de reiniciar.
     *
     * @param actionEvent evento de clic
     */
    @javafx.fxml.FXML
    public void onReiniciar(ActionEvent actionEvent) {
        opc = 0;
        mostrar(opc);
    }

    /**
     * Maneja el evento de clic en el botón de aplicar.
     *
     * @param actionEvent evento de clic
     */
    @javafx.fxml.FXML
    public void onApply(ActionEvent actionEvent) {
        opc = 5;
        mostrar(opc);
    }
    /**
     * Maneja el evento de clic en el botón de agregar al carrito.
     *
     * @param actionEvent evento de clic
     */
    @javafx.fxml.FXML
    public void onaddButton(ActionEvent actionEvent) {
        for (int i = 1; i <= (int) cantidadid.getValue(); i++){
            Integer id = Integer.valueOf(idpid.getText());
            System.out.println(idpid.getText() + " " + nombrepid.getText());
            Productos p = pm.getProductoscarro(id);
            this.productoscarroid.add(p);
            System.out.println(p.getNombre());
        }
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Productos agregados al carrito");
        a.setContentText("Productos agregados al carrito correctamente");
        a.showAndWait();
    }
    /**
     * Devuelve la lista de productos agregados al carrito.
     *
     */
    public static ArrayList<Productos> getIds(){
        return productoscarroid;
    }

    public MenuproductosController() {
    }
}