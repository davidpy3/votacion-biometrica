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
import jpa.Zona;

/**
 *
 * @author nin
 */
@FacesConverter(value="ZonaConverter")
public class ZonaListConverter implements Converter{
    private GenericoEJB genericJB;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         try {
            genericJB = (GenericoEJB) InitialContext.doLookup("java:global/WebApplication1/GenericoEJB");
        } catch (NamingException ex) {
            Logger.getLogger(DepartamentoListConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Zona zona = (Zona)genericJB.getEm().createNamedQuery("Zona.findByIdZona").setParameter("idZona", Long.parseLong(value)).getSingleResult();

        return zona;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Zona zona = (Zona)value;
        return zona.getIdZona().toString();
    }

}
