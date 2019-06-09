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
@Table(name = "archivos_libro_ea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchivosLibroEa.findAll", query = "SELECT a FROM ArchivosLibroEa a")
    , @NamedQuery(name = "ArchivosLibroEa.findById", query = "SELECT a FROM ArchivosLibroEa a WHERE a.id = :id")
    , @NamedQuery(name = "ArchivosLibroEa.findByUrlArchivo", query = "SELECT a FROM ArchivosLibroEa a WHERE a.urlArchivo = :urlArchivo")
    , @NamedQuery(name = "ArchivosLibroEa.findByNombre", query = "SELECT a FROM ArchivosLibroEa a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "ArchivosLibroEa.findByTipoArchivo", query = "SELECT a FROM ArchivosLibroEa a WHERE a.tipoArchivo = :tipoArchivo")
    , @NamedQuery(name = "ArchivosLibroEa.findByFechaAlta", query = "SELECT a FROM ArchivosLibroEa a WHERE a.fechaAlta = :fechaAlta")})
public class ArchivosLibroEa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "url_archivo")
    private String urlArchivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tipo_archivo")
    private String tipoArchivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @JoinColumn(name = "id_publicidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LibroPublicadoEa idPublicidad;

    public ArchivosLibroEa() {
    }

    public ArchivosLibroEa(Integer id) {
        this.id = id;
    }

    public ArchivosLibroEa(Integer id, String urlArchivo, String nombre, String tipoArchivo, Date fechaAlta) {
        this.id = id;
        this.urlArchivo = urlArchivo;
        this.nombre = nombre;
        this.tipoArchivo = tipoArchivo;
        this.fechaAlta = fechaAlta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LibroPublicadoEa getIdPublicidad() {
        return idPublicidad;
    }

    public void setIdPublicidad(LibroPublicadoEa idPublicidad) {
        this.idPublicidad = idPublicidad;
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
        if (!(object instanceof ArchivosLibroEa)) {
            return false;
        }
        ArchivosLibroEa other = (ArchivosLibroEa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.editorialaragon.datamodel.entidades.ArchivosLibroEa[ id=" + id + " ]";
    }
    
}
