package com.example.chocolux.controller;

import com.example.chocolux.model.OwnerDto;
import com.example.chocolux.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/crate/owner")
    public void createOwner(@Valid @RequestBody OwnerDto ownerDto){
        ownerService.createOwner(ownerDto);
    }

    @PutMapping("/edit/about/company")
    public void editAboutCompany(@RequestParam("aboutCompany") String aboutCompany){
        ownerService.editAboutCompany(aboutCompany);
    }

    @GetMapping("/show/about/company")
    public OwnerDto showAboutCompany(){
        return ownerService.showAboutCompany();
    }
}
