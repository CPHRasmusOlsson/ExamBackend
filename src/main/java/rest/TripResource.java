/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.trip.TripDTO;
import errorhandling.API_Exception;
import errorhandling.NotFoundException;
import facades.TripFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Olsso
 */
@Path("trip")
public class TripResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    
    private static final TripFacade FACADE = TripFacade.getTripFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo(){
        return "{\"msg\":\"Welcome to TripPage\"}";
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("show")
    public Response showTrips() throws API_Exception {
        List<TripDTO> tripDTOs = TripDTO.getDTos(FACADE.getAllTripsFromEntity());
        return Response.ok().entity(GSON.toJson(tripDTOs)).build();
    }
    
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response deleteById(@PathParam("id")Long id) throws NotFoundException {
        boolean result = FACADE.deleteTripById(id);
        if(result){
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.notModified().build();
        }
    }

}
