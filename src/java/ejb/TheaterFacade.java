/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import ejb.AbstractFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Theater;

/**
 *
 * @author dharmaraj
 */
@Stateless
public class TheaterFacade extends AbstractFacade<Theater> {

    @PersistenceContext(unitName = "eticketingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TheaterFacade() {
        super(Theater.class);
    }

}
