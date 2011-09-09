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
@Table(name = "distrito")
@NamedQueries({
    @NamedQuery(name = "Distrito.findAll", query = "SELECT d FROM Distrito d"),
    @NamedQuery(name = "Distrito.findByIdDis", query = "SELECT d FROM Distrito d WHERE d.idDis = :idDis"),
    @NamedQuery(name = "Distrito.findByDisNombre", query = "SELECT d FROM Distrito d WHERE d.disNombre = :disNombre")})
public class Distrito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_dis")
    private Long idDis;
    @Column(name = "dis_nombre")
    private String disNombre;
    @OneToMany(mappedBy = "distrito")
    private List<Candidato> candidatoList;
    @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")
    @ManyToOne
    private Departamento departamento;
    @OneToMany(mappedBy = "distrito")
    private List<Zona> zonaList;

    public Distrito() {
    }

    public Distrito(Long idDis) {
        this.idDis = idDis;
    }

    public Long getIdDis() {
        return idDis;
    }

    public void setIdDis(Long idDis) {
        this.idDis = idDis;
    }

    public String getDisNombre() {
        return disNombre;
    }

    public void setDisNombre(String disNombre) {
        this.disNombre = disNombre;
    }

    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }

    public void setCandidatoList(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Zona> getZonaList() {
        return zonaList;
    }

    public void setZonaList(List<Zona> zonaList) {
        this.zonaList = zonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDis != null ? idDis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distrito)) {
            return false;
        }
        Distrito other = (Distrito) object;
        if ((this.idDis == null && other.idDis != null) || (this.idDis != null && !this.idDis.equals(other.idDis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Distrito[idDis=" + idDis + "]";
    }

}
