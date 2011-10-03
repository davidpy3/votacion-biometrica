package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
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

    @Inject
    private Conversation conversacion;

    private String codigo;
    private String nombre;
    private String apellido;
    private String ci;
    private String foto;
    private String idlist;
    private String idelec;
    private Date feincrip;
    private String idcandepart;
    private String idcandist;
    private Candidato candidato;

    private Lista lista;
    private Elecciontipo elecciontipo;
    private Departamento departamento;
    private Distrito distrito;

    public void grabar(ActionEvent actionEvent) {
        boolean modificar=false;
        if (getCandidato()==null) {
            setCandidato(new Candidato());
        }else{
            modificar=true;
        }

        getCandidato().setIdCandidatos(Long.parseLong(getCodigo()));
        getCandidato().setCanNombre(getNombre());
        getCandidato().setCanApellido(getApellido());
        getCandidato().setCanCi(getCi());
        getCandidato().setCanFoto(getFoto());
        getCandidato().setLista(lista);
        getCandidato().setElecciontipo(elecciontipo);
        getCandidato().setFeInscripcion(getFeincrip());
        getCandidato().setDepartamento(departamento);
        getCandidato().setDistrito(distrito);
        if (modificar) {
            genericoEJB.actulizar(candidato);
        }else{
            genericoEJB.insertar(candidato);
        }
        limpiarCampos();
    }

    public void borrar(ActionEvent actionEvent) {
        genericoEJB.eliminar(candidato);
        limpiarCampos();
    }

    public void actualizacion() {
        genericoEJB.actulizar(candidato);
    }
     public void limpiar(ActionEvent actionEvent){
        limpiarCampos();
    }

    public void limpiarCampos() {
        setCandidato(null);
        setCodigo("");
        setNombre("");
        setApellido("");
        setCi("");
        setFoto("");
        setIdlist("");
        setIdelec("");
        setFeincrip(null);
        setIdcandepart("");
        setIdcandist("");
    }
    /*

    public Candidato getCandidato() {
        if (candidato == null) {
            candidato = new Candidato();
        }
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        if (candidato != null) {
            setCodigo(candidato.getIdCandidatos().toString());
            setNombre(candidato.getCanNombre());
            setApellido(candidato.getCanApellido());
            setCi(candidato.getCanCi());
            setFoto(candidato.getCanFoto());
            setIdlist(candidato.getLista().toString());
            setIdelec(candidato.getElecciontipo().toString());
            setFeincrip(candidato.getFeInscripcion().toString());
            setIdcandepart(candidato.getDepartamento().toString());
            setIdcandist(candidato.getDistrito().toString());
        }

        this.candidato = candidato;
    }
     *
     */
    public GenericoEJB<Candidato> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Candidato> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public List<Candidato> getListarTodos() {
        return genericoEJB.getEm().createNamedQuery("Candidato.findAll").getResultList();
    }

    public List<SelectItem> getListaDistritos() {
        List<Distrito> lista1 = genericoEJB.getEm().createNamedQuery("Distrito.findAll").getResultList();

        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Distrito elemento : lista1) {
            items.add(new SelectItem(elemento, elemento.getDisNombre()));
        }

        return items;
    }

    public List<SelectItem> getListaDepartamento() {
        List<Departamento> lista2 = genericoEJB.getEm().createNamedQuery("Departamento.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Departamento elementod : lista2) {
            items.add(new SelectItem(elementod, elementod.getDepNombre()));
        }
        return items;
    }

    public List<SelectItem> getListaEleccionTipo() {
        List<Elecciontipo> lista3 = genericoEJB.getEm().createNamedQuery("Elecciontipo.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Elecciontipo elementoe : lista3) {
            items.add(new SelectItem(elementoe, elementoe.getElecNombre()));
        }
        return items;
    }

    public List<SelectItem> getListaLis() {
        List<Lista> lista4 = genericoEJB.getEm().createNamedQuery("Lista.findAll").getResultList();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Lista elementol : lista4) {
            items.add(new SelectItem(elementol, elementol.getLisNombre()));
        }
        return items;
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
        if(!codigo.equalsIgnoreCase("")&&getCandidato()!=null)
            getCandidato().setIdCandidatos(Long.parseLong(codigo));
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
        if(!nombre.equalsIgnoreCase("")&&getCandidato()!=null)
            getCandidato().setCanNombre(nombre);
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        if(!apellido.equalsIgnoreCase("")&&getCandidato()!=null)
            getCandidato().setCanApellido(apellido);
        this.apellido = apellido;
    }

    /**
     * @return the ci
     */
    public String getCi() {
        return ci;
    }

    /**
     * @param ci the ci to set
     */
    public void setCi(String ci) {
        if(!ci.equalsIgnoreCase("")&&getCandidato()!=null)
            getCandidato().setCanCi(ci);
        this.ci = ci;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        if(!foto.equalsIgnoreCase("")&&getCandidato()!=null)
            getCandidato().setCanFoto(foto);
        this.foto = foto;
    }

    /**
     * @return the idlist
     */
    public String getIdlist() {
        return idlist;
    }

    /**
     * @param idlist the idlist to set
     */
    public void setIdlist(String idlist) {
        if(!idlist.equalsIgnoreCase("")&&getCandidato()!=null)
            getCandidato().setLista(null);
        this.idlist = idlist;
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
        if(!idelec.equalsIgnoreCase("")&&getCandidato()!=null)
            getCandidato().setLista(null);
        this.idelec = idelec;
    }

 

    /**
     * @return the idcandepart
     */
    public String getIdcandepart() {
        return idcandepart;
    }

    /**
     * @param idcandepart the idcandepart to set
     */
    public void setIdcandepart(String idcandepart) {
        if(!idcandepart.equalsIgnoreCase("")&&getCandidato()!=null)
            getCandidato().setDepartamento(null);
        this.idcandepart = idcandepart;
    }

    /**
     * @return the idcandist
     */
    public String getIdcandist() {
        return idcandist;
    }

    /**
     * @param idcandist the idcandist to set
     */
    public void setIdcandist(String idcandist) {
        if(!idcandist.equalsIgnoreCase("")&&getCandidato()!=null)
            getCandidato().setDistrito(null);
        this.idcandist = idcandist;
    }

    /**
     * @return the lista
     */
    public Lista getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(Lista lista) {
        this.lista = lista;
    }

    /**
     * @return the elecciontipo
     */
    public Elecciontipo getElecciontipo() {
        return elecciontipo;
    }

    /**
     * @param elecciontipo the elecciontipo to set
     */
    public void setElecciontipo(Elecciontipo elecciontipo) {
        this.elecciontipo = elecciontipo;
    }

    /**
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
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

    /**
     * @return the candidato
     */
    public Candidato getCandidato() {
         if (candidato == null) {
            candidato = new Candidato();
        }
        return candidato;
        
    }

    /**
     * @param candidato the candidato to set
     */
    public void setCandidato(Candidato candidato) {
        if (candidato != null) {
            setCodigo(candidato.getIdCandidatos().toString());
            setNombre(candidato.getCanNombre());
            setApellido(candidato.getCanApellido());
            setCi(candidato.getCanCi());
            setFoto(candidato.getCanFoto());
            setLista(candidato.getLista());
            setElecciontipo(candidato.getElecciontipo());
            setFeincrip(candidato.getFeInscripcion());
            setDepartamento(candidato.getDepartamento());
            setDistrito(candidato.getDistrito());
        }
        this.candidato = candidato;
    }

    /**
     * @return the feincrip
     */
    public Date getFeincrip() {
        return feincrip;
    }

    /**
     * @param feincrip the feincrip to set
     */
    public void setFeincrip(Date feincrip) {
        this.feincrip = feincrip;
    }
  }

