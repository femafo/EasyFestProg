package com.easyfest.easyfest;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class UsuariosModel extends DBUtil{

    public void anadirUsurios(String nombre, String apellidos, String dni, String correo, String contrasena, LocalDate fecha_nacimiento){
        try {

            PreparedStatement ps = this.getConexion().prepareStatement("INSERT INTO easyfest.usuario (fecha_nacimiento, nombre, apellidos, dni, correo, contrasenya) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setDate(1, Date.valueOf(fecha_nacimiento));
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setString(4, dni);
            ps.setString(5, correo);
            ps.setString(6, contrasena);

            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public UsuariosModel() {
    }
}
