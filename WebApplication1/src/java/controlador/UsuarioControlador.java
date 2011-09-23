package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Usuario;

/**
 *
 * @author nin
 */
@Named
@SessionScoped
public class UsuarioControlador implements Serializable {

    @EJB
    protected GenericoEJB<Usuario> genericoEJB;
    @Inject
    protected Conversation conversacion;

    private String codigousu;
    private String nombreusu;
    private String passwordusu;
    private String descripcionusu;

    private Usuario usuario;

    public void grabar(ActionEvent actionEvent){

        boolean modificar=false;

        if (usuario==null){
            usuario=new Usuario();
         }else{
            modificar=true;
         }
        usuario.setIdUsu(Long.parseLong(getCodigousu()));
        usuario.setUsuNombre(getNombreusu());
        usuario.setPassword(getPasswordusu());
        usuario.setUsuDescripcion(getDescripcionusu());
        if(modificar){
            genericoEJB.actulizar(usuario);
        }else{
            genericoEJB.insertar(usuario);
        }
        limpiarCampos();
    }
    public void borrar(ActionEvent actionEvent){
        genericoEJB.eliminar(usuario);
        limpiarCampos();
    }
    public void actualizacion(){
        genericoEJB.actulizar(usuario);
    }
    public GenericoEJB<Usuario> getGenericoEJB() {
        return genericoEJB;
    }

    public void setGenericoEJB(GenericoEJB<Usuario> genericoEJB) {
        this.genericoEJB = genericoEJB;
    }

    public Usuario getUsuario() {
        if(usuario==null)
            usuario=new Usuario();
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        if (usuario !=null) {
            setCodigousu(usuario.getIdUsu().toString());
            setNombreusu(usuario.getUsuNombre());
            setPasswordusu(usuario.getPassword());
            setDescripcionusu(usuario.getUsuDescripcion());
        }
        this.usuario = usuario;
    }

    public List<Usuario> getListarTodos(){
        return genericoEJB.getEm().createNamedQuery("Usuario.findAll").getResultList();
    }
public void limpiar(ActionEvent actionEvent){
        limpiarCampos();
    }
    public void limpiarCampos(){
        usuario=null;
         setCodigousu("");
         setNombreusu("");
         setPasswordusu("");
         setDescripcionusu("");
    }
    /**
     * @return the codigousu
     */
    public String getCodigousu() {
        return codigousu;
    }

    /**
     * @param codigousu the codigousu to set
     */
    public void setCodigousu(String codigousu) {
        if (!codigousu.equalsIgnoreCase("")&&usuario!=null) {
            usuario.setIdUsu(Long.parseLong(codigousu));

        }
        this.codigousu = codigousu;
    }

    /**
     * @return the nombreusu
     */
    public String getNombreusu() {
        return nombreusu;
    }

    /**
     * @param nombreusu the nombreusu to set
     */
    public void setNombreusu(String nombreusu) {
        if (!nombreusu.equalsIgnoreCase("")&&usuario!=null) {
            usuario.setUsuNombre(nombreusu);
        }
        this.nombreusu = nombreusu;
    }

    /**
     * @return the passwordusu
     */
    public String getPasswordusu() {
        return passwordusu;
    }

    /**
     * @param passwordusu the passwordusu to set
     */
    public void setPasswordusu(String passwordusu) {
       if(!passwordusu.equalsIgnoreCase("")&&usuario!=null)
            usuario.setPassword(passwordusu);
        this.passwordusu=passwordusu;
    }

    /**
     * @return the descripcionusu
     */
    public String getDescripcionusu() {
        return descripcionusu;
    }

    /**
     * @param descripcionusu the descripcionusu to set
     */
    public void setDescripcionusu(String descripcionusu) {
       if(!descripcionusu.equalsIgnoreCase("")&&usuario!=null)
            usuario.setUsuDescripcion(descripcionusu);
        this.descripcionusu = descripcionusu;
    }
}
