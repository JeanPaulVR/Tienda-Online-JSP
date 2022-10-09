/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.Producto;

/**
 *
 * @author Jean Paul
 */
public class ProductoDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public Producto DatosProducto(int cod) {

        Producto p = new Producto();
        String sql = "SELECT * "
                + "FROM producto "
                + "WHERE tb_producto_cod = " + cod;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                p.setCodigo(rs.getInt("tb_producto_cod"));
                p.setNombre(rs.getString("tb_producto_nombre"));
                p.setImagenP(rs.getBytes("tb_producto_imgp"));
                p.setImagen(rs.getBytes("tb_producto_img"));
                p.setPrecio(rs.getDouble("tb_producto_precio"));
                p.setStock(rs.getInt("tb_producto_stock"));
                p.setCodCat(rs.getInt("tb_categoria_cod"));
                p.setPtosG(rs.getInt("tb_producto_ptosg"));

            }

        } catch (Exception e) {
            return null;
        }
        return p;
    }

    public String Insertar(Producto producto) {

        String sql = "INSERT INTO producto ("
                + "tb_producto_nombre, "
                + "tb_producto_imgp, "
                + "tb_producto_img, "
                + "tb_producto_precio , "
                + "tb_producto_stock, "
                + "tb_producto_ptosg, "
                + "tb_categoria_cod) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setBlob(2, producto.getImgP());
            ps.setBlob(3, producto.getImg());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getStock());
            ps.setInt(6, producto.getPtosG());
            ps.setInt(7, producto.getCodCat());
            ps.executeUpdate();

            mensaje = "PRODUCTO AGREGADO";

        } catch (Exception e) {

            mensaje = "OCURRIO UN ERROR: " + e;
        }

        return mensaje;
    }

    public String Eliminar(int cod) {

        String sql = "DELETE FROM producto "
                + "WHERE(tb_producto_cod = '" + cod + "')";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "PRODUCTO ELIMINADO";

        } catch (Exception e) {

            mensaje = "OCURRIO UN ERROR: " + e;
        }

        return mensaje;
    }

    public String Modificar(Producto producto) {

        String sql = "UPDATE producto SET "
                + "tb_producto_nombre=?, "
                + "tb_producto_imgp=?, "
                + "tb_producto_img=?, "
                + "tb_producto_precio=?, "
                + "tb_producto_ptosg=?, "
                + "tb_categoria_cod=? "
                + "WHERE "
                + "tb_producto_cod="
                + producto.getCodigo();

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setBlob(2, producto.getImgP());
            ps.setBlob(3, producto.getImg());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getPtosG());
            ps.setInt(6, producto.getCodCat());
            ps.executeUpdate();

            mensaje = "PRODUCTO MODIFICADO";

        } catch (Exception e) {

            mensaje = "OCURRIO UN ERROR: " + e;
        }

        return mensaje;
    }

    public List listarProductos(String busq) {

        List<Producto> productos = new ArrayList<>();

        String sql = "SELECT * "
                + "FROM producto p "
                + "JOIN categoria c ON p.tb_categoria_cod = c.tb_categoria_cod "
                + "WHERE tb_producto_nombre LIKE '%" + busq + "%' "
                + "OR tb_categoria_nombre LIKE '%" + busq + "%'";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Producto p = new Producto();
                p.setCodigo(rs.getInt("tb_producto_cod"));
                p.setNombre(rs.getString("tb_producto_nombre"));
                p.setPrecio(rs.getDouble("tb_producto_precio"));
                p.setStock(rs.getInt("tb_producto_stock"));
                p.setPtosG(rs.getInt("tb_producto_ptosg"));
                p.setCodCat(rs.getInt("tb_categoria_cod"));
                p.setNomCat(rs.getString("tb_categoria_nombre"));
                productos.add(p);

            }

        } catch (Exception e) {

        }

        return productos;

    }

    public String Stock(int cod, int stock) {

        String sql = "UPDATE producto SET "
                + "tb_producto_stock=" + stock
                + " WHERE "
                + "tb_producto_cod="
                + cod;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "STOCK ACTUALIZADO";

        } catch (Exception e) {

            mensaje = "OCURRIO UN ERROR: " + e;
        }

        return mensaje;
    }

    public int Contar() {

        int n = 0;
        String sql = "SELECT count(tb_producto_cod) "
                + "FROM producto";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                n = rs.getInt("count(tb_producto_cod)");
            }

        } catch (Exception e) {

        }
        return n;

    }

    public int[] MejoresProductos() {

        int[] cod = new int[3];

        String sql = "SELECT p.tb_producto_cod, count(*) "
                + "FROM detallepedido d "
                + "JOIN producto p ON d.tb_producto_cod = p.tb_producto_cod "
                + "JOIN pedido pd ON d.tb_pedido_id = pd.tb_pedido_id "
                + "WHERE tb_pedido_estado = \"REALIZADO\" "
                + "GROUP BY p.tb_producto_cod "
                + "LIMIT 3";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {

                cod[i] = rs.getInt("tb_producto_cod");
                i++;
            }

        } catch (Exception e) {

        }

        return cod;

    }

    public Producto LoMasNuevo() {

        Producto p = new Producto();
        
        String sql = "SELECT * "
                + "FROM producto "
                + "ORDER BY tb_producto_cod DESC "
                + "LIMIT 1";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                p.setCodigo(rs.getInt("tb_producto_cod"));
                p.setNombre(rs.getString("tb_producto_nombre"));
                p.setPrecio(rs.getDouble("tb_producto_precio"));
                p.setStock(rs.getInt("tb_producto_stock"));
                p.setPtosG(rs.getInt("tb_producto_ptosg"));
                p.setCodCat(rs.getInt("tb_categoria_cod"));
                p.setNomCat(rs.getString("tb_categoria_nombre"));

            }

        } catch (Exception e) {

        }

        return p;

    }

}
