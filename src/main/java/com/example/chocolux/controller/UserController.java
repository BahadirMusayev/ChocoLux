package com.example.chocolux.controller;

import com.example.chocolux.model.UserDtoInput;
import com.example.chocolux.model.UserDtoOutput;
import com.example.chocolux.service.UserService;
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
    public void sendTestimonialImage(@RequestParam("email") String email,
                                     @RequestParam("testimonial") String testimonial,
                                     @RequestParam("image") MultipartFile image) throws IOException {
        userService.sendTestimonial(email, testimonial, image);
    }

    @GetMapping("/show/testimonial")
    public UserDtoOutput showTestimonial(@RequestParam("id") Integer id) {
        return userService.showTestimonial(id);
    }
}
