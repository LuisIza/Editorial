/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.datamodel.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "usuarios_ea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosEa.findAll", query = "SELECT u FROM UsuariosEa u")
    , @NamedQuery(name = "UsuariosEa.findByEmail", query = "SELECT u FROM UsuariosEa u WHERE u.email = :email")
    , @NamedQuery(name = "UsuariosEa.findByNombre", query = "SELECT u FROM UsuariosEa u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "UsuariosEa.findByContrasenya", query = "SELECT u FROM UsuariosEa u WHERE u.contrasenya = :contrasenya")
    , @NamedQuery(name = "UsuariosEa.findByFechaAlta", query = "SELECT u FROM UsuariosEa u WHERE u.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "UsuariosEa.findByPermisos", query = "SELECT u FROM UsuariosEa u WHERE u.permisos = :permisos")})
public class UsuariosEa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "contrasenya")
    private String contrasenya;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "permisos")
    private String permisos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "email")
    private Collection<LibroPublicadoEa> libroPublicadoEaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<HistorialCompras> historialComprasCollection;

    public UsuariosEa() {
    }

    public UsuariosEa(String email) {
        this.email = email;
    }

    public UsuariosEa(String email, String nombre, String contrasenya, Date fechaAlta, String permisos) {
        this.email = email;
        this.nombre = nombre;
        this.contrasenya = contrasenya;
        this.fechaAlta = fechaAlta;
        this.permisos = permisos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<LibroPublicadoEa> getLibroPublicadoEaCollection() {
        return libroPublicadoEaCollection;
    }

    public void setLibroPublicadoEaCollection(Collection<LibroPublicadoEa> libroPublicadoEaCollection) {
        this.libroPublicadoEaCollection = libroPublicadoEaCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<HistorialCompras> getHistorialComprasCollection() {
        return historialComprasCollection;
    }

    public void setHistorialComprasCollection(Collection<HistorialCompras> historialComprasCollection) {
        this.historialComprasCollection = historialComprasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosEa)) {
            return false;
        }
        UsuariosEa other = (UsuariosEa) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa[ email=" + email + " ]";
    }
    
}
