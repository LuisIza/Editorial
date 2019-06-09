/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.datamodel.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "productos_ea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosEa.findAll", query = "SELECT p FROM ProductosEa p")
    , @NamedQuery(name = "ProductosEa.findById", query = "SELECT p FROM ProductosEa p WHERE p.id = :id")
    , @NamedQuery(name = "ProductosEa.findByTipo", query = "SELECT p FROM ProductosEa p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "ProductosEa.findByTapaProducto", query = "SELECT p FROM ProductosEa p WHERE p.tapaProducto = :tapaProducto")
    , @NamedQuery(name = "ProductosEa.findByEncuadernado", query = "SELECT p FROM ProductosEa p WHERE p.encuadernado = :encuadernado")
    , @NamedQuery(name = "ProductosEa.findByTamanyoLibro", query = "SELECT p FROM ProductosEa p WHERE p.tamanyoLibro = :tamanyoLibro")
    , @NamedQuery(name = "ProductosEa.findByCalidadPapel", query = "SELECT p FROM ProductosEa p WHERE p.calidadPapel = :calidadPapel")
    , @NamedQuery(name = "ProductosEa.findByColorInterior", query = "SELECT p FROM ProductosEa p WHERE p.colorInterior = :colorInterior")
    , @NamedQuery(name = "ProductosEa.findByIva", query = "SELECT p FROM ProductosEa p WHERE p.iva = :iva")
    , @NamedQuery(name = "ProductosEa.findByPrecio", query = "SELECT p FROM ProductosEa p WHERE p.precio = :precio")})
public class ProductosEa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "tapa_producto")
    private String tapaProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "encuadernado")
    private String encuadernado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "tamanyo_libro")
    private String tamanyoLibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "calidad_papel")
    private String calidadPapel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "color_interior")
    private String colorInterior;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva")
    private BigDecimal iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;

    public ProductosEa() {
    }

    public ProductosEa(String id) {
        this.id = id;
    }

    public ProductosEa(String id, String tipo, String tapaProducto, String encuadernado, String tamanyoLibro, String calidadPapel, String colorInterior, BigDecimal iva, BigDecimal precio) {
        this.id = id;
        this.tipo = tipo;
        this.tapaProducto = tapaProducto;
        this.encuadernado = encuadernado;
        this.tamanyoLibro = tamanyoLibro;
        this.calidadPapel = calidadPapel;
        this.colorInterior = colorInterior;
        this.iva = iva;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTapaProducto() {
        return tapaProducto;
    }

    public void setTapaProducto(String tapaProducto) {
        this.tapaProducto = tapaProducto;
    }

    public String getEncuadernado() {
        return encuadernado;
    }

    public void setEncuadernado(String encuadernado) {
        this.encuadernado = encuadernado;
    }

    public String getTamanyoLibro() {
        return tamanyoLibro;
    }

    public void setTamanyoLibro(String tamanyoLibro) {
        this.tamanyoLibro = tamanyoLibro;
    }

    public String getCalidadPapel() {
        return calidadPapel;
    }

    public void setCalidadPapel(String calidadPapel) {
        this.calidadPapel = calidadPapel;
    }

    public String getColorInterior() {
        return colorInterior;
    }

    public void setColorInterior(String colorInterior) {
        this.colorInterior = colorInterior;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosEa)) {
            return false;
        }
        ProductosEa other = (ProductosEa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.editorialaragon.datamodel.entidades.ProductosEa[ id=" + id + " ]";
    }
    
}
