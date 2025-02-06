package com.example.chocolux.service;

import com.example.chocolux.dao.entity.ChocolateEntity;
import com.example.chocolux.dao.entity.ChocolateImageEntity;
import com.example.chocolux.dao.repository.ChocolateImageRepository;
import com.example.chocolux.dao.repository.ChocolateRepository;
import com.example.chocolux.mapper.ChocolateMapper;
import com.example.chocolux.model.ChocolateDto;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public void addChocolate(ChocolateDto chocolateDto, MultipartFile image) throws IOException{
        log.info("Add Chocolate Started... ");
        ChocolateEntity chocolateEntity = chocolateMapper.
                mapChocolateDtoToEntity(chocolateDto);
        byte[] imageData = image.getBytes();
        ChocolateImageEntity chocolateImageEntity = chocolateEntity.getChocolateImageEntity();
        if (chocolateImageEntity == null) {
            ChocolateImageEntity chocolateImage = new ChocolateImageEntity();
            chocolateImage.setImage(imageData);
            chocolateImage.setChocolateEntity(chocolateEntity);
            chocolateImageRepository.save(chocolateImage);
        } else {
            chocolateImageEntity.setImage(imageData);
            chocolateImageRepository.save(chocolateImageEntity);
        }
        chocolateRepository.save(chocolateEntity);
        log.info("Add Chocolate Ended ");
    }
}
