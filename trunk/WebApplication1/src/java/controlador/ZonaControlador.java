package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import jpa.Distrito;
import jpa.Zona;

/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class ZonaControlador implements Serializable {
    @EJB
    protected GenericoEJB<Zona>genericoEJB;
    private Zona zona = new Zona();

    public void grabar(){
        genericoEJB.insertar(zona);
    }
    public void borrar(){
        genericoEJB.eliminar(zona);
    }
    public void actualizacion(){
        genericoEJB.actulizar(zona);
    }

    public GenericoEJB<Zona> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Zona> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public Zona getZona() {
        if(zona==null)
            zona=new Zona();
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    public List<Zona> getListarTodos(){
        return genericoEJB.getEm().createNamedQuery("Zona.findAll").getResultList();
    }

    public List<SelectItem> getListaDistritos(){
        List<Distrito> lista =genericoEJB.getEm().createNamedQuery("Distrito.findAll").getResultList();

        List<SelectItem> items = new ArrayList<SelectItem>();
        for(Distrito elemento : lista){
            items.add(new SelectItem(elemento, elemento.getDisNombre()));
        }

        return items;
    }
    public void limpiarCampos(){
        zona=null;
    }
}
