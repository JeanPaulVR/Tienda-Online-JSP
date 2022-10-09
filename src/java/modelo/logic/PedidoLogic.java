/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.Pedido;
import modelo.dao.PedidoDao;

/**
 *
 * @author Jean Paul
 */
public class PedidoLogic {
    
    String msj;
    PedidoDao daoP = new PedidoDao();
    Pedido beansP = new Pedido();
    
    public int Agregar(Pedido pedido) {
        
        int id = 0;
        if (pedido.getCodigoU() > 0
                && pedido.getTotal() > 0
                && pedido.getEstado().compareTo("") != 0
                && pedido.getPtosCanje() >= 0
                && pedido.getTotalNeto() > 0
                && pedido.getTotalptosG() >= 0) {
            
            id=daoP.Insertar(pedido);
        } else {
            
        }
        return id;
    }
    
    public List Listar(String tipo, String desde, String hasta) {
        
        List<Pedido> lista = new ArrayList<>();
        
        if(desde.compareTo("")==0 && hasta.compareTo("")==0){
            lista = daoP.ListarPedidos(tipo);
        } else{
            lista = daoP.ListarxFecha(tipo, desde, hasta);
        }
        return lista;
    }
    
    public List ListarxUsuario(int cod) {
        
        List<Pedido> lista = new ArrayList<>();
        
        if(cod != 0){
            lista = daoP.ListarxUsuarios(cod);
        } else{
            lista = null;
        }
        return lista;
    }
    
    public Pedido Datos(int cod) {

        beansP = daoP.Datos(cod);
        return beansP;
    }
    
    public String Cambiarestado(Pedido pedido){
        
        if(pedido.getEstado().compareTo("")!=0
                && pedido.getCodigo() > 0){
            
            msj = daoP.ModEstado(pedido);
        }else{
            msj = "OCURRIO UN ERROR";
        }
        return msj;
    }
    
    public String Eliminar(int cod) {
        
        if (cod > 0) {
            msj=daoP.Eliminar(cod);
        } else {
            
        }
        return msj;
    }
    
    public int Contar(String tip) {
        
        int n = daoP.Contar(tip);
        return n;
    }
}
