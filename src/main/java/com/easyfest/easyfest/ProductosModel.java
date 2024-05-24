package com.easyfest.easyfest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductosModel extends DBUtil{

    public ArrayList<Productos> getProductos (){
        ArrayList<Productos> listap = new ArrayList<Productos>();

        try {

            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.producto");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Productos p = new Productos (rs.getInt("id_producto"),rs.getString("nombre"),rs.getString("descripcion"),rs.getDouble("precio"), rs.getDate("fecha_inicio").toLocalDate(), rs.getDate("fecha_fin").toLocalDate());
                listap.add(p);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listap;
    }
    public ArrayList<Productos> getProductosNombre (){
        ArrayList<Productos> listap = new ArrayList<Productos>();

        try {

            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.producto where nombre like \"Tomo%\"");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Productos p = new Productos (rs.getInt("id_producto"),rs.getString("nombre"),rs.getString("descripcion"),rs.getDouble("precio"), rs.getDate("fecha_inicio").toLocalDate(), rs.getDate("fecha_fin").toLocalDate());
                listap.add(p);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listap;
    }

    public ProductosModel() {
    }
}
