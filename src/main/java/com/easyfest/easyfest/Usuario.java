package com.easyfest.easyfest;

public class Usuario {
    private int id;
    private int fecha_nacimiento;
    private String nombre;
    private String apellidos;
    private String dni;
    private String correo;
    private String contrasena;
    private boolean admin;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(int fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Usuario(int id, int fecha_nacimiento, String nombre, String apellidos, String dni, String correo, String contrasena, boolean admin) {
        this.id = id;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo = correo;
        this.contrasena = contrasena;
        this.admin = admin;
    }
}
