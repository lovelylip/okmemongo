package com.okme.fam.service.impl;

import com.okme.fam.service.DmCqbhService;
import com.okme.fam.domain.DmCqbh;
import com.okme.fam.repository.DmCqbhRepository;
import com.okme.fam.service.dto.DmCqbhDTO;
import com.okme.fam.service.mapper.DmCqbhMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link DmCqbh}.
 */
@Service
public class DmCqbhServiceImpl implements DmCqbhService {

    private final Logger log = LoggerFactory.getLogger(DmCqbhServiceImpl.class);

    private final DmCqbhRepository dmCqbhRepository;

    private final DmCqbhMapper dmCqbhMapper;

    public DmCqbhServiceImpl(DmCqbhRepository dmCqbhRepository, DmCqbhMapper dmCqbhMapper) {
        this.dmCqbhRepository = dmCqbhRepository;
        this.dmCqbhMapper = dmCqbhMapper;
    }

    @Override
    public DmCqbhDTO save(DmCqbhDTO dmCqbhDTO) {
        log.debug("Request to save DmCqbh : {}", dmCqbhDTO);
        DmCqbh dmCqbh = dmCqbhMapper.toEntity(dmCqbhDTO);
        dmCqbh = dmCqbhRepository.save(dmCqbh);
        return dmCqbhMapper.toDto(dmCqbh);
    }

    @Override
    public Page<DmCqbhDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DmCqbhs");
        return dmCqbhRepository.findAll(pageable)
            .map(dmCqbhMapper::toDto);
    }


    @Override
    public Optional<DmCqbhDTO> findOne(String id) {
        log.debug("Request to get DmCqbh : {}", id);
        return dmCqbhRepository.findById(id)
            .map(dmCqbhMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete DmCqbh : {}", id);
        dmCqbhRepository.deleteById(id);
    }
}
