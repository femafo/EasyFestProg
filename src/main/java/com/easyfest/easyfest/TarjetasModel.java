package com.easyfest.easyfest;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TarjetasModel extends DBUtil{

    public void anadirTarjeta(int id_usuario, LocalDate fecha_caducidad, int cvv, String num_tarjeta, String titular){
        try {

            PreparedStatement ps = this.getConexion().prepareStatement("INSERT INTO easyfest.tarjetas (id_usuario, fecha_caducidad, cvv, num_tarjeta, titular) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, id_usuario);
            ps.setDate(2, Date.valueOf(fecha_caducidad));
            ps.setInt(3, cvv);
            ps.setString(4, num_tarjeta);
            ps.setString(5, titular);

            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

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

    public Tarjetas getTarjetaByNum(String num_tarjeta) {
        Tarjetas t = null; // Initialize to null to handle the case where no tarjeta is found.
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





    public TarjetasModel() {
    }
}
