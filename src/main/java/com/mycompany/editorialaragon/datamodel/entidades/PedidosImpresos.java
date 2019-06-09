/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.datamodel.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "pedidos_impresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidosImpresos.findAll", query = "SELECT p FROM PedidosImpresos p")
    , @NamedQuery(name = "PedidosImpresos.findById", query = "SELECT p FROM PedidosImpresos p WHERE p.id = :id")
    , @NamedQuery(name = "PedidosImpresos.findByCliente", query = "SELECT p FROM PedidosImpresos p WHERE p.cliente = :cliente")
    , @NamedQuery(name = "PedidosImpresos.findByReferencia", query = "SELECT p FROM PedidosImpresos p WHERE p.referencia = :referencia")
    , @NamedQuery(name = "PedidosImpresos.findByUrlArchivocliente", query = "SELECT p FROM PedidosImpresos p WHERE p.urlArchivocliente = :urlArchivocliente")
    , @NamedQuery(name = "PedidosImpresos.findByProducto", query = "SELECT p FROM PedidosImpresos p WHERE p.producto = :producto")
    , @NamedQuery(name = "PedidosImpresos.findByCantidad", query = "SELECT p FROM PedidosImpresos p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "PedidosImpresos.findByPaginas", query = "SELECT p FROM PedidosImpresos p WHERE p.paginas = :paginas")
    , @NamedQuery(name = "PedidosImpresos.findByPrecio", query = "SELECT p FROM PedidosImpresos p WHERE p.precio = :precio")
    , @NamedQuery(name = "PedidosImpresos.findByFechaAlta", query = "SELECT p FROM PedidosImpresos p WHERE p.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "PedidosImpresos.findByEstado", query = "SELECT p FROM PedidosImpresos p WHERE p.estado = :estado")
    , @NamedQuery(name = "PedidosImpresos.findByConfirmacion", query = "SELECT p FROM PedidosImpresos p WHERE p.confirmacion = :confirmacion")
    , @NamedQuery(name = "PedidosImpresos.findByFechaCorfirmacion", query = "SELECT p FROM PedidosImpresos p WHERE p.fechaCorfirmacion = :fechaCorfirmacion")})
public class PedidosImpresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "cliente")
    private String cliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "url_archivocliente")
    private String urlArchivocliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "producto")
    private String producto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paginas")
    private int paginas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "estado")
    private String estado;
    @Size(max = 20)
    @Column(name = "confirmacion")
    private String confirmacion;
    @Column(name = "fecha_corfirmacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCorfirmacion;

    public PedidosImpresos() {
    }

    public PedidosImpresos(Integer id) {
        this.id = id;
    }

    public PedidosImpresos(Integer id, String cliente, String referencia, String urlArchivocliente, String producto, int cantidad, int paginas, BigDecimal precio, Date fechaAlta, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.referencia = referencia;
        this.urlArchivocliente = urlArchivocliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.paginas = paginas;
        this.precio = precio;
        this.fechaAlta = fechaAlta;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getUrlArchivocliente() {
        return urlArchivocliente;
    }

    public void setUrlArchivocliente(String urlArchivocliente) {
        this.urlArchivocliente = urlArchivocliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public Date getFechaCorfirmacion() {
        return fechaCorfirmacion;
    }

    public void setFechaCorfirmacion(Date fechaCorfirmacion) {
        this.fechaCorfirmacion = fechaCorfirmacion;
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
        if (!(object instanceof PedidosImpresos)) {
            return false;
        }
        PedidosImpresos other = (PedidosImpresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.editorialaragon.datamodel.entidades.PedidosImpresos[ id=" + id + " ]";
    }
    
}
