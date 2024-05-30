/**
 * Clase UsuariosModel que interactúa con la base de datos para realizar operaciones relacionadas con los usuarios.
 */
package com.easyfest.easyfest;

import javafx.scene.control.Alert;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 * Modelo para los usuarios.
 * esta clase lo que hace es crear y poner todas las funciones de los Usuarios
 */
public class UsuariosModel extends DBUtil {

    /**
     * Constructor de la clase UsuariosModel.
     */
    public UsuariosModel() {
    }

    /**
     * Método para añadir un nuevo usuario a la base de datos.
     *
     * @param nombre         nombre del usuario.
     * @param apellidos      apellidos del usuario.
     * @param dni            dni del usuario.
     * @param correo         correo del usuario.
     * @param contrasena     contraseña del usuario.
     * @param fecha_nacimiento fecha de nacimiento del usuario.
     */
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
            e.printStackTrace();
        }
    }

    /**
     * Método para iniciar sesión de un usuario.
     *
     * @param correo    correo del usuario.
     * @param contrasena contraseña del usuario.
     * @return true si el usuario existe y la contraseña es correcta, false en caso contrario.
     */
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

    /**
     * Método para buscar un usuario en la base de datos por su correo electrónico.
     *
     * @param correo correo del usuario.
     * @return objeto Usuario si se encuentra el usuario, null en caso contrario.
     */
    public Usuario buscarUsuario(String correo) {
        Usuario u = null;
        try {
            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM easyfest.usuario WHERE correo LIKE ?");
            ps.setString(1, correo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");