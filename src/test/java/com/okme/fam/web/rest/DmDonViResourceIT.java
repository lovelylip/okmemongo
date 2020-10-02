package com.okme.fam.web.rest;

import com.okme.fam.OkmeApp;
import com.okme.fam.domain.DmDonVi;
import com.okme.fam.repository.DmDonViRepository;
import com.okme.fam.service.DmDonViService;
import com.okme.fam.service.dto.DmDonViDTO;
import com.okme.fam.service.mapper.DmDonViMapper;

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
 * Integration tests for the {@link DmDonViResource} REST controller.
 */
@SpringBootTest(classes = OkmeApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class DmDonViResourceIT {

    private static final String DEFAULT_MA = "AAAAAAAAAA";
    private static final String UPDATED_MA = "BBBBBBBBBB";

    @Autowired
    private DmDonViRepository dmDonViRepository;

    @Autowired
    private DmDonViMapper dmDonViMapper;

    @Autowired
    private DmDonViService dmDonViService;

    @Autowired
    private MockMvc restDmDonViMockMvc;

    private DmDonVi dmDonVi;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DmDonVi createEntity() {
        DmDonVi dmDonVi = new DmDonVi()
            .ma(DEFAULT_MA);
        return dmDonVi;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DmDonVi createUpdatedEntity() {
        DmDonVi dmDonVi = new DmDonVi()
            .ma(UPDATED_MA);
        return dmDonVi;
    }

    @BeforeEach
    public void initTest() {
        dmDonViRepository.deleteAll();
        dmDonVi = createEntity();
    }

    @Test
    public void createDmDonVi() throws Exception {
        int databaseSizeBeforeCreate = dmDonViRepository.findAll().size();
        // Create the DmDonVi
        DmDonViDTO dmDonViDTO = dmDonViMapper.toDto(dmDonVi);
        restDmDonViMockMvc.perform(post("/api/dm-don-vis")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmDonViDTO)))
            .andExpect(status().isCreated());

        // Validate the DmDonVi in the database
        List<DmDonVi> dmDonViList = dmDonViRepository.findAll();
        assertThat(dmDonViList).hasSize(databaseSizeBeforeCreate + 1);
        DmDonVi testDmDonVi = dmDonViList.get(dmDonViList.size() - 1);
        assertThat(testDmDonVi.getMa()).isEqualTo(DEFAULT_MA);
    }

    @Test
    public void createDmDonViWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dmDonViRepository.findAll().size();

        // Create the DmDonVi with an existing ID
        dmDonVi.setId("existing_id");
        DmDonViDTO dmDonViDTO = dmDonViMapper.toDto(dmDonVi);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDmDonViMockMvc.perform(post("/api/dm-don-vis")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmDonViDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DmDonVi in the database
        List<DmDonVi> dmDonViList = dmDonViRepository.findAll();
        assertThat(dmDonViList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void checkMaIsRequired() throws Exception {
        int databaseSizeBeforeTest = dmDonViRepository.findAll().size();
        // set the field null
        dmDonVi.setMa(null);

        // Create the DmDonVi, which fails.
        DmDonViDTO dmDonViDTO = dmDonViMapper.toDto(dmDonVi);


        restDmDonViMockMvc.perform(post("/api/dm-don-vis")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmDonViDTO)))
            .andExpect(status().isBadRequest());

        List<DmDonVi> dmDonViList = dmDonViRepository.findAll();
        assertThat(dmDonViList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void getAllDmDonVis() throws Exception {
        // Initialize the database
        dmDonViRepository.save(dmDonVi);

        // Get all the dmDonViList
        restDmDonViMockMvc.perform(get("/api/dm-don-vis?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dmDonVi.getId())))
            .andExpect(jsonPath("$.[*].ma").value(hasItem(DEFAULT_MA)));
    }
    
    @Test
    public void getDmDonVi() throws Exception {
        // Initialize the database
        dmDonViRepository.save(dmDonVi);

        // Get the dmDonVi
        restDmDonViMockMvc.perform(get("/api/dm-don-vis/{id}", dmDonVi.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dmDonVi.getId()))
            .andExpect(jsonPath("$.ma").value(DEFAULT_MA));
    }
    @Test
    public void getNonExistingDmDonVi() throws Exception {
        // Get the dmDonVi
        restDmDonViMockMvc.perform(get("/api/dm-don-vis/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateDmDonVi() throws Exception {
        // Initialize the database
        dmDonViRepository.save(dmDonVi);

        int databaseSizeBeforeUpdate = dmDonViRepository.findAll().size();

        // Update the dmDonVi
        DmDonVi updatedDmDonVi = dmDonViRepository.findById(dmDonVi.getId()).get();
        updatedDmDonVi
            .ma(UPDATED_MA);
        DmDonViDTO dmDonViDTO = dmDonViMapper.toDto(updatedDmDonVi);

        restDmDonViMockMvc.perform(put("/api/dm-don-vis")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmDonViDTO)))
            .andExpect(status().isOk());

        // Validate the DmDonVi in the database
        List<DmDonVi> dmDonViList = dmDonViRepository.findAll();
        assertThat(dmDonViList).hasSize(databaseSizeBeforeUpdate);
        DmDonVi testDmDonVi = dmDonViList.get(dmDonViList.size() - 1);
        assertThat(testDmDonVi.getMa()).isEqualTo(UPDATED_MA);
    }

    @Test
    public void updateNonExistingDmDonVi() throws Exception {
        int databaseSizeBeforeUpdate = dmDonViRepository.findAll().size();

        // Create the DmDonVi
        DmDonViDTO dmDonViDTO = dmDonViMapper.toDto(dmDonVi);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDmDonViMockMvc.perform(put("/api/dm-don-vis")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dmDonViDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DmDonVi in the database
        List<DmDonVi> dmDonViList = dmDonViRepository.findAll();
        assertThat(dmDonViList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteDmDonVi() throws Exception {
        // Initialize the database
        dmDonViRepository.save(dmDonVi);

        int databaseSizeBeforeDelete = dmDonViRepository.findAll().size();

        // Delete the dmDonVi
        restDmDonViMockMvc.perform(delete("/api/dm-don-vis/{id}", dmDonVi.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DmDonVi> dmDonViList = dmDonViRepository.findAll();
        assertThat(dmDonViList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
