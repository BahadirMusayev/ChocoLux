package com.example.chocolux.controller;

import com.example.chocolux.model.UserDtoInput;
import com.example.chocolux.model.UserDtoOutput;
import com.example.chocolux.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/contacts/us")
    public void contactUs(@RequestBody UserDtoInput userDtoInput){
        userService.contactUs(userDtoInput);
    }

    @PostMapping("/send/testimonial")
    public void sendTestimonial(String email, String testimonial){
        userService.sendTestimonial(email, testimonial);
    }

    @GetMapping("/show/testimonials")
    public List<UserDtoOutput> showTestimonials(){
        return userService.showTestimonials();
    }
}
