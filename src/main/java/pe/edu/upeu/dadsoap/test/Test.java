package pe.edu.upeu.dadsoap.test;

import com.google.gson.Gson;
import pe.edu.upeu.dadsoap.config.Conexion;
import pe.edu.upeu.dadsoap.dao.PostDao;
import pe.edu.upeu.dadsoap.daoImpl.PostDaoImpl;

public class Test {
    static Gson gson = new Gson();
    static PostDao p = new PostDaoImpl();
    
        public static void main(String[] args) {
        if (Conexion.getConexion() != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("No conectado");
        }
            System.out.println(gson.toJson(p.readAll()));
            //System.out.println(gson.toJson(p.read(1)));
    }
}
