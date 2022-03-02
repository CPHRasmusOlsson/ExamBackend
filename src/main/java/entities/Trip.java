
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@NamedQuery(name = "Trip.deleteAllRows", query = "DELETE from Trip")
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;
    private String time;
    private String location;
    private int duration;
    private String packingList;
    
    @ManyToMany
    private List<User> users;
    
    @ManyToOne
    private Guide guide;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPackingList() {
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }
    
    public Trip(){
        
    }

    public Trip(String name, String date, String time, String location, int duration, String packingList) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.duration = duration;
        this.packingList = packingList;
        this.users = new ArrayList<>();
    }
        

    public Long getId() {
        return id;
    }
    

    public void setId(Long id) {
        this.id = id;
    }
    
    public List<User> getPersons() {
        return users;
    }

    public void setPersons(List<User> persons) {
        this.users = persons;
    }
    
    


    
}
