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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import org.controlsfx.control.RangeSlider;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class MenuproductosController implements Initializable {
    @javafx.fxml.FXML
    private Label nombrepid;
    @javafx.fxml.FXML
    private HBox productoelegidoid;
    @javafx.fxml.FXML
    private Label preciopid;
    @javafx.fxml.FXML
    private ImageView imgpid;
    @javafx.fxml.FXML
    private GridPane grid;
    @javafx.fxml.FXML
    private ScrollPane scroll;
    public ProductosModel pm = new ProductosModel();

    private List<Productos>  listaprueba = new ArrayList<Productos>();

    private MiLista miLista;
    public int opc;
    @javafx.fxml.FXML
    private TextField textsearchid;
    @javafx.fxml.FXML
    private RadioButton ascid;
    @javafx.fxml.FXML
    private Spinner preciomaxid;
    @javafx.fxml.FXML
    private RadioButton descid;
    @javafx.fxml.FXML
    private Spinner preciominid;
    @javafx.fxml.FXML
    private ToggleGroup fecha;
    @javafx.fxml.FXML
    private Button reinbuttonid;
    @javafx.fxml.FXML
    private Button aplbuttonid;


    private void setProductoelegido (Productos productos){
        nombrepid.setText(productos.getNombre());
        preciopid.setText(productos.getPrecio() + "€");

    }

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
    }

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
            case 1:
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

    @javafx.fxml.FXML
    public void onReiniciar(ActionEvent actionEvent) {
        opc = 0;
        mostrar(opc);
    }


    @javafx.fxml.FXML
    public void onApply(ActionEvent actionEvent) {
        opc = 1;
        mostrar(opc);
    }
}