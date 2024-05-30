/**
 * Clase que gestiona los pedidos en la base de datos.
 */
package com.easyfest.easyfest;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PedidoModel extends DBUtil{

    /**
     * Añade un nuevo pedido a la base de datos.
     *
     * @param id_tarjeta ID de la tarjeta asociada al pedido
     * @param id_usuario ID del usuario que realiza el pedido
     * @param id_producto ID del producto solicitado
     */
    public void anadirPedido (int id_tarjeta, int id_usuario, int id_producto) {
        try {
            // Prepara la sentencia SQL
            PreparedStatement ps = this.getConexion().prepareStatement("INSERT INTO easyfest.pedidos (id_tarjeta, id_usuario, id_producto, fecha_compra) VALUES (?, ?, ?, NOW())");

            // Establece los parámetros
            ps.setInt(1, id_tarjeta);
            ps.setInt(2, id_usuario);
            ps.setInt(3, id_producto);

            // Ejecuta la consulta
            ps.execute();

        } catch (SQLException e) {
            // Maneja la excepción
            e.printStackTrace();
        }
    }

    /**
     * Obtiene los pedidos realizados por un usuario específico.
     *
     * @param id_usuario ID del usuario del cual se desean obtener los pedidos
     * @return ArrayList de Productos que contiene los pedidos realizados por el usuario
     */
    public ArrayList<Productos> getPedidosbyId (int id_usuario){
        ArrayList<Productos> listap = new ArrayList<>();
        try {
            // Prepara la consulta SQL
            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.pedidos pe INNER JOIN easyfest.producto p ON pe.id_producto = p.id_producto WHERE pe.id_usuario = ?");
            ps.setInt(1, id_usuario);

            // Ejecuta la consulta
            ResultSet rs = ps.executeQuery();

            // Recorre los resultados y los agrega a la lista
            while (rs.next()) {
                Productos p = new Productos (rs.getInt("id_producto"),rs.getString("nombre"),rs.getString("descripcion"),rs.getDouble("precio"), rs.getDate("fecha_inicio").toLocalDate(), rs.getDate("fecha_fin").toLocalDate(), rs.getString("imgpr"));
                listap.add(p);
            }
        } catch (SQLException e) {
            // Maneja la excepción
            e.printStackTrace();
        }
        return listap;
    }

    /**
     * Constructor de la clase PedidoModel.
     */
    public PedidoModel() {
    }
}
