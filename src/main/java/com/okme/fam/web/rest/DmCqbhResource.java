package com.okme.fam.web.rest;

import com.okme.fam.service.DmCqbhService;
import com.okme.fam.web.rest.errors.BadRequestAlertException;
import com.okme.fam.service.dto.DmCqbhDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.okme.fam.domain.DmCqbh}.
 */
@RestController
@RequestMapping("/api")
public class DmCqbhResource {

    private final Logger log = LoggerFactory.getLogger(DmCqbhResource.class);

    private static final String ENTITY_NAME = "dmCqbh";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DmCqbhService dmCqbhService;

    public DmCqbhResource(DmCqbhService dmCqbhService) {
        this.dmCqbhService = dmCqbhService;
    }

    /**
     * {@code POST  /dm-cqbhs} : Create a new dmCqbh.
     *
     * @param dmCqbhDTO the dmCqbhDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dmCqbhDTO, or with status {@code 400 (Bad Request)} if the dmCqbh has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dm-cqbhs")
    public ResponseEntity<DmCqbhDTO> createDmCqbh(@Valid @RequestBody DmCqbhDTO dmCqbhDTO) throws URISyntaxException {
        log.debug("REST request to save DmCqbh : {}", dmCqbhDTO);
        if (dmCqbhDTO.getId() != null) {
            throw new BadRequestAlertException("A new dmCqbh cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DmCqbhDTO result = dmCqbhService.save(dmCqbhDTO);
        return ResponseEntity.created(new URI("/api/dm-cqbhs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /dm-cqbhs} : Updates an existing dmCqbh.
     *
     * @param dmCqbhDTO the dmCqbhDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dmCqbhDTO,
     * or with status {@code 400 (Bad Request)} if the dmCqbhDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dmCqbhDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dm-cqbhs")
    public ResponseEntity<DmCqbhDTO> updateDmCqbh(@Valid @RequestBody DmCqbhDTO dmCqbhDTO) throws URISyntaxException {
        log.debug("REST request to update DmCqbh : {}", dmCqbhDTO);
        if (dmCqbhDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DmCqbhDTO result = dmCqbhService.save(dmCqbhDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dmCqbhDTO.getId()))
            .body(result);
    }

    /**
     * {@code GET  /dm-cqbhs} : get all the dmCqbhs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dmCqbhs in body.
     */
    @GetMapping("/dm-cqbhs")
    public ResponseEntity<List<DmCqbhDTO>> getAllDmCqbhs(Pageable pageable) {
        log.debug("REST request to get a page of DmCqbhs");
        Page<DmCqbhDTO> page = dmCqbhService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dm-cqbhs/:id} : get the "id" dmCqbh.
     *
     * @param id the id of the dmCqbhDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dmCqbhDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dm-cqbhs/{id}")
    public ResponseEntity<DmCqbhDTO> getDmCqbh(@PathVariable String id) {
        log.debug("REST request to get DmCqbh : {}", id);
        Optional<DmCqbhDTO> dmCqbhDTO = dmCqbhService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dmCqbhDTO);
    }

    /**
     * {@code DELETE  /dm-cqbhs/:id} : delete the "id" dmCqbh.
     *
     * @param id the id of the dmCqbhDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dm-cqbhs/{id}")
    public ResponseEntity<Void> deleteDmCqbh(@PathVariable String id) {
        log.debug("REST request to delete DmCqbh : {}", id);
        dmCqbhService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
