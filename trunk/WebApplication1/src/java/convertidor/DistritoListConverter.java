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
import jpa.Distrito;

/**
 *
 * @author nin
 */
@FacesConverter(value="DistritoConverter")
public class DistritoListConverter implements Converter {
    protected GenericoEJB<Distrito> genericJB;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            genericJB = (GenericoEJB) InitialContext.doLookup("java:global/WebApplication1/GenericoEJB");
        } catch (NamingException ex) {
            Logger.getLogger(DistritoListConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
       Distrito distrito = (Distrito)genericJB.getEm().createNamedQuery("Distrito.findByIdDis").setParameter("idDis", Long.parseLong(value)).getSingleResult();

        return distrito;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         Distrito distrito = (Distrito)value;
        return distrito.getIdDis().toString();
    }

}
