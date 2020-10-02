package com.okme.fam.web.rest;

import com.okme.fam.OkmeApp;
import com.okme.fam.domain.DmCqbh;
import com.okme.fam.repository.DmCqbhRepository;
import com.okme.fam.service.DmCqbhService;
import com.okme.fam.service.dto.DmCqbhDTO;
import com.okme.fam.service.mapper.DmCqbhMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link DmCqbhResource} REST controller.
 */
@SpringBootTest(classes = OkmeApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class DmCqbhResourceIT {

    private static final String DEFAULT_MA = "AAAAAAAAAA";
    private static final String UPDATED_MA = "BBBBBBBBBB";

    @Autowired
    private DmCqbhRepository dmCqbhRepository;

    @Autowired
    private DmCqbhMapper dmCqbhMapper;

    @Autowired
    private DmCqbhService dmCqbhService;

    @Autowired
    private MockMvc restDmCqbhMockMvc;

    private DmCqbh dmCqbh;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DmCqbh createEntity() {
        DmCqbh dmCqbh = new DmCqbh()
            .ma(DEFAULT_MA);
        return dmCqbh;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DmCqbh createUpdatedEntity() {
        DmCqbh dmCqbh = new DmCqbh()
            .ma(UPDATED_MA);
        return dmCqbh;
    }

    @BeforeEach
    public void initTest() {
        dmCqbhRepository.deleteAll();
        dmCqbh = createEntity();
    }

    @Test
    public void createDmCqbh() throws Exception {
        int databaseSizeBeforeCreate = dmCqbhRepository.findAll().size();
        // Create the DmCqbh
        DmCqbhDTO dmCqbhDTO = dmCqbhMapper.toDto(dmCqbh);
        restDmCqbhMockMvc.perform(post("/api/dm-cqbhs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmCqbhDTO)))
            .andExpect(status().isCreated());

        // Validate the DmCqbh in the database
        List<DmCqbh> dmCqbhList = dmCqbhRepository.findAll();
        assertThat(dmCqbhList).hasSize(databaseSizeBeforeCreate + 1);
        DmCqbh testDmCqbh = dmCqbhList.get(dmCqbhList.size() - 1);
        assertThat(testDmCqbh.getMa()).isEqualTo(DEFAULT_MA);
    }

    @Test
    public void createDmCqbhWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dmCqbhRepository.findAll().size();

        // Create the DmCqbh with an existing ID
        dmCqbh.setId("existing_id");
        DmCqbhDTO dmCqbhDTO = dmCqbhMapper.toDto(dmCqbh);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDmCqbhMockMvc.perform(post("/api/dm-cqbhs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmCqbhDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DmCqbh in the database
        List<DmCqbh> dmCqbhList = dmCqbhRepository.findAll();
        assertThat(dmCqbhList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void checkMaIsRequired() throws Exception {
        int databaseSizeBeforeTest = dmCqbhRepository.findAll().size();
        // set the field null
        dmCqbh.setMa(null);

        // Create the DmCqbh, which fails.
        DmCqbhDTO dmCqbhDTO = dmCqbhMapper.toDto(dmCqbh);


        restDmCqbhMockMvc.perform(post("/api/dm-cqbhs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmCqbhDTO)))
            .andExpect(status().isBadRequest());

        List<DmCqbh> dmCqbhList = dmCqbhRepository.findAll();
        assertThat(dmCqbhList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void getAllDmCqbhs() throws Exception {
        // Initialize the database
        dmCqbhRepository.save(dmCqbh);

        // Get all the dmCqbhList
        restDmCqbhMockMvc.perform(get("/api/dm-cqbhs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dmCqbh.getId())))
            .andExpect(jsonPath("$.[*].ma").value(hasItem(DEFAULT_MA)));
    }
    
    @Test
    public void getDmCqbh() throws Exception {
        // Initialize the database
        dmCqbhRepository.save(dmCqbh);

        // Get the dmCqbh
        restDmCqbhMockMvc.perform(get("/api/dm-cqbhs/{id}", dmCqbh.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dmCqbh.getId()))
            .andExpect(jsonPath("$.ma").value(DEFAULT_MA));
    }
    @Test
    public void getNonExistingDmCqbh() throws Exception {
        // Get the dmCqbh
        restDmCqbhMockMvc.perform(get("/api/dm-cqbhs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateDmCqbh() throws Exception {
        // Initialize the database
        dmCqbhRepository.save(dmCqbh);

        int databaseSizeBeforeUpdate = dmCqbhRepository.findAll().size();

        // Update the dmCqbh
        DmCqbh updatedDmCqbh = dmCqbhRepository.findById(dmCqbh.getId()).get();
        updatedDmCqbh
            .ma(UPDATED_MA);
        DmCqbhDTO dmCqbhDTO = dmCqbhMapper.toDto(updatedDmCqbh);

        restDmCqbhMockMvc.perform(put("/api/dm-cqbhs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmCqbhDTO)))
            .andExpect(status().isOk());

        // Validate the DmCqbh in the database
        List<DmCqbh> dmCqbhList = dmCqbhRepository.findAll();
        assertThat(dmCqbhList).hasSize(databaseSizeBeforeUpdate);
        DmCqbh testDmCqbh = dmCqbhList.get(dmCqbhList.size() - 1);
        assertThat(testDmCqbh.getMa()).isEqualTo(UPDATED_MA);
    }

    @Test
    public void updateNonExistingDmCqbh() throws Exception {
        int databaseSizeBeforeUpdate = dmCqbhRepository.findAll().size();

        // Create the DmCqbh
        DmCqbhDTO dmCqbhDTO = dmCqbhMapper.toDto(dmCqbh);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDmCqbhMockMvc.perform(put("/api/dm-cqbhs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmCqbhDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DmCqbh in the database
        List<DmCqbh> dmCqbhList = dmCqbhRepository.findAll();
        assertThat(dmCqbhList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteDmCqbh() throws Exception {
        // Initialize the database
        dmCqbhRepository.save(dmCqbh);

        int databaseSizeBeforeDelete = dmCqbhRepository.findAll().size();

        // Delete the dmCqbh
        restDmCqbhMockMvc.perform(delete("/api/dm-cqbhs/{id}", dmCqbh.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DmCqbh> dmCqbhList = dmCqbhRepository.findAll();
        assertThat(dmCqbhList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
