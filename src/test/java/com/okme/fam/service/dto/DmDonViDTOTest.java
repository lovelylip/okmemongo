package com.okme.fam.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.okme.fam.web.rest.TestUtil;

public class DmDonViDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DmDonViDTO.class);
        DmDonViDTO dmDonViDTO1 = new DmDonViDTO();
        dmDonViDTO1.setId("id1");
        DmDonViDTO dmDonViDTO2 = new DmDonViDTO();
        assertThat(dmDonViDTO1).isNotEqualTo(dmDonViDTO2);
        dmDonViDTO2.setId(dmDonViDTO1.getId());
        assertThat(dmDonViDTO1).isEqualTo(dmDonViDTO2);
        dmDonViDTO2.setId("id2");
        assertThat(dmDonViDTO1).isNotEqualTo(dmDonViDTO2);
        dmDonViDTO1.setId(null);
        assertThat(dmDonViDTO1).isNotEqualTo(dmDonViDTO2);
    }
}
