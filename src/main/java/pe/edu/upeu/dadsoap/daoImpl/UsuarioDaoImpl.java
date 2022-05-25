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
        String SQL = "select *from fc_create_usuario(?,?,?,?);";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getIdpersona());
            ps.setInt(4, user.getIdrol());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public int update(Usuario user) {
        String SQL = "UPDATE usuarios SET username=?, password=?, idpersona=?, idrol=? WHERE idusuario=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getIdpersona());
            ps.setInt(4, user.getIdrol());
            ps.setInt(5, user.getIdusuario());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM usuarios WHERE idusuario=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public Usuario read(int id) {
        String SQL = "SELECT * FROM usuarios WHERE idusuario=?";
        Usuario u = new Usuario();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setIdusuario(rs.getInt("idusuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setIdpersona(rs.getInt("idpersona"));
                u.setIdrol(rs.getInt("idrol"));
                u.setFechacreacion(rs.getString("fechacreacion"));
                u.setEstado(rs.getBoolean("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return u;
    }

    @Override
    public List<Usuario> readAll() {
        String SQL = "SELECT * FROM usuarios";
        List<Usuario> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setIdusuario(rs.getInt("idusuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setIdpersona(rs.getInt("idpersona"));
                u.setIdrol(rs.getInt("idrol"));
                u.setFechacreacion(rs.getString("fechacreacion"));
                u.setEstado(rs.getBoolean("estado"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    /*@Override
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
            System.err.println("Error: " + e);
        }
        return lista;
    }
     */
}
