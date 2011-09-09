/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package convertidor;

import ejb.GenericoEJB;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jpa.Departamento;

/**
 *
 * @author Diaz
 */
@FacesConverter(value="DepartamentoConverter")
public class DepartamentoListConverter implements Converter{

    
    protected GenericoEJB<Departamento> genericJB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            genericJB = (GenericoEJB) InitialContext.doLookup("java:global/WebApplication1/GenericoEJB");
        } catch (NamingException ex) {
            Logger.getLogger(DepartamentoListConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Departamento departamento = (Departamento)genericJB.getEm().createNamedQuery("Departamento.findByIdDep").setParameter("idDep", Long.parseLong(value)).getSingleResult();
        
        return departamento;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Departamento departamento = (Departamento)value;
        return departamento.getIdDep().toString();
    }

}
