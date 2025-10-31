package com.cpifppiramide.prueba1.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    private DBConnection(){}

    public static Connection getInstance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://coches-prueba.cx0imquaojhi.us-east-1.rds.amazonaws.com:3306/Examen1",
                        "admin", "QTSiGwgBkgPb94");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

}
