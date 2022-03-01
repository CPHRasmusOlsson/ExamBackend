/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Race;
import errorhandling.API_Exception;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Rasmus
 */
public class RaceFacade {

    private static EntityManagerFactory emf;
    private static RaceFacade instance;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private RaceFacade() {
    }

    public static RaceFacade getRaceFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RaceFacade();
        }
        return instance;
    }



    public List<Race> getAllRacesFromEntity() throws API_Exception {

        EntityManager em = emf.createEntityManager();
        try {

        TypedQuery<Race> query = em.createQuery("SELECT r FROM Race r", Race.class);
        return query.getResultList();

        } catch (Exception e) {
            throw new API_Exception(e.getMessage());
        }

    }


}