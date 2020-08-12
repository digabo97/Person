package com.bancobogota.data;

import com.bancobogota.domain.Person;
import java.util.List;

/**
 *
 * @author Gabriel Arias
 */
public interface PersonDAO {

    public List<Person> findAllPerson();

    public Person findPerson(Person ap_person);

    public void insertPerson(Person ap_person);

    public void updatePerson(Person ap_person);

    public void deletePerson(Person ap_person);
}
