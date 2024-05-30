package com.easyfest.easyfest;

import java.awt.*;
import java.time.LocalDate;
import javafx.scene.image.Image;

/**
 * La clase Usuario representa a un usuario en el sistema EasyFest.
 * esta clase tiene los parametros de un usuario.
 */
public class Usuario {
    private int id;
    private LocalDate fecha_nacimiento;
    private String nombre;
    private String apellidos;
    private String dni;
    private String correo;
    private String contrasena;
    private boolean admin;
    private Image imagen;

    /**
     * Constructor completo de la clase Usuario .
     *
     * @param id               El ID del usuario.
     * @param fecha_nacimiento La fecha de nacimiento del usuario.
     * @param nombre           El nombre del usuario.
     * @param apellidos        Los apellidos del usuario.
     * @param dni              El DNI del usuario.
     * @param correo           El correo del usuario.
     * @param contrasena       La contraseña del usuario.
     * @param admin            Indica si el usuario es administrador.
     * @param imagen           La imagen del usuario.
     */
    public Usuario(int id, LocalDate fecha_nacimiento, String nombre, String apellidos, String dni, String correo, String contrasena, boolean admin, Image imagen) {
        this.id = id;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo = correo;
        this.contrasena = contrasena;
        this.admin = admin;
        this.imagen = imagen;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param id El ID del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return La fecha de nacimiento del usuario.
     */
    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fecha_nacimiento La fecha de nacimiento del usuario.
     */
    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del usuario.
     *
     * @return Los apellidos del usuario.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del usuario.
     *
     * @param apellidos Los apellidos del usuario.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el DNI del usuario.
     *
     * @return El DNI del usuario.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del usuario.
     *
     * @param dni El DNI del usuario.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el correo del usuario.
     *
     * @return El correo del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo del usuario.
     *
     * @param correo El correo del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena La contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Indica si el usuario es administrador.
     *
     * @return true si el usuario es administrador, false en caso contrario.
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Establece si el usuario es administrador.
     *
     * @param admin true si el usuario es administrador, false en caso contrario.
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * Obtiene la imagen del usuario.
     *
     * @return La imagen del usuario.
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * Establece la imagen del usuario.
     *
     * @param imagen La imagen del usuario.
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    /**
     * Constructor de la clase Usuario sin la imagen.
     *
     * @param id               El ID del usuario.
     * @param fecha_nacimiento La fecha de nacimiento del usuario.
     * @param nombre           El nombre del usuario.
     * @param apellidos        Los apellidos del usuario.
     * @param dni              El DNI del usuario.
     * @param correo           El correo del usuario.
     * @param contrasena       La contraseña del usuario.
     * @param admin            Indica si el usuario es administrador.
     */
    public Usuario(int id, LocalDate fecha_nacimiento, String nombre, String apellidos, String dni, String correo, String contrasena, boolean admin) {
        this.id = id;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo = correo;
        this.contrasena = contrasena;
        this.admin = admin;
    }

    /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario() {
    }
}
