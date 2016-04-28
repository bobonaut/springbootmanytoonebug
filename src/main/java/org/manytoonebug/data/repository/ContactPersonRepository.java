package org.manytoonebug.data.repository;

import org.manytoonebug.data.entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author k.kondratov on 4/26/2016.
 */
@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, ContactPerson.ContactPersonPK>, JpaSpecificationExecutor<ContactPerson> {
}
