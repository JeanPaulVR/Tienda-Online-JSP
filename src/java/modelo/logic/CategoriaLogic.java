/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.Categoria;
import modelo.dao.CategoriaDao;

/**
 *
 * @author ERIKA
 */
public class CategoriaLogic {

    String msj;
    CategoriaDao dC = new CategoriaDao();
    Categoria bC = new Categoria();
    int cantidad;

    public String Agregar(Categoria categoria) {
        
        List<Categoria> categorias = new ArrayList<>();
        categorias = dC.listarcategoria("");
        
        if (categoria.getNombre().compareTo("") != 0) {

            List<String> nombres = new ArrayList<>();
            
            int contadorC = 0;

            while (contadorC < categorias.size()) {
                nombres.add(categorias.get(contadorC).getNombre());
                contadorC = contadorC + 1;
            }
            
            int pos = nombres.indexOf(categoria.getNombre());
            
            if(pos>=0){
                msj = "LA CATEGORIA YA EXISTE";
            } else{
                msj = dC.Agregar(categoria);
            }
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }
    
    public String Modificar(Categoria categoria) {
        
        List<Categoria> categorias = new ArrayList<>();
        categorias = dC.listarcategoria("");
        
        if (categoria.getNombre().compareTo("") != 0
                && categoria.getCodigo() > 0) {

            List<String> nombres = new ArrayList<>();
            
            int contadorC = 0;

            while (contadorC < categorias.size()) {
                nombres.add(categorias.get(contadorC).getNombre());
                contadorC = contadorC + 1;
            }
            
            int pos = nombres.indexOf(categoria.getNombre());
            
            if(pos>=0){
                msj = "LA CATEGORIA YA EXISTE";
            } else{
                msj = dC.Modificar(categoria);
            }
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }
    
    public String Eliminar(int cod) {
        
        if (cod > 0) {
            msj = dC.Eliminar(cod);
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }
    
    public List Listar(String b_cate) {
        
        List<Categoria> categorias = new ArrayList<>();
        categorias = dC.listarcategoria(b_cate);
        return categorias;
    }
    
    public int Contar() {
        
        int n = dC.Contar();
        return n;
    }
}
