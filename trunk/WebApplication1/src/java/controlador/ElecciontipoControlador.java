package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Elecciontipo;


/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class ElecciontipoControlador implements Serializable {

    @EJB
    protected GenericoEJB<Elecciontipo> genericoEJB;

    @Inject
    protected Conversation conversacion;

    private Long codigo;
    private String nombre;
    private Date fechaEleccion;



    private Elecciontipo eleccionTipo;
    public void grabar(ActionEvent actionEvent){

        eleccionTipo = new Elecciontipo();
        eleccionTipo.setIdEleccion(codigo);
        eleccionTipo.setElecNombre(nombre);
        eleccionTipo.setElecFecha(fechaEleccion);
        genericoEJB.insertar(eleccionTipo);
        limpiarCampos();

    }
    public void borrar(ActionEvent actionEvent){
        genericoEJB.eliminar(eleccionTipo);
        limpiarCampos();
    }
    public void limpiar(ActionEvent actionEvent){
        limpiarCampos();
    }
    public GenericoEJB<Elecciontipo> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Elecciontipo> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public Elecciontipo getEleccionTipo() {
        if(eleccionTipo==null)
            eleccionTipo=new Elecciontipo();
        return eleccionTipo;
    }

    public void setEleccionTipo(Elecciontipo eleccionTipo) {
        if(eleccionTipo != null){
            codigo = eleccionTipo.getIdEleccion();
            nombre = eleccionTipo.getElecNombre();
            fechaEleccion = eleccionTipo.getElecFecha();
        }
        this.eleccionTipo = eleccionTipo;
    }

    public List<Elecciontipo> getListarTodos(){
        return genericoEJB.getEm().createNamedQuery("Elecciontipo.findAll").getResultList();
    }

    public void limpiarCampos(){
        eleccionTipo=null;
        codigo=0L;
        nombre="";
        fechaEleccion=null;
    }

    /**
     * @return the codigo
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Long codigo) {
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
     * @return the fechaEleccion
     */
    public Date getFechaEleccion() {
        return fechaEleccion;
    }

    /**
     * @param fechaEleccion the fechaEleccion to set
     */
    public void setFechaEleccion(Date fechaEleccion) {
        this.fechaEleccion = fechaEleccion;
    }
    
}
