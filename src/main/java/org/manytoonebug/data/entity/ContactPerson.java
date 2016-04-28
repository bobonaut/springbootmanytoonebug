package org.manytoonebug.data.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author k.kondratov on 4/25/2016.
 */
@Entity(name = "contact_person")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ContactPerson extends AbstractEntity<ContactPerson.ContactPersonPK> {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;

    private String email;

    protected ContactPerson(){}

    public ContactPerson(ContactPersonPK id) {
        this.id = id;
    }

    public ContactPerson(Person person, Company company) {
        this(new ContactPersonPK(person, company));
        this.person = person;
        this.company = company;
    }

    @EmbeddedId
    private ContactPerson.ContactPersonPK id;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public ContactPersonPK getId() {
        return this.id;
    }

    @Embeddable
    public static class ContactPersonPK implements Serializable {

        /**
         * Serial version uid.
         */
        private static final long serialVersionUID = 1L;


        @Column(name = "person_id", length = 36, nullable=false)
        @Type(type="uuid-char")
        private UUID personId;

        @Column(name = "company_id", length = 36, nullable=false)
        @Type(type="uuid-char")
        private UUID companyId;

        public ContactPersonPK() {
        }

        public ContactPersonPK(Person person, Company company) {
            this.personId = person.getId();
            this.companyId = company.getId();
        }

        public ContactPersonPK(UUID companyId, UUID personId) {
            this.companyId = companyId;
            this.personId = personId;
        }

        public UUID getPersonId() {
            return personId;
        }

        public void setPersonId(UUID personId) {
            this.personId = personId;
        }

        public UUID getCompanyId() {
            return companyId;
        }

        public void setCompanyId(UUID companyId) {
            this.companyId = companyId;
        }

        @Override
        public String toString() {
            return String.format("%s%s", companyId.toString(), personId.toString());
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) {
                return false;
            }
            if(obj == this) {
                return true;
            }
            if(!this.getClass().isInstance(obj)) {
                return false;
            }

            ContactPersonPK other = this.getClass().cast(obj);

            return
                    new EqualsBuilder()
                            .append(this.getPersonId(), other.getPersonId())
                            .append(this.getCompanyId(), other.getCompanyId())
                            .isEquals();
        }

        @Override
        public int hashCode() {
            return
                    new HashCodeBuilder()
                            .append(this.getPersonId())
                            .append(this.getCompanyId())
                            .toHashCode();
        }
    }
}
