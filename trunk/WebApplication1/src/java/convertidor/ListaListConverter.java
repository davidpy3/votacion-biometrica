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
import jpa.Lista;

/**
 *
 * @author nin
 */
@FacesConverter(value="ListaConverter")
public class ListaListConverter implements Converter{

     protected GenericoEJB<Lista> genericJB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            genericJB = (GenericoEJB) InitialContext.doLookup("java:global/WebApplication1/GenericoEJB");
        } catch (NamingException ex) {
            Logger.getLogger(ListaListConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Lista lista = (Lista)genericJB.getEm().createNamedQuery("Lista.findByIdLista").setParameter("idLista", Long.parseLong(value)).getSingleResult();

        return lista;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      Lista lista = (Lista)value;
        return lista.getIdLista().toString();
    }

}
