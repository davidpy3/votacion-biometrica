/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nin
 */
@Entity
@Table(name = "candidato")
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c"),
    @NamedQuery(name = "Candidato.findByIdCandidatos", query = "SELECT c FROM Candidato c WHERE c.idCandidatos = :idCandidatos"),
    @NamedQuery(name = "Candidato.findByCanNombre", query = "SELECT c FROM Candidato c WHERE c.canNombre = :canNombre"),
    @NamedQuery(name = "Candidato.findByCanApellido", query = "SELECT c FROM Candidato c WHERE c.canApellido = :canApellido"),
    @NamedQuery(name = "Candidato.findByCanCi", query = "SELECT c FROM Candidato c WHERE c.canCi = :canCi"),
    @NamedQuery(name = "Candidato.findByCanFoto", query = "SELECT c FROM Candidato c WHERE c.canFoto = :canFoto"),
    @NamedQuery(name = "Candidato.findByFeInscripcion", query = "SELECT c FROM Candidato c WHERE c.feInscripcion = :feInscripcion")})
public class Candidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_candidatos")
    private Long idCandidatos;
    @Column(name = "can_nombre")
    private String canNombre;
    @Column(name = "can_apellido")
    private String canApellido;
    @Column(name = "can_ci")
    private String canCi;
    @Column(name = "can_foto")
    private String canFoto;
    @Column(name = "fe_inscripcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feInscripcion;
    @JoinColumn(name = "id_lis", referencedColumnName = "id_lista")
    @ManyToOne
    private Lista lista;
    @JoinColumn(name = "id_eleccion", referencedColumnName = "id_eleccion")
    @ManyToOne
    private Elecciontipo elecciontipo;
    @JoinColumn(name = "id_canDistrito", referencedColumnName = "id_dis")
    @ManyToOne
    private Distrito distrito;
    @JoinColumn(name = "id_candDepartamento", referencedColumnName = "id_dep")
    @ManyToOne
    private Departamento departamento;

    public Candidato() {
    }

    public Candidato(Long idCandidatos) {
        this.idCandidatos = idCandidatos;
    }

    public Long getIdCandidatos() {
        return idCandidatos;
    }

    public void setIdCandidatos(Long idCandidatos) {
        this.idCandidatos = idCandidatos;
    }

    public String getCanNombre() {
        return canNombre;
    }

    public void setCanNombre(String canNombre) {
        this.canNombre = canNombre;
    }

    public String getCanApellido() {
        return canApellido;
    }

    public void setCanApellido(String canApellido) {
        this.canApellido = canApellido;
    }

    public String getCanCi() {
        return canCi;
    }

    public void setCanCi(String canCi) {
        this.canCi = canCi;
    }

    public String getCanFoto() {
        return canFoto;
    }

    public void setCanFoto(String canFoto) {
        this.canFoto = canFoto;
    }

    public Date getFeInscripcion() {
        return feInscripcion;
    }

    public void setFeInscripcion(Date feInscripcion) {
        this.feInscripcion = feInscripcion;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Elecciontipo getElecciontipo() {
        return elecciontipo;
    }

    public void setElecciontipo(Elecciontipo elecciontipo) {
        this.elecciontipo = elecciontipo;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCandidatos != null ? idCandidatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.idCandidatos == null && other.idCandidatos != null) || (this.idCandidatos != null && !this.idCandidatos.equals(other.idCandidatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Candidato[idCandidatos=" + idCandidatos + "]";
    }

}
