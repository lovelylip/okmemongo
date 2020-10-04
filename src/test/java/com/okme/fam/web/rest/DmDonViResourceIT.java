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

    private static final String DEFAULT_TEN = "AAAAAAAAAA";
    private static final String UPDATED_TEN = "BBBBBBBBBB";

    private static final Long DEFAULT_TONG_LD = 1L;
    private static final Long UPDATED_TONG_LD = 2L;

    private static final Long DEFAULT_TONG_LUONG = 1L;
    private static final Long UPDATED_TONG_LUONG = 2L;

    private static final String DEFAULT_LOAI_DV = "AAAAAAAAAA";
    private static final String UPDATED_LOAI_DV = "BBBBBBBBBB";

    private static final String DEFAULT_DIACHI = "AAAAAAAAAA";
    private static final String UPDATED_DIACHI = "BBBBBBBBBB";

    private static final String DEFAULT_DIENTHOAI = "AAAAAAAAAA";
    private static final String UPDATED_DIENTHOAI = "BBBBBBBBBB";

    private static final String DEFAULT_FAX = "AAAAAAAAAA";
    private static final String UPDATED_FAX = "BBBBBBBBBB";

    private static final String DEFAULT_SO_TAI_KHOAN = "AAAAAAAAAA";
    private static final String UPDATED_SO_TAI_KHOAN = "BBBBBBBBBB";

    private static final String DEFAULT_NGAN_HANG = "AAAAAAAAAA";
    private static final String UPDATED_NGAN_HANG = "BBBBBBBBBB";

    private static final String DEFAULT_MA_CQBH = "AAAAAAAAAA";
    private static final String UPDATED_MA_CQBH = "BBBBBBBBBB";

    private static final String DEFAULT_MA_TINH = "AAAAAAAAAA";
    private static final String UPDATED_MA_TINH = "BBBBBBBBBB";

    private static final String DEFAULT_MA_HUYEN = "AAAAAAAAAA";
    private static final String UPDATED_MA_HUYEN = "BBBBBBBBBB";

    private static final String DEFAULT_SO_DKKD = "AAAAAAAAAA";
    private static final String UPDATED_SO_DKKD = "BBBBBBBBBB";

    private static final String DEFAULT_MA_ST = "AAAAAAAAAA";
    private static final String UPDATED_MA_ST = "BBBBBBBBBB";

    private static final String DEFAULT_NGUOI_LH = "AAAAAAAAAA";
    private static final String UPDATED_NGUOI_LH = "BBBBBBBBBB";

    private static final String DEFAULT_MA_DVIKCB = "AAAAAAAAAA";
    private static final String UPDATED_MA_DVIKCB = "BBBBBBBBBB";

    private static final String DEFAULT_MA_KHOIKCB = "AAAAAAAAAA";
    private static final String UPDATED_MA_KHOIKCB = "BBBBBBBBBB";

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
            .ma(DEFAULT_MA)
            .ten(DEFAULT_TEN)
            .tongLd(DEFAULT_TONG_LD)
            .tongLuong(DEFAULT_TONG_LUONG)
            .loaiDv(DEFAULT_LOAI_DV)
            .diachi(DEFAULT_DIACHI)
            .dienthoai(DEFAULT_DIENTHOAI)
            .fax(DEFAULT_FAX)
            .soTaiKhoan(DEFAULT_SO_TAI_KHOAN)
            .nganHang(DEFAULT_NGAN_HANG)
            .maCqbh(DEFAULT_MA_CQBH)
            .maTinh(DEFAULT_MA_TINH)
            .maHuyen(DEFAULT_MA_HUYEN)
            .soDkkd(DEFAULT_SO_DKKD)
            .maSt(DEFAULT_MA_ST)
            .nguoiLh(DEFAULT_NGUOI_LH)
            .maDvikcb(DEFAULT_MA_DVIKCB)
            .maKhoikcb(DEFAULT_MA_KHOIKCB);
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
            .ma(UPDATED_MA)
            .ten(UPDATED_TEN)
            .tongLd(UPDATED_TONG_LD)
            .tongLuong(UPDATED_TONG_LUONG)
            .loaiDv(UPDATED_LOAI_DV)
            .diachi(UPDATED_DIACHI)
            .dienthoai(UPDATED_DIENTHOAI)
            .fax(UPDATED_FAX)
            .soTaiKhoan(UPDATED_SO_TAI_KHOAN)
            .nganHang(UPDATED_NGAN_HANG)
            .maCqbh(UPDATED_MA_CQBH)
            .maTinh(UPDATED_MA_TINH)
            .maHuyen(UPDATED_MA_HUYEN)
            .soDkkd(UPDATED_SO_DKKD)
            .maSt(UPDATED_MA_ST)
            .nguoiLh(UPDATED_NGUOI_LH)
            .maDvikcb(UPDATED_MA_DVIKCB)
            .maKhoikcb(UPDATED_MA_KHOIKCB);
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
        assertThat(testDmDonVi.getTen()).isEqualTo(DEFAULT_TEN);
        assertThat(testDmDonVi.getTongLd()).isEqualTo(DEFAULT_TONG_LD);
        assertThat(testDmDonVi.getTongLuong()).isEqualTo(DEFAULT_TONG_LUONG);
        assertThat(testDmDonVi.getLoaiDv()).isEqualTo(DEFAULT_LOAI_DV);
        assertThat(testDmDonVi.getDiachi()).isEqualTo(DEFAULT_DIACHI);
        assertThat(testDmDonVi.getDienthoai()).isEqualTo(DEFAULT_DIENTHOAI);
        assertThat(testDmDonVi.getFax()).isEqualTo(DEFAULT_FAX);
        assertThat(testDmDonVi.getSoTaiKhoan()).isEqualTo(DEFAULT_SO_TAI_KHOAN);
        assertThat(testDmDonVi.getNganHang()).isEqualTo(DEFAULT_NGAN_HANG);
        assertThat(testDmDonVi.getMaCqbh()).isEqualTo(DEFAULT_MA_CQBH);
        assertThat(testDmDonVi.getMaTinh()).isEqualTo(DEFAULT_MA_TINH);
        assertThat(testDmDonVi.getMaHuyen()).isEqualTo(DEFAULT_MA_HUYEN);
        assertThat(testDmDonVi.getSoDkkd()).isEqualTo(DEFAULT_SO_DKKD);
        assertThat(testDmDonVi.getMaSt()).isEqualTo(DEFAULT_MA_ST);
        assertThat(testDmDonVi.getNguoiLh()).isEqualTo(DEFAULT_NGUOI_LH);
        assertThat(testDmDonVi.getMaDvikcb()).isEqualTo(DEFAULT_MA_DVIKCB);
        assertThat(testDmDonVi.getMaKhoikcb()).isEqualTo(DEFAULT_MA_KHOIKCB);
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
            .andExpect(jsonPath("$.[*].ma").value(hasItem(DEFAULT_MA)))
            .andExpect(jsonPath("$.[*].ten").value(hasItem(DEFAULT_TEN)))
            .andExpect(jsonPath("$.[*].tongLd").value(hasItem(DEFAULT_TONG_LD.intValue())))
            .andExpect(jsonPath("$.[*].tongLuong").value(hasItem(DEFAULT_TONG_LUONG.intValue())))
            .andExpect(jsonPath("$.[*].loaiDv").value(hasItem(DEFAULT_LOAI_DV)))
            .andExpect(jsonPath("$.[*].diachi").value(hasItem(DEFAULT_DIACHI)))
            .andExpect(jsonPath("$.[*].dienthoai").value(hasItem(DEFAULT_DIENTHOAI)))
            .andExpect(jsonPath("$.[*].fax").value(hasItem(DEFAULT_FAX)))
            .andExpect(jsonPath("$.[*].soTaiKhoan").value(hasItem(DEFAULT_SO_TAI_KHOAN)))
            .andExpect(jsonPath("$.[*].nganHang").value(hasItem(DEFAULT_NGAN_HANG)))
            .andExpect(jsonPath("$.[*].maCqbh").value(hasItem(DEFAULT_MA_CQBH)))
            .andExpect(jsonPath("$.[*].maTinh").value(hasItem(DEFAULT_MA_TINH)))
            .andExpect(jsonPath("$.[*].maHuyen").value(hasItem(DEFAULT_MA_HUYEN)))
            .andExpect(jsonPath("$.[*].soDkkd").value(hasItem(DEFAULT_SO_DKKD)))
            .andExpect(jsonPath("$.[*].maSt").value(hasItem(DEFAULT_MA_ST)))
            .andExpect(jsonPath("$.[*].nguoiLh").value(hasItem(DEFAULT_NGUOI_LH)))
            .andExpect(jsonPath("$.[*].maDvikcb").value(hasItem(DEFAULT_MA_DVIKCB)))
            .andExpect(jsonPath("$.[*].maKhoikcb").value(hasItem(DEFAULT_MA_KHOIKCB)));
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
            .andExpect(jsonPath("$.ma").value(DEFAULT_MA))
            .andExpect(jsonPath("$.ten").value(DEFAULT_TEN))
            .andExpect(jsonPath("$.tongLd").value(DEFAULT_TONG_LD.intValue()))
            .andExpect(jsonPath("$.tongLuong").value(DEFAULT_TONG_LUONG.intValue()))
            .andExpect(jsonPath("$.loaiDv").value(DEFAULT_LOAI_DV))
            .andExpect(jsonPath("$.diachi").value(DEFAULT_DIACHI))
            .andExpect(jsonPath("$.dienthoai").value(DEFAULT_DIENTHOAI))
            .andExpect(jsonPath("$.fax").value(DEFAULT_FAX))
            .andExpect(jsonPath("$.soTaiKhoan").value(DEFAULT_SO_TAI_KHOAN))
            .andExpect(jsonPath("$.nganHang").value(DEFAULT_NGAN_HANG))
            .andExpect(jsonPath("$.maCqbh").value(DEFAULT_MA_CQBH))
            .andExpect(jsonPath("$.maTinh").value(DEFAULT_MA_TINH))
            .andExpect(jsonPath("$.maHuyen").value(DEFAULT_MA_HUYEN))
            .andExpect(jsonPath("$.soDkkd").value(DEFAULT_SO_DKKD))
            .andExpect(jsonPath("$.maSt").value(DEFAULT_MA_ST))
            .andExpect(jsonPath("$.nguoiLh").value(DEFAULT_NGUOI_LH))
            .andExpect(jsonPath("$.maDvikcb").value(DEFAULT_MA_DVIKCB))
            .andExpect(jsonPath("$.maKhoikcb").value(DEFAULT_MA_KHOIKCB));
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
            .ma(UPDATED_MA)
            .ten(UPDATED_TEN)
            .tongLd(UPDATED_TONG_LD)
            .tongLuong(UPDATED_TONG_LUONG)
            .loaiDv(UPDATED_LOAI_DV)
            .diachi(UPDATED_DIACHI)
            .dienthoai(UPDATED_DIENTHOAI)
            .fax(UPDATED_FAX)
            .soTaiKhoan(UPDATED_SO_TAI_KHOAN)
            .nganHang(UPDATED_NGAN_HANG)
            .maCqbh(UPDATED_MA_CQBH)
            .maTinh(UPDATED_MA_TINH)
            .maHuyen(UPDATED_MA_HUYEN)
            .soDkkd(UPDATED_SO_DKKD)
            .maSt(UPDATED_MA_ST)
            .nguoiLh(UPDATED_NGUOI_LH)
            .maDvikcb(UPDATED_MA_DVIKCB)
            .maKhoikcb(UPDATED_MA_KHOIKCB);
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
        assertThat(testDmDonVi.getTen()).isEqualTo(UPDATED_TEN);
        assertThat(testDmDonVi.getTongLd()).isEqualTo(UPDATED_TONG_LD);
        assertThat(testDmDonVi.getTongLuong()).isEqualTo(UPDATED_TONG_LUONG);
        assertThat(testDmDonVi.getLoaiDv()).isEqualTo(UPDATED_LOAI_DV);
        assertThat(testDmDonVi.getDiachi()).isEqualTo(UPDATED_DIACHI);
        assertThat(testDmDonVi.getDienthoai()).isEqualTo(UPDATED_DIENTHOAI);
        assertThat(testDmDonVi.getFax()).isEqualTo(UPDATED_FAX);
        assertThat(testDmDonVi.getSoTaiKhoan()).isEqualTo(UPDATED_SO_TAI_KHOAN);
        assertThat(testDmDonVi.getNganHang()).isEqualTo(UPDATED_NGAN_HANG);
        assertThat(testDmDonVi.getMaCqbh()).isEqualTo(UPDATED_MA_CQBH);
        assertThat(testDmDonVi.getMaTinh()).isEqualTo(UPDATED_MA_TINH);
        assertThat(testDmDonVi.getMaHuyen()).isEqualTo(UPDATED_MA_HUYEN);
        assertThat(testDmDonVi.getSoDkkd()).isEqualTo(UPDATED_SO_DKKD);
        assertThat(testDmDonVi.getMaSt()).isEqualTo(UPDATED_MA_ST);
        assertThat(testDmDonVi.getNguoiLh()).isEqualTo(UPDATED_NGUOI_LH);
        assertThat(testDmDonVi.getMaDvikcb()).isEqualTo(UPDATED_MA_DVIKCB);
        assertThat(testDmDonVi.getMaKhoikcb()).isEqualTo(UPDATED_MA_KHOIKCB);
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
