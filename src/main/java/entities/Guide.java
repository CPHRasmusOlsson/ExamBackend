package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
public class Guide implements Serializable {
    
    @OneToMany(mappedBy = "guide",cascade = CascadeType.PERSIST)
    List<Trip> trip;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private int birthYear;
    private String profile;
    private String imgUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public List getTrip(){
        return trip;
    }
    
    public void addTrip(Trip trip){
        this.trip.add(trip);
        if(trip != null){
            trip.setGuide(this);
        }
    }
    
    public void removeTrip(Trip trip){
        if(trip!=null){
        this.trip.remove(trip);
        }
    }
    
    public Guide(){
    }
    
    public Guide(String name, String gender, int birthYear,String profile,String imgUrl ){
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.profile = profile;
        this.imgUrl = imgUrl;
        this.trip = new ArrayList<>();
    }
    


    
}
