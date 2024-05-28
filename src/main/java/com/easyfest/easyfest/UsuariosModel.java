package com.easyfest.easyfest;

import javafx.scene.control.Alert;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import  javafx.scene.image.Image;

public class UsuariosModel extends DBUtil {

    public void anadirUsurios(String nombre, String apellidos, String dni, String correo, String contrasena, LocalDate fecha_nacimiento) {
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

    public boolean loginusuario(String correo, String contrasena) {
        try (PreparedStatement ps = this.getConexion().prepareStatement(
                "SELECT correo, contrasenya FROM easyfest.usuario WHERE correo = ? AND contrasenya = ?")) {

            ps.setString(1, correo);
            ps.setString(2, contrasena);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public UsuariosModel() {
    }

    //funcion buscar usuario el cual se llama en el log in para que se guarde un usuario (correo tiene que ser PKey)
    public Usuario buscarUsuario(String correo) {
        Usuario u = null;
        try {
            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.usuario WHERE correo LIKE ?");
            ps.setString(1, correo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String dni = rs.getString("dni");
                String correoUsuario = rs.getString("correo");
                String contrasenya = rs.getString("contrasenya");
                boolean esAdmin = rs.getBoolean("esAdmin");

                // Verificar si la columna Blob no está vacía
                Image img = null;
                Blob blob = rs.getBlob("imagen");
                if (blob != null) {
                    try (InputStream is = blob.getBinaryStream()) {
                        img = new Image(is);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                u = new Usuario(idUsuario, fechaNacimiento, nombre, apellidos, dni, correoUsuario, contrasenya, esAdmin, img);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public Usuario buscarUsuariolog(String correo) {
        Usuario u = null;
        try {
            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.usuario WHERE correo LIKE ?");
            ps.setString(1, correo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String dni = rs.getString("dni");
                String correoUsuario = rs.getString("correo");
                String contrasenya = rs.getString("contrasenya");
                boolean esAdmin = rs.getBoolean("esAdmin");

                u = new Usuario(idUsuario, fechaNacimiento, nombre, apellidos, dni, correoUsuario, contrasenya, esAdmin);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public void anyadirImagen(String correo, File imagen) {

        String sql = "UPDATE usuario SET imagen = ? WHERE correo = ?";

        try (PreparedStatement ps = this.getConexion().prepareStatement(sql);
             FileInputStream fis = new FileInputStream(imagen)) {

            // Establecer el archivo de imagen en el campo BLOB
            ps.setBinaryStream(1, fis, (int) imagen.length());

            // Establecer el correo
            ps.setString(2, correo);

            // Ejecutar la actualización
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("La imagen ha sido actualizada correctamente para el usuario con correo: " + correo);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();

        }
    }

    public Integer getIdUser(String correo) {
        Integer id = null;
        String query = "SELECT id_usuario FROM easyfest.usuario WHERE correo = ?";

        try (PreparedStatement ps = this.getConexion().prepareStatement(query)) {
            ps.setString(1, correo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id_usuario");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

}



