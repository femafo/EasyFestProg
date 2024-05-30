package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
/**
 * Controlador para la pantalla de menú de administrador.
 *
 * @author fermin
 */
public class AdminmenuController implements Initializable {
    /**
     * Pane para eliminar productos.
     */
    @javafx.fxml.FXML
    private Pane delpaneid;
    /**
     * Spinner para seleccionar el precio del producto.
     */
    @javafx.fxml.FXML
    private Spinner precioid;
    /**
     * Botón para agregar un producto.
     */
    @javafx.fxml.FXML
    private Button addbuttonid;
    /**
     * DatePicker para seleccionar la fecha de inicio del producto.
     */
    @javafx.fxml.FXML
    private DatePicker fechainid;

    /**
     * TextArea para describir el producto.
     */
    @javafx.fxml.FXML
    private TextArea descripcionid;
    /**
     * Botón para agregar un producto individual.
     */
    @javafx.fxml.FXML
    private Button addonebuttonid;
    /**
     * Botón para eliminar un producto individual.
     */
    @javafx.fxml.FXML
    private Button delonebuttonid;
    /**
     * TextField para ingresar el nombre del producto.
     */
    @javafx.fxml.FXML
    private TextField nombreid;
    /**
     * Botón para cerrar la pantalla de agregar producto.
     */
    @javafx.fxml.FXML
    private Button closebuttonid;
    /**
     * DatePicker para seleccionar la fecha de fin del producto.
     */
    @javafx.fxml.FXML
    private DatePicker fechafinid;
    /**
     * Pane para agregar productos.
     */
    @javafx.fxml.FXML
    private Pane addpaneid;
    /**
     * Modelo de productos.
     */
    ProductosModel pm = new ProductosModel();
    /**
     * Modelo de login.
     */
    Login lg = new Login();
    /**
     * Modelo de usuarios.
     */
    UsuariosModel um = new UsuariosModel();
    /**
     * Botón para eliminar un producto.
     */
    @javafx.fxml.FXML
    private Button delbuttonid;
    /**
     * ChoiceBox para seleccionar el producto a eliminar.
     */
    @javafx.fxml.FXML
    private ChoiceBox productoschiceid;
    /**
     * Botón para cerrar la pantalla de eliminar producto.
     */
    @javafx.fxml.FXML
    private Button closedelbuttonid;
    /**
     * Maneja el evento de clic en el botón de eliminar un producto individual.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void onDelonebuttonid(ActionEvent actionEvent) {
        delpaneid.setVisible(true);
        String correouser = lg.getCorreom();
        int idu = um.getIdUser(correouser);
        ArrayList <Productos> listap = pm.getProductosbyIda(idu);
        for (Productos p : listap){
            productoschiceid.getItems().add(p.getNombre());
        }
    }
    /**
     * Maneja el evento de clic en el botón de agregar un producto.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void onAddbutton(ActionEvent actionEvent) {
        String nombre = nombreid.getText();
        String descripcion = descripcionid.getText();
        int precio = (int) precioid.getValue();
        LocalDate fecha_ini = fechainid.getValue();
        LocalDate fecha_fin = fechafinid.getValue();
        String correouser = lg.getCorreom();
        int idu = um.getIdUser(correouser);
        pm.anadirProducto(nombre, descripcion, precio, fecha_ini, fecha_fin, idu);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Producto Agregado");
        a.setContentText("Producto agregado correctamente");
        a.showAndWait();
    }
    /**
     * Maneja el evento de clic en el botón de agregar un producto individual.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void onAddonebutton(ActionEvent actionEvent) {
        addpaneid.setVisible(true);
    }
    /**
     * Maneja el evento de clic en el botón de cerrar la pantalla de agregar producto.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void onClosebutton(ActionEvent actionEvent) {
        addpaneid.setVisible(false);
    }
    /**
     * Inicializa el controlador.
     *
     * @param url la URL del recurso
     * @param resourceBundle el bundle de recursos
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> precio =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, 0, 100);
        precioid.setValueFactory(precio);
        String correouser = lg.getCorreom();
    }
    /**
     * Maneja el evento de clic enel botón de eliminar un producto.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void onDelbutton(ActionEvent actionEvent) {
        String elproducto = (String) productoschiceid.getValue();
        int res = pm.eliminarProducto(elproducto);
        if (res >= 1){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Producto Eliminado");
            a.setContentText("El producto ha sido eliminado correctamente.");
            a.showAndWait();
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Producto No Eliminado");
            a.setContentText("Revise los datos del producto a eliminar.");
            a.showAndWait();
        }
    }
    /**
     * Maneja el evento de clic en el botón de cerrar la pantalla de eliminar producto.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void onClosedelbutton(ActionEvent actionEvent) {
        delpaneid.setVisible(false);
    }
}
