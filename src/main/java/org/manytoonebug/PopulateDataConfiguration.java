package org.manytoonebug;

import org.manytoonebug.data.entity.Company;
import org.manytoonebug.data.entity.ContactPerson;
import org.manytoonebug.data.entity.Person;
import org.manytoonebug.data.repository.CompanyRepository;
import org.manytoonebug.data.repository.ContactPersonRepository;
import org.manytoonebug.data.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author k.kondratov on 4/26/2016.
 */
@Component
public class PopulateDataConfiguration {

    private PersonRepository personRepository;
    private ContactPersonRepository contactPersonRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public PopulateDataConfiguration(PersonRepository personRepository, ContactPersonRepository contactPersonRepository, CompanyRepository companyRepository) {
        this.personRepository = personRepository;
        this.contactPersonRepository = contactPersonRepository;
        this.companyRepository = companyRepository;
    }

    @PostConstruct
    public void initTestData() {
        Company lexCorp = new Company("LexCorp");
        lexCorp = this.companyRepository.save(lexCorp);

        Company starkIndustries = new Company("Stark Industries");
        starkIndustries = this.companyRepository.save(starkIndustries);

        Company smokeIndustries = new Company("Smoke Industries");
        smokeIndustries = this.companyRepository.save(smokeIndustries);

        Company starLabs = new Company("S.T.A.R. Labs");
        starLabs = this.companyRepository.save(starLabs);

        Person lex = new Person("Lex", "Luthor");
        lex = this.personRepository.save(lex);

        Person barry = new Person("Barry", "Allen");
        barry = this.personRepository.save(barry);

        Person howard = new Person("Howard", "Stark");
        howard = this.personRepository.save(howard);

        Person felicity = new Person("Felicity", "Smoke");
        felicity = this.personRepository.save(felicity);

        ContactPerson lexCP = new ContactPerson(lex, lexCorp);
        lex.getContactPersons().add(lexCP);
        this.contactPersonRepository.save(lexCP);

        ContactPerson howardCP = new ContactPerson(howard, starkIndustries);
        howard.getContactPersons().add(howardCP);
        this.contactPersonRepository.save(howardCP);

        ContactPerson felicityCP = new ContactPerson(felicity, smokeIndustries);
        felicity.getContactPersons().add(felicityCP);
        this.contactPersonRepository.save(felicityCP);

        ContactPerson barryCP = new ContactPerson(barry, starLabs);
        barry.getContactPersons().add(barryCP);
        this.contactPersonRepository.save(barryCP);
    }
}
