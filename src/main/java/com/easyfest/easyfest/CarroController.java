package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarroController implements Initializable {
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

    private MiListaC miLista;
    public int opc;
    @javafx.fxml.FXML
    private Label idpid;

    public static ArrayList<Productos> productoscarroid = new ArrayList<Productos>();
    MenuproductosController mp = new MenuproductosController();
    @javafx.fxml.FXML
    private Button delbuttonid;
    @javafx.fxml.FXML
    private Button comprarbuttonid;
    @javafx.fxml.FXML
    private AnchorPane carroid;
    @javafx.fxml.FXML
    private Pane compraid;
    @javafx.fxml.FXML
    private ChoiceBox tarjetauser;
    public TarjetasModel tm = new TarjetasModel();
    @javafx.fxml.FXML
    private Button addtarjetabuttonid;
    @javafx.fxml.FXML
    private Button closebuttonid;
    @javafx.fxml.FXML
    private Button pagarbuttonid;
    private boolean paneaddactivo = false;
    public Login lg = new Login();
    private UsuariosModel um = new UsuariosModel();
    private PedidoModel pem = new PedidoModel();


    private void setProductoelegido (Productos productos){
        nombrepid.setText(productos.getNombre());
        preciopid.setText(productos.getPrecio() + "€");
        idpid.setText(String.valueOf(productos.getId()));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       mostrar();
    }

    public void mostrar(){
        this.productoscarroid = mp.getIds();
        int column = 0;
        int row = 1;
        grid.getChildren().clear();
        List<Productos>  listaall = productoscarroid;
        if (listaall.size() >0 ){
            setProductoelegido(listaall.get(0));
            miLista = new MiListaC() {
                @Override
                public void onClickLista(Productos productos) {
                    setProductoelegido(productos);
                }
            };
        }
        try {
            for (int i = 0; i < listaall.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("carroitems.fxml"));

                AnchorPane pane = fxmlLoader.load();


                CarroItemsController carroItemsController = fxmlLoader.getController();
                carroItemsController.setData(listaall.get(i), miLista);

                if (column == 1){
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
        /*
        RangeSlider slider = new RangeSlider(0, 100, 10, 90);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(25);
        slider.setBlockIncrement(10);
        vboxid.setPadding(new Insets(75));
        vboxid.setSpacing(150);
        vboxid.getChildren().addAll(slider);

         */
    }

    @javafx.fxml.FXML
    public void ondelButton(ActionEvent actionEvent) {
        Integer id = Integer.valueOf(idpid.getText());
        boolean continua = false;
        int i = 0;
        do {
            if (productoscarroid.get(i).getId() == id){
                productoscarroid.remove(i);
                continua = true;
            }
            i++;
        }while (i < productoscarroid.size() && continua == false);
        mostrar();
    }
    public static ArrayList<Productos> getfinalProductos(){
        return productoscarroid;
    }

    @javafx.fxml.FXML
    public void onComprarbutton(ActionEvent actionEvent) {
        String correouser = lg.getCorreom();
        int idu = um.getIdUser(correouser);
        ArrayList<Tarjetas> tarjetacompra = tm.getTarjetasUser(idu);
        ArrayList<String> listatarjetas = new ArrayList<String>();
        compraid.setVisible(true);
        for (Tarjetas t : tarjetacompra){
            listatarjetas.add(t.getNum_tarjeta());
        }
        tarjetauser.getItems().addAll(listatarjetas);
    }

    public CarroController() {
    }

    @javafx.fxml.FXML
    public void onAddtarjeta(ActionEvent actionEvent) {
        try {
            AnchorPane addtarjeta = FXMLLoader.load(getClass().getResource("addtarjeta.fxml"));
            this.carroid.getChildren().setAll(addtarjeta);
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }

    @javafx.fxml.FXML
    public void onClosebutton(ActionEvent actionEvent) {
        compraid.setVisible(false);
    }

    @javafx.fxml.FXML
    public void onPagarbuttonid(ActionEvent actionEvent) {
        for (Productos p : productoscarroid) {
            String tarjetaselected = String.valueOf(tarjetauser.getValue());
            Tarjetas t = tm.getTarjetaByNum(tarjetaselected);
            String correouser = lg.getCorreom();
            System.out.println(correouser + " " + tarjetaselected);
            int idu = um.getIdUser(correouser);
            pem.anadirPedido(t.getId_tarjeta(), idu, p.getId());

        }
    }
}