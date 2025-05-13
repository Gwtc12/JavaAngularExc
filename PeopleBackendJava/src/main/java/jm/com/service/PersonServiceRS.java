package jm.com.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam; 
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import jm.com.data.DaoPerson;
import jm.com.domain.Person;

@Stateless
@Path("/people")
public class PersonServiceRS {

    @Inject
    private DaoPerson daoPerson;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Person> getAllPeople() {
        List<Person> people = daoPerson.findAllPeople();
        System.out.println("people = " + people);
        return people;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Person findPerson(@PathParam("id") int id) {
        Person person = daoPerson.findPerson(new Person(id));
        System.out.println("found person = " + person);
        return person;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Person addPerson(Person person) {
        daoPerson.insertPerson(person);
        System.out.println(" add person = " + person);
        return person;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modifyPerson(@PathParam("id") int id, Person modifyPerson) {
        Person person = daoPerson.findPerson(new Person(id));
        if (person != null) {
            daoPerson.updatePerson(modifyPerson);
            return Response.ok().entity(modifyPerson).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deletePerson(@PathParam("id") int id) {
        daoPerson.deletePerson(new Person(id));
        System.out.println("delete id person = " + id);
        return Response.ok().build();
    }

}
