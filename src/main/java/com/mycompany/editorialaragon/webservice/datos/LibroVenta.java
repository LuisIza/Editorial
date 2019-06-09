/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.webservice.datos;

import java.math.BigDecimal;

/**
 *
 * @author Luis
 */
public class LibroVenta {
    int id;
    String nombreLibro;
    String genero;
    String categoria;
    String descripcion;
    String autor;
    String editorial;
    String urlPortada;
    String idioma;
    String isbn;
    int paginas;
    BigDecimal digital;
    BigDecimal impreso;
    String urlLibro;

    public LibroVenta() {
    }

    public LibroVenta(int id, String nombreLibro, String genero, String categoria, String descripcion, String autor, String editorial, String urlPortada, String idioma, String isbn, int paginas, BigDecimal digital, BigDecimal impreso, String urlLibro) {
        this.id = id;
        this.nombreLibro = nombreLibro;
        this.genero = genero;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.autor = autor;
        this.editorial = editorial;
        this.urlPortada = urlPortada;
        this.idioma = idioma;
        this.isbn = isbn;
        this.paginas = paginas;
        this.digital = digital;
        this.impreso = impreso;
        this.urlLibro = urlLibro;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public BigDecimal getDigital() {
        return digital;
    }

    public void setDigital(BigDecimal digital) {
        this.digital = digital;
    }

    public BigDecimal getImpreso() {
        return impreso;
    }

    public void setImpreso(BigDecimal impreso) {
        this.impreso = impreso;
    }

    public String getUrlLibro() {
        return urlLibro;
    }

    public void setUrlLibro(String urlLibro) {
        this.urlLibro = urlLibro;
    }

    
}
