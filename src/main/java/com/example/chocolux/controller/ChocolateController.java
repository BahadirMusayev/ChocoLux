package com.example.chocolux.controller;

import com.example.chocolux.model.ChocolateDtoInput;
import com.example.chocolux.service.ChocolateService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @PostMapping(value = "/add/chocolate/image", consumes = "multipart/form-data")
    public void addChocolateImage(@RequestParam("name") String name,
                                  @RequestParam("image") MultipartFile image) throws IOException{
        chocolateService.addChocolateImage(name, image);
    }
}