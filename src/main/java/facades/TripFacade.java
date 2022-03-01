/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Trip;
import errorhandling.API_Exception;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;


/**
 *
 * @author Olsso
 */
public class TripFacade {
    
    private static EntityManagerFactory emf;
    private static TripFacade instance;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    
    private TripFacade(){
    }
    
    public static TripFacade getTripFacade(EntityManagerFactory _emf){
        if(instance==null){
            emf = _emf;
            instance = new TripFacade();
        }
        return instance;
    }
    
    public List<Trip> getAllTripsFromEntity() throws API_Exception{
        EntityManager em = emf.createEntityManager();
        try{
            
            TypedQuery<Trip> query = em.createQuery("SELECT t FROM Trip t",Trip.class);
            return  query.getResultList();
        } catch (Exception e){
            throw new API_Exception(e.getMessage());
        }
   
    }
    
}
