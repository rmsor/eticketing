package ejb;

import ejb.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Genre;

/**
 *
 * @author xtrememe
 */
@Stateless
public class GenreFacade extends AbstractFacade<Genre> {

    @PersistenceContext(unitName = "eticketingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenreFacade() {
        super(Genre.class);
    }


    public Genre findById(Long id) {
        Query findByGenreid = em.createNamedQuery("Genre.findByGenreid");
        findByGenreid.setParameter("genreid", id);
        return (Genre) findByGenreid.getSingleResult();
    }

}
