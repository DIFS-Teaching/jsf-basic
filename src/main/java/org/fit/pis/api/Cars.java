/**
 * 
 */
package org.fit.pis.api;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.fit.pis.data.Car;

@Stateless
@Path("/cars")
public class Cars 
{
    private EntityManager em;
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public Cars() 
    {
    }

    @PostConstruct
    public void init()
    {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestApp");
    	em = factory.createEntityManager();
    }
    
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getJson() throws NamingException 
    {
    	List<Car> data = em.createQuery("SELECT c FROM Car c", Car.class).getResultList();
    	return data;
    }

    /**
     * PUT method for updating or creating an instance of People
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(List<Car> content) 
    {
    }


}
