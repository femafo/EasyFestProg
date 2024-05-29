package com.easyfest.easyfest;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PedidoModel extends DBUtil{

    public void anadirPedido (int id_tarjeta, int id_usuario, int id_producto) {
        try {

            PreparedStatement ps = this.getConexion().prepareStatement("INSERT INTO easyfest.pedidos (id_tarjeta, id_usuario, id_producto, fecha_compra) VALUES (?, ?, ?, NOW())");

            ps.setInt(1, id_tarjeta);
            ps.setInt(2, id_usuario);
            ps.setInt(3, id_producto);

            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public ArrayList<Productos> getPedidosbyId (int id_usuario){
        ArrayList<Productos> listap = new ArrayList<>();
        try {
            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.pedidos pe inner join easyfest.producto p on pe.id_producto = p.id_producto WHERE pe.id_usuario = ?");
            ps.setInt(1, id_usuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Productos p = new Productos (rs.getInt("id_producto"),rs.getString("nombre"),rs.getString("descripcion"),rs.getDouble("precio"), rs.getDate("fecha_inicio").toLocalDate(), rs.getDate("fecha_fin").toLocalDate(), rs.getString("imgpr"));
                listap.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listap;
    }
    public PedidoModel() {
    }
}
