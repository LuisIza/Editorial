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
@Table(name = "archivos_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchivosCliente.findAll", query = "SELECT a FROM ArchivosCliente a")
    , @NamedQuery(name = "ArchivosCliente.findById", query = "SELECT a FROM ArchivosCliente a WHERE a.id = :id")
    , @NamedQuery(name = "ArchivosCliente.findByIdHistorial", query = "SELECT a FROM ArchivosCliente a WHERE a.idHistorial = :idHistorial")
    , @NamedQuery(name = "ArchivosCliente.findByUrlArchivo", query = "SELECT a FROM ArchivosCliente a WHERE a.urlArchivo = :urlArchivo")
    , @NamedQuery(name = "ArchivosCliente.findByNombre", query = "SELECT a FROM ArchivosCliente a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "ArchivosCliente.findByFechaAlta", query = "SELECT a FROM ArchivosCliente a WHERE a.fechaAlta = :fechaAlta")})
public class ArchivosCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_historial")
    private int idHistorial;
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
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    public ArchivosCliente() {
    }

    public ArchivosCliente(Integer id) {
        this.id = id;
    }

    public ArchivosCliente(Integer id, int idHistorial, String urlArchivo, String nombre, Date fechaAlta) {
        this.id = id;
        this.idHistorial = idHistorial;
        this.urlArchivo = urlArchivo;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
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

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
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
        if (!(object instanceof ArchivosCliente)) {
            return false;
        }
        ArchivosCliente other = (ArchivosCliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.editorialaragon.datamodel.entidades.ArchivosCliente[ id=" + id + " ]";
    }
    
}
