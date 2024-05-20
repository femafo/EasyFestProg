package com.easyfest.easyfest;

import javafx.scene.control.Alert;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public boolean loginusuario(String correo, String contrasena){
        ArrayList<String> login = new ArrayList<String>();
        try {
            PreparedStatement ps = this.getConexion().prepareStatement("SELECT correo, contrasenya FROM easyfest.usuarios WHERE correo = ? AND contrasenya = ?");
            ps.setString(1, correo);
            ps.setString(2, contrasena);

            ResultSet rs = ps.executeQuery();
            String correo2 = rs.getString("correo");
            if (correo.equals(correo2)){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Vuelva a intentarlo");
                a.setContentText("El usuario o la contraseña pueden ser incorrectos.");
                a.showAndWait();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public UsuariosModel() {
    }
}
