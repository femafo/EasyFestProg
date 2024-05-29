package com.easyfest.easyfest;

import java.time.LocalDate;

public class Productos {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

    public Productos(int id, String nombre, String descripcion, double precio, LocalDate fecha_inicio, LocalDate fecha_fin, String img) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.img = img;
    }

    public Productos() {
    }
}
