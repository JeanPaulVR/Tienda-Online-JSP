/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author Jean Paul
 */
public class Producto {
    private int codigo;
    private String nombre;
    private InputStream imgP;
    private InputStream img;
    private byte [] imagenP;
    private byte [] imagen;
    private double precio;
    private int stock;
    private int codCat;
    private int ptosG;
    
    private String nomCat;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public InputStream getImg() {
        return img;
    }

    public void setImg(InputStream img) {
        this.img = img;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public InputStream getImgP() {
        return imgP;
    }

    public void setImgP(InputStream imgP) {
        this.imgP = imgP;
    }

    public byte[] getImagenP() {
        return imagenP;
    }

    public void setImagenP(byte[] imagenP) {
        this.imagenP = imagenP;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodCat() {
        return codCat;
    }

    public void setCodCat(int cadCat) {
        this.codCat = cadCat;
    }

    public int getPtosG() {
        return ptosG;
    }

    public void setPtosG(int ptosG) {
        this.ptosG = ptosG;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }
}
