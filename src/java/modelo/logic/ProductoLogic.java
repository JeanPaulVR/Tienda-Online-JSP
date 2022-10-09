/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.Producto;
import modelo.dao.ProductoDao;

/**
 *
 * @author Jean Paul
 */
public class ProductoLogic {

    String msj;
    ProductoDao dP = new ProductoDao();
    Producto bP = new Producto();
    int cantidad;

    public String Agregar(Producto producto) {

        List<Producto> productos = new ArrayList<>();
        productos = dP.listarProductos("");

        if (producto.getNombre().compareTo("") != 0
                && producto.getImgP() != null
                && producto.getImg() != null
                && producto.getPrecio() > 0
                && producto.getStock() > 0
                && producto.getCodCat() > 0
                && producto.getPtosG() > 0) {

            List<String> nombres = new ArrayList<>();

            int contadorP = 0;

            while (contadorP < productos.size()) {
                nombres.add(productos.get(contadorP).getNombre());
                contadorP = contadorP + 1;
            }

            int pos = nombres.indexOf(producto.getNombre());

            if (pos >= 0) {
                msj = "EL PRODUCTO YA EXISTE";
            } else {
                msj = dP.Insertar(producto);
            }
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public String Modificar(Producto producto) {

        List<Producto> productos = new ArrayList<>();
        productos = dP.listarProductos("");

        if (producto.getCodigo() > 0
                && producto.getNombre().compareTo("") != 0
                && producto.getImgP() != null
                && producto.getImg() != null
                && producto.getPrecio() > 0
                && producto.getCodCat() > 0) {

            List<String> nombres = new ArrayList<>();

            int contadorP = 0;

            while (contadorP < productos.size()) {
                if (productos.get(contadorP).getNombre().compareTo(producto.getNombre()) != 0) {
                    nombres.add(productos.get(contadorP).getNombre());
                }
                contadorP = contadorP + 1;
            }

            int pos = nombres.indexOf(producto.getNombre());

            if (pos >= 0) {
                msj = "EL PRODUCTO YA EXISTE";
            } else {
                msj = dP.Modificar(producto);
            }
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public String Eliminar(int codigo) {

        if (codigo > 0) {
            msj = dP.Eliminar(codigo);
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public List Listar(String busq) {

        List<Producto> productos = new ArrayList<>();
        productos = dP.listarProductos(busq);
        return productos;
    }

    public byte[] Imagen(String tip, int cod) {

        byte[] b = null;
        if (tip.equals("a")) {
            b = dP.DatosProducto(cod).getImagenP();
        } else if (tip.equals("b")) {
            b = dP.DatosProducto(cod).getImagen();
        }
        return b;
    }

    public Producto Datos(int cod) {

        bP = dP.DatosProducto(cod);
        return bP;
    }

    public String Stock(int cod, int cantidad, String tipo) {

        bP = Datos(cod);
        int stock;
        if (tipo.equals("REDUCIR")) {
            stock = bP.getStock() - cantidad;
            msj = dP.Stock(cod, stock);

        } else if (tipo.equals("AUMENTAR")) {
            stock = bP.getStock() + cantidad;
            msj = dP.Stock(cod, stock);
        }
        return msj;
    }

    public int Contar() {

        int n = dP.Contar();
        return n;
    }

    public List MejoresProductos() {

        List<Producto> productos = new ArrayList<>();
        int[] cod = dP.MejoresProductos();

        for (int i = 0; i < cod.length; i++) {
            bP = dP.DatosProducto(cod[i]);
            productos.add(bP);
        }

        return productos;
    }

    public Producto LoMasNuevo() {

        bP = dP.LoMasNuevo();

        return bP;
    }
}
