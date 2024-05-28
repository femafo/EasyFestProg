package com.easyfest.easyfest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PagoItemsController {
    @FXML
    private ImageView imgid;
    @FXML
    private Label precioid;
    @FXML
    private Label nombreid;

    @FXML
    private void click (MouseEvent mouseEvent){
        miLista.onClickLista(c);
    }

    private Productos c;
    private MiListaP miLista;

    public void setData (Productos productos, MiListaP miLista){
        this.c = productos;
        this.miLista = miLista;
        nombreid.setText(c.getNombre());
        precioid.setText(c.getPrecio() + "€");
    }
}
