package com.easyfest.easyfest;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La clase TarjetasModel proporciona métodos para interactuar con la tabla de tarjetas en la base de datos.
 */
public class TarjetasModel extends DBUtil {

    /**
     * Añade una nueva tarjeta a la base de datos.
     *
     * @param id_usuario      El ID del usuario asociado a la tarjeta.
     * @param fecha_caducidad La fecha de caducidad de la tarjeta.
     * @param cvv             El código CVV de la tarjeta.
     * @param num_tarjeta     El número de la tarjeta.
     * @param titular         El titular de la tarjeta.
     */
    public void anadirTarjeta(int id_usuario, LocalDate fecha_caducidad, int cvv, String num_tarjeta, String titular) {
        try {
            PreparedStatement ps = this.getConexion().prepareStatement("INSERT INTO easyfest.tarjetas (id_usuario, fecha_caducidad, cvv, num_tarjeta, titular) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, id_usuario);
            ps.setDate(2, Date.valueOf(fecha_caducidad));
            ps.setInt(3, cvv);
            ps.setString(4, num_tarjeta);
            ps.setString(5, titular);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene todas las tarjetas asociadas a un usuario.
     *
     * @param id_usuario El ID del usuario cuyas tarjetas se desean obtener.
     * @return Una lista de tarjetas asociadas al usuario.
     */
    public ArrayList<Tarjetas> getTarjetasUser(int id_usuario) {
        ArrayList<Tarjetas> listat = new ArrayList<>();
        try {
            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.tarjetas WHERE id_usuario = ? ORDER BY id_usuario");
            ps.setInt(1, id_usuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tarjetas t = new Tarjetas(rs.getInt("id_tarjeta"), rs.getDate("fecha_caducidad"), rs.getInt("cvv"), rs.getString("titular"), rs.getString("num_tarjeta"));
                listat.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listat;
    }

    /**
     * Obtiene una tarjeta basada en su número.
     *
     * @param num_tarjeta El número de tarjeta.
     * @return La tarjeta correspondiente al número especificado, o null si no se encuentra ninguna tarjeta.
     */
    public Tarjetas getTarjetaByNum(String num_tarjeta) {
        Tarjetas t = null; // Inicializamos a null para manejar el caso en el que no se encuentre ninguna tarjeta.
        String query = "SELECT * FROM easyfest.tarjetas WHERE num_tarjeta = ?";

        try (PreparedStatement ps = this.getConexion().prepareStatement(query)) {
            ps.setString(1, num_tarjeta);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    t = new Tarjetas(
                            rs.getInt("id_tarjeta"),
                            rs.getDate("fecha_caducidad"),
                            rs.getInt("cvv"),
                            rs.getString("titular"),
                            rs.getString("num_tarjeta")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }

    /**
     * Constructor por defecto de la clase TarjetasModel.
     */
    public TarjetasModel() {
    }
}
