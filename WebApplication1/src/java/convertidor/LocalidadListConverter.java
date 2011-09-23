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
import jpa.Localidad;

/**
 *
 * @author nin
 */
@FacesConverter(value="LocalidadConverter")
public class LocalidadListConverter implements Converter {

     protected GenericoEJB<Localidad> genericJB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       try {
            genericJB = (GenericoEJB) InitialContext.doLookup("java:global/WebApplication1/GenericoEJB");
        } catch (NamingException ex) {
            Logger.getLogger(LocalidadListConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Localidad localidad = (Localidad)genericJB.getEm().createNamedQuery("Localidad.findByIdLo").setParameter("idLo", Long.parseLong(value)).getSingleResult();

        return localidad;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Localidad localidad = (Localidad)value;
        return localidad.getIdLo().toString();
    }

}
