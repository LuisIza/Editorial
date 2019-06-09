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
public class ListaLibros {
    private List <LibroCliente> libro;
    private boolean confirm;

    public ListaLibros() {
    }

    public ListaLibros(List<LibroCliente> libro, boolean confirm) {
        this.libro = libro;
        this.confirm = confirm;
    }

    public List<LibroCliente> getLibro() {
        return libro;
    }

    public void setLibro(List<LibroCliente> libro) {
        this.libro = libro;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

   

    
    
    
}
