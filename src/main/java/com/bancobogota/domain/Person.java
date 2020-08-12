package com.bancobogota.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @Column(name = "id_father")
    private int idFather;

    @Column(name = "id_mother")
    private int idMother;

    private String fullName;

    private String phone;

    private String gender;

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

    public Person Adoptar(Person ap_person) {
        if (ap_person != null) {
            String ls_gender;

            ls_gender = getGender();

            if (ls_gender.equalsIgnoreCase("M")) {
                int li_idFather;

                li_idFather = ap_person.getIdFather();

                if (li_idFather == 0) {
                    ap_person.setIdFather(getIdPerson());
                }
            } else if (ls_gender.equalsIgnoreCase("F")) {
                int li_idMother;

                li_idMother = ap_person.getIdMother();

                if (li_idMother == 0) {
                    ap_person.setIdMother(getIdPerson());
                }
            }
        }

        return ap_person;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int ai_idPerson) {
        idPerson = ai_idPerson;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String as_gender) {
        gender = as_gender;
    }

    public int getIdFather() {
        return idFather;
    }

    public void setIdFather(int ai_idFather) {
        idFather = ai_idFather;
    }

    public int getIdMother() {
        return idMother;
    }

    public void setIdMother(int ai_idMother) {
        idMother = ai_idMother;
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
