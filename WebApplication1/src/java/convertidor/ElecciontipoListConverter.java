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
import jpa.Elecciontipo;
/**
 *
 * @author nin
 */
@FacesConverter(value="ElecciontipoConverter")
public class ElecciontipoListConverter implements Converter{

    protected GenericoEJB<Elecciontipo> genericJB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         try {
            genericJB = (GenericoEJB) InitialContext.doLookup("java:global/WebApplication1/GenericoEJB");
        } catch (NamingException ex) {
            Logger.getLogger(ElecciontipoListConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Elecciontipo elecciontipo = (Elecciontipo)genericJB.getEm().createNamedQuery("Elecciontipo.findByIdEleccion").setParameter("idEleccion", Long.parseLong(value)).getSingleResult();

        return elecciontipo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Elecciontipo elecciontipo = (Elecciontipo)value;
        return elecciontipo.getIdEleccion().toString();
    }

}
