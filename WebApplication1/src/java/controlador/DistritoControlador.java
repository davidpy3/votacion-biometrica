package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Departamento;
import jpa.Distrito;

/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class DistritoControlador implements Serializable{

    @EJB
    protected GenericoEJB<Distrito> genericoEJB;
    @Inject
    protected Conversation conversacion;
    private String codigo;
    private String nombre;
    private Departamento departamento;

    private Distrito distrito;
    
    public void grabar(ActionEvent actionEvent) {

        boolean modificar = false;

        if(distrito == null){
            distrito = new Distrito();
        }else{
            modificar = true;
        }

        distrito.setIdDis(Long.parseLong(getCodigo()));
        distrito.setDisNombre(getNombre());
        distrito.setDepartamento(departamento);
        if(modificar){
            genericoEJB.actulizar(distrito);
        }else{
            genericoEJB.insertar(distrito);
        }


        limpiarCampos();
    }

    public void borrar(ActionEvent actionEvent) {
        genericoEJB.eliminar(distrito);
        limpiarCampos();
    }

    public void limpiar(ActionEvent actionEvent){
        limpiarCampos();
    }

    public void limpiarCampos() {
        distrito = null;
        setNombre("");
        setCodigo("");

    }
   

    public GenericoEJB<Distrito> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Distrito> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }
    public List<Distrito> getListarTodos(){
        return genericoEJB.getEm().createNamedQuery("Distrito.findAll").getResultList();
    }

    public List<Departamento> getListaDepartamento(){
        List<Departamento> lista =genericoEJB.getEm().createNamedQuery("Departamento.findAll").getResultList();
        
       return lista;
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
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the distrito
     */
    public Distrito getDistrito() {
        return distrito;
    }

    /**
     * @param distrito the distroto to set
     */
    public void setDistrito(Distrito distrito) {
        if (distrito != null) {
            setCodigo(distrito.getIdDis().toString());
            setNombre(distrito.getDisNombre());
            setDepartamento(distrito.getDepartamento());
        }
        this.distrito = distrito;
    }
    
}
