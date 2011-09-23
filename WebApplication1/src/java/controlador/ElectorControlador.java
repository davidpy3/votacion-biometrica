package controlador;

import ejb.GenericoEJB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Elector;
import jpa.Localidad;
import jpa.Mesas;
import jpa.Profesion;

/**
 *SessionScoped: Specifies that a bean is session scoped.

 * @author nin
 */
@Named
@SessionScoped
public class ElectorControlador implements Serializable {

    @EJB
    protected GenericoEJB<Elector> genericoEJB;
    @Inject
    protected Conversation conversacion;
    private String codigo;
    private String nombre;
    private String apellido;
    private String ci;
    private String huella;
    private String foto;
    private String sexo;
    private Date fechan;
    private String direccion;
    private Date fecha;
    private String estacivil;
    private String nacionalidad;
    private String voto;
    
    private Elector elector;
    private Localidad localidad;
    private Profesion profesion;
    private Mesas mesas;

    public void grabar(ActionEvent actionEvent) {
        boolean modificar=false;
        if(elector==null){
             elector = new Elector();
        }else{
            modificar=true;
        }
        elector.setIdElec(Long.parseLong(getCodigo()));
        elector.setEleNombre(getNombre());
        elector.setEleApellido(getApellido());
        elector.setEleCi(getCi());
        elector.setEleHuella(getHuella());
        elector.setEleFoto(getFoto());
        elector.setEleSexo(getSexo());
        elector.setFechaN(getFechan());
        elector.setDireccion(getDireccion());
        elector.setFecha(getFecha());
        elector.setEleEstacivil(getEstacivil());
        elector.setLocalidad(localidad);
        elector.setProfesion(profesion);
        elector.setEleNacionalidad(getNacionalidad());
        elector.setEleVoto(getVoto());
        elector.setMesas(mesas);
        if(modificar){
         genericoEJB.actulizar(elector);
        }else{
            genericoEJB.insertar(elector);
        }

        limpiarCampos();
    }
    public void borrar(ActionEvent actionEvent) {
        genericoEJB.eliminar(elector);
        limpiarCampos();
    }

    public void limpiar(ActionEvent actionEvent){
        limpiarCampos();
    }

    public void limpiarCampos() {
        elector = null;
        setCodigo("");
        setNombre("");
        setApellido("");
        setCi("");
        setHuella("");
        setFoto("");
        setSexo("");
        fechan=null;
        setDireccion("");
        fecha=null;
        setEstacivil("");
        setNacionalidad("");
        setVoto("");
     }


    public void actualizacion() {
        genericoEJB.actulizar(elector);
    }
    public GenericoEJB<Elector> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Elector> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public List<Elector> getListarTodos() {
        return genericoEJB.getEm().createNamedQuery("Elector.findAll").getResultList();
    }

    public List<SelectItem> getListaLocalidad() {
        List<Localidad> lista = genericoEJB.getEm().createNamedQuery("Localidad.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Localidad elemento : lista) {
            items.add(new SelectItem(elemento, elemento.getLoNombre()));
        }
        return items;
    }

    public List<SelectItem> getListaProfesion() {
        List<Profesion> lista = genericoEJB.getEm().createNamedQuery("Profesion.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Profesion elemento : lista) {
            items.add(new SelectItem(elemento, elemento.getProNombre()));
        }
        return items;
    }

    public List<SelectItem> getListaMesas() {
        List<Mesas> lista = genericoEJB.getEm().createNamedQuery("Mesas.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Mesas elemento : lista) {
            items.add(new SelectItem(elemento, elemento.getMeNombre()));
        }
        return items;
    }

    public Elector getElector() {
        if (elector == null) {
            elector = new Elector();
        }
        return elector;
    }

    public void setElector(Elector elector) {
        if (elector != null) {
            setCodigo(elector.getIdElec().toString());
            setNombre(elector.getEleNombre());
            setApellido(elector.getEleApellido());
            setCi(elector.getEleCi());
            setHuella(elector.getEleHuella());
            setFoto(elector.getEleFoto());
            setSexo(elector.getEleSexo());
            setFechan(elector.getFechaN());
            setDireccion(elector.getDireccion());
            setFecha(elector.getFecha());
            setEstacivil(elector.getEleEstacivil());
            setLocalidad(elector.getLocalidad());
            setProfesion(elector.getProfesion());
            setNacionalidad(elector.getEleNacionalidad());
            setVoto(elector.getEleVoto());
            setMesas(elector.getMesas());
        }
        this.elector = elector;
    }
    
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        if(!codigo.equalsIgnoreCase("")&&elector!=null)
            elector.setIdElec(Long.parseLong(codigo));
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        if(!nombre.equalsIgnoreCase("")&&elector!=null)
            elector.setEleNombre(nombre);
        this.apellido = apellido;
    }

    /**
     * @return the ci
     */
    public String getCi() {
        return ci;
    }

    /**
     * @param ci the ci to set
     */
    public void setCi(String ci) {
        if(!ci.equalsIgnoreCase("")&&elector!=null)
            elector.setEleCi(ci);
        this.ci = ci;
    }

    /**
     * @return the huella
     */
    public String getHuella() {
        return huella;
    }

    /**
     * @param huella the huella to set
     */
    public void setHuella(String huella) {
        if(!huella.equalsIgnoreCase("")&&elector!=null)
            elector.setEleHuella(huella);
        this.huella = huella;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        if(!foto.equalsIgnoreCase("")&&elector!=null)
            elector.setEleFoto(foto);
        this.foto = foto;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        if(!sexo.equalsIgnoreCase("")&&elector!=null)
            elector.setEleSexo(sexo);
        this.sexo = sexo;
    }
    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        if(!direccion.equalsIgnoreCase("")&&elector!=null)
            elector.setDireccion(direccion);
        this.direccion = direccion;
    }

  
    /**
     * @return the estacivil
     */
    public String getEstacivil() {
        return estacivil;
    }

    /**
     * @param estacivil the estacivil to set
     */
    public void setEstacivil(String estacivil) {
        if(!estacivil.equalsIgnoreCase("")&&elector!=null)
            elector.setEleEstacivil(estacivil);
        this.estacivil = estacivil;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        if(!nacionalidad.equalsIgnoreCase("")&&elector!=null)
            elector.setEleNacionalidad(nacionalidad);
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the voto
     */
    public String getVoto() {
        return voto;
    }

    /**
     * @param voto the voto to set
     */
    public void setVoto(String voto) {
        if(!voto.equalsIgnoreCase("")&&elector!=null)
            elector.setEleVoto(voto);
        this.voto = voto;
    }

    /**
     * @return the localidad
     */
    public Localidad getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    /**
     * @return the profesion
     */
    public Profesion getProfesion() {
        return profesion;
    }

    /**
     * @param profesion the profesion to set
     */
    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    /**
     * @return the mesas
     */
    public Mesas getMesas() {
        return mesas;
    }

    /**
     * @param mesas the mesas to set
     */
    public void setMesas(Mesas mesas) {
        this.mesas = mesas;
    }

    /**
     * @return the fechan
     */
    public Date getFechan() {
        return fechan;
    }

    /**
     * @param fechan the fechan to set
     */
    public void setFechan(Date fechan) {
        this.fechan = fechan;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   

}
