package ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.UserInfo;

/**
 *
 * @author xtrememe
 */
@Stateless
public class UserFacade extends AbstractFacade<UserInfo> {

    @PersistenceContext(unitName = "eticketingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(UserInfo.class);
    }

    public UserInfo findByEmail(String email) {
        try {
            if (email == null) {
                email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
            }

            String jpql = "SELECT u from User u where u.email = :email";
            Query query = getEntityManager().createQuery(jpql, UserInfo.class);
            query.setParameter("email", email);
            return (UserInfo) query.getSingleResult();

        } catch (Exception e) {

            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public int updatePassword(String password, String email) {
        String jpql = "UPDATE User SET password = :pwd WHERE email = :email";
        Query query = em.createQuery(jpql, UserInfo.class);
        query.setParameter("pwd", password);
        query.setParameter("email", email);
        return query.executeUpdate();
    }

    public int updateProfile(Long user_id, String email, String firstName, String lastName,
            String password, String phoneNumber, String addressLine1, String addressLine2,
            String gender, String age, String profilePic) {

        System.out.println(user_id + "=" + email + "=" + firstName + "=" + lastName + "=" + password);

        String jpql = "";

        if (profilePic.length() > 1) {
            jpql = "UPDATE User SET firstName= :firstName, "
                    + "lastName= :lastName , email= :email"
                    + " ,password = :pwd, "
                    + "phoneNumber=:phoneNumber, addressLine1=:addressLine1, "
                    + "addressLine2=:addressLine2, gender=:gender, age=:age,"
                    + "profilePic=:profilePic WHERE id = :user_id";
        } else {
            jpql = "UPDATE User SET firstName= :firstName, "
                    + "lastName= :lastName , email= :email"
                    + " ,password = :pwd, "
                    + "phoneNumber=:phoneNumber, addressLine1=:addressLine1, "
                    + "addressLine2=:addressLine2, gender=:gender, age=:age "
                    + " WHERE id = :user_id";
        }

        Query query = em.createQuery(jpql, UserInfo.class);

        query.setParameter("pwd", password);
        query.setParameter("email", email);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("user_id", user_id);
        query.setParameter("phoneNumber", phoneNumber);
        query.setParameter("addressLine1", addressLine1);
        query.setParameter("addressLine2", addressLine2);
        query.setParameter("gender", gender);
        query.setParameter("age", age);
        if (profilePic.length() > 1) {
            query.setParameter("profilePic", profilePic);
        }

        return query.executeUpdate();
    }

}
