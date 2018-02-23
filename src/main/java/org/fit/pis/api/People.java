package org.fit.pis.api;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;

import org.fit.pis.data.Person;
import org.fit.pis.service.PersonManager;

/*
 * TEST URL:
 * http://localhost:8080/jsf-basic/rest/people/list
 */
@Stateless
@Path("/people")
public class People 
{
	@EJB
	private PersonManager personMgr; 
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public People() 
    {
    }

    @PostConstruct
    public void init()
    {
    }
    
    /**
     * Retrieves representation of an instance of People
     * @return list of Person
     * @throws NamingException 
     */
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getJson() throws NamingException 
    {
    	return personMgr.findAll();
    }

    /**
     * PUT method for updating or creating an instance of People
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(List<Person> content) 
    {
    }

}