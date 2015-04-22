package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Movie;

/**
 *
 * @author xtrememe
 */
@Stateless
public class MovieFacade extends AbstractFacade<Movie> {

    @PersistenceContext(unitName = "eticketingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovieFacade() {
        super(Movie.class);
    }

    public Movie findById(Long id) {
        Query findByMovieid = em.createNamedQuery("Movie.findByMovieid");
        findByMovieid.setParameter("movieid", id);
        return (Movie) findByMovieid.getSingleResult();
    }

}
