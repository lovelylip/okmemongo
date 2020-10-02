package com.okme.fam.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DmDonViMapperTest {

    private DmDonViMapper dmDonViMapper;

    @BeforeEach
    public void setUp() {
        dmDonViMapper = new DmDonViMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(dmDonViMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(dmDonViMapper.fromId(null)).isNull();
    }
}
