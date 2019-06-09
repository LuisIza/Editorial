/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.datamodel.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "generos_ea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenerosEa.findAll", query = "SELECT g FROM GenerosEa g")
    , @NamedQuery(name = "GenerosEa.findById", query = "SELECT g FROM GenerosEa g WHERE g.id = :id")
    , @NamedQuery(name = "GenerosEa.findByGenero", query = "SELECT g FROM GenerosEa g WHERE g.genero = :genero")})
public class GenerosEa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "genero")
    private String genero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero")
    private Collection<CategoriasLibrosEa> categoriasLibrosEaCollection;

    public GenerosEa() {
    }

    public GenerosEa(Integer id) {
        this.id = id;
    }

    public GenerosEa(Integer id, String genero) {
        this.id = id;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<CategoriasLibrosEa> getCategoriasLibrosEaCollection() {
        return categoriasLibrosEaCollection;
    }

    public void setCategoriasLibrosEaCollection(Collection<CategoriasLibrosEa> categoriasLibrosEaCollection) {
        this.categoriasLibrosEaCollection = categoriasLibrosEaCollection;
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
        if (!(object instanceof GenerosEa)) {
            return false;
        }
        GenerosEa other = (GenerosEa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.editorialaragon.datamodel.entidades.GenerosEa[ id=" + id + " ]";
    }
    
}
