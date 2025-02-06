package com.example.chocolux.controller;

import com.example.chocolux.model.ChocolateDtoInput;
import com.example.chocolux.service.ChocolateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chocolate")
public class ChocolateController {
    private final ChocolateService chocolateService;

    public ChocolateController(ChocolateService chocolateService) {
        this.chocolateService = chocolateService;
    }

    @PostMapping("/add/chocolate")
    public void addChocolate(@RequestBody ChocolateDtoInput chocolateDtoInput) {
        chocolateService.addChocolate(chocolateDtoInput );
    }
}