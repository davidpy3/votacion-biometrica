package controlador;
import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
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
public class ElectorControlador implements Serializable{
    @EJB
    protected GenericoEJB<Elector> genericoEJB;
    private Elector elector=new Elector();
    public void grabar(){
        genericoEJB.insertar(elector);
    }
    public void borrar(){
        genericoEJB.eliminar(elector);
    }
    public void actualizacion(){
        genericoEJB.actulizar(elector);
    }

    public Elector getElector() {
        if (elector==null)
            elector=new Elector();
        return elector;
    }

    public void setElector(Elector elector) {
        this.elector = elector;
    }

    public GenericoEJB<Elector> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Elector> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }
    public List<Elector> getListarTodos(){
        return genericoEJB.getEm().createNamedQuery("Elector.findAll").getResultList();
    }
     public List<SelectItem> getListaLocalidad(){
        List<Localidad> lista =genericoEJB.getEm().createNamedQuery("Localidad.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for(Localidad elemento : lista){
            items.add(new SelectItem(elemento, elemento.getLoNombre()));
        }
       return items;
    }
      public List<SelectItem> getListaProfesion(){
        List<Profesion> lista =genericoEJB.getEm().createNamedQuery("Profesion.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for(Profesion elemento : lista){
            items.add(new SelectItem(elemento, elemento.getProNombre()));
        }
       return items;
    }
    public List<SelectItem> getListaMesas(){
        List<Mesas> lista =genericoEJB.getEm().createNamedQuery("Mesas.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for(Mesas elemento : lista){
            items.add(new SelectItem(elemento, elemento.getMeNombre()));
        }
       return items;
    }


    public void limpiarCampos(){
        elector=null;
    }
    

}
