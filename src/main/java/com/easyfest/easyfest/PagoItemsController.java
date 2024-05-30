/**
 * Controlador para los elementos de pago de los productos en una lista.
 */
package com.easyfest.easyfest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PagoItemsController {
    @FXML
    private ImageView imgid; // ImageView para mostrar la imagen del producto
    @FXML
    private Label precioid; // Label para mostrar el precio del producto
    @FXML
    private Label nombreid; // Label para mostrar el nombre del producto

    /**
     * Método para manejar el clic en un elemento de la lista de productos.
     *
     * @param mouseEvent Evento del ratón
     */
    @FXML
    private void click (MouseEvent mouseEvent){
        miLista.onClickLista(c);
    }

    private Productos c; // Producto asociado al elemento de la lista
    private MiListaP miLista; // Controlador de la lista de productos

    /**
     * Establece los datos del producto y el controlador de la lista.
     *
     * @param productos Producto a mostrar
     * @param miLista Controlador de la lista de productos
     */
    public void setData (Productos productos, MiListaP miLista){
        this.c = productos;
        this.miLista = miLista;
        nombreid.setText(c.getNombre()); // Establece el nombre del producto
        precioid.setText(c.getPrecio() + "€"); // Establece el precio del producto
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
            imgid.setImage(image); // Establece la imagen del producto
        }
    }
}
