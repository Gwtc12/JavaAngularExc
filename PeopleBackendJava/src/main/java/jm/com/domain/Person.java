
package jm.com.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.io.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Person.findAllPeople", query = "SELECT p FROM Person p ORDER BY p.idPerson")
        
})
public class Person implements Serializable {

   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private int idPerson;
    
    private String name;
    
     public Person(int idPerson, String name) {
        this.idPerson = idPerson;
        this.name = name;
    }

    public Person(int idPerson) {
        this.idPerson = idPerson;
    }

    public Person() {
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "idPerson=" + idPerson + ", name=" + name + '}';
    }
    
}
