package controlador;
import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import jpa.Localidad;
import jpa.Zona;

/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class LocalidadControlador implements Serializable{
    @EJB
    protected GenericoEJB<Localidad> genericoEJB;
    private Localidad localidad=new Localidad();
    public void grabar(){
        genericoEJB.insertar(localidad);
    }
    public void borrar(){
        genericoEJB.eliminar(localidad);
    }
    public void actualizacion(){
        genericoEJB.actulizar(localidad);
    }

    public GenericoEJB<Localidad> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Localidad> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public Localidad getLocalidad() {
        if(localidad==null)
            localidad=new Localidad();
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    public List<Localidad> getListarTodos(){
        return genericoEJB.getEm().createNamedQuery("Localidad.findAll").getResultList();
    }
    public List<SelectItem> getListaZona(){
        List<Zona> lista =genericoEJB.getEm().createNamedQuery("Zona.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for(Zona elemento : lista){
            items.add(new SelectItem(elemento, elemento.getZonaNombre()));
        }
       return items;
    }
    public void limpiarCampos(){
        localidad=null;
    }



}
