package controlador;

import ejb.GenericoEJB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
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
    private Usuario usuario=new Usuario();
    public void grabar(){
        genericoEJB.insertar(usuario);
    }
    public void borrar(){
        genericoEJB.eliminar(usuario);
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
        this.usuario = usuario;
    }

    public List<Usuario> getListarTodos(){
        return genericoEJB.getEm().createNamedQuery("Usuario.findAll").getResultList();
    }

    public void limpiarCampos(){
        usuario=null;
    }


}
