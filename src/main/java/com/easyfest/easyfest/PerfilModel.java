package com.easyfest.easyfest;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class PerfilModel extends DBUtil{

    public PerfilModel(){}

    //funcion para actualizar los datos al darle al boton de actualizar en perfil
    public void actualizarDatos(String nombre, String apellidos, String correo, LocalDate nacimiento, String imgURL, int id) {
        String sql = "UPDATE usuario SET nombre = ?, apellidos = ?, correo = ?, fecha_nacimiento = ?, imagen = ? WHERE id_usuario = ?";

        try (PreparedStatement ps = this.getConexion().prepareStatement(sql)) {
            // Convertir nacimiento de LocalDate a Date
            Date nacimientoDate = Date.valueOf(nacimiento);

            // Convertir imgURL en un File
            File image = new File(imgURL);

            try (FileInputStream fis = new FileInputStream(image)) {
                // Establecer los parámetros del PreparedStatement
                ps.setString(1, nombre);
                ps.setString(2, apellidos);
                ps.setString(3, correo);
                ps.setDate(4, nacimientoDate);
                ps.setBinaryStream(5, fis, (int) image.length());
                ps.setInt(6, id);

                // Ejecutar la actualización
                int filasActualizadas = ps.executeUpdate();
                if (filasActualizadas > 0) {
                    System.out.println("Datos del usuario actualizados correctamente.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
