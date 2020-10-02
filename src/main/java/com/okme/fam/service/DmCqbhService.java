package com.okme.fam.service;

import com.okme.fam.service.dto.DmCqbhDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.okme.fam.domain.DmCqbh}.
 */
public interface DmCqbhService {

    /**
     * Save a dmCqbh.
     *
     * @param dmCqbhDTO the entity to save.
     * @return the persisted entity.
     */
    DmCqbhDTO save(DmCqbhDTO dmCqbhDTO);

    /**
     * Get all the dmCqbhs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DmCqbhDTO> findAll(Pageable pageable);


    /**
     * Get the "id" dmCqbh.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DmCqbhDTO> findOne(String id);

    /**
     * Delete the "id" dmCqbh.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
