package com.easyfest.easyfest;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Modelo para la gestión de productos en la base de datos.
 *
 * Esta clase proporciona métodos para realizar operaciones relacionadas con los productos en la base de datos.
 */
public class ProductosModel extends DBUtil {

    /**
     * Obtiene todos los productos de la base de datos.
     *
     * @return Una lista de todos los productos en la base de datos.
     */
    public ArrayList<Productos> getProductos() {
        ArrayList<Productos> listap = new ArrayList<Productos>();

        try {
            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.producto");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Productos p = new Productos(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate(),
                        rs.getString("imgpr")
                );
                listap.add(p);
            }
        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
        }
        return listap;
    }

    /**
     * Obtiene una lista de productos filtrados según los criterios especificados.
     *
     * @param busqueda Término de búsqueda para filtrar por nombre.
     * @param min      Precio mínimo para filtrar.
     * @param max      Precio máximo para filtrar.
     * @param fecha    Booleano que indica si se desea ordenar por fecha de inicio ascendente.
     * @return Una lista de productos filtrada según los criterios especificados.
     */
    public ArrayList<Productos> getProductosFiltro(String busqueda, int min, int max, boolean fecha) {
        ArrayList<Productos> listap = new ArrayList<Productos>();
        String sql = "SELECT * FROM easyfest.producto WHERE 1=1";
        if (busqueda.length() > 0) {
            sql = sql + " AND nombre LIKE \"" + busqueda + "%\"";
        }
        if (min > 0 && max > 0) {
            sql = sql + " AND precio > " + min + " AND precio < " + max;
        }
        if (fecha == true) {
            sql = sql + " ORDER BY fecha_inicio ASC";
        } else {
            sql = sql + " ORDER BY fecha_inicio DESC";
        }
        try (Connection conn = this.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Productos p = new Productos(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate(),
                        rs.getString("imgpr")
                );
                listap.add(p);
            }
        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
        }
        return listap;
    }

    /**
     * Obtiene un producto según su ID.
     *
     * @param id El ID del producto.
     * @return El producto correspondiente al ID especificado, o null si no se encuentra.
     */
    public Productos getProductoscarro(int id) {
        Productos producto = null;

        try (PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.producto WHERE id_producto = ?")) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
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
            // Manejo de excepciones
            e.printStackTrace();
        }

        return producto;
    }

    /**
     * Añade un nuevo producto a la base de datos.
     *
     * @param nombre       El nombre del producto.
     * @param descripcion  La descripción del producto.
     * @param precio       El precio del producto.
     * @param fecha_inicio La fecha de inicio de disponibilidad del producto.
     * @param fecha_fin    La fecha de fin de disponibilidad del producto.
     * @param id_admin     El ID del administrador asociado al producto.
     */
    public void anadirProducto(String nombre, String descripcion, int precio, LocalDate fecha_inicio, LocalDate fecha_fin, int id_admin) {
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
            // Manejo de excepciones
            e.printStackTrace();
        }
    }

    /**
     * Obtiene una lista de productos asociados a un ID de administrador.
     *
     * @param id_admin El ID del administrador.
     * @return Una lista de productos asociados al ID del administrador especificado.
     */
    public ArrayList<Productos> getProductosbyIda(int id_admin) {
        Productos producto = null;
        ArrayList<Productos> listap = new ArrayList<Productos>();

        try (PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.producto WHERE id_admin = ?")) {
            ps.setInt(1, id_admin);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
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
            // Manejo de excepciones
            e.printStackTrace();
        }

        return listap;
    }

    /**
     * Elimina un producto de la base de datos según su nombre.
     *
     * @param nombre El nombre del producto a eliminar.
     * @return El número de filas afectadas por la eliminación.
     */
    public int eliminarProducto(String nombre) {
        int res = 0;
        try {
            PreparedStatement ps = this.getConexion().prepareStatement("DELETE FROM easyfest.producto WHERE nombre LIKE ?");
            ps.setString(1, nombre);

            res = ps.executeUpdate();
        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
        }
        return res;
    }
}