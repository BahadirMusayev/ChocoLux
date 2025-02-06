package com.example.chocolux.service;

import com.example.chocolux.dao.entity.ChocolateEntity;
import com.example.chocolux.dao.repository.ChocolateImageRepository;
import com.example.chocolux.dao.repository.ChocolateRepository;
import com.example.chocolux.mapper.ChocolateMapper;
import com.example.chocolux.model.ChocolateDtoInput;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChocolateService {

    private final ChocolateRepository chocolateRepository;

    private final ChocolateMapper chocolateMapper;

    private final ChocolateImageRepository chocolateImageRepository;

    public ChocolateService(ChocolateRepository chocolateRepository, ChocolateMapper chocolateMapper, ChocolateImageRepository chocolateImageRepository) {
        this.chocolateRepository = chocolateRepository;
        this.chocolateMapper = chocolateMapper;
        this.chocolateImageRepository = chocolateImageRepository;
    }

    @Transactional
    public void addChocolate(ChocolateDtoInput chocolateDtoInput ) {
        log.info("Add Chocolate Started... ");
        ChocolateEntity chocolateEntity = chocolateMapper.
                mapChocolateDtoInputToEntity(chocolateDtoInput);
        chocolateRepository.save(chocolateEntity);
        log.info("Add Chocolate Ended ");
    }

//    public List<ChocolateDtoOutput> showChocolates() {
//        log.info("Show Chocolates Started... ");
//        List<ChocolateEntity> chocolates = chocolateRepository.findAll();
//
//        return chocolates.stream()
//                .map(chocolate -> new ChocolateDtoOutput(
//                        chocolate.getName(),
//                        chocolate.getPrice()
////                        chocolate.getChocolateImageEntity() != null
////                                ? Collections.singletonList(Base64.getEncoder().encodeToString(chocolate.getChocolateImageEntity().getImage()))
////                                : null
//                ))
//                .toList();
//
//    }
}
