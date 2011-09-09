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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nin
 */
@Entity
@Table(name = "profesion")
@NamedQueries({
    @NamedQuery(name = "Profesion.findAll", query = "SELECT p FROM Profesion p"),
    @NamedQuery(name = "Profesion.findByIdProfe", query = "SELECT p FROM Profesion p WHERE p.idProfe = :idProfe"),
    @NamedQuery(name = "Profesion.findByProNombre", query = "SELECT p FROM Profesion p WHERE p.proNombre = :proNombre")})
public class Profesion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_profe")
    private Long idProfe;
    @Column(name = "pro_nombre")
    private String proNombre;
    @OneToMany(mappedBy = "profesion")
    private List<Elector> electorList;

    public Profesion() {
    }

    public Profesion(Long idProfe) {
        this.idProfe = idProfe;
    }

    public Long getIdProfe() {
        return idProfe;
    }

    public void setIdProfe(Long idProfe) {
        this.idProfe = idProfe;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
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
        hash += (idProfe != null ? idProfe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesion)) {
            return false;
        }
        Profesion other = (Profesion) object;
        if ((this.idProfe == null && other.idProfe != null) || (this.idProfe != null && !this.idProfe.equals(other.idProfe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Profesion[idProfe=" + idProfe + "]";
    }

}
