package com.okme.fam.repository;

import com.okme.fam.domain.DmDonVi;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the DmDonVi entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DmDonViRepository extends MongoRepository<DmDonVi, String> {
}
