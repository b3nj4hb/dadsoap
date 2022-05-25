package pe.edu.upeu.dadsoap.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:postgresql://ec2-34-201-95-176.compute-1.amazonaws.com/df1s2p9kv5ot4p";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String PASS = "504be79431768462db829c50fe9b8ea220df44b9fda3bcede0fa2d76960384d0";
    private static final String USER = "oyeisgczawbfza";
    private static Connection cx = null;

    public static Connection getConexion() {
        try {
            Class.forName(DRIVER);
            if (cx == null) {
                cx = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error:" + e);
        }
        return cx;
    }
}
