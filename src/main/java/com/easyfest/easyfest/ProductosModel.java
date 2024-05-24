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
    public ArrayList<Productos> getProductosNombre (String busqueda){
        ArrayList<Productos> listap = new ArrayList<Productos>();
        String sql = "SELECT * FROM easyfest.producto WHERE nombre LIKE ?";
        try (Connection conn = this.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1,  busqueda + "%");
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

    public ArrayList<Productos> getProductosPrecio (int minimo, int maximo){
        ArrayList<Productos> listap = new ArrayList<Productos>();
        String sql = "SELECT * FROM easyfest.producto WHERE precio > ? AND precio < ?";
        try (Connection conn = this.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1,  minimo);
            ps.setInt(2,  maximo);
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
    public ArrayList<Productos> getProductosDateAsc (){
        ArrayList<Productos> listap = new ArrayList<Productos>();
        String sql = "SELECT * FROM easyfest.producto ORDER BY fecha_inicio ASC";
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

    public ArrayList<Productos> getProductosDateDesc (){
        ArrayList<Productos> listap = new ArrayList<Productos>();
        String sql = "SELECT * FROM easyfest.producto ORDER BY fecha_inicio DESC";
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

    public ProductosModel() {
    }
}
