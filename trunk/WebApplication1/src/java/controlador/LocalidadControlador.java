package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Localidad;
import jpa.Zona;

/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class LocalidadControlador implements Serializable {

    @EJB
    protected GenericoEJB<Localidad> genericoEJB;
    @Inject
    protected Conversation conversacion;
    private String codigo;
    private String nombre;
    private Localidad localidad;
    private Zona zona;

    public void grabar(ActionEvent actionEvent) {
        boolean modificar = false;
        if (localidad == null) {
            localidad = new Localidad();
        } else {
            modificar = true;
        }

        localidad.setIdLo(Long.parseLong(getCodigo()));
        localidad.setLoNombre(getNombre());
        localidad.setZona(zona);

        if (modificar) {
            genericoEJB.actulizar(localidad);
        } else {
            genericoEJB.insertar(localidad);
        }
        limpiarCampos();
    }

    public void borrar(ActionEvent actionEvent) {
        genericoEJB.eliminar(localidad);
        limpiarCampos();
    }
     public void limpiar(ActionEvent actionEvent) {
        limpiarCampos();
    }

    public void limpiarCampos() {
        setCodigo("");
        setNombre("");
        localidad = null;
    }

    public void actualizacion() {
        genericoEJB.actulizar(localidad);
    }

    public GenericoEJB<Localidad> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Localidad> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

     public List<Localidad> getListarTodos() {
        return genericoEJB.getEm().createNamedQuery("Localidad.findAll").getResultList();
    }

     public List<SelectItem> getListaZona() {
        List<Zona> lista = genericoEJB.getEm().createNamedQuery("Zona.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Zona elemento : lista) {
            items.add(new SelectItem(elemento, elemento.getZonaNombre()));
        }
        return items;
    }
    public Localidad getLocalidad() {
        if (localidad == null) {
            localidad = new Localidad();
        }
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        if (localidad != null) {
            setCodigo(localidad.getIdLo().toString());
            setNombre(localidad.getLoNombre());
            setZona(localidad.getZona());
        }
        this.localidad = localidad;
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
        if (!codigo.equalsIgnoreCase("") && localidad != null) {
            localidad.setIdLo(Long.parseLong(codigo));
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
        if (!nombre.equalsIgnoreCase("") && localidad != null) {
            localidad.setLoNombre(nombre);
        }
        this.nombre = nombre;
    }

    /**
     * @return the idzona
     */
    

    /**
     * @return the zona
     */
    public Zona getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(Zona zona) {
        this.zona = zona;
    }
}
