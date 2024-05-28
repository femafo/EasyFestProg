package com.easyfest.easyfest;

import java.time.LocalDate;

public class Pedido {
    private int id_pedido;
    private int id_tarjeta;
    private int id_usuario;
    private int id_producto;
    private LocalDate fecha_compra;

    public int getId_pedido() {
        return id_pedido;
    }
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_tarjeta() {
        return id_tarjeta;
    }
    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public LocalDate getFecha_compra() {
        return fecha_compra;
    }
    public void setFecha_compra(LocalDate fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Pedido() {
    }
}
