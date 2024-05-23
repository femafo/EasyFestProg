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

    private List<Customer>  listaprueba = new ArrayList<Customer>();

    private MiLista miLista;

    private  List<Customer> getprueba () {
        List<Customer>  listaprueba = new ArrayList<Customer>();
        Customer c;

        listaprueba.add(new Customer ("C001","Danapala","1981-2-6","No.20 Walana","Panadura"));
        listaprueba.add(new Customer ("C002","Gunapala","1982-8-12","No 200, Thalpitiya","Wadduwa"));
        listaprueba.add(new Customer ("C003","Amarapala","1988-1-2","No 100, Horawala","Matugama"));
        listaprueba.add(new Customer ("C004","Somapala","1952-1-2","No .10, Ginigama","Galle"));
        listaprueba.add(new Customer ("C005","Jinapala","1974-1-8","N0. 34 Ginthota","Aluthgama"));
        listaprueba.add(new Customer ("C006","Gnanawathee","1982-1-3","No56,230, Galle Road","Panadura"));
        listaprueba.add(new Customer ("C007","Amarawathee","1984-5-7","No34,Galle Road","Ambalangoda"));
        listaprueba.add(new Customer ("C008","Leelawathee","1950-4-8","No 12,Rathnapura Road","Madampe"));
        listaprueba.add(new Customer ("C009","Gunawathee","1972-3-9","No122,Anuradhapura Road","Kurunegala"));
        listaprueba.add( new Customer ("C010","Dayapala","1983-4-9","No. 234,Attidiya Road","Dehiwala"));
        listaprueba.add(new Customer ("C011","Sangapala","1990-5-9","No.43,St Peters Road","Negambo"));
        listaprueba.add(new Customer ("C012","Ariyawathee","1987-8-9","No. 123, Pamunuwa Road","Maharagama"));
        listaprueba.add(new Customer ("C013","Somawathee","1987-5-3","No. 345, Matugama Road","Kalutara"));
        return listaprueba;
    }

    private void setProductoelegido (Customer customer){
        nombrepid.setText(customer.getName());
        preciopid.setText(customer.getId() + "€");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int column = 0;
        int row = 1;
        listaprueba.addAll(getprueba());
        if (listaprueba.size() >0 ){
            setProductoelegido(listaprueba.get(0));
            miLista = new MiLista() {
                @Override
                public void onClickLista(Customer customer) {
                    setProductoelegido(customer);
                }
            };
        }
        try {
        for (int i = 0; i < listaprueba.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("items.fxml"));

                AnchorPane pane = fxmlLoader.load();


            ItemsController itemsController = fxmlLoader.getController();
            itemsController.setData(listaprueba.get(i), miLista);

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

    }
}
