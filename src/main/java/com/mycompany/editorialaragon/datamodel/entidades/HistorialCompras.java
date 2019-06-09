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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "historial_compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialCompras.findAll", query = "SELECT h FROM HistorialCompras h")
    , @NamedQuery(name = "HistorialCompras.findById", query = "SELECT h FROM HistorialCompras h WHERE h.id = :id")
    , @NamedQuery(name = "HistorialCompras.findByReferencia", query = "SELECT h FROM HistorialCompras h WHERE h.referencia = :referencia")
    , @NamedQuery(name = "HistorialCompras.findByDatosCliente", query = "SELECT h FROM HistorialCompras h WHERE h.datosCliente = :datosCliente")
    , @NamedQuery(name = "HistorialCompras.findByFecha", query = "SELECT h FROM HistorialCompras h WHERE h.fecha = :fecha")
    , @NamedQuery(name = "HistorialCompras.findByCantidad", query = "SELECT h FROM HistorialCompras h WHERE h.cantidad = :cantidad")
    , @NamedQuery(name = "HistorialCompras.findByPrecioBase", query = "SELECT h FROM HistorialCompras h WHERE h.precioBase = :precioBase")
    , @NamedQuery(name = "HistorialCompras.findByIvaBase", query = "SELECT h FROM HistorialCompras h WHERE h.ivaBase = :ivaBase")
    , @NamedQuery(name = "HistorialCompras.findByPrecioTotal", query = "SELECT h FROM HistorialCompras h WHERE h.precioTotal = :precioTotal")
    , @NamedQuery(name = "HistorialCompras.findByEstado", query = "SELECT h FROM HistorialCompras h WHERE h.estado = :estado")
    , @NamedQuery(name = "HistorialCompras.findByConfirmacion", query = "SELECT h FROM HistorialCompras h WHERE h.confirmacion = :confirmacion")
    , @NamedQuery(name = "HistorialCompras.findByFechaCorfirmacion", query = "SELECT h FROM HistorialCompras h WHERE h.fechaCorfirmacion = :fechaCorfirmacion")})
public class HistorialCompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "datos_cliente")
    private Integer datosCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_base")
    private BigDecimal precioBase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva_base")
    private BigDecimal ivaBase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_total")
    private BigDecimal precioTotal;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @Size(max = 20)
    @Column(name = "confirmacion")
    private String confirmacion;
    @Column(name = "fecha_corfirmacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCorfirmacion;
    @JoinColumn(name = "cliente", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private UsuariosEa cliente;
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LibroPublicadoEa productoId;

    public HistorialCompras() {
    }

    public HistorialCompras(Integer id) {
        this.id = id;
    }

    public HistorialCompras(Integer id, String referencia, Date fecha, int cantidad, BigDecimal precioBase, BigDecimal ivaBase, BigDecimal precioTotal) {
        this.id = id;
        this.referencia = referencia;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precioBase = precioBase;
        this.ivaBase = ivaBase;
        this.precioTotal = precioTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(Integer datosCliente) {
        this.datosCliente = datosCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public BigDecimal getIvaBase() {
        return ivaBase;
    }

    public void setIvaBase(BigDecimal ivaBase) {
        this.ivaBase = ivaBase;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
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

    public UsuariosEa getCliente() {
        return cliente;
    }

    public void setCliente(UsuariosEa cliente) {
        this.cliente = cliente;
    }

    public LibroPublicadoEa getProductoId() {
        return productoId;
    }

    public void setProductoId(LibroPublicadoEa productoId) {
        this.productoId = productoId;
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
        if (!(object instanceof HistorialCompras)) {
            return false;
        }
        HistorialCompras other = (HistorialCompras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.editorialaragon.datamodel.entidades.HistorialCompras[ id=" + id + " ]";
    }
    
}
