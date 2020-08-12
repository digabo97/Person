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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_father")
    private int idFather;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mother")
    private int idMother;

    private String fullName;

    private String phone;

    private String gender;

    private Date birth;

    private List<Person> hijos;

    private final String CS_MASCULINO = "M";

    private final String CS_FEMENINO = "F";

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

    public void Adoptar(Person ap_person) {
        if (ap_person != null) {
            List<Person> llp_hijos;
            String ls_gender;

            llp_hijos = getHijos();
            ls_gender = getGender();

            if (llp_hijos == null) {
                llp_hijos = new ArrayList<>();
            }

            if (ls_gender.equalsIgnoreCase(CS_MASCULINO)) {
                int li_idFather;

                li_idFather = ap_person.getIdFather();

                if (li_idFather == 0) {
                    ap_person.setIdFather(getIdPerson());
                    llp_hijos.add(ap_person);
                }
            } else if (ls_gender.equalsIgnoreCase(CS_FEMENINO)) {
                int li_idMother;

                li_idMother = ap_person.getIdMother();

                if (li_idMother == 0) {
                    ap_person.setIdMother(getIdPerson());
                    llp_hijos.add(ap_person);
                }
            }

            setHijos(llp_hijos);
        }
    }

    public List<Person> getHijos() {
        return hijos;
    }

    public void setHijos(List<Person> alp_hijos) {
        hijos = alp_hijos;
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
