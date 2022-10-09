/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.List;
import modelo.beans.DetallePedido;
import modelo.dao.DetallePedidoDao;

/**
 *
 * @author Jean Paul
 */
public class DetallePedidoLogic {
    
    String msj;
    DetallePedidoDao daoD = new DetallePedidoDao();
    DetallePedido beansD = new DetallePedido();
    
    public String Agregar(DetallePedido dpedido) {
        
        if (dpedido.getCantidad() > 0
                && dpedido.getPrecio() > 0
                && dpedido.getPtosG() > 0
                && dpedido.getCodPedido() > 0
                && dpedido.getCodProducto() > 0){
            
            msj=daoD.Insertar(dpedido);
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }
    
    public List DetallesPedido(int cod){
        
        List<DetallePedido> detalles = daoD.ListarDetalles(cod);
        return detalles;
    }
    
    public String Eliminar(int cod) {
        
        if (cod > 0) {
            msj=daoD.Eliminar(cod);
        } else {
            
        }
        return msj;
    }
}
