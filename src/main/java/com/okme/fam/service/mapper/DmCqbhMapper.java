package com.okme.fam.service.mapper;


import com.okme.fam.domain.*;
import com.okme.fam.service.dto.DmCqbhDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DmCqbh} and its DTO {@link DmCqbhDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DmCqbhMapper extends EntityMapper<DmCqbhDTO, DmCqbh> {



    default DmCqbh fromId(String id) {
        if (id == null) {
            return null;
        }
        DmCqbh dmCqbh = new DmCqbh();
        dmCqbh.setId(id);
        return dmCqbh;
    }
}
