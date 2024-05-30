package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
/**
 * Controlador para los elementos de la lista de productos.
 *
 * @author fermin
 */
public class ItemsController {
    /**
     * Imagen del producto.
     */
    @javafx.fxml.FXML
    private ImageView imgid;
    /**
     * Precio del producto.
     */
    @javafx.fxml.FXML
    private Label precioid;
    /**
     * Nombre del producto.
     */
    @javafx.fxml.FXML
    private Label nombreid;
    /**
     * Maneja el evento de clic en un elemento de la lista.
     *
     * @param mouseEvent evento de clic
     */
    @FXML
    private void click (MouseEvent mouseEvent){
        miLista.onClickLista(c);
    }
    /**
     * Producto seleccionado.
     */
    private Productos c;
    /**
     * Objeto que maneja la lista de productos.
     */
    private MiLista miLista;
    /**
     * Establece los datos del producto y el objeto que maneja la lista.
     *
     * @param productos producto a mostrar
     * @param miLista   objeto que maneja la lista
     */
    public void setData (Productos productos, MiLista miLista){
        this.c = productos;
        this.miLista = miLista;
        nombreid.setText(c.getNombre());
        precioid.setText(c.getPrecio() + "€");
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
