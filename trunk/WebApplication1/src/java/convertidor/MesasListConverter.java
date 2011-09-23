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
import jpa.Mesas;

/**
 *
 * @author nin
 */
@FacesConverter(value="MesasConverter")
public class MesasListConverter implements Converter {

     protected GenericoEJB<Mesas> genericJB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         try {
            genericJB = (GenericoEJB) InitialContext.doLookup("java:global/WebApplication1/GenericoEJB");
        } catch (NamingException ex) {
            Logger.getLogger(MesasListConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Mesas mesas = (Mesas)genericJB.getEm().createNamedQuery("Mesas.findByIdMesas").setParameter("idMesas", Long.parseLong(value)).getSingleResult();

        return mesas;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Mesas mesas = (Mesas)value;
        return mesas.getIdMesas().toString();
    }

}
