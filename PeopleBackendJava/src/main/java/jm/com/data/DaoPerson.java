package jm.com.data;

import java.util.List;
import jm.com.domain.Person;

public interface DaoPerson {

    public List<Person> findAllPeople();

    public Person findPerson(Person person);

    public void insertPerson(Person person);

    public void updatePerson(Person person);

    public void deletePerson(Person person);

}
