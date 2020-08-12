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
    @Path("all")
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

    @GET
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("adopt/{idChild}/{idFather}/{idMother}")
    public Response adopt(@PathParam("idChild") int ai_idPerson, @PathParam("idFather") int ai_idFather, @PathParam("idMother") int ai_idMother) {
        Person lp_person;

        lp_person = ipd_personDAO.findPerson(new Person(ai_idPerson));

        if (lp_person != null) {

            int li_idFather;
            int li_idMother;

            li_idFather = lp_person.getIdFather();
            li_idMother = lp_person.getIdMother();

            if (li_idFather == 0 && li_idMother == 0) {
                return Response.status(Status.BAD_REQUEST).build();
            }

            if (ai_idFather != 0) {
                Person lp_father;

                lp_father = ipd_personDAO.findPerson(new Person(ai_idFather));

                if (lp_father == null) {
                    return Response.status(Status.BAD_REQUEST).build();
                }
            }

            if (ai_idMother != 0) {
                Person lp_mother;

                lp_mother = ipd_personDAO.findPerson(new Person(ai_idMother));

                if (lp_mother == null) {
                    return Response.status(Status.BAD_REQUEST).build();
                }
            }

            lp_person.setIdFather(ai_idFather);
            lp_person.setIdMother(ai_idMother);

            ipd_personDAO.updatePerson(lp_person);

            System.out.println("Persona modificada: " + lp_person);

            return Response.ok().entity(lp_person).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("del/{id}")
    public Response deletePerson(@PathParam("id") int ai_idPerson) {
        ipd_personDAO.deletePerson(new Person(ai_idPerson));

        System.out.println("Persona eliminada: " + ai_idPerson);

        return Response.ok().build();
    }
}
