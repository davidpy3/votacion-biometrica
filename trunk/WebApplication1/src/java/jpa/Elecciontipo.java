/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nin
 */
@Entity
@Table(name = "elecciontipo")
@NamedQueries({
    @NamedQuery(name = "Elecciontipo.findAll", query = "SELECT e FROM Elecciontipo e"),
    @NamedQuery(name = "Elecciontipo.findByIdEleccion", query = "SELECT e FROM Elecciontipo e WHERE e.idEleccion = :idEleccion"),
    @NamedQuery(name = "Elecciontipo.findByElecNombre", query = "SELECT e FROM Elecciontipo e WHERE e.elecNombre = :elecNombre"),
    @NamedQuery(name = "Elecciontipo.findByElecFecha", query = "SELECT e FROM Elecciontipo e WHERE e.elecFecha = :elecFecha")})
public class Elecciontipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_eleccion")
    private Long idEleccion;
    @Column(name = "elec_nombre")
    private String elecNombre;
    @Column(name = "elec_fecha")
    @Temporal(TemporalType.DATE)
    private Date elecFecha;
    @OneToMany(mappedBy = "elecciontipo")
    private List<Candidato> candidatoList;
    @OneToMany(mappedBy = "elecciontipo")
    private List<TiposVotos> tiposVotosList;

    public Elecciontipo() {
    }

    public Elecciontipo(Long idEleccion) {
        this.idEleccion = idEleccion;
    }

    public Long getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(Long idEleccion) {
        this.idEleccion = idEleccion;
    }

    public String getElecNombre() {
        return elecNombre;
    }

    public void setElecNombre(String elecNombre) {
        this.elecNombre = elecNombre;
    }

    public Date getElecFecha() {
        return elecFecha;
    }

    public void setElecFecha(Date elecFecha) {
        this.elecFecha = elecFecha;
    }

    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }

    public void setCandidatoList(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }

    public List<TiposVotos> getTiposVotosList() {
        return tiposVotosList;
    }

    public void setTiposVotosList(List<TiposVotos> tiposVotosList) {
        this.tiposVotosList = tiposVotosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEleccion != null ? idEleccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elecciontipo)) {
            return false;
        }
        Elecciontipo other = (Elecciontipo) object;
        if ((this.idEleccion == null && other.idEleccion != null) || (this.idEleccion != null && !this.idEleccion.equals(other.idEleccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Elecciontipo[idEleccion=" + idEleccion + "]";
    }

}
