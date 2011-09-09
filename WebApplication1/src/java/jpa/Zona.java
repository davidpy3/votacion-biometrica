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
@Table(name = "zona")
@NamedQueries({
    @NamedQuery(name = "Zona.findAll", query = "SELECT z FROM Zona z"),
    @NamedQuery(name = "Zona.findByIdZona", query = "SELECT z FROM Zona z WHERE z.idZona = :idZona"),
    @NamedQuery(name = "Zona.findByZonaNombre", query = "SELECT z FROM Zona z WHERE z.zonaNombre = :zonaNombre")})
public class Zona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_zona")
    private Long idZona;
    @Column(name = "zona_nombre")
    private String zonaNombre;
    @OneToMany(mappedBy = "zona")
    private List<Localidad> localidadList;
    @JoinColumn(name = "id_distrito", referencedColumnName = "id_dis")
    @ManyToOne
    private Distrito distrito;

    public Zona() {
    }

    public Zona(Long idZona) {
        this.idZona = idZona;
    }

    public Long getIdZona() {
        return idZona;
    }

    public void setIdZona(Long idZona) {
        this.idZona = idZona;
    }

    public String getZonaNombre() {
        return zonaNombre;
    }

    public void setZonaNombre(String zonaNombre) {
        this.zonaNombre = zonaNombre;
    }

    public List<Localidad> getLocalidadList() {
        return localidadList;
    }

    public void setLocalidadList(List<Localidad> localidadList) {
        this.localidadList = localidadList;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZona != null ? idZona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zona)) {
            return false;
        }
        Zona other = (Zona) object;
        if ((this.idZona == null && other.idZona != null) || (this.idZona != null && !this.idZona.equals(other.idZona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Zona[idZona=" + idZona + "]";
    }

}
