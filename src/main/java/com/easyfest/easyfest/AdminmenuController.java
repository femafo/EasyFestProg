package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminmenuController implements Initializable {
    @javafx.fxml.FXML
    private Pane delpaneid;
    @javafx.fxml.FXML
    private Spinner precioid;
    @javafx.fxml.FXML
    private Button addbuttonid;
    @javafx.fxml.FXML
    private DatePicker fechainid;
    @javafx.fxml.FXML
    private TextArea descripcionid;
    @javafx.fxml.FXML
    private Button addonebuttonid;
    @javafx.fxml.FXML
    private Button delonebuttonid;
    @javafx.fxml.FXML
    private TextField nombreid;
    @javafx.fxml.FXML
    private Button closebuttonid;
    @javafx.fxml.FXML
    private DatePicker fechafinid;
    @javafx.fxml.FXML
    private Pane addpaneid;
    ProductosModel pm = new ProductosModel();
    Login lg = new Login();
    UsuariosModel um = new UsuariosModel();
    @javafx.fxml.FXML
    private Button delbuttonid;
    @javafx.fxml.FXML
    private ChoiceBox productoschiceid;
    @javafx.fxml.FXML
    private Button closedelbuttonid;

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

    @javafx.fxml.FXML
    public void onAddonebutton(ActionEvent actionEvent) {
        addpaneid.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onClosebutton(ActionEvent actionEvent) {
        addpaneid.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> precio =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, 0, 100);
        precioid.setValueFactory(precio);
        String correouser = lg.getCorreom();
    }

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

    @javafx.fxml.FXML
    public void onClosedelbutton(ActionEvent actionEvent) {
        delpaneid.setVisible(false);
    }
}
