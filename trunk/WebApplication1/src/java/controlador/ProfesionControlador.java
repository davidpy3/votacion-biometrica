package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Profesion;

/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class ProfesionControlador implements Serializable {

    @EJB
    protected GenericoEJB<Profesion> genericoEJB;
    @Inject
    protected Conversation conversacion;
    private String codigo;
    private String nombre;
    private Profesion profesion;

    public void grabar(ActionEvent actionEvent) {

        boolean modificar = false;

        if(profesion == null){
            profesion = new Profesion();
        }else{
            modificar = true;
        }

        profesion.setIdProfe(Long.parseLong(getCodigo()));
        profesion.setProNombre(getNombre());
        if(modificar){
            genericoEJB.actulizar(profesion);
        }else{
            genericoEJB.insertar(profesion);
        }
        

        limpiarCampos();
    }

    public void borrar(ActionEvent actionEvent) {
        genericoEJB.eliminar(profesion);
        limpiarCampos();
    }

    public void actualizacion() {
        genericoEJB.actulizar(profesion);
    }

    public GenericoEJB<Profesion> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Profesion> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public Profesion getProfesion() {
        if (profesion == null) {
            profesion = new Profesion();
        }
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        if (profesion != null) {
            setCodigo(profesion.getIdProfe().toString());
            setNombre(profesion.getProNombre());
        }

        this.profesion = profesion;
    }

    public List<Profesion> getListarTodos() {
        return genericoEJB.getEm().createNamedQuery("Profesion.findAll").getResultList();
    }
    public void limpiar(ActionEvent actionEvent){
        limpiarCampos();
    }

    public void limpiarCampos() {
        profesion = null;
        setNombre("");
        setCodigo("");

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
        if(!codigo.equalsIgnoreCase("") && profesion!=null)
            profesion.setIdProfe(Long.parseLong(codigo));

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
        if(!nombre.equalsIgnoreCase("") && profesion!=null)
            profesion.setProNombre(nombre);
        
        this.nombre = nombre;
    }

}
