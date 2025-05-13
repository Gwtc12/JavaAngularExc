
package jm.com.data;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;
import jm.com.domain.Person;

@Stateless
public class PersonDaoImpl implements DaoPerson{

    @PersistenceContext (unitName = "PersonPu")
    
    EntityManager em;
    
    @Override
    public List<Person> findAllPeople() {
        return em.createNamedQuery("Person.findAllPeople").getResultList();
        
    }

    @Override
    public Person findPerson(Person person) {
        return em.find(Person.class, person.getIdPerson());
    }

    @Override
    public void insertPerson(Person person) {
        em.persist(person);
        em.flush();
    }

    @Override
    public void updatePerson(Person person) {
        em.merge(person);
    }

    @Override
    public void deletePerson(Person person) {
        em.remove(em.merge(person));
    }
    
}
