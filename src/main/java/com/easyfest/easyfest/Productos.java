package com.easyfest.easyfest;

import java.time.LocalDate;

/**
 * Esta clase representa un producto en el sistema.
 */
public class Productos {
    private int id; // Identificador único del producto.
    private String nombre; // Nombre del producto.
    private String descripcion; // Descripción del producto.
    private double precio; // Precio del producto.
    private LocalDate fecha_inicio; // Fecha de inicio de disponibilidad del producto.
    private LocalDate fecha_fin; // Fecha de fin de disponibilidad del producto.
    private String img; // Ruta de la imagen asociada al producto.

    /**
     * Obtiene el identificador del producto.
     * @return El identificador del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del producto.
     * @param id El identificador del producto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * @param nombre El nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del producto.
     * @return La descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     * @param descripcion La descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del producto.
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     * @param precio El precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la fecha de inicio de disponibilidad del producto.
     * @return La fecha de inicio de disponibilidad del producto.
     */
    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * Establece la fecha de inicio de disponibilidad del producto.
     * @param fecha_inicio La fecha de inicio de disponibilidad del producto.
     */
    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * Obtiene la fecha de fin de disponibilidad del producto.
     * @return La fecha de fin de disponibilidad del producto.
     */
    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    /**
     * Establece la fecha de fin de disponibilidad del producto.
     * @param fecha_fin La fecha de fin de disponibilidad del producto.
     */
    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * Obtiene la ruta de la imagen asociada al producto.
     * @return La ruta de la imagen asociada al producto.
     */
    public String getImg() {
        return img;
    }

    /**
     * Establece la ruta de la imagen asociada al producto.
     * @param img La ruta de la imagen asociada al producto.
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * Constructor de la clase Productos.
     * @param id Identificador único del producto.
     * @param nombre Nombre del producto.
     * @param descripcion Descripción del producto.
     * @param precio Precio del producto.
     * @param fecha_inicio Fecha de inicio de disponibilidad del producto.
     * @param fecha_fin Fecha de fin de disponibilidad del producto.
     * @param img Ruta de la imagen asociada al producto.
     */
    public Productos(int id, String nombre, String descripcion, double precio, LocalDate fecha_inicio, LocalDate fecha_fin, String img) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.img = img;
    }

    /**
     * Constructor vacío de la clase Productos.
     */
    public Productos() {
    }
}
