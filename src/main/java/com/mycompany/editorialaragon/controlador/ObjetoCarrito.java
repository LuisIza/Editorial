/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador;

import java.math.BigDecimal;

/**
 *
 * @author Luis
 */
public class ObjetoCarrito {
    int codigoLibro;
    String nombre;
    String tipo;
    int catidad;
    BigDecimal precio;

    public ObjetoCarrito() {
    }

    public ObjetoCarrito(int codigoLibro, String nombre, String tipo, int catidad, BigDecimal precio) {
        this.codigoLibro = codigoLibro;
        this.nombre = nombre;
        this.tipo = tipo;
        this.catidad = catidad;
        this.precio = precio;
    }

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(int codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    
    
}
