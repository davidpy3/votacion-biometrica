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
import jpa.Profesion;

/**
 *
 * @author nin
 */
@FacesConverter(value="ProfesionConverter")
public class ProfesionListConverter implements Converter {

     protected GenericoEJB<Profesion> genericJB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            genericJB = (GenericoEJB) InitialContext.doLookup("java:global/WebApplication1/GenericoEJB");
        } catch (NamingException ex) {
            Logger.getLogger(ProfesionListConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Profesion profesion = (Profesion)genericJB.getEm().createNamedQuery("Profesion.findByIdProfe").setParameter("idProfe", Long.parseLong(value)).getSingleResult();

        return profesion;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Profesion profesion = (Profesion)value;
        return profesion.getIdProfe().toString();
    }

}
