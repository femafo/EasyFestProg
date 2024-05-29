package com.easyfest.easyfest;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductosModel extends DBUtil{

    public ArrayList<Productos> getProductos (){
        ArrayList<Productos> listap = new ArrayList<Productos>();

        try {

            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.producto");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Productos p = new Productos (rs.getInt("id_producto"),rs.getString("nombre"),rs.getString("descripcion"),rs.getDouble("precio"), rs.getDate("fecha_inicio").toLocalDate(), rs.getDate("fecha_fin").toLocalDate(), rs.getString("imgpr"));
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
                Productos p = new Productos (rs.getInt("id_producto"),rs.getString("nombre"),rs.getString("descripcion"),rs.getDouble("precio"), rs.getDate("fecha_inicio").toLocalDate(), rs.getDate("fecha_fin").toLocalDate(), rs.getString("imgpr"));
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
                            rs.getDate("fecha_fin").toLocalDate(),
                            rs.getString("imgpr")
                    );
                }
            }
        } catch (SQLException e) {
            // Log the exception (using a logging framework is recommended).
            e.printStackTrace();
        }

        return producto; // Return the found product or null if not found.
    }

    public void anadirProducto (String nombre, String descripcion, int precio, LocalDate fecha_inicio, LocalDate fecha_fin, int id_admin){
        try {

            PreparedStatement ps = this.getConexion().prepareStatement("INSERT INTO easyfest.producto (nombre, descripcion, precio, fecha_inicio, fecha_fin, id_admin) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setInt(3, precio);
            ps.setDate(4, Date.valueOf(fecha_inicio));
            ps.setDate(5, Date.valueOf(fecha_fin));
            ps.setInt(6, id_admin);

            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<Productos> getProductosbyIda(int id_admin) {
        Productos producto = null; // Initialize producto as null to handle cases where no product is found.
        ArrayList<Productos> listap= new ArrayList<Productos>();
        // Using try-with-resources to ensure the PreparedStatement and ResultSet are closed automatically.
        try (PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.producto WHERE id_admin = ?")) {
            ps.setInt(1, id_admin);

            // Execute the query and process the result set.
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) { // Check if a result is returned.
                    producto = new Productos(
                            rs.getInt("id_producto"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getDouble("precio"),
                            rs.getDate("fecha_inicio").toLocalDate(),
                            rs.getDate("fecha_fin").toLocalDate(),
                            rs.getString("imgpr")
                    );
                    listap.add(producto);
                }
            }
        } catch (SQLException e) {
            // Log the exception (using a logging framework is recommended).
            e.printStackTrace();
        }

        return listap; // Return the found product or null if not found.
    }

    public int eliminarProducto (String nombre){
        int res = 0;
        try {

            PreparedStatement ps = this.getConexion().prepareStatement("DELETE FROM easyfest.producto WHERE nombre LIKE ?");
            ps.setString(1, nombre);

            res = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }



    public ProductosModel() {
    }
}
