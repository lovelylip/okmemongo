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

import java.time.LocalDate;
import java.time.ZoneId;
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

    private static final String DEFAULT_TEN = "AAAAAAAAAA";
    private static final String UPDATED_TEN = "BBBBBBBBBB";

    private static final String DEFAULT_DIA_CHI = "AAAAAAAAAA";
    private static final String UPDATED_DIA_CHI = "BBBBBBBBBB";

    private static final String DEFAULT_MA_XA = "AAAAAAAAAA";
    private static final String UPDATED_MA_XA = "BBBBBBBBBB";

    private static final String DEFAULT_MA_HUYEN = "AAAAAAAAAA";
    private static final String UPDATED_MA_HUYEN = "BBBBBBBBBB";

    private static final String DEFAULT_MA_TINH = "AAAAAAAAAA";
    private static final String UPDATED_MA_TINH = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL_ACC = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_ACC = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CREATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_ACTIVE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ACTIVE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_INACTIVE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INACTIVE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_MA_CQBH_CHA = "AAAAAAAAAA";
    private static final String UPDATED_MA_CQBH_CHA = "BBBBBBBBBB";

    private static final String DEFAULT_NGUOI_KY = "AAAAAAAAAA";
    private static final String UPDATED_NGUOI_KY = "BBBBBBBBBB";

    private static final String DEFAULT_CHUC_DANH = "AAAAAAAAAA";
    private static final String UPDATED_CHUC_DANH = "BBBBBBBBBB";

    private static final String DEFAULT_TEN_NOI_KY = "AAAAAAAAAA";
    private static final String UPDATED_TEN_NOI_KY = "BBBBBBBBBB";

    private static final String DEFAULT_IS_ACTIVE = "AAAAAAAAAA";
    private static final String UPDATED_IS_ACTIVE = "BBBBBBBBBB";

    private static final String DEFAULT_PATH = "AAAAAAAAAA";
    private static final String UPDATED_PATH = "BBBBBBBBBB";

    private static final Long DEFAULT_NGAY_KHOA = 1L;
    private static final Long UPDATED_NGAY_KHOA = 2L;

    private static final String DEFAULT_NGAY_TEMP = "AAAAAAAAAA";
    private static final String UPDATED_NGAY_TEMP = "BBBBBBBBBB";

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
            .ma(DEFAULT_MA)
            .ten(DEFAULT_TEN)
            .diaChi(DEFAULT_DIA_CHI)
            .maXa(DEFAULT_MA_XA)
            .maHuyen(DEFAULT_MA_HUYEN)
            .maTinh(DEFAULT_MA_TINH)
            .emailAcc(DEFAULT_EMAIL_ACC)
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .status(DEFAULT_STATUS)
            .createDate(DEFAULT_CREATE_DATE)
            .activeDate(DEFAULT_ACTIVE_DATE)
            .inactiveDate(DEFAULT_INACTIVE_DATE)
            .maCqbhCha(DEFAULT_MA_CQBH_CHA)
            .nguoiKy(DEFAULT_NGUOI_KY)
            .chucDanh(DEFAULT_CHUC_DANH)
            .tenNoiKy(DEFAULT_TEN_NOI_KY)
            .isActive(DEFAULT_IS_ACTIVE)
            .path(DEFAULT_PATH)
            .ngayKhoa(DEFAULT_NGAY_KHOA)
            .ngayTemp(DEFAULT_NGAY_TEMP);
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
            .ma(UPDATED_MA)
            .ten(UPDATED_TEN)
            .diaChi(UPDATED_DIA_CHI)
            .maXa(UPDATED_MA_XA)
            .maHuyen(UPDATED_MA_HUYEN)
            .maTinh(UPDATED_MA_TINH)
            .emailAcc(UPDATED_EMAIL_ACC)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .status(UPDATED_STATUS)
            .createDate(UPDATED_CREATE_DATE)
            .activeDate(UPDATED_ACTIVE_DATE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .maCqbhCha(UPDATED_MA_CQBH_CHA)
            .nguoiKy(UPDATED_NGUOI_KY)
            .chucDanh(UPDATED_CHUC_DANH)
            .tenNoiKy(UPDATED_TEN_NOI_KY)
            .isActive(UPDATED_IS_ACTIVE)
            .path(UPDATED_PATH)
            .ngayKhoa(UPDATED_NGAY_KHOA)
            .ngayTemp(UPDATED_NGAY_TEMP);
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
        assertThat(testDmCqbh.getTen()).isEqualTo(DEFAULT_TEN);
        assertThat(testDmCqbh.getDiaChi()).isEqualTo(DEFAULT_DIA_CHI);
        assertThat(testDmCqbh.getMaXa()).isEqualTo(DEFAULT_MA_XA);
        assertThat(testDmCqbh.getMaHuyen()).isEqualTo(DEFAULT_MA_HUYEN);
        assertThat(testDmCqbh.getMaTinh()).isEqualTo(DEFAULT_MA_TINH);
        assertThat(testDmCqbh.getEmailAcc()).isEqualTo(DEFAULT_EMAIL_ACC);
        assertThat(testDmCqbh.getPhoneNumber()).isEqualTo(DEFAULT_PHONE_NUMBER);
        assertThat(testDmCqbh.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testDmCqbh.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testDmCqbh.getActiveDate()).isEqualTo(DEFAULT_ACTIVE_DATE);
        assertThat(testDmCqbh.getInactiveDate()).isEqualTo(DEFAULT_INACTIVE_DATE);
        assertThat(testDmCqbh.getMaCqbhCha()).isEqualTo(DEFAULT_MA_CQBH_CHA);
        assertThat(testDmCqbh.getNguoiKy()).isEqualTo(DEFAULT_NGUOI_KY);
        assertThat(testDmCqbh.getChucDanh()).isEqualTo(DEFAULT_CHUC_DANH);
        assertThat(testDmCqbh.getTenNoiKy()).isEqualTo(DEFAULT_TEN_NOI_KY);
        assertThat(testDmCqbh.getIsActive()).isEqualTo(DEFAULT_IS_ACTIVE);
        assertThat(testDmCqbh.getPath()).isEqualTo(DEFAULT_PATH);
        assertThat(testDmCqbh.getNgayKhoa()).isEqualTo(DEFAULT_NGAY_KHOA);
        assertThat(testDmCqbh.getNgayTemp()).isEqualTo(DEFAULT_NGAY_TEMP);
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
            .andExpect(jsonPath("$.[*].ma").value(hasItem(DEFAULT_MA)))
            .andExpect(jsonPath("$.[*].ten").value(hasItem(DEFAULT_TEN)))
            .andExpect(jsonPath("$.[*].diaChi").value(hasItem(DEFAULT_DIA_CHI)))
            .andExpect(jsonPath("$.[*].maXa").value(hasItem(DEFAULT_MA_XA)))
            .andExpect(jsonPath("$.[*].maHuyen").value(hasItem(DEFAULT_MA_HUYEN)))
            .andExpect(jsonPath("$.[*].maTinh").value(hasItem(DEFAULT_MA_TINH)))
            .andExpect(jsonPath("$.[*].emailAcc").value(hasItem(DEFAULT_EMAIL_ACC)))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].activeDate").value(hasItem(DEFAULT_ACTIVE_DATE.toString())))
            .andExpect(jsonPath("$.[*].inactiveDate").value(hasItem(DEFAULT_INACTIVE_DATE.toString())))
            .andExpect(jsonPath("$.[*].maCqbhCha").value(hasItem(DEFAULT_MA_CQBH_CHA)))
            .andExpect(jsonPath("$.[*].nguoiKy").value(hasItem(DEFAULT_NGUOI_KY)))
            .andExpect(jsonPath("$.[*].chucDanh").value(hasItem(DEFAULT_CHUC_DANH)))
            .andExpect(jsonPath("$.[*].tenNoiKy").value(hasItem(DEFAULT_TEN_NOI_KY)))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].path").value(hasItem(DEFAULT_PATH)))
            .andExpect(jsonPath("$.[*].ngayKhoa").value(hasItem(DEFAULT_NGAY_KHOA.intValue())))
            .andExpect(jsonPath("$.[*].ngayTemp").value(hasItem(DEFAULT_NGAY_TEMP)));
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
            .andExpect(jsonPath("$.ma").value(DEFAULT_MA))
            .andExpect(jsonPath("$.ten").value(DEFAULT_TEN))
            .andExpect(jsonPath("$.diaChi").value(DEFAULT_DIA_CHI))
            .andExpect(jsonPath("$.maXa").value(DEFAULT_MA_XA))
            .andExpect(jsonPath("$.maHuyen").value(DEFAULT_MA_HUYEN))
            .andExpect(jsonPath("$.maTinh").value(DEFAULT_MA_TINH))
            .andExpect(jsonPath("$.emailAcc").value(DEFAULT_EMAIL_ACC))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()))
            .andExpect(jsonPath("$.activeDate").value(DEFAULT_ACTIVE_DATE.toString()))
            .andExpect(jsonPath("$.inactiveDate").value(DEFAULT_INACTIVE_DATE.toString()))
            .andExpect(jsonPath("$.maCqbhCha").value(DEFAULT_MA_CQBH_CHA))
            .andExpect(jsonPath("$.nguoiKy").value(DEFAULT_NGUOI_KY))
            .andExpect(jsonPath("$.chucDanh").value(DEFAULT_CHUC_DANH))
            .andExpect(jsonPath("$.tenNoiKy").value(DEFAULT_TEN_NOI_KY))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE))
            .andExpect(jsonPath("$.path").value(DEFAULT_PATH))
            .andExpect(jsonPath("$.ngayKhoa").value(DEFAULT_NGAY_KHOA.intValue()))
            .andExpect(jsonPath("$.ngayTemp").value(DEFAULT_NGAY_TEMP));
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
            .ma(UPDATED_MA)
            .ten(UPDATED_TEN)
            .diaChi(UPDATED_DIA_CHI)
            .maXa(UPDATED_MA_XA)
            .maHuyen(UPDATED_MA_HUYEN)
            .maTinh(UPDATED_MA_TINH)
            .emailAcc(UPDATED_EMAIL_ACC)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .status(UPDATED_STATUS)
            .createDate(UPDATED_CREATE_DATE)
            .activeDate(UPDATED_ACTIVE_DATE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .maCqbhCha(UPDATED_MA_CQBH_CHA)
            .nguoiKy(UPDATED_NGUOI_KY)
            .chucDanh(UPDATED_CHUC_DANH)
            .tenNoiKy(UPDATED_TEN_NOI_KY)
            .isActive(UPDATED_IS_ACTIVE)
            .path(UPDATED_PATH)
            .ngayKhoa(UPDATED_NGAY_KHOA)
            .ngayTemp(UPDATED_NGAY_TEMP);
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
        assertThat(testDmCqbh.getTen()).isEqualTo(UPDATED_TEN);
        assertThat(testDmCqbh.getDiaChi()).isEqualTo(UPDATED_DIA_CHI);
        assertThat(testDmCqbh.getMaXa()).isEqualTo(UPDATED_MA_XA);
        assertThat(testDmCqbh.getMaHuyen()).isEqualTo(UPDATED_MA_HUYEN);
        assertThat(testDmCqbh.getMaTinh()).isEqualTo(UPDATED_MA_TINH);
        assertThat(testDmCqbh.getEmailAcc()).isEqualTo(UPDATED_EMAIL_ACC);
        assertThat(testDmCqbh.getPhoneNumber()).isEqualTo(UPDATED_PHONE_NUMBER);
        assertThat(testDmCqbh.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testDmCqbh.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testDmCqbh.getActiveDate()).isEqualTo(UPDATED_ACTIVE_DATE);
        assertThat(testDmCqbh.getInactiveDate()).isEqualTo(UPDATED_INACTIVE_DATE);
        assertThat(testDmCqbh.getMaCqbhCha()).isEqualTo(UPDATED_MA_CQBH_CHA);
        assertThat(testDmCqbh.getNguoiKy()).isEqualTo(UPDATED_NGUOI_KY);
        assertThat(testDmCqbh.getChucDanh()).isEqualTo(UPDATED_CHUC_DANH);
        assertThat(testDmCqbh.getTenNoiKy()).isEqualTo(UPDATED_TEN_NOI_KY);
        assertThat(testDmCqbh.getIsActive()).isEqualTo(UPDATED_IS_ACTIVE);
        assertThat(testDmCqbh.getPath()).isEqualTo(UPDATED_PATH);
        assertThat(testDmCqbh.getNgayKhoa()).isEqualTo(UPDATED_NGAY_KHOA);
        assertThat(testDmCqbh.getNgayTemp()).isEqualTo(UPDATED_NGAY_TEMP);
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
