package org.example.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que se encarga de manejar la conexión con la base de datos a partir de JDBC
 */
public class DatabaseConnector {

    public static Connection obtenerConexion(){
        Connection connection = null;

        try {
            final String DRIVER = "com.mysql.jdbc.Driver";
            final String URL = "jdbc:mysql://localhost:3306/playersranking";
            final String USER = "root";
            final String PASSWORD = "123456789";

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

}
