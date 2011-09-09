/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.TiposVotos;

/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class TiposVotosControlador implements Serializable {
    @EJB
protected GenericoEJB<TiposVotos> genericoEJB;
private TiposVotos tiposVotos=new TiposVotos();
public void grabar(){
    genericoEJB.insertar(tiposVotos);
}
public void borrar(){
    genericoEJB.eliminar(tiposVotos);
}
public void actualizavion(){
    genericoEJB.actulizar(tiposVotos);
}

    public GenericoEJB<TiposVotos> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<TiposVotos> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public TiposVotos getTiposVotos() {
        if(tiposVotos==null)
            tiposVotos=new TiposVotos();
        return tiposVotos;
    }

    public void setTiposVotos(TiposVotos tiposVotos) {
        this.tiposVotos = tiposVotos;
    }
public List<TiposVotos> getListarTodos(){
    return genericoEJB.getEm().createNamedQuery("TiposVotos.findAll").getResultList();
}
public void limpiarCampos(){
    tiposVotos=null;
}
}
