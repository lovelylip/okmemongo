package com.okme.fam.service.impl;

import com.okme.fam.service.DmDonViService;
import com.okme.fam.domain.DmDonVi;
import com.okme.fam.repository.DmDonViRepository;
import com.okme.fam.service.dto.DmDonViDTO;
import com.okme.fam.service.mapper.DmDonViMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link DmDonVi}.
 */
@Service
public class DmDonViServiceImpl implements DmDonViService {

    private final Logger log = LoggerFactory.getLogger(DmDonViServiceImpl.class);

    private final DmDonViRepository dmDonViRepository;

    private final DmDonViMapper dmDonViMapper;

    public DmDonViServiceImpl(DmDonViRepository dmDonViRepository, DmDonViMapper dmDonViMapper) {
        this.dmDonViRepository = dmDonViRepository;
        this.dmDonViMapper = dmDonViMapper;
    }

    @Override
    public DmDonViDTO save(DmDonViDTO dmDonViDTO) {
        log.debug("Request to save DmDonVi : {}", dmDonViDTO);
        DmDonVi dmDonVi = dmDonViMapper.toEntity(dmDonViDTO);
        dmDonVi = dmDonViRepository.save(dmDonVi);
        return dmDonViMapper.toDto(dmDonVi);
    }

    @Override
    public Page<DmDonViDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DmDonVis");
        return dmDonViRepository.findAll(pageable)
            .map(dmDonViMapper::toDto);
    }


    @Override
    public Optional<DmDonViDTO> findOne(String id) {
        log.debug("Request to get DmDonVi : {}", id);
        return dmDonViRepository.findById(id)
            .map(dmDonViMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete DmDonVi : {}", id);
        dmDonViRepository.deleteById(id);
    }
}
