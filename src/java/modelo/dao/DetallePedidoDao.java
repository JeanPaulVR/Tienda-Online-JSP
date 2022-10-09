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
import modelo.beans.DetallePedido;

/**
 *
 * @author Jean Paul
 */
public class DetallePedidoDao {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;
    
    public String Insertar(DetallePedido detalle){
        
        String sql = "INSERT INTO detallepedido ("
                + "tb_detalledelpedido_cant, "
                + "tb_detalledelpedido_precventa , "
                + "tb_detalledelpedido_ptsgancom , "
                + "tb_pedido_id ,"
                + "tb_producto_cod) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getPrecio());
            ps.setInt(3, detalle.getPtosG());
            ps.setInt(4, detalle.getCodPedido());
            ps.setInt(5, detalle.getCodProducto());
            ps.executeUpdate();

            mensaje = "COMPLETADO";

        } catch (Exception e) {

            mensaje = "OCURRIO UN ERROR: " + e;
        }

        return mensaje;
    }
    
    public List ListarDetalles(int cod){
        List<DetallePedido> detalle=new ArrayList<>();
        
        String sql="SELECT * "
                + "FROM detallepedido "
                + "WHERE tb_pedido_id = "+ cod ;
             
        try{
            
        
            con=objcon.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                DetallePedido p = new DetallePedido();
                p.setCodPedido(rs.getInt("tb_pedido_id"));
                p.setCodProducto(rs.getInt("tb_producto_cod"));
                p.setCantidad(rs.getInt("tb_detalledelpedido_cant"));
                p.setPrecio(rs.getDouble("tb_detalledelpedido_precventa"));
                
                detalle.add(p);   
            }
            
        }catch(Exception e){
            
        } 
               
        return detalle;
    }
    
    public String Eliminar(int cod){
        
            String sql = "DELETE FROM detallepedido WHERE "
                + "(tb_pedido_id = '" + cod + "')";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "REALIZADO";

        } catch (Exception e) {

            mensaje = "OCURRIO UN ERROR: " + e;
        }

        return mensaje;
    }
}
