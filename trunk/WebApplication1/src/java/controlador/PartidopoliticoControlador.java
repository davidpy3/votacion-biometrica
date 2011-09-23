/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.List;
import javax.faces.component.html.HtmlInputText;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
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
    @Inject
    protected Conversation conversacion;
    private String codigo;
    private String nombre;
    private String siglas;
    private String lema;
    private String color;
    private Partidopolitico partidopolitico;

    public void grabar(ActionEvent actionEvent) {
        boolean modificar=false;
        if(partidopolitico==null){
            partidopolitico = new Partidopolitico();
        }else{
            modificar=true;
        }

        partidopolitico.setIdPartido(Long.parseLong(getCodigo()));
        partidopolitico.setPartNombre(getNombre());
        partidopolitico.setPartSiglas(getSiglas());
        partidopolitico.setPartLema(getLema());
        partidopolitico.setPartColor(getColor());

        if(modificar){
            genericoEJB.actulizar(partidopolitico);
        }else{
            genericoEJB.insertar(partidopolitico);
        }

        limpiarCampos();
    }

    public void borrar(ActionEvent actionEvent) {
        genericoEJB.eliminar(partidopolitico);
        limpiarCampos();
    }

    public void actualizacion() {
        genericoEJB.actulizar(partidopolitico);
    }

    public GenericoEJB<Partidopolitico> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Partidopolitico> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public Partidopolitico getPartidopolitico() {
        if (partidopolitico == null) {
            partidopolitico = new Partidopolitico();
        }
        return partidopolitico;
    }

    public void setPartidopolitico(Partidopolitico partidopolitico) {
        if (partidopolitico != null) {
            setCodigo(partidopolitico.getIdPartido().toString());
            setNombre(partidopolitico.getPartNombre());
            setSiglas(partidopolitico.getPartSiglas());
            setLema(partidopolitico.getPartLema());
            setColor(partidopolitico.getPartColor());
        }

        this.partidopolitico = partidopolitico;
    }

    public List<Partidopolitico> getListarTodos() {
        return genericoEJB.getEm().createNamedQuery("Partidopolitico.findAll").getResultList();
    }
 public void limpiar(ActionEvent actionEvent){
        limpiarCampos();
    }
    public void limpiarCampos() {
        partidopolitico = null;
        setCodigo("");
        setNombre("");
        setSiglas("");
        setLema("");
        setColor("");
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
        if(!codigo.equalsIgnoreCase("")&&partidopolitico!=null)
            partidopolitico.setIdPartido(Long.parseLong(codigo));
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
        if(!nombre.equalsIgnoreCase("")&&partidopolitico!=null)
            partidopolitico.setPartNombre(nombre);
        this.nombre = nombre;
    }

    /**
     * @return the siglas
     */
    public String getSiglas() {
        return siglas;
    }

    /**
     * @param siglas the siglas to set
     */
    public void setSiglas(String siglas) {
        if(!siglas.equalsIgnoreCase("")&&partidopolitico!=null)
            partidopolitico.setPartSiglas(siglas);
        this.siglas = siglas;
    }

    /**
     * @return the lema
     */
    public String getLema() {
        return lema;
    }

    /**
     * @param lema the lema to set
     */
    public void setLema(String lema) {
        if(!siglas.equalsIgnoreCase("")&&partidopolitico!=null)
            partidopolitico.setPartLema(lema);
        this.lema = lema;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        if(color.equalsIgnoreCase("")&&partidopolitico!=null)
            partidopolitico.setPartColor(color);
        this.color = color;
    }


}
