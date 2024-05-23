package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ItemsController {
    @javafx.fxml.FXML
    private ImageView imgid;
    @javafx.fxml.FXML
    private Label precioid;
    @javafx.fxml.FXML
    private Label nombreid;

    @FXML
    private void click (MouseEvent mouseEvent){
        miLista.onClickLista(c);
    }

    private Customer c;
    private MiLista miLista;

    public void setData (Customer customer, MiLista miLista){
        this.c = customer;
        this.miLista = miLista;
        nombreid.setText(c.getName());
        precioid.setText(c.getId() + "€");
    }
}
