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
@Table(name = "lista")
@NamedQueries({
    @NamedQuery(name = "Lista.findAll", query = "SELECT l FROM Lista l"),
    @NamedQuery(name = "Lista.findByIdLista", query = "SELECT l FROM Lista l WHERE l.idLista = :idLista"),
    @NamedQuery(name = "Lista.findByLisNombre", query = "SELECT l FROM Lista l WHERE l.lisNombre = :lisNombre"),
    @NamedQuery(name = "Lista.findByContador", query = "SELECT l FROM Lista l WHERE l.contador = :contador")})
public class Lista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_lista")
    private Long idLista;
    @Column(name = "lis_nombre")
    private String lisNombre;
    @Column(name = "contador")
    private Integer contador;
    @OneToMany(mappedBy = "lista")
    private List<Candidato> candidatoList;
    @JoinColumn(name = "id_part", referencedColumnName = "id_partido")
    @ManyToOne(optional = false)
    private Partidopolitico partidopolitico;

    public Lista() {
    }

    public Lista(Long idLista) {
        this.idLista = idLista;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public String getLisNombre() {
        return lisNombre;
    }

    public void setLisNombre(String lisNombre) {
        this.lisNombre = lisNombre;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }

    public void setCandidatoList(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }

    public Partidopolitico getPartidopolitico() {
        return partidopolitico;
    }

    public void setPartidopolitico(Partidopolitico partidopolitico) {
        this.partidopolitico = partidopolitico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lista)) {
            return false;
        }
        Lista other = (Lista) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Lista[idLista=" + idLista + "]";
    }

}
