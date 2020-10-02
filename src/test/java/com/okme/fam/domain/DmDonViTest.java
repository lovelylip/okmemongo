package com.okme.fam.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.okme.fam.web.rest.TestUtil;

public class DmDonViTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DmDonVi.class);
        DmDonVi dmDonVi1 = new DmDonVi();
        dmDonVi1.setId("id1");
        DmDonVi dmDonVi2 = new DmDonVi();
        dmDonVi2.setId(dmDonVi1.getId());
        assertThat(dmDonVi1).isEqualTo(dmDonVi2);
        dmDonVi2.setId("id2");
        assertThat(dmDonVi1).isNotEqualTo(dmDonVi2);
        dmDonVi1.setId(null);
        assertThat(dmDonVi1).isNotEqualTo(dmDonVi2);
    }
}
