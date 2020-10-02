package com.okme.fam.service.mapper;


import com.okme.fam.domain.*;
import com.okme.fam.service.dto.DmDonViDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DmDonVi} and its DTO {@link DmDonViDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DmDonViMapper extends EntityMapper<DmDonViDTO, DmDonVi> {



    default DmDonVi fromId(String id) {
        if (id == null) {
            return null;
        }
        DmDonVi dmDonVi = new DmDonVi();
        dmDonVi.setId(id);
        return dmDonVi;
    }
}
