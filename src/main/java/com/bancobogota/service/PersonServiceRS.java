package com.bancobogota.service;

import com.bancobogota.data.PersonDAO;
import com.bancobogota.domain.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Gabriel Arias
 */
@Stateless
@Path("/persons")
public class PersonServiceRS {

    @Inject
    private PersonDAO ipd_personDAO;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Person> listPersons() {

        List<Person> llp_persons;

        llp_persons = ipd_personDAO.findAllPerson();

        System.out.println("Personas: " + llp_persons);

        return llp_persons;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Person findPerson(@PathParam("id") int ai_idPerson) {
        Person lp_person;

        lp_person = ipd_personDAO.findPerson(new Person(ai_idPerson));

        System.out.println("Persona: " + lp_person);

        return lp_person;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Person addPerson(Person ap_person) {
        ipd_personDAO.insertPerson(ap_person);

        System.out.println("Persona: " + ap_person);

        return ap_person;
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response editPerson(@PathParam("id") int ai_idPerson, Person ap_modifyPerson)
    {
        Person lp_person;
        
        lp_person = ipd_personDAO.findPerson(new Person(ai_idPerson));
        
        if(lp_person != null)
        {
            ipd_personDAO.updatePerson(ap_modifyPerson);
            
            System.out.println("Persona modificada: " + ap_modifyPerson);
        
            return Response.ok().entity(ap_modifyPerson).build();
        }
        else
            return Response.status(Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deletePerson(@PathParam("id") int ai_idPerson)
    {
        ipd_personDAO.deletePerson(new Person(ai_idPerson));
        
        System.out.println("Persona eliminada: " + ai_idPerson);
        
        return Response.ok().build();
    }
}
