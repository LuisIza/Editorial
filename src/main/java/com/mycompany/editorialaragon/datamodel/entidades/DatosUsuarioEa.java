/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.datamodel.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "datos_usuario_ea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosUsuarioEa.findAll", query = "SELECT d FROM DatosUsuarioEa d")
    , @NamedQuery(name = "DatosUsuarioEa.findById", query = "SELECT d FROM DatosUsuarioEa d WHERE d.id = :id")
    , @NamedQuery(name = "DatosUsuarioEa.findByNombre", query = "SELECT d FROM DatosUsuarioEa d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DatosUsuarioEa.findByApellidos", query = "SELECT d FROM DatosUsuarioEa d WHERE d.apellidos = :apellidos")
    , @NamedQuery(name = "DatosUsuarioEa.findByTelefono", query = "SELECT d FROM DatosUsuarioEa d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "DatosUsuarioEa.findByEmail", query = "SELECT d FROM DatosUsuarioEa d WHERE d.email = :email")
    , @NamedQuery(name = "DatosUsuarioEa.findByDireccion", query = "SELECT d FROM DatosUsuarioEa d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "DatosUsuarioEa.findByCp", query = "SELECT d FROM DatosUsuarioEa d WHERE d.cp = :cp")
    , @NamedQuery(name = "DatosUsuarioEa.findByPoblacion", query = "SELECT d FROM DatosUsuarioEa d WHERE d.poblacion = :poblacion")
    , @NamedQuery(name = "DatosUsuarioEa.findByPais", query = "SELECT d FROM DatosUsuarioEa d WHERE d.pais = :pais")})
public class DatosUsuarioEa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 80)
    @Column(name = "email")
    private String email;
    @Size(max = 250)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 10)
    @Column(name = "cp")
    private String cp;
    @Size(max = 80)
    @Column(name = "poblacion")
    private String poblacion;
    @Size(max = 80)
    @Column(name = "pais")
    private String pais;
    @JoinColumn(name = "cliente", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private UsuariosEa cliente;

    public DatosUsuarioEa() {
    }

    public DatosUsuarioEa(Integer id) {
        this.id = id;
    }

    public DatosUsuarioEa(Integer id, String nombre, String apellidos, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public UsuariosEa getCliente() {
        return cliente;
    }

    public void setCliente(UsuariosEa cliente) {
        this.cliente = cliente;
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
        if (!(object instanceof DatosUsuarioEa)) {
            return false;
        }
        DatosUsuarioEa other = (DatosUsuarioEa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.editorialaragon.datamodel.entidades.DatosUsuarioEa[ id=" + id + " ]";
    }
    
}
