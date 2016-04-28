package org.manytoonebug.data.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author k.kondratov on 4/25/2016.
 */
@Entity(name = "company")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Company extends AbstractIdEntity {

    private String name;

    @OneToMany(mappedBy = "company")
    @JsonIdentityReference(alwaysAsId = true)
    private List<ContactPerson> contactPersons = new ArrayList<>();

    public Company() {}

    public Company(String name) {
        this.name = name;
    }

    public List<ContactPerson> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(List<ContactPerson> contactPersons) {
        this.contactPersons = contactPersons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
