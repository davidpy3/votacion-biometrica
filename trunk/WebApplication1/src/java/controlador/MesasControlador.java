/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
import jpa.Mesas;

/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class MesasControlador implements Serializable {
    @EJB
protected GenericoEJB<Mesas> genericoEJB;
    private Mesas mesas;
    public void borra(){
        genericoEJB.eliminar(getMesas());
    }
    public void grabar(){
        genericoEJB.insertar(getMesas());
        mesas = null;

    }
    public void actualizacion(){
        genericoEJB.actulizar(getMesas());
    }

    public GenericoEJB<Mesas> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Mesas> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public Mesas getMesas() {
        if(mesas==null)
            mesas=new Mesas();
        return mesas;
    }

    public void setMesas(Mesas mesas) {
        this.mesas = mesas;
    }
    public List<Mesas> getListarTodos(){
        return genericoEJB.getEm().createNamedQuery("Mesas.findAll").getResultList();
    }
    public List<SelectItem> getListaLocal(){
        List<Localidad> lista =genericoEJB.getEm().createNamedQuery("Localidad.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for(Localidad elemento : lista){
            items.add(new SelectItem(elemento, elemento.getLoNombre()));
        }
       return items;
    }
    public void limpiarCampos(){
        setMesas(null);
    }



}
