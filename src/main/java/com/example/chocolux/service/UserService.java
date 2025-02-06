package com.example.chocolux.service;

import com.example.chocolux.dao.entity.UserEntity;
import com.example.chocolux.dao.exception.NotFoundException;
import com.example.chocolux.dao.repository.UserRepository;
import com.example.chocolux.mapper.UserMapper;
import com.example.chocolux.model.UserDtoInput;
import com.example.chocolux.model.UserDtoOutput;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public void contactUs(UserDtoInput userDtoInput){
        log.info("Contact Us Started... ");
        UserEntity userEntity = userMapper.
                mapUserDtoInputToEntity(userDtoInput);
        userRepository.save(userEntity);
        log.info("Contact Us Ended ");
    }

    @Transactional
    public void sendTestimonial(String email, String testimonial){
        log.info("Send Testimonial Started... ");
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null){
            throw new NotFoundException("This user has not applied ");
        }
        userEntity.setTestimonial(testimonial);
        log.info("Send Testimonial Ended ");
    }

    public List<UserDtoOutput> showTestimonials(){
        log.info("Show Testimonials Started... ");
        List<UserEntity> userEntities = userRepository.
                findAll();
        return userMapper.
                mapUserEntityToDtoOutputs(userEntities);
    }

//    public ResponseEntity<byte []> showImages(){
//        log.info("Show Images Started... ");
//        UserEntity userEntity = userRepository.findAll();
//        UserImageEntity userImageEntity = userEntity.getUserImageEntity();
//        byte[] imageData = userImageEntity.getProfileImage();
//        if (imageData == null) {
//            throw new NotFoundException("No profile picture ");
//        }
//        return ResponseEntity.ok().
//                header("Content-Type", "image/png").
//                body(imageData);
//    }
}
