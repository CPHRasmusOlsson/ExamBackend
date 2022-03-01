/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos.trip;

import entities.Trip;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Olsso
 */
public class TripDTO {
    
    private Long id;
    private String name;
    private String date;
    private String time;
    private String location;
    private int duration;
    private String packingList;

    public TripDTO(String name, String date, String time, String location, int duration, String packingList) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.duration = duration;
        this.packingList = packingList;
    }
    
    public TripDTO(Trip t){
        if(t.getId() != null) this.id = t.getId();
        this.name = t.getName();
        this.date = t.getDate();
        this.time = t.getTime();
        this.location = t.getLocation();
        this.packingList = t.getPackingList();        
    }
    
    public static List<TripDTO> getDTos(List<Trip> trips){
        List<TripDTO> dtos = new ArrayList();
        trips.forEach(trip->dtos.add(new TripDTO(trip)));
        return dtos;
    }

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
    
   
    
    
}
