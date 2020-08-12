package com.bancobogota.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Gabriel Arias
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Person.findAllPerson", query = "SELECT p FROM Person p ORDER BY p.idPerson")
})
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private int idPerson;

    private String fullName;

    private String phone;

    private Date birth;

    public Person() {

    }

    public Person(int ai_idPerson) {
        idPerson = ai_idPerson;
    }

    public Person(int ai_idPerson, String as_fullName, Date ad_birth, String as_phone) {
        idPerson = ai_idPerson;
        fullName = as_fullName;
        birth = ad_birth;
        phone = as_phone;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int ai_idPerson) {
        idPerson = ai_idPerson;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String as_fullName) {
        fullName = as_fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String as_phone) {
        phone = as_phone;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date ad_birth) {
        birth = ad_birth;
    }

    @Override
    public String toString() {
        return "Person{" + "idPerson=" + idPerson + ", fullName=" + fullName + ", phone=" + phone + ", birth=" + birth + '}';
    }
}
