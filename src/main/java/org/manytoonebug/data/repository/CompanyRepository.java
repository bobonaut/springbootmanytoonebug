package org.manytoonebug.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.manytoonebug.data.entity.Company;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author k.kondratov on 4/26/2016.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID>, JpaSpecificationExecutor<Company> {
}
