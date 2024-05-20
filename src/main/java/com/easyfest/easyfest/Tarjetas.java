package com.easyfest.easyfest;

public class Tarjetas {
    private int id_tarjeta;
    private int fecha_caducidad;
    private int cvv;
    private String num_tarjeta;
    private String titular;

    public int getId_tarjeta() {
        return id_tarjeta;
    }
    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public int getFecha_caducidad() {
        return fecha_caducidad;
    }
    public void setFecha_caducidad(int fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getNum_tarjeta() {
        return num_tarjeta;
    }
    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Tarjetas(int id_tarjeta, int fecha_caducidad, int cvv, String titular, String num_tarjeta) {
        this.id_tarjeta = id_tarjeta;
        this.fecha_caducidad = fecha_caducidad;
        this.cvv = cvv;
        this.titular = titular;
        this.num_tarjeta = num_tarjeta;
    }
}
