/**
 * Clase que representa un pedido en el sistema.
 */
package com.easyfest.easyfest;

import java.time.LocalDate;

public class Pedido {
    private int id_pedido; // Identificador único del pedido
    private int id_tarjeta; // Identificador de la tarjeta asociada al pedido
    private int id_usuario; // Identificador del usuario que realiza el pedido
    private int id_producto; // Identificador del producto solicitado
    private LocalDate fecha_compra; // Fecha en la que se realizó la compra

    /**
     * Obtiene el ID del pedido.
     *
     * @return ID del pedido
     */
    public int getId_pedido() {
        return id_pedido;
    }

    /**
     * Establece el ID del pedido.
     *
     * @param id_pedido ID del pedido
     */
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    /**
     * Obtiene el ID de la tarjeta asociada al pedido.
     *
     * @return ID de la tarjeta asociada al pedido
     */
    public int getId_tarjeta() {
        return id_tarjeta;
    }

    /**
     * Establece el ID de la tarjeta asociada al pedido.
     *
     * @param id_tarjeta ID de la tarjeta asociada al pedido
     */
    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    /**
     * Obtiene el ID del usuario que realiza el pedido.
     *
     * @return ID del usuario que realiza el pedido
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * Establece el ID del usuario que realiza el pedido.
     *
     * @param id_usuario ID del usuario que realiza el pedido
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * Obtiene el ID del producto solicitado.
     *
     * @return ID del producto solicitado
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * Establece el ID del producto solicitado.
     *
     * @param id_producto ID del producto solicitado
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * Obtiene la fecha en la que se realizó la compra.
     *
     * @return Fecha en la que se realizó la compra
     */
    public LocalDate getFecha_compra() {
        return fecha_compra;
    }

    /**
     * Establece la fecha en la que se realizó la compra.
     *
     * @param fecha_compra Fecha en la que se realizó la compra
     */
    public void setFecha_compra(LocalDate fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    /**
     * Constructor de la clase Pedido.
     */
    public Pedido() {
    }
}
