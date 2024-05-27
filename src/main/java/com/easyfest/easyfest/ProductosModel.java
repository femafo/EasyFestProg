package com.easyfest.easyfest;

import java.sql.Connection;
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
    public ArrayList<Productos> getProductosFiltro (String busqueda, int min, int max, boolean fecha){
        ArrayList<Productos> listap = new ArrayList<Productos>();
        String sql = "SELECT * FROM easyfest.producto WHERE 1=1";
        if (busqueda.length() > 0){
            sql = sql + " AND nombre LIKE \"" + busqueda + "%\"";
        }
        if (min > 0 && max > 0){
            sql = sql + " AND precio > " + min + " AND precio < " + max;
        }
        if (fecha == true){
            sql = sql + " ORDER BY fecha_inicio ASC";
        }else{
            sql = sql + " ORDER BY fecha_inicio DESC";
        }
        try (Connection conn = this.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

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
    public Productos getProductoscarro(int id) {
        Productos producto = null; // Initialize producto as null to handle cases where no product is found.

        // Using try-with-resources to ensure the PreparedStatement and ResultSet are closed automatically.
        try (PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.producto WHERE id_producto = ?")) {
            ps.setInt(1, id);

            // Execute the query and process the result set.
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) { // Check if a result is returned.
                    producto = new Productos(
                            rs.getInt("id_producto"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getDouble("precio"),
                            rs.getDate("fecha_inicio").toLocalDate(),
                            rs.getDate("fecha_fin").toLocalDate()
                    );
                }
            }
        } catch (SQLException e) {
            // Log the exception (using a logging framework is recommended).
            e.printStackTrace();
        }

        return producto; // Return the found product or null if not found.
    }


    public ProductosModel() {
    }
}
