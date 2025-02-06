package com.example.chocolux.controller;

import com.example.chocolux.model.OwnerDto;
import com.example.chocolux.service.OwnerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/edit/about/company")
    public void editAboutCompany(String aboutCompany){
        ownerService.editAboutCompany(aboutCompany);
    }

    @GetMapping("/show/about/company")
    public OwnerDto showAboutCompany(){
        return ownerService.showAboutCompany();
    }
}
