package com.example.chocolux.service;

import com.example.chocolux.dao.entity.OwnerEntity;
import com.example.chocolux.dao.repository.OwnerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public void editAboutCompany(String aboutCompany){
        log.info("Edit Company Started... ");
        OwnerEntity ownerEntity = ownerRepository.
                findById(1).orElseThrow();
        ownerEntity.setAboutCompany(aboutCompany);
        ownerRepository.save(ownerEntity);
        log.info("Edit Company Ended ");
    }
}
