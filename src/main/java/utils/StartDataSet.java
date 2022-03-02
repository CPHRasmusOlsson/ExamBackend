package utils;

import entities.Guide;
import entities.Role;
import entities.User;
import entities.Trip;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class StartDataSet {

    public static User user,admin,both;
    public static Role userRole,adminRole;
    public static Guide guide1;
    public static Trip trip1,trip2;

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        setupInitialData(emf);
    }

    //Entity managerFactory is deciding whether the data is to test or prod database.
    //Is called both from rest and test cases
    public static void setupInitialData(EntityManagerFactory _emf){
        EntityManager em = _emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("User.deleteAllRows").executeUpdate();
            em.createNamedQuery("Role.deleteAllRows").executeUpdate();
            em.createNamedQuery("Trip.deleteAllRows").executeUpdate();


            List<Trip> trips = new ArrayList();

            
            guide1 = new Guide("John","Male",1992,"profile","img.webm");            
            trip1 = new Trip("BonbonLand","22-04","12:00","Bonbon gade 3", 2 ,"regntøj og gode sko");
            trip2 = new Trip("Tivoli","12-05","09:30","Kbh. Centrum", 6 ,"Solcreme og godt humør");
            
            trips.add(trip1);
            trips.add(trip2);
            
            user = new User("user", "testUser");
            admin = new User("admin", "testAdmin");
            both = new User("user_admin", "testBoth");

            userRole = new Role("user");
            adminRole = new Role("admin");
            
            

            user.addRole(userRole);
            admin.addRole(adminRole);
            both.addRole(userRole);
            both.addRole(adminRole);
            
            

            
            em.persist(trip1);
            em.persist(trip2);

            em.persist(userRole);
            em.persist(adminRole);

            em.persist(user);
            em.persist(admin);
            em.persist(both);

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
}
