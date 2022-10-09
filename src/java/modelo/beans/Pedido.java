/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

import java.sql.Date;

/**
 *
 * @author Jean Paul
 */
public class Pedido {
    private int codigo;
    private int codigoU;
    private Date fechaC;
    private Date fechaE;
    private double total;
    private String estado;
    private int ptosCanje;
    private double totalNeto;
    private int totalptosG;
    
    private String nomUsu;
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoU() {
        return codigoU;
    }

    public void setCodigoU(int codigoU) {
        this.codigoU = codigoU;
    }

    public Date getFechaC() {
        return fechaC;
    }

    public void setFechaC(Date fechaC) {
        this.fechaC = fechaC;
    }

    public Date getFechaE() {
        return fechaE;
    }

    public void setFechaE(Date fechaE) {
        this.fechaE = fechaE;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPtosCanje() {
        return ptosCanje;
    }

    public void setPtosCanje(int ptosCanje) {
        this.ptosCanje = ptosCanje;
    }

    public double getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(double totalNeto) {
        this.totalNeto = totalNeto;
    }

    public int getTotalptosG() {
        return totalptosG;
    }

    public void setTotalptosG(int totalptosG) {
        this.totalptosG = totalptosG;
    }

    public String getNomUsu() {
        return nomUsu;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }
}
