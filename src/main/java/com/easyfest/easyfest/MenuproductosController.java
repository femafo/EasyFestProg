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
    private Button buttontextid;
    @javafx.fxml.FXML
    private RadioButton ascid;
    @javafx.fxml.FXML
    private Spinner preciomaxid;
    @javafx.fxml.FXML
    private RadioButton descid;
    @javafx.fxml.FXML
    private Spinner preciominid;
    @javafx.fxml.FXML
    private Button buttondateid;
    @javafx.fxml.FXML
    private ToggleGroup fecha;
    @javafx.fxml.FXML
    private Button buttonpriceid;
    @javafx.fxml.FXML
    private Button reinbuttonid;


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
                String busqueda = textsearchid.getText();
                List<Productos>  listan = new ArrayList<Productos>();
                listan.addAll(pm.getProductosNombre(busqueda));
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
            case 2:
                grid.getChildren().clear();
                int minimo = (int) preciominid.getValue();
                int maximo = (int) preciomaxid.getValue();
                List<Productos>  listapr = new ArrayList<Productos>();
                listapr.addAll(pm.getProductosPrecio(minimo, maximo));
                if (listapr.size() >0 ){
                    setProductoelegido(listapr.get(0));
                    miLista = new MiLista() {
                        @Override
                        public void onClickLista(Productos productos) {
                            setProductoelegido(productos);
                        }
                    };
                }
                try {
                    for (int i = 0; i < listapr.size(); i++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("items.fxml"));

                        AnchorPane pane = fxmlLoader.load();


                        ItemsController itemsController = fxmlLoader.getController();
                        itemsController.setData(listapr.get(i), miLista);

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
            case 3:
                grid.getChildren().clear();
                List<Productos>  listaa = new ArrayList<Productos>();
                listaa.addAll(pm.getProductosDateAsc());
                if (listaa.size() >0 ){
                    setProductoelegido(listaa.get(0));
                    miLista = new MiLista() {
                        @Override
                        public void onClickLista(Productos productos) {
                            setProductoelegido(productos);
                        }
                    };
                }
                try {
                    for (int i = 0; i < listaa.size(); i++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("items.fxml"));

                        AnchorPane pane = fxmlLoader.load();


                        ItemsController itemsController = fxmlLoader.getController();
                        itemsController.setData(listaa.get(i), miLista);

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
            case 4:
                grid.getChildren().clear();
                List<Productos>  listad = new ArrayList<Productos>();
                listad.addAll(pm.getProductosDateDesc());
                if (listad.size() >0 ){
                    setProductoelegido(listad.get(0));
                    miLista = new MiLista() {
                        @Override
                        public void onClickLista(Productos productos) {
                            setProductoelegido(productos);
                        }
                    };
                }
                try {
                    for (int i = 0; i < listad.size(); i++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("items.fxml"));

                        AnchorPane pane = fxmlLoader.load();


                        ItemsController itemsController = fxmlLoader.getController();
                        itemsController.setData(listad.get(i), miLista);

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
    public void ontext(ActionEvent actionEvent) {
        String busqueda = textsearchid.getText();
        if (textsearchid.getText().length() <  1) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Vuelva a intentarlo");
            a.setContentText("Introduzca texto para poder buscar el producto.");
            a.showAndWait();
        } else{
            int opc = 1;
            mostrar(opc);
        }
    }

    @javafx.fxml.FXML
    public void onDate(ActionEvent actionEvent) {
        if (ascid.isSelected()){
            int opc = 3;
            mostrar(opc);
        }
        if (descid.isSelected()){
            int opc = 4;
            mostrar(opc);
        }
        if (fecha.getSelectedToggle() == null){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Vuelva a intentarlo");
            a.setContentText("Seleccione el sentido de la fecha.");
            a.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void onPrice(ActionEvent actionEvent) {
        int opc = 2;
        mostrar(opc);
    }

    @javafx.fxml.FXML
    public void onReiniciar(ActionEvent actionEvent) {
        opc = 0;
        mostrar(opc);
    }
}