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
@Table(name = "mesas")
@NamedQueries({
    @NamedQuery(name = "Mesas.findAll", query = "SELECT m FROM Mesas m"),
    @NamedQuery(name = "Mesas.findByIdMesas", query = "SELECT m FROM Mesas m WHERE m.idMesas = :idMesas"),
    @NamedQuery(name = "Mesas.findByMeNombre", query = "SELECT m FROM Mesas m WHERE m.meNombre = :meNombre")})
public class Mesas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_mesas")
    private Long idMesas;
    @Column(name = "me_nombre")
    private String meNombre;
    @JoinColumn(name = "id_local", referencedColumnName = "id_lo")
    @ManyToOne
    private Localidad localidad;
    @OneToMany(mappedBy = "mesas")
    private List<Elector> electorList;

    public Mesas() {
    }

    public Mesas(Long idMesas) {
        this.idMesas = idMesas;
    }

    public Long getIdMesas() {
        return idMesas;
    }

    public void setIdMesas(Long idMesas) {
        this.idMesas = idMesas;
    }

    public String getMeNombre() {
        return meNombre;
    }

    public void setMeNombre(String meNombre) {
        this.meNombre = meNombre;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
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
        hash += (idMesas != null ? idMesas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesas)) {
            return false;
        }
        Mesas other = (Mesas) object;
        if ((this.idMesas == null && other.idMesas != null) || (this.idMesas != null && !this.idMesas.equals(other.idMesas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Mesas[idMesas=" + idMesas + "]";
    }

}
