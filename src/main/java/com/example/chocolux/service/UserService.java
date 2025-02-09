package com.example.chocolux.service;

import com.example.chocolux.dao.entity.UserEntity;
import com.example.chocolux.dao.entity.UserTestimonialEntity;
import com.example.chocolux.dao.exception.NotFoundException;
import com.example.chocolux.dao.repository.UserTestimonialRepository;
import com.example.chocolux.dao.repository.UserRepository;
import com.example.chocolux.mapper.UserMapper;
import com.example.chocolux.model.UserDtoInput;
import com.example.chocolux.model.UserDtoOutput;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final UserTestimonialRepository userTestimonialRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper, UserTestimonialRepository userTestimonialRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userTestimonialRepository = userTestimonialRepository;
    }

    @Transactional
    public void contactUs(UserDtoInput userDtoInput) {
        log.info("Contact Us Started... ");

        UserEntity userEntity = userMapper.
                mapUserDtoInputToEntity(userDtoInput);
        userRepository.save(userEntity);

        log.info("Contact Us Ended ");
    }

    @Transactional
    public void sendTestimonial(String email, String testimonial, MultipartFile image) throws IOException {
        log.info("Send Testimonial Started... ");

        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            throw new NotFoundException("This user has not applied ");
        }
        UserTestimonialEntity userTestimonial = new UserTestimonialEntity();
        byte[] imageData = image.getBytes();
        userTestimonial.setTestimonial(testimonial);
        userTestimonial.setUserEntity(userEntity);
        userTestimonial.setImage(imageData);
        userTestimonial.setUserEntity(userEntity);
        userTestimonialRepository.save(userTestimonial);

        log.info("Send Testimonial Ended ");
    }

    public UserDtoOutput showTestimonial(String email, Integer testimonialID) {
        log.info("Show Testimonial Started... ");

        UserEntity userEntity = userRepository.
                findByEmail(email);
        if(userEntity==null){
            throw new NotFoundException("User Not Found !");
        }
        UserDtoOutput userDtoOutput = new UserDtoOutput();
        userDtoOutput.setFullName(userEntity.getFullName());
        if (testimonialID >= userEntity.getTestimonials().size() || testimonialID < 0) {
            throw new NotFoundException("Invalid Testimonial ID");
        }
        userDtoOutput.setTestimonial(userEntity.getTestimonials()
                .get(testimonialID).getTestimonial());
        return userDtoOutput;
    }

    public void showTestimonialImage(String email, Integer testimonialID, HttpServletResponse response) throws IOException {
        log.info("Show Testimonial Image Started... ");

        UserEntity userEntity = userRepository.findByEmail(email);

        if (testimonialID > userEntity.getTestimonials().size() || testimonialID < 0) {
            throw new NotFoundException("Invalid Testimonial ID");
        }

        UserTestimonialEntity testimonial = userTestimonialRepository.findById(testimonialID)
                .orElseThrow(() -> new NotFoundException("Testimonial Not Found"));

        if (!testimonial.getUserEntity().getId().equals(userEntity.getId())) {
            throw new NotFoundException("Testimonial does not belong to this user");
        }

        byte[] imageData = testimonial.getImage();

        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        response.getOutputStream().write(imageData);
        response.getOutputStream().flush();

        log.info("Show Testimonial Image Ended ");
    }
}
