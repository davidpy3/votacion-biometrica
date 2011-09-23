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
    @Inject
    protected Conversation conversation;

    private String codigo;
    private String nombre;
    private String contador;
    

    private Lista lista;
    private Partidopolitico partidopolitico;

   public void grabar(ActionEvent actionEvent){
        boolean modificar=false;
        if (lista == null) {
               lista=new Lista();
       }else{
            modificar=true;
       }

        lista.setIdLista(Long.parseLong(getCodigo()));
        lista.setLisNombre(getNombre());
        lista.setContador(Integer.parseInt(getContador()));
        lista.setPartidopolitico(partidopolitico);

        if (modificar) {
            genericoEJB.actulizar(lista);
        }else{
              genericoEJB.insertar(lista);
        }
        limpiarCampos();
    }
    public void borrar(ActionEvent actionEvent){
        genericoEJB.eliminar(lista);
        limpiarCampos();
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

    
/**
    public void setLista(Lista lista) {
        if (lista !=null){
        setCodigo(lista.getIdLista().toString());
        setNombre(lista.getLisNombre());
        setContador(lista.getContador().toString());
        setPartidopolitico(lista.getPartidopolitico());
        }
          this.lista = lista;
    }
 */
    public List<Lista> getListarTodos(){
        return genericoEJB.getEm().createNamedQuery("Lista.findAll").getResultList();
    }


   public List<SelectItem> getListaPartidopolitico() {
        List<Partidopolitico> lista2 = genericoEJB.getEm().createNamedQuery("Partidopolitico.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Partidopolitico elemento : lista2) {
            items.add(new SelectItem(elemento, elemento.getPartNombre()));
        }
        return items;
    }

    public void limpiar(ActionEvent actionEvent){
        limpiarCampos();
    }
    public void limpiarCampos(){
        lista=null;
        setCodigo("");
        setNombre("");
        setContador("");
        

    }
     public Lista getLista() {
        if (lista == null) {
            lista=new Lista();

        }
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(Lista lista) {
         if (lista !=null){
        setCodigo(lista.getIdLista().toString());
        setNombre(lista.getLisNombre());
        setContador(lista.getContador().toString());
        setPartidopolitico(lista.getPartidopolitico());
        }
          this.lista = lista;
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
        
        this.nombre = nombre;
    }

    /**
     * @return the contador
     */
    public String getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(String contador) {
        this.contador = contador;
    }

    

    /**
     * @return the partidopolitico
     */
    public Partidopolitico getPartidopolitico() {
        return partidopolitico;
    }

    /**
     * @param partidopolitico the partidopolitico to set
     */
    public void setPartidopolitico(Partidopolitico partidopolitico) {
        this.partidopolitico = partidopolitico;
    }

    /**
     * @return the lista
     */
   

}

