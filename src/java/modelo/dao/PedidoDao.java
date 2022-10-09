/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.Pedido;

/**
 *
 * @author Jean Paul
 */
public class PedidoDao {
    
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;
    
    public int Insertar(Pedido pedido){
        
        int id = 0;
        String sql = "INSERT INTO pedido ("
                + "tb_pedido_fechora, "
                + "tb_pedido_total, "
                + "tb_pedido_estado, "
                + "tb_pedido_ptoscanje, "
                + "tb_pedido_totalneto, "
                + "tb_pedido_totalptosg, "
                + "tb_usuario_cod)"
                + "VALUES (CURDATE(), ?, ?, ?, ?, ?, ?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, pedido.getTotal());
            ps.setString(2, pedido.getEstado());
            ps.setInt(3, pedido.getPtosCanje());
            ps.setDouble(4, pedido.getTotalNeto());
            ps.setInt(5, pedido.getTotalptosG());
            ps.setInt(6, pedido.getCodigoU());
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }


        } catch (Exception e) {
            
        }

        return id;
    }
    
    
    public String ModEstado(Pedido pedido){
        
        String sql = "UPDATE pedido SET "
                + "tb_pedido_fechoraentrega = ?, "
                + "tb_pedido_estado = ? "
                + "WHERE (tb_pedido_id = ?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, pedido.getFechaE());
            ps.setString(2, pedido.getEstado());
            ps.setInt(3, pedido.getCodigo());
            ps.executeUpdate();

            mensaje = "COMPLETADO";

        } catch (Exception e) {

            mensaje = "OCURRIO UN ERROR: " + e;
        }

        return mensaje;
    }
    
    public String Eliminar(int cod){
        
            String sql = "DELETE FROM pedido WHERE "
                + "(tb_pedido_id = '" + cod + "')";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "PEDIDO ELIMINADO";

        } catch (Exception e) {

            mensaje = "OCURRIO UN ERROR: " + e;
        }

        return mensaje;
    }
    
    public List ListarPedidos(String estado){
        
        List<Pedido> pedidos=new ArrayList<>();
        
        String sql="SELECT * "
                + "FROM pedido "
                + "JOIN usuario ON pedido.tb_usuario_cod = usuario.tb_usuario_cod "
                + "WHERE tb_pedido_estado = '" + estado + "'";
             
        try{
            
        
            con=objcon.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                Pedido p = new Pedido();
                p.setCodigo(rs.getInt("tb_pedido_id"));
                p.setFechaC(rs.getDate("tb_pedido_fechora"));
                p.setFechaE(rs.getDate("tb_pedido_fechoraentrega"));
                p.setTotal(rs.getDouble("tb_pedido_total"));
                p.setEstado(rs.getString("tb_pedido_estado"));
                p.setPtosCanje(rs.getInt("tb_pedido_ptoscanje"));
                p.setTotalNeto(rs.getDouble("tb_pedido_totalneto"));
                p.setTotalptosG(rs.getInt("tb_pedido_totalptosg"));
                p.setCodigoU(rs.getInt("tb_usuario_cod"));
                p.setNomUsu(rs.getString("tb_usuario_usua"));
                
                pedidos.add(p);   
            }
            
        }catch(Exception e){
            
        } 
               
        return pedidos;
    }
    
    public List ListarxUsuarios(int cod){
        
        List<Pedido> pedidos=new ArrayList<>();
        
        String sql="SELECT * "
                + "FROM pedido "
                + "WHERE tb_usuario_cod = " + cod;
             
        try{
            
            con=objcon.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                Pedido p = new Pedido();
                p.setCodigo(rs.getInt("tb_pedido_id"));
                p.setFechaC(rs.getDate("tb_pedido_fechora"));
                p.setFechaE(rs.getDate("tb_pedido_fechoraentrega"));
                p.setTotal(rs.getDouble("tb_pedido_total"));
                p.setEstado(rs.getString("tb_pedido_estado"));
                p.setPtosCanje(rs.getInt("tb_pedido_ptoscanje"));
                p.setTotalNeto(rs.getDouble("tb_pedido_totalneto"));
                p.setTotalptosG(rs.getInt("tb_pedido_totalptosg"));
                p.setCodigoU(rs.getInt("tb_usuario_cod"));
                
                pedidos.add(p);   
            }
            
        }catch(Exception e){
            
        } 
               
        return pedidos;
    }
    
    public List ListarxFecha(String estado, String desde, String hasta){
        
        List<Pedido> pedidos=new ArrayList<>();
        
        String sql="SELECT * "
                + "FROM pedido "
                + "JOIN usuario ON pedido.tb_usuario_cod = usuario.tb_usuario_cod "
                + "WHERE tb_pedido_estado = '" + estado + "' "
                +"AND tb_pedido_fechora between \""+ desde +"\" AND \""+ hasta +"\"";
             
        try{
            
        
            con=objcon.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                Pedido p = new Pedido();
                p.setCodigo(rs.getInt("tb_pedido_id"));
                p.setFechaC(rs.getDate("tb_pedido_fechora"));
                p.setFechaE(rs.getDate("tb_pedido_fechoraentrega"));
                p.setTotal(rs.getDouble("tb_pedido_total"));
                p.setEstado(rs.getString("tb_pedido_estado"));
                p.setPtosCanje(rs.getInt("tb_pedido_ptoscanje"));
                p.setTotalNeto(rs.getDouble("tb_pedido_totalneto"));
                p.setTotalptosG(rs.getInt("tb_pedido_totalptosg"));
                p.setCodigoU(rs.getInt("tb_usuario_cod"));
                p.setNomUsu(rs.getString("tb_usuario_usua"));
                
                pedidos.add(p);   
            }
            
        }catch(Exception e){
            
        } 
               
        return pedidos;
    }
    
    public Pedido Datos(int cod) {
        
        Pedido p = new Pedido();
        String sql = "SELECT * "
                + "FROM pedido "
                + "WHERE tb_pedido_id = " + cod;
        
        try {
            
            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                p.setCodigo(rs.getInt("tb_pedido_id"));
                p.setFechaC(rs.getDate("tb_pedido_fechora"));
                p.setTotal(rs.getDouble("tb_pedido_total"));
                p.setPtosCanje(rs.getInt("tb_pedido_ptoscanje"));
                p.setTotalNeto(rs.getDouble("tb_pedido_totalneto"));
                p.setTotalptosG(rs.getInt("tb_pedido_totalptosg"));
                p.setCodigoU(rs.getInt("tb_usuario_cod"));
                
            }

        } catch (Exception e) {
            return null;
        }
        return p;
    }
    
    public int Contar(String tip) {

        int n = 0;
        String sql = "SELECT count(tb_pedido_estado) "
                + "FROM pedido "
                + "WHERE tb_pedido_estado='"+ tip+"'";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                n = rs.getInt("count(tb_pedido_estado)");
            }

        } catch (Exception e) {

        }
        return n;

    }
}
