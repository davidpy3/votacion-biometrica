package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *Stateless:Component-defining annotation for a stateless session bean.
 * PersistenceContext:Expresses a dependency on a container-managed
 *EntityManager and its associated persistence context.
 * Expresa una dependencia en un recipiente gestionados EntityManager y su
 *contexto asociado persistencia.
 * @author nin
 */
@Stateless
public class GenericoEJB<E> {

    @PersistenceContext
    private EntityManager em;

    public void insertar(E entidad) {
        getEm().persist(entidad);
    }

    public void actulizar(E entida) {
        getEm().merge(entida);

    }

    public void eliminar(E entidad) {
        getEm().remove(em.merge(entidad));
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
