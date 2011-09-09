/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nin
 */
@Entity
@Table(name = "partidopolitico")
@NamedQueries({
    @NamedQuery(name = "Partidopolitico.findAll", query = "SELECT p FROM Partidopolitico p"),
    @NamedQuery(name = "Partidopolitico.findByIdPartido", query = "SELECT p FROM Partidopolitico p WHERE p.idPartido = :idPartido"),
    @NamedQuery(name = "Partidopolitico.findByPartNombre", query = "SELECT p FROM Partidopolitico p WHERE p.partNombre = :partNombre"),
    @NamedQuery(name = "Partidopolitico.findByPartSiglas", query = "SELECT p FROM Partidopolitico p WHERE p.partSiglas = :partSiglas"),
    @NamedQuery(name = "Partidopolitico.findByPartLema", query = "SELECT p FROM Partidopolitico p WHERE p.partLema = :partLema"),
    @NamedQuery(name = "Partidopolitico.findByPartColor", query = "SELECT p FROM Partidopolitico p WHERE p.partColor = :partColor")})
public class Partidopolitico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_partido")
    private Long idPartido;
    @Column(name = "part_nombre")
    private String partNombre;
    @Column(name = "part_siglas")
    private String partSiglas;
    @Column(name = "part_lema")
    private String partLema;
    @Column(name = "part_color")
    private String partColor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partidopolitico")
    private List<Lista> listaList;

    public Partidopolitico() {
    }

    public Partidopolitico(Long idPartido) {
        this.idPartido = idPartido;
    }

    public Long getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Long idPartido) {
        this.idPartido = idPartido;
    }

    public String getPartNombre() {
        return partNombre;
    }

    public void setPartNombre(String partNombre) {
        this.partNombre = partNombre;
    }

    public String getPartSiglas() {
        return partSiglas;
    }

    public void setPartSiglas(String partSiglas) {
        this.partSiglas = partSiglas;
    }

    public String getPartLema() {
        return partLema;
    }

    public void setPartLema(String partLema) {
        this.partLema = partLema;
    }

    public String getPartColor() {
        return partColor;
    }

    public void setPartColor(String partColor) {
        this.partColor = partColor;
    }

    public List<Lista> getListaList() {
        return listaList;
    }

    public void setListaList(List<Lista> listaList) {
        this.listaList = listaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartido != null ? idPartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partidopolitico)) {
            return false;
        }
        Partidopolitico other = (Partidopolitico) object;
        if ((this.idPartido == null && other.idPartido != null) || (this.idPartido != null && !this.idPartido.equals(other.idPartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Partidopolitico[idPartido=" + idPartido + "]";
    }

}
