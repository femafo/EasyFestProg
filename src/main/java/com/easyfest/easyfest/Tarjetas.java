package com.easyfest.easyfest;

import java.sql.Date;
import java.time.LocalDate;

/**
 * La clase Tarjetas representa una tarjeta de crédito  con los parametros.
 */
public class Tarjetas {
    private int id_tarjeta;
    private Date fecha_caducidad;
    private int cvv;
    private String num_tarjeta;
    private String titular;

    /**
     * Obtiene el ID de la tarjeta.
     *
     * @return El ID de la tarjeta.
     */
    public int getId_tarjeta() {
        return id_tarjeta;
    }

    /**
     * Establece el ID de la tarjeta.
     *
     * @param id_tarjeta El ID de la tarjeta a establecer.
     */
    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    /**
     * Obtiene la fecha de caducidad de la tarjeta.
     *
     * @return La fecha de caducidad de la tarjeta.
     */
    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    /**
     * Establece la fecha de caducidad de la tarjeta.
     *
     * @param fecha_caducidad La fecha de caducidad de la tarjeta a establecer.
     */
    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    /**
     * Obtiene el CVV de la tarjeta.
     *
     * @return El CVV de la tarjeta.
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * Establece el CVV de la tarjeta.
     *
     * @param cvv El CVV de la tarjeta a establecer.
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * Obtiene el número de la tarjeta.
     *
     * @return El número de la tarjeta.
     */
    public String getNum_tarjeta() {
        return num_tarjeta;
    }

    /**
     * Establece el número de la tarjeta.
     *
     * @param num_tarjeta El número de la tarjeta a establecer.
     */
    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    /**
     * Obtiene el titular de la tarjeta.
     *
     * @return El titular de la tarjeta.
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Establece el titular de la tarjeta.
     *
     * @param titular El titular de la tarjeta a establecer.
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * Constructor parametrizado de la clase Tarjetas.
     *
     * @param id_tarjeta      El ID de la tarjeta.
     * @param fecha_caducidad La fecha de caducidad de la tarjeta.
     * @param cvv             El CVV de la tarjeta.
     * @param titular         El titular de la tarjeta.
     * @param num_tarjeta     El número de la tarjeta.
     */
    public Tarjetas(int id_tarjeta, Date fecha_caducidad, int cvv, String titular, String num_tarjeta) {
        this.id_tarjeta = id_tarjeta;
        this.fecha_caducidad = fecha_caducidad;
        this.cvv = cvv;
        this.titular = titular;
        this.num_tarjeta = num_tarjeta;
    }

    /**
     * Constructor por defecto de la clase Tarjetas.
     */
    public Tarjetas() {
    }
}
