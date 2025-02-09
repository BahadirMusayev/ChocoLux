package com.example.chocolux.controller;

import com.example.chocolux.model.OwnerDto;
import com.example.chocolux.service.OwnerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/crate/owner")
    public void createOwner(@RequestBody OwnerDto ownerDto){
        ownerService.createOwner(ownerDto);
    }

    @PostMapping("/edit/about/company")
    public void editAboutCompany(@RequestParam("aboutCompany") String aboutCompany){
        ownerService.editAboutCompany(aboutCompany);
    }

    @GetMapping("/show/about/company")
    public OwnerDto showAboutCompany(){
        return ownerService.showAboutCompany();
    }
}
