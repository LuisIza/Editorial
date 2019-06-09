/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador;

/**
 *
 * @author Luis
 */
public class PrecioListado {
    
    String codigo;
    double precio;

    public PrecioListado(String codigo, double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }

    public PrecioListado() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
