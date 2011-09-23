/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package convertidor;

import ejb.GenericoEJB;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jpa.Partidopolitico;

/**
 *
 * @author nin
 */
@FacesConverter(value="PartidopoliticoConverter")
public class PartidopoliticoListConverter implements Converter{

     protected GenericoEJB<Partidopolitico> genericJB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            genericJB = (GenericoEJB) InitialContext.doLookup("java:global/WebApplication1/GenericoEJB");
        } catch (NamingException ex) {
            Logger.getLogger(PartidopoliticoListConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Partidopolitico partidopolitico = (Partidopolitico)genericJB.getEm().createNamedQuery("Partidopolitico.findByIdPartido").setParameter("idPartido", Long.parseLong(value)).getSingleResult();

        return partidopolitico;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Partidopolitico partidopolitico = (Partidopolitico)value;
        return partidopolitico.getIdPartido().toString();
    }

}
