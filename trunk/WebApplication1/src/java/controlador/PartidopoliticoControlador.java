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
import jpa.Partidopolitico;
/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class PartidopoliticoControlador implements Serializable {
    @EJB
    protected GenericoEJB<Partidopolitico> genericoEJB;
    private Partidopolitico partidopolitico=new Partidopolitico();
    public void grabar(){
        genericoEJB.insertar(partidopolitico);
    }
    public void borrar(){
        genericoEJB.eliminar(partidopolitico);
    }
    public void actualizacion(){
        genericoEJB.actulizar(partidopolitico);
    }

    public GenericoEJB<Partidopolitico> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Partidopolitico> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public Partidopolitico getPartidopolitico() {
        if(partidopolitico==null)
            partidopolitico=new Partidopolitico();
        return partidopolitico;
    }

    public void setPartidopolitico(Partidopolitico partidopolitico) {
        this.partidopolitico = partidopolitico;
    }
    public List<Partidopolitico> getListarTodos(){
        return genericoEJB.getEm().createNamedQuery("Partidopolitico.findAll").getResultList();
    }
    public void limpiarCampos(){
        partidopolitico=null;
    }
 }
