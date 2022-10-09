/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.Usuario;

/**
 *
 * @author Jean Paul
 */
public class UsuarioDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public Usuario Datos(String usuario) {

        Usuario u = new Usuario();
        String sql = "SELECT * "
                + "FROM usuario "
                + "WHERE tb_usuario_usua = '" + usuario + "'";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                u.setCodigo(rs.getInt("tb_usuario_cod"));
                u.setDni(rs.getString("tb_usuario_dni"));
                u.setApell(rs.getString("tb_usuario_apell"));
                u.setNombres(rs.getString("tb_usuario_nom"));
                u.setUsuario(rs.getString("tb_usuario_usua"));
                u.setContraseña(rs.getString("tb_usuario_contr"));
                u.setTipo(rs.getString("tb_usuario_tipo"));
                u.setCodverif(rs.getString("tb_usuario_codverif"));
                u.setPtosac(rs.getInt("tb_usuario_ptsacum"));
            }

        } catch (Exception e) {
            return null;
        }
        return u;
    }

    public Usuario DatosxC(int cod) {

        Usuario u = new Usuario();
        String sql = "SELECT * "
                + "FROM usuario "
                + "WHERE tb_usuario_cod =" + cod;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                u.setCodigo(rs.getInt("tb_usuario_cod"));
                u.setDni(rs.getString("tb_usuario_dni"));
                u.setApell(rs.getString("tb_usuario_apell"));
                u.setNombres(rs.getString("tb_usuario_nom"));
                u.setUsuario(rs.getString("tb_usuario_usua"));
                u.setContraseña(rs.getString("tb_usuario_contr"));
                u.setPtosac(rs.getInt("tb_usuario_ptsacum"));
            }

        } catch (Exception e) {
            return null;
        }
        return u;
    }

    public String Agregar(Usuario usuario) {

        String sql = "INSERT INTO usuario ("
                + "tb_usuario_dni, "
                + "tb_usuario_apell, "
                + "tb_usuario_nom, "
                + "tb_usuario_usua, "
                + "tb_usuario_contr, "
                + "tb_usuario_correo, "
                + "tb_usuario_tipo, "
                + "tb_usuario_ptsacum) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getDni());
            ps.setString(2, usuario.getApell());
            ps.setString(3, usuario.getNombres());
            ps.setString(4, usuario.getUsuario());
            ps.setString(5, usuario.getContraseña());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getTipo());
            ps.setInt(8, usuario.getPtosac());

            ps.executeUpdate();

            mensaje = "USUARIO AGREGADO";

        } catch (Exception e) {

            mensaje = "ERROR AL AGREGAR USUARIO: " + e;
        }

        return mensaje;
    }

    public List listarUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * "
                + "FROM usuario "
                + "WHERE tb_usuario_tipo = 'CL'";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Usuario u = new Usuario();
                u.setCodigo(rs.getInt("tb_usuario_cod"));
                u.setDni(rs.getString("tb_usuario_dni"));
                u.setApell(rs.getString("tb_usuario_apell"));
                u.setNombres(rs.getString("tb_usuario_nom"));
                u.setUsuario(rs.getString("tb_usuario_usua"));
                u.setContraseña(rs.getString("tb_usuario_contr"));
                u.setCorreo(rs.getString("tb_usuario_correo"));
                usuarios.add(u);

            }

        } catch (Exception e) {

        }

        return usuarios;

    }

    public List listarAdministradores() {

        List<Usuario> administradores = new ArrayList<>();

        String sql = "SELECT * "
                + "FROM usuario "
                + "WHERE tb_usuario_tipo = 'AD'";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Usuario u = new Usuario();
                u.setCodigo(rs.getInt("tb_usuario_cod"));
                u.setDni(rs.getString("tb_usuario_dni"));
                u.setApell(rs.getString("tb_usuario_apepater"));
                u.setNombres(rs.getString("tb_usuario_nom"));
                u.setUsuario(rs.getString("tb_usuario_usua"));
                u.setContraseña(rs.getString("tb_usuario_contr"));
                u.setCorreo(rs.getString("tb_usuario_correo"));
                u.setCodverif(rs.getString("tb_usuario_codverif"));
                administradores.add(u);

            }

        } catch (Exception e) {

        }

        return administradores;
    }

    public String Puntos(int cod, String puntos) {

        String sql = "UPDATE usuario SET "
                + "tb_usuario_ptsacum=tb_usuario_ptsacum" + puntos
                + "WHERE "
                + "tb_usuario_cod=" + cod;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            mensaje = "PUNTOS ACTUALIZADOS";

        } catch (Exception e) {
            mensaje = "ERROR";
        }
        return mensaje;

    }

    public int Contar() {

        int n = 0;
        String sql = "SELECT count(tb_usuario_cod) "
                + "FROM usuario";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                n = rs.getInt("count(tb_usuario_cod)");
            }

        } catch (Exception e) {

        }
        return n;

    }
}
