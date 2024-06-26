package com.easyfest.easyfest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase utilitaria para interactuar con la base de datos de EasyFest.
 *
 * @author fermin
 */
public class DBUtil {

    private Connection conn;
    private String cadenaConexion = "jdbc:mysql://127.0.0.1:3306/easyfest";
    private String nombreUsuario = "root";
    private String password = "1234";
    /**
     * Conexión a la base de datos.
     */
    public Connection getConexion() {

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.conn = DriverManager.getConnection(this.cadenaConexion, this.nombreUsuario, this.password);
            return this.conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Cierra la conexión a la base de datos.
     */
    public void cerrarConexion() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
