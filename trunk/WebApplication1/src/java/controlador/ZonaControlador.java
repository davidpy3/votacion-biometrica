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
    protected GenericoEJB<Zona> genericoEJB;
    @Inject
    protected Conversation conversation;
    private String codigo;
    private String nombre;
    private String iddistrito;
    private Zona zona;
    private Distrito distrito;

    public void grabar(ActionEvent actionEvent) {
        boolean modificar = false;
        if (zona == null) {
            zona = new Zona();
        } else {
            modificar = true;
        }

        zona.setIdZona(Long.parseLong(getCodigo()));
        zona.setZonaNombre(getNombre());
        zona.setDistrito(distrito);

        if (modificar) {
            genericoEJB.actulizar(zona);
        } else {
            genericoEJB.insertar(zona);
        }
        limpiarCampos();
    }

    public void borrar(ActionEvent actionEvent) {
        genericoEJB.eliminar(zona);
        limpiarCampos();
    }

    public void actualizacion() {
        genericoEJB.actulizar(zona);
    }

    public GenericoEJB<Zona> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Zona> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public Zona getZona() {
        if (zona == null) {
            zona = new Zona();
        }
        return zona;
    }

    public void setZona(Zona zona) {
        if (zona != null) {
            setCodigo(zona.getIdZona().toString());
            setNombre(zona.getZonaNombre());
            setDistrito(zona.getDistrito());
        }
        this.zona = zona;
    }

    public List<Zona> getListarTodos() {
        return genericoEJB.getEm().createNamedQuery("Zona.findAll").getResultList();
    }

    public List<Distrito> getListaDistritos() {
        List<Distrito> lista = genericoEJB.getEm().createNamedQuery("Distrito.findAll").getResultList();

        return lista;
    }

    public void limpiar(ActionEvent actionEvent) {
        limpiarCampos();
    }

    public void limpiarCampos() {
        setCodigo("");
        setNombre("");
        setIddistrito("");
        zona = null;
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
        if (!codigo.equalsIgnoreCase("") && zona != null) {
            zona.setIdZona(Long.parseLong(codigo));
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
        if (!nombre.equalsIgnoreCase("") && zona != null) {
            zona.setZonaNombre(nombre);
        }
        this.nombre = nombre;
    }

    /**
     * @return the iddistrito
     */
    public String getIddistrito() {
        return iddistrito;
    }

    /**
     * @param iddistrito the iddistrito to set
     */
    public void setIddistrito(String iddistrito) {
        if (!iddistrito.equalsIgnoreCase("") && zona != null) {
            zona.setDistrito(null);
        }
        this.iddistrito = iddistrito;
    }

    /**
     * @return the distrito
     */
    public Distrito getDistrito() {
        return distrito;
    }

    /**
     * @param distrito the distrito to set
     */
    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
}
