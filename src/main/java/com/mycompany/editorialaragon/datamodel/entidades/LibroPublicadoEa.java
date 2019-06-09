/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.datamodel.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "libro_publicado_ea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibroPublicadoEa.findAll", query = "SELECT l FROM LibroPublicadoEa l")
    , @NamedQuery(name = "LibroPublicadoEa.findById", query = "SELECT l FROM LibroPublicadoEa l WHERE l.id = :id")
    , @NamedQuery(name = "LibroPublicadoEa.findByNombreLibro", query = "SELECT l FROM LibroPublicadoEa l WHERE l.nombreLibro = :nombreLibro")
    , @NamedQuery(name = "LibroPublicadoEa.findByAutor", query = "SELECT l FROM LibroPublicadoEa l WHERE l.autor = :autor")
    , @NamedQuery(name = "LibroPublicadoEa.findByGenero", query = "SELECT l FROM LibroPublicadoEa l WHERE l.genero = :genero")
    , @NamedQuery(name = "LibroPublicadoEa.findByCategoria", query = "SELECT l FROM LibroPublicadoEa l WHERE l.categoria = :categoria")
    , @NamedQuery(name = "LibroPublicadoEa.findByFechaAlta", query = "SELECT l FROM LibroPublicadoEa l WHERE l.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "LibroPublicadoEa.findByEstado", query = "SELECT l FROM LibroPublicadoEa l WHERE l.estado = :estado")
    , @NamedQuery(name = "LibroPublicadoEa.findByEditorial", query = "SELECT l FROM LibroPublicadoEa l WHERE l.editorial = :editorial")
    , @NamedQuery(name = "LibroPublicadoEa.findByIsbn", query = "SELECT l FROM LibroPublicadoEa l WHERE l.isbn = :isbn")
    , @NamedQuery(name = "LibroPublicadoEa.findByPaginas", query = "SELECT l FROM LibroPublicadoEa l WHERE l.paginas = :paginas")
    , @NamedQuery(name = "LibroPublicadoEa.findByIdioma", query = "SELECT l FROM LibroPublicadoEa l WHERE l.idioma = :idioma")
    , @NamedQuery(name = "LibroPublicadoEa.findByDigital", query = "SELECT l FROM LibroPublicadoEa l WHERE l.digital = :digital")
    , @NamedQuery(name = "LibroPublicadoEa.findByImpreso", query = "SELECT l FROM LibroPublicadoEa l WHERE l.impreso = :impreso")
    , @NamedQuery(name = "LibroPublicadoEa.findByPermanencia", query = "SELECT l FROM LibroPublicadoEa l WHERE l.permanencia = :permanencia")
    , @NamedQuery(name = "LibroPublicadoEa.findByUrlPortada", query = "SELECT l FROM LibroPublicadoEa l WHERE l.urlPortada = :urlPortada")})
public class LibroPublicadoEa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre_libro")
    private String nombreLibro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "categoria")
    private String categoria;
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
    @Size(max = 50)
    @Column(name = "editorial")
    private String editorial;
    @Size(max = 50)
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "paginas")
    private Integer paginas;
    @Size(max = 20)
    @Column(name = "idioma")
    private String idioma;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "digital")
    private BigDecimal digital;
    @Column(name = "impreso")
    private BigDecimal impreso;
    @Size(max = 5)
    @Column(name = "permanencia")
    private String permanencia;
    @Size(max = 200)
    @Column(name = "url_portada")
    private String urlPortada;
    @JoinColumn(name = "email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private UsuariosEa email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private Collection<HistorialCompras> historialComprasCollection;

    public LibroPublicadoEa() {
    }

    public LibroPublicadoEa(Integer id) {
        this.id = id;
    }

    public LibroPublicadoEa(Integer id, String nombreLibro, String descripcion, String autor, String genero, String categoria, Date fechaAlta, String estado) {
        this.id = id;
        this.nombreLibro = nombreLibro;
        this.descripcion = descripcion;
        this.autor = autor;
        this.genero = genero;
        this.categoria = categoria;
        this.fechaAlta = fechaAlta;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public BigDecimal getDigital() {
        return digital;
    }

    public void setDigital(BigDecimal digital) {
        this.digital = digital;
    }

    public BigDecimal getImpreso() {
        return impreso;
    }

    public void setImpreso(BigDecimal impreso) {
        this.impreso = impreso;
    }

    public String getPermanencia() {
        return permanencia;
    }

    public void setPermanencia(String permanencia) {
        this.permanencia = permanencia;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

    public UsuariosEa getEmail() {
        return email;
    }

    public void setEmail(UsuariosEa email) {
        this.email = email;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroPublicadoEa)) {
            return false;
        }
        LibroPublicadoEa other = (LibroPublicadoEa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.editorialaragon.datamodel.entidades.LibroPublicadoEa[ id=" + id + " ]";
    }
    
}
