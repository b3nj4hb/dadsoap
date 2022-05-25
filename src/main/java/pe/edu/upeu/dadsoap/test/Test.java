package pe.edu.upeu.dadsoap.test;

import pe.edu.upeu.dadsoap.config.Conexion;

public class Test {
        public static void main(String[] args) {
        if (Conexion.getConex() != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("No conectado");
        }

    }
}
