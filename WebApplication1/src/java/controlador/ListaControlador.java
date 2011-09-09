package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import jpa.Lista;
import jpa.Partidopolitico;

/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class ListaControlador implements Serializable {
    @EJB
    protected GenericoEJB<Lista>genericoEJB;
    private Lista lista=new Lista();
   
    public void grabar(){
        genericoEJB.insertar(lista);
    }
    public void borrar(){
        genericoEJB.eliminar(lista);
    }
    public void actualizacion(){
        genericoEJB.actulizar(lista);
    }

    public GenericoEJB<Lista> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Lista> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public Lista getLista() {
        if(lista==null)
            lista=new Lista();
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
    public List<Lista> getListarTodos(){
        return genericoEJB.getEm().createNamedQuery("Lista.findAll").getResultList();
    }

   public List<SelectItem> getListaPartido(){
        List<Partidopolitico> lista1 =genericoEJB.getEm().createNamedQuery("Partidopolitico.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for(Partidopolitico elemento : lista1){
            items.add(new SelectItem(elemento, elemento.getPartNombre()));
        }
       return items;
    }
    public void limpiarCampos(){
        lista=null;
    }

}
