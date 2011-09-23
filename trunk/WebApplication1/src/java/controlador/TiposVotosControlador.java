/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.faces.component.html.HtmlInputText;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
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

@Inject
protected Conversation conversacion;

private String codigo;
private String nombre;
private String contfinal;
private String idelec;

private TiposVotos tiposVotos;


public void grabar(ActionEvent actionEvent){
    boolean modificar=false;
    if(tiposVotos==null){
        tiposVotos=new TiposVotos();
    }else{
        modificar=true;
    }
    tiposVotos.setIdVoto(Long.parseLong(getCodigo()));
    tiposVotos.setVoDescripcion(getNombre());
    tiposVotos.setVocontadorFinal(null);
    tiposVotos.setElecciontipo(null);

    if(modificar){
        genericoEJB.actulizar(tiposVotos);
    }else{
        genericoEJB.insertar(tiposVotos);
    }
     limpiarCampos();
}
public void borrar(ActionEvent actionEvent){
    genericoEJB.eliminar(tiposVotos);
    limpiarCampos();
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
        if(tiposVotos==null){
            tiposVotos=new TiposVotos();
        }
       return tiposVotos;
    }

    public void setTiposVotos(TiposVotos tiposVotos) {
        if(tiposVotos !=null){
             setCodigo(tiposVotos.getIdVoto().toString());
             setNombre(tiposVotos.getVoDescripcion());
             setContfinal(tiposVotos.getVocontadorFinal().toString());
             setIdelec(tiposVotos.getElecciontipo().toString());
        }
          this.tiposVotos = tiposVotos;
    }
public List<TiposVotos> getListarTodos(){
    return genericoEJB.getEm().createNamedQuery("TiposVotos.findAll").getResultList();
}
public void limpiar(ActionEvent actionEvent){
        limpiarCampos();
    }
public void limpiarCampos(){
    tiposVotos=null;
        setNombre("");
        setCodigo("");
        setContfinal("");
        setIdelec("");
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
        if(!codigo.equalsIgnoreCase("")&&tiposVotos!=null)
            tiposVotos.setIdVoto(Long.parseLong(codigo));
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
        if(!nombre.equalsIgnoreCase("")&&tiposVotos!=null)
            tiposVotos.setVoDescripcion(nombre);
        this.nombre = nombre;
    }

    /**
     * @return the contfinal
     */
    public String getContfinal() {
        return contfinal;
    }

    /**
     * @param contfinal the contfinal to set
     */
    public void setContfinal(String contfinal) {
        if(!contfinal.equalsIgnoreCase("")&&tiposVotos!=null)
            tiposVotos.setVocontadorFinal(BigInteger.ZERO);
        this.contfinal = contfinal;
    }

    /**
     * @return the idelec
     */
    public String getIdelec() {
        return idelec;
    }

    /**
     * @param idelec the idelec to set
     */
    public void setIdelec(String idelec) {
        if(!idelec.equalsIgnoreCase("")&&tiposVotos!=null)
            tiposVotos.setElecciontipo(null);

        this.idelec = idelec;
    }



}

