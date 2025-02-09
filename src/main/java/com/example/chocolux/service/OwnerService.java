package com.example.chocolux.service;

import com.example.chocolux.dao.entity.OwnerEntity;
import com.example.chocolux.dao.exception.NotFoundException;
import com.example.chocolux.dao.repository.OwnerRepository;
import com.example.chocolux.mapper.OwnerMapper;
import com.example.chocolux.model.OwnerDto;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OwnerService {

    private final OwnerRepository ownerRepository;

    private final OwnerMapper ownerMapper;

    public OwnerService(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
    }

    @Transactional
    public void createOwner(OwnerDto ownerDto){
        log.info("Create Owner Started... ");

        OwnerEntity ownerEntity = ownerMapper.
                mapOwnerDtoToEntity(ownerDto);
        ownerRepository.save(ownerEntity);

        log.info("Create Owner Ended ");
    }

    @Transactional
    public void editAboutCompany(String aboutCompany){
        log.info("Edit Company Started... ");

        OwnerEntity ownerEntity = ownerRepository.findById(1).
                orElseThrow(()-> new NotFoundException("Owner Not Found !"));
        ownerEntity.setAboutCompany(aboutCompany);
        ownerRepository.save(ownerEntity);

        log.info("Edit Company Ended ");
    }

    public OwnerDto showAboutCompany(){
        log.info("Show About Company Started... ");

        OwnerEntity ownerEntity = ownerRepository.
                findById(1).orElseThrow(()-> new NotFoundException("Owner Not Found !"));
        return ownerMapper.
                mapOwnerEntityToDto(ownerEntity);
    }
}
