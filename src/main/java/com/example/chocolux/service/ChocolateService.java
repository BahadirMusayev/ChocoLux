package com.example.chocolux.service;

import com.example.chocolux.dao.entity.ChocolateEntity;
import com.example.chocolux.dao.entity.ChocolateImageEntity;
import com.example.chocolux.dao.exception.FoundException;
import com.example.chocolux.dao.exception.NotFoundException;
import com.example.chocolux.dao.repository.ChocolateImageRepository;
import com.example.chocolux.dao.repository.ChocolateRepository;
import com.example.chocolux.dao.repository.OwnerRepository;
import com.example.chocolux.mapper.ChocolateMapper;
import com.example.chocolux.model.ChocolateDto;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;

@Service
@Slf4j
public class ChocolateService {

    private final ChocolateRepository chocolateRepository;

    private final ChocolateMapper chocolateMapper;

    private final ChocolateImageRepository chocolateImageRepository;

    private final OwnerRepository ownerRepository;

    public ChocolateService(ChocolateRepository chocolateRepository, ChocolateMapper chocolateMapper, ChocolateImageRepository chocolateImageRepository, OwnerRepository ownerRepository) {
        this.chocolateRepository = chocolateRepository;
        this.chocolateMapper = chocolateMapper;
        this.chocolateImageRepository = chocolateImageRepository;
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public void addChocolate(ChocolateDto chocolateDto) {
        log.info("Add Chocolate Started... ");

        ChocolateEntity chocolateEntity = chocolateMapper.
                mapChocolateDtoInputToEntity(chocolateDto);
        if (chocolateRepository.findByNameIgnoreCase(chocolateDto.getName()) != null) {
            throw new FoundException("This chocolate is also found");
        }
        chocolateEntity.setOwnerEntity(ownerRepository.findById(1).orElseThrow());
        chocolateRepository.save(chocolateEntity);

        log.info("Add Chocolate Ended ");
    }

    @Transactional
    public void editChocolateImage(String name, MultipartFile image) throws IOException {
        log.info("Add Chocolate Image Started... ");

        ChocolateEntity chocolateEntity = chocolateRepository.
                findByNameIgnoreCase(name);
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

        log.info("Add Chocolate Image Ended ");
    }

    public ChocolateDto showChocolate(String name){
        log.info("Show Chocolate Started... ");

        ChocolateEntity chocolateEntity = chocolateRepository.findByNameIgnoreCase(name);
        if(chocolateEntity==null){
            throw new NotFoundException("Chocolate Not Found ");
        }
        return chocolateMapper.
                mapEntityToChocolateDtoOutput(chocolateEntity);
    }

    public void showChocolateImage(String name, HttpServletResponse response) throws IOException {
        log.info("Show Chocolate Image Started... ");

        ChocolateEntity chocolateEntity = chocolateRepository.
                findByNameIgnoreCase(name);
        ChocolateImageEntity chocolateImageEntity = chocolateEntity.getChocolateImageEntity();
        if(chocolateImageEntity == null){
            throw new NotFoundException("Chocolate Image Not Found !");
        }
        byte[] imageData = chocolateImageEntity.getImage();

        response.setContentType("image/png");
        response.setContentLength(imageData.length);
        response.setHeader("Content-Disposition", "inline; filename=\"profile.png\"");

        OutputStream outputStream = response.getOutputStream();
        outputStream.write(imageData);
        outputStream.flush();

        log.info("Show Chocolate Image Ended ");
    }
}
