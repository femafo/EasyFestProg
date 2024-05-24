package com.easyfest.easyfest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

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
    @javafx.fxml.FXML
    private Button buttonid;
    public int opc;


    private void setProductoelegido (Productos productos){
        nombrepid.setText(productos.getNombre());
        preciopid.setText(productos.getPrecio() + "€");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        opc = 0;
        mostrar(opc);
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
                List<Productos>  listan = new ArrayList<Productos>();
                listan.addAll(pm.getProductosNombre());
                if (listan.size() >0 ){
                    setProductoelegido(listan.get(0));
                    miLista = new MiLista() {
                        @Override
                        public void onClickLista(Productos productos) {
                            setProductoelegido(productos);
                        }
                    };
                }
                try {
                    for (int i = 0; i < listan.size(); i++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("items.fxml"));

                        AnchorPane pane = fxmlLoader.load();


                        ItemsController itemsController = fxmlLoader.getController();
                        itemsController.setData(listan.get(i), miLista);

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
    public void onButton(ActionEvent actionEvent) {
        int opc = 1;
        mostrar(opc);
    }
}
