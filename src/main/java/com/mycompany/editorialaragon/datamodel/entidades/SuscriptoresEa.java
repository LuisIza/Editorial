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
@Table(name = "suscriptores_ea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuscriptoresEa.findAll", query = "SELECT s FROM SuscriptoresEa s")
    , @NamedQuery(name = "SuscriptoresEa.findById", query = "SELECT s FROM SuscriptoresEa s WHERE s.id = :id")
    , @NamedQuery(name = "SuscriptoresEa.findByNombre", query = "SELECT s FROM SuscriptoresEa s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SuscriptoresEa.findByEmail", query = "SELECT s FROM SuscriptoresEa s WHERE s.email = :email")
    , @NamedQuery(name = "SuscriptoresEa.findByFechaAlta", query = "SELECT s FROM SuscriptoresEa s WHERE s.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "SuscriptoresEa.findByLibro", query = "SELECT s FROM SuscriptoresEa s WHERE s.libro = :libro")
    , @NamedQuery(name = "SuscriptoresEa.findByEstado", query = "SELECT s FROM SuscriptoresEa s WHERE s.estado = :estado")})
public class SuscriptoresEa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "libro")
    private int libro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;

    public SuscriptoresEa() {
    }

    public SuscriptoresEa(Integer id) {
        this.id = id;
    }

    public SuscriptoresEa(Integer id, String nombre, String email, Date fechaAlta, int libro, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.libro = libro;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getLibro() {
        return libro;
    }

    public void setLibro(int libro) {
        this.libro = libro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof SuscriptoresEa)) {
            return false;
        }
        SuscriptoresEa other = (SuscriptoresEa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.editorialaragon.datamodel.entidades.SuscriptoresEa[ id=" + id + " ]";
    }
    
}
