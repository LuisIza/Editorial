/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.datamodel.entidades;

import java.io.Serializable;
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
@Table(name = "codigos_libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigosLibros.findAll", query = "SELECT c FROM CodigosLibros c")
    , @NamedQuery(name = "CodigosLibros.findById", query = "SELECT c FROM CodigosLibros c WHERE c.id = :id")
    , @NamedQuery(name = "CodigosLibros.findByReferencia", query = "SELECT c FROM CodigosLibros c WHERE c.referencia = :referencia")
    , @NamedQuery(name = "CodigosLibros.findByCodigo", query = "SELECT c FROM CodigosLibros c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "CodigosLibros.findByFechaInicio", query = "SELECT c FROM CodigosLibros c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "CodigosLibros.findByFechaFin", query = "SELECT c FROM CodigosLibros c WHERE c.fechaFin = :fechaFin")})
public class CodigosLibros implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    public CodigosLibros() {
    }

    public CodigosLibros(Integer id) {
        this.id = id;
    }

    public CodigosLibros(Integer id, String referencia, String codigo, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.referencia = referencia;
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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
        if (!(object instanceof CodigosLibros)) {
            return false;
        }
        CodigosLibros other = (CodigosLibros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.editorialaragon.datamodel.entidades.CodigosLibros[ id=" + id + " ]";
    }
    
}
