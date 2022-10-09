/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.Categoria;

/**
 *
 * @author ERIKA
 */
public class CategoriaDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public String Agregar(Categoria Categoria) {

        String sql = "INSERT INTO categoria ("
                + "tb_categoria_nombre) "
                + "VALUES (?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Categoria.getNombre());

            ps.executeUpdate();
            //cerrando conexion
            con.close();
            ps.close();
            rs.close();

            mensaje = "CATEGORIA AGREGADA";

        } catch (SQLException e) {

            mensaje = "ERROR AL AGREGAR CATEGORIA: " + e;
        }

        return mensaje;
    }

    public String Modificar(Categoria Categoria) {

        String sql = "UPDATE categoria SET "
                + "tb_categoria_nombre=? "
                + "WHERE "
                + "tb_categoria_cod="
                + Categoria.getCodigo();

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Categoria.getNombre());

            ps.executeUpdate();
            //cerrando conexion
            con.close();
            ps.close();
            rs.close();

            mensaje = "CATEGORIA MODIFICADA";

        } catch (SQLException e) {

            mensaje = "ERROR AL AGREGAR CATEGORIA: " + e;
        }

        return mensaje;
    }
    
    public String Eliminar(int cod){
        
        String sql = "DELETE FROM categoria "
                + "WHERE (tb_categoria_cod = '" + cod + "')";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "CATEGORIA ELIMINADO";

        } catch (Exception e) {

            mensaje = "OCURRIO UN ERROR: " + e;
        }

        return mensaje;
    }

    public List listarcategoria(String b_cat) {

        List<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT * FROM categoria "
                + "WHERE tb_categoria_nombre LIKE '%"+ b_cat +"%'";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Categoria u = new Categoria();
                u.setCodigo(rs.getInt("tb_categoria_cod"));
                u.setNombre(rs.getString("tb_categoria_nombre"));
                categorias.add(u);

            }

        } catch (SQLException e) {

        }

        return categorias;

    }
    
    public int Contar() {

        int n = 0;
        String sql = "SELECT count(tb_categoria_cod) "
                + "FROM categoria";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                n = rs.getInt("count(tb_categoria_cod)");
            }

        } catch (Exception e) {

        }
        return n;

    }
}
