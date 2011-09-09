package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import jpa.Candidato;
import jpa.Departamento;
import jpa.Distrito;
import jpa.Elecciontipo;
import jpa.Lista;

/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class CandidatoControlador implements Serializable {
 @EJB
    protected GenericoEJB<Candidato> genericoEJB;
    private Candidato candidato=new Candidato();
    public void grabar(){
        genericoEJB.insertar(candidato);
    }
    public void borrar(){
        genericoEJB.eliminar(candidato);
    }
    public void actualizacion(){
        genericoEJB.actulizar(candidato);
    }

    public Candidato getCandidato() {
        if(candidato==null)
            candidato=new Candidato();
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public GenericoEJB<Candidato> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Candidato> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }
    public List<Candidato> getListarTodos(){
       return genericoEJB.getEm().createNamedQuery("Candidato.findAll").getResultList();
    }

    public List<SelectItem> getListaDistritos(){
        List<Distrito> lista =genericoEJB.getEm().createNamedQuery("Distrito.findAll").getResultList();

        List<SelectItem> items = new ArrayList<SelectItem>();
        for(Distrito elemento : lista){
            items.add(new SelectItem(elemento, elemento.getDisNombre()));
        }

        return items;
    }
    public List<SelectItem> getListaDepartamento(){
        List<Departamento> lista1 =genericoEJB.getEm().createNamedQuery("Departamento.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for(Departamento elementod : lista1){
            items.add(new SelectItem(elementod, elementod.getDepNombre()));
        }
       return items;
    }

    public List<SelectItem> getListaEleccionTipo(){
        List<Elecciontipo> lista2=genericoEJB.getEm().createNamedQuery("Elecciontipo.findAll").getResultList();
        List<SelectItem> items=new ArrayList<SelectItem>();
        for(Elecciontipo elementoe : lista2){
            items.add(new SelectItem(elementoe, elementoe.getElecNombre()));
        }
        return items;
    }
    public List<SelectItem> getListaLis(){
        List<Lista> lista3=genericoEJB.getEm().createNamedQuery("Lista.findAll").getResultList();
        List<SelectItem> items=new ArrayList<SelectItem>();
        for(Lista elementol : lista3){
            items.add(new  SelectItem(elementol, elementol.getLisNombre()));
        }
        return items;
    }

    public void limpiarCampos(){
        candidato=null;
    }
    
}
