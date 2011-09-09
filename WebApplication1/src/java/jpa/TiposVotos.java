/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author nin
 */
@Entity
@Table(name = "tiposVotos")
@NamedQueries({
    @NamedQuery(name = "TiposVotos.findAll", query = "SELECT t FROM TiposVotos t"),
    @NamedQuery(name = "TiposVotos.findByIdVoto", query = "SELECT t FROM TiposVotos t WHERE t.idVoto = :idVoto"),
    @NamedQuery(name = "TiposVotos.findByVoDescripcion", query = "SELECT t FROM TiposVotos t WHERE t.voDescripcion = :voDescripcion"),
    @NamedQuery(name = "TiposVotos.findByVocontadorFinal", query = "SELECT t FROM TiposVotos t WHERE t.vocontadorFinal = :vocontadorFinal")})
public class TiposVotos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_voto")
    private Long idVoto;
    @Column(name = "vo_descripcion")
    private String voDescripcion;
    @Column(name = "vo_contadorFinal")
    private BigInteger vocontadorFinal;
    @JoinColumn(name = "id_eleccion", referencedColumnName = "id_eleccion")
    @ManyToOne
    private Elecciontipo elecciontipo;

    public TiposVotos() {
    }

    public TiposVotos(Long idVoto) {
        this.idVoto = idVoto;
    }

    public Long getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(Long idVoto) {
        this.idVoto = idVoto;
    }

    public String getVoDescripcion() {
        return voDescripcion;
    }

    public void setVoDescripcion(String voDescripcion) {
        this.voDescripcion = voDescripcion;
    }

    public BigInteger getVocontadorFinal() {
        return vocontadorFinal;
    }

    public void setVocontadorFinal(BigInteger vocontadorFinal) {
        this.vocontadorFinal = vocontadorFinal;
    }

    public Elecciontipo getElecciontipo() {
        return elecciontipo;
    }

    public void setElecciontipo(Elecciontipo elecciontipo) {
        this.elecciontipo = elecciontipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVoto != null ? idVoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposVotos)) {
            return false;
        }
        TiposVotos other = (TiposVotos) object;
        if ((this.idVoto == null && other.idVoto != null) || (this.idVoto != null && !this.idVoto.equals(other.idVoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TiposVotos[idVoto=" + idVoto + "]";
    }

}
