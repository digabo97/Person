package com.bancobogota.data;

import com.bancobogota.domain.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Gabriel Arias
 */

@Stateless
public class PersonDAOImpl implements PersonDAO {
    
    @PersistenceContext (unitName = "PersonPU")
    EntityManager iem_entityManager;

    @Override
    public List<Person> findAllPerson() {
        return iem_entityManager.createNamedQuery("Person.findAllPerson").getResultList();
    }

    @Override
    public Person findPerson(Person ap_person) {
        return iem_entityManager.find(Person.class, ap_person.getIdPerson());
    }

    @Override
    public void insertPerson(Person ap_person) {
        iem_entityManager.persist(ap_person);
        iem_entityManager.flush();
    }

    @Override
    public void updatePerson(Person ap_person) {
        iem_entityManager.merge(ap_person);
    }

    @Override
    public void deletePerson(Person ap_person) {
        iem_entityManager.remove(iem_entityManager.merge(ap_person));
    }

}
