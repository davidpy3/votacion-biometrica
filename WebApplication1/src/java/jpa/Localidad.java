/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nin
 */
@Entity
@Table(name = "localidad")
@NamedQueries({
    @NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l"),
    @NamedQuery(name = "Localidad.findByIdLo", query = "SELECT l FROM Localidad l WHERE l.idLo = :idLo"),
    @NamedQuery(name = "Localidad.findByLoNombre", query = "SELECT l FROM Localidad l WHERE l.loNombre = :loNombre")})
public class Localidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_lo")
    private Long idLo;
    @Column(name = "lo_nombre")
    private String loNombre;
    @JoinColumn(name = "id_zona", referencedColumnName = "id_zona")
    @ManyToOne
    private Zona zona;
    @OneToMany(mappedBy = "localidad")
    private List<Mesas> mesasList;
    @OneToMany(mappedBy = "localidad")
    private List<Elector> electorList;

    public Localidad() {
    }

    public Localidad(Long idLo) {
        this.idLo = idLo;
    }

    public Long getIdLo() {
        return idLo;
    }

    public void setIdLo(Long idLo) {
        this.idLo = idLo;
    }

    public String getLoNombre() {
        return loNombre;
    }

    public void setLoNombre(String loNombre) {
        this.loNombre = loNombre;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public List<Mesas> getMesasList() {
        return mesasList;
    }

    public void setMesasList(List<Mesas> mesasList) {
        this.mesasList = mesasList;
    }

    public List<Elector> getElectorList() {
        return electorList;
    }

    public void setElectorList(List<Elector> electorList) {
        this.electorList = electorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLo != null ? idLo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.idLo == null && other.idLo != null) || (this.idLo != null && !this.idLo.equals(other.idLo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Localidad[idLo=" + idLo + "]";
    }

}
