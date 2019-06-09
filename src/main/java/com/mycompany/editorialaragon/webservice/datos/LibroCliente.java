/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.webservice.datos;

/**
 *
 * @author Luis
 */
public class LibroCliente {
    int id;
    String nombreLibro;
    String categoria;
    String descripcion;
    String autor;
    String editorial;
    String urlPortada;

    public LibroCliente() {
    }

    public LibroCliente(int id, String nombreLibro, String categoria, String descripcion, String autor, String editorial, String urlPortada) {
        this.id = id;
        this.nombreLibro = nombreLibro;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.autor = autor;
        this.editorial = editorial;
        this.urlPortada = urlPortada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }
    
    
}
