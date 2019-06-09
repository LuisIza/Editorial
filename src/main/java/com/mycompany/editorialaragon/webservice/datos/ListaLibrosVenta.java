/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.webservice.datos;

import java.util.List;

/**
 *
 * @author Luis
 */
public class ListaLibrosVenta {
    private List<LibroVenta> libros;
    private boolean confirm;

    public ListaLibrosVenta() {
    }

    public ListaLibrosVenta(List<LibroVenta> libros, boolean confirm) {
        this.libros = libros;
        this.confirm = confirm;
    }

    public List<LibroVenta> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroVenta> libros) {
        this.libros = libros;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

}
