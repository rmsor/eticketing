package ejb;

import static javafx.scene.input.KeyCode.T;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Validation;
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
<<<<<<< HEAD
    
   
=======

    public Genre findById(Long id) {
        Query findByGenreid = em.createNamedQuery("Genre.findByGenreid");
        findByGenreid.setParameter("genreid", id);
        return (Genre) findByGenreid.getSingleResult();
    }
>>>>>>> 7bab758b1ec519fa82934cc55e563a92500ff217

}
