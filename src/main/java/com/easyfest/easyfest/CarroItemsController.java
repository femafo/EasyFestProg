package com.easyfest.easyfest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CarroItemsController {
    @FXML
    private ImageView imgid;
    @FXML
    private Label precioid;
    @FXML
    private Label nombreid;
    @FXML
    private Label fechainid;
    @FXML
    private Label fechafinid;

    @FXML
    private void click (MouseEvent mouseEvent){
        miLista.onClickLista(c);
    }

    private Productos c;
    private MiListaC miLista;

    public void setData (Productos productos, MiListaC miLista){
        this.c = productos;
        this.miLista = miLista;
        nombreid.setText(c.getNombre());
        precioid.setText(c.getPrecio() + "€");
        fechainid.setText(String.valueOf(c.getFecha_inicio()));
        fechafinid.setText(String.valueOf(c.getFecha_fin()));
        String imguser = c.getImg();

        String imgPath = "/img/" + imguser;

        Image image = null;
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
            imgid.setImage(image);
        }
    }
}
