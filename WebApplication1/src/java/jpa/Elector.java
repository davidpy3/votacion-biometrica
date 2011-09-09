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
@Table(name = "elector")
@NamedQueries({
    @NamedQuery(name = "Elector.findAll", query = "SELECT e FROM Elector e"),
    @NamedQuery(name = "Elector.findByIdElec", query = "SELECT e FROM Elector e WHERE e.idElec = :idElec"),
    @NamedQuery(name = "Elector.findByEleNombre", query = "SELECT e FROM Elector e WHERE e.eleNombre = :eleNombre"),
    @NamedQuery(name = "Elector.findByEleApellido", query = "SELECT e FROM Elector e WHERE e.eleApellido = :eleApellido"),
    @NamedQuery(name = "Elector.findByEleCi", query = "SELECT e FROM Elector e WHERE e.eleCi = :eleCi"),
    @NamedQuery(name = "Elector.findByEleHuella", query = "SELECT e FROM Elector e WHERE e.eleHuella = :eleHuella"),
    @NamedQuery(name = "Elector.findByEleFoto", query = "SELECT e FROM Elector e WHERE e.eleFoto = :eleFoto"),
    @NamedQuery(name = "Elector.findByEleSexo", query = "SELECT e FROM Elector e WHERE e.eleSexo = :eleSexo"),
    @NamedQuery(name = "Elector.findByFechaN", query = "SELECT e FROM Elector e WHERE e.fechaN = :fechaN"),
    @NamedQuery(name = "Elector.findByDireccion", query = "SELECT e FROM Elector e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Elector.findByFecha", query = "SELECT e FROM Elector e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Elector.findByEleEstacivil", query = "SELECT e FROM Elector e WHERE e.eleEstacivil = :eleEstacivil"),
    @NamedQuery(name = "Elector.findByEleNacionalidad", query = "SELECT e FROM Elector e WHERE e.eleNacionalidad = :eleNacionalidad"),
    @NamedQuery(name = "Elector.findByEleVoto", query = "SELECT e FROM Elector e WHERE e.eleVoto = :eleVoto")})
public class Elector implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_elec")
    private Long idElec;
    @Column(name = "ele_nombre")
    private String eleNombre;
    @Column(name = "ele_apellido")
    private String eleApellido;
    @Column(name = "ele_ci")
    private String eleCi;
    @Column(name = "ele_huella")
    private String eleHuella;
    @Column(name = "ele_foto")
    private String eleFoto;
    @Column(name = "ele_sexo")
    private String eleSexo;
    @Column(name = "fecha_n")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaN;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "ele_estacivil")
    private String eleEstacivil;
    @Column(name = "ele_nacionalidad")
    private String eleNacionalidad;
    @Column(name = "ele_voto")
    private String eleVoto;
    @JoinColumn(name = "id_profe", referencedColumnName = "id_profe")
    @ManyToOne
    private Profesion profesion;
    @JoinColumn(name = "id_mesas", referencedColumnName = "id_mesas")
    @ManyToOne
    private Mesas mesas;
    @JoinColumn(name = "id_local", referencedColumnName = "id_lo")
    @ManyToOne
    private Localidad localidad;

    public Elector() {
    }

    public Elector(Long idElec) {
        this.idElec = idElec;
    }

    public Long getIdElec() {
        return idElec;
    }

    public void setIdElec(Long idElec) {
        this.idElec = idElec;
    }

    public String getEleNombre() {
        return eleNombre;
    }

    public void setEleNombre(String eleNombre) {
        this.eleNombre = eleNombre;
    }

    public String getEleApellido() {
        return eleApellido;
    }

    public void setEleApellido(String eleApellido) {
        this.eleApellido = eleApellido;
    }

    public String getEleCi() {
        return eleCi;
    }

    public void setEleCi(String eleCi) {
        this.eleCi = eleCi;
    }

    public String getEleHuella() {
        return eleHuella;
    }

    public void setEleHuella(String eleHuella) {
        this.eleHuella = eleHuella;
    }

    public String getEleFoto() {
        return eleFoto;
    }

    public void setEleFoto(String eleFoto) {
        this.eleFoto = eleFoto;
    }

    public String getEleSexo() {
        return eleSexo;
    }

    public void setEleSexo(String eleSexo) {
        this.eleSexo = eleSexo;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEleEstacivil() {
        return eleEstacivil;
    }

    public void setEleEstacivil(String eleEstacivil) {
        this.eleEstacivil = eleEstacivil;
    }

    public String getEleNacionalidad() {
        return eleNacionalidad;
    }

    public void setEleNacionalidad(String eleNacionalidad) {
        this.eleNacionalidad = eleNacionalidad;
    }

    public String getEleVoto() {
        return eleVoto;
    }

    public void setEleVoto(String eleVoto) {
        this.eleVoto = eleVoto;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public Mesas getMesas() {
        return mesas;
    }

    public void setMesas(Mesas mesas) {
        this.mesas = mesas;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idElec != null ? idElec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elector)) {
            return false;
        }
        Elector other = (Elector) object;
        if ((this.idElec == null && other.idElec != null) || (this.idElec != null && !this.idElec.equals(other.idElec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Elector[idElec=" + idElec + "]";
    }

}
