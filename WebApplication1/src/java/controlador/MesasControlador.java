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
import javax.enterprise.context.Conversation;
import javax.faces.component.html.HtmlInputText;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
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
    @Inject
    protected Conversation conversacion;
    private String codigo;
    private String nombre;
    private Mesas mesas;
    private Localidad localidad;

    public void grabar(ActionEvent actionEvent) {
        boolean modificar = false;
        if (mesas == null) {
            mesas = new Mesas();
        } else {
            modificar = true;
        }

        mesas.setIdMesas(Long.parseLong(getCodigo()));
        mesas.setMeNombre(getNombre());
        mesas.setLocalidad(localidad);

        if (modificar) {
            genericoEJB.actulizar(mesas);
        } else {
            genericoEJB.insertar(mesas);
        }
        limpiarCampos();
    }

    public void borra(ActionEvent actionEvent) {
        genericoEJB.eliminar(mesas);
        limpiarCampos();
    }

    public void limpiar(ActionEvent actionEvent) {
        limpiarCampos();
    }

    public void limpiarCampos() {
        mesas = null;
        setCodigo("");
        setNombre("");
    }

    public void actualizacion() {
        genericoEJB.actulizar(mesas);
    }

    public GenericoEJB<Mesas> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Mesas> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

     public List<Mesas> getListarTodos() {
        return genericoEJB.getEm().createNamedQuery("Mesas.findAll").getResultList();
    }

     public List<SelectItem> getListaLocal() {
        List<Localidad> lista = genericoEJB.getEm().createNamedQuery("Localidad.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Localidad elemento : lista) {
            items.add(new SelectItem(elemento, elemento.getLoNombre()));
        }
        return items;
    }

    public Mesas getMesas() {
        if (mesas == null) {
            mesas = new Mesas();
        }
        return mesas;
    }

    public void setMesas(Mesas mesas) {
        if (mesas != null) {
            setCodigo(mesas.getIdMesas().toString());
            setNombre(mesas.getMeNombre());
            setLocalidad(mesas.getLocalidad());
        }
        this.mesas = mesas;
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
        if (!codigo.equalsIgnoreCase("") && mesas != null) {
            mesas.setIdMesas(Long.parseLong(codigo));
        }
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
        if (!nombre.equalsIgnoreCase("") && mesas != null) {
            mesas.setMeNombre(nombre);
        }
        this.nombre = nombre;
    }

   
    /**
     * @return the localidad
     */
    public Localidad getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
