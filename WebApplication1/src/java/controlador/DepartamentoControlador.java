package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Departamento;

/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class DepartamentoControlador implements Serializable {
    @EJB
    protected GenericoEJB<Departamento> genericoEJB;

    @Inject
    protected Conversation conversacion;

    private Long codigo;
    private String nombre;



    private Departamento departamento;
    public void grabar(ActionEvent actionEvent){

        departamento = new Departamento();
        departamento.setIdDep(codigo);
        departamento.setDepNombre(nombre);
        genericoEJB.insertar(departamento);
        limpiarCampos();
        
    }
    public void borrar(ActionEvent actionEvent){
        genericoEJB.eliminar(departamento);
        limpiarCampos();
    }
    public void limpiar(ActionEvent actionEvent){
        limpiarCampos();
    }
    public GenericoEJB<Departamento> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Departamento> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public Departamento getDepartamento() {
        if(departamento==null)
            departamento=new Departamento();
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        if(departamento != null){
            codigo = departamento.getIdDep();
            nombre = departamento.getDepNombre();
        }
        this.departamento = departamento;
    }

    public List<Departamento> getListarTodos(){
        return genericoEJB.getEm().createNamedQuery("Departamento.findAll").getResultList();
    }

    public void limpiarCampos(){
        departamento=null;
        codigo=0L;
        nombre="";
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

}
