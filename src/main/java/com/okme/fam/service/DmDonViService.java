package com.okme.fam.service;

import com.okme.fam.service.dto.DmDonViDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.okme.fam.domain.DmDonVi}.
 */
public interface DmDonViService {

    /**
     * Save a dmDonVi.
     *
     * @param dmDonViDTO the entity to save.
     * @return the persisted entity.
     */
    DmDonViDTO save(DmDonViDTO dmDonViDTO);

    /**
     * Get all the dmDonVis.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DmDonViDTO> findAll(Pageable pageable);


    /**
     * Get the "id" dmDonVi.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DmDonViDTO> findOne(String id);

    /**
     * Delete the "id" dmDonVi.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
