package com.example.chocolux.controller;

import com.example.chocolux.model.UserDtoInput;
import com.example.chocolux.model.UserDtoOutput;
import com.example.chocolux.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/contacts/us")
    public void contactUs(@RequestBody UserDtoInput userDtoInput) {
        userService.contactUs(userDtoInput);
    }

    @PostMapping(value = "/send/testimonial", consumes = "multipart/form-data")
    public void sendTestimonial(@RequestParam("email") String email,
                                     @RequestParam("testimonial") String testimonial,
                                     @RequestParam("image") MultipartFile image) throws IOException {
        userService.sendTestimonial(email, testimonial, image);
    }

    @GetMapping("/show/testimonial")
    public UserDtoOutput showTestimonial(@RequestParam("email") String email,
                                         @RequestParam("testimonial") Integer testimonialID) {
        return userService.showTestimonial(email, testimonialID);
    }

    @GetMapping("/show/testimonial/image")
    public void showTestimonialImage(@RequestParam("email") String email,
                                    @RequestParam("testimonialID") Integer testimonialID,
                                    HttpServletResponse response) throws IOException {
        userService.showTestimonialImage(email, testimonialID, response);
    }
}
