package pe.edu.upeu.dadsoap.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:postgresql://ec2-54-211-255-161.compute-1.amazonaws.com/d4jqho7u4g1cm8";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String PASS = "e9cb0b02098df2e001ea7ebd6ac4e7ccbd7d61105c71c64bd81249806cd57164";
    private static final String USER = "hfpxlcrtixfojk";
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
