package com.easyfest.easyfest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
/**
 * Controlador de la vista de items del carrito de compras.
 *
 * @author fermin
 */
public class CarroItemsController {
    /**
     * Vista de la imagen del producto.
     */
    @FXML
    private ImageView imgid;
    /**
     * Etiqueta que muestra el precio del producto.
     */
    @FXML
    private Label precioid;
    /**
     * Etiqueta que muestra el nombre del producto.
     */
    @FXML
    private Label nombreid;

    /**
     * Etiqueta que muestra la fecha de inicio del producto.
     */
    @FXML
    private Label fechainid;
    /**
     * Etiqueta que muestra la fecha de fin del producto.
     */
    @FXML
    private Label fechafinid;
    @FXML
    private void click (MouseEvent mouseEvent){
        miLista.onClickLista(c);
    }
    /**
     * Producto actual que se está mostrando.
     */
    private Productos c;
    /**
     * Referencia a la lista de productos.
     */
    private MiListaC miLista;
    /**
     * Establece los datos del producto y la lista de productos.
     *
     * @param productos producto a mostrar
     * @param miLista lista de productos
     */
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
