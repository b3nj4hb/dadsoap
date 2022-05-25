/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.dadsoap.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.dadsoap.config.Conexion;
import pe.edu.upeu.dadsoap.dao.UsuarioDao;
import pe.edu.upeu.dadsoap.model.Usuario;

/**
 *
 * @author admin
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int create(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String SQL = "select u.idusuario, u.username, p.apellidos, p.nombres, r.nombre from usuarios as u"
                + "inner join roles as r on u.idrol=r.idrol"
                + "inner join personas as p on u.idpersona=p.idpersona;";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("idusuario", rs.getInt("idusuario"));
                map.put("username", rs.getString("username"));
                map.put("apellidos", rs.getString("apellidos"));
                map.put("nombres", rs.getString("nombres"));
                map.put("rol", rs.getString("nombre"));
                lista.add(map);
            }
        } catch (SQLException e) {
            System.err.println("Error: "+e);
        }
return lista;
    }

}
