package com.example.chocolux.controller;

import com.example.chocolux.model.ChocolateDto;
import com.example.chocolux.service.ChocolateService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Validated
@RequestMapping("/api/chocolate")
public class ChocolateController {

    private final ChocolateService chocolateService;

    public ChocolateController(ChocolateService chocolateService) {
        this.chocolateService = chocolateService;
    }

    @PostMapping("/add/chocolate")
    public void addChocolate(@Valid @RequestBody ChocolateDto chocolateDto) {
        chocolateService.addChocolate(chocolateDto);
    }

    @PutMapping(value = "/edit/chocolate/image", consumes = "multipart/form-data")
    public void editChocolateImage(@RequestParam("name") String name,
                                  @RequestParam("image") MultipartFile image) throws IOException{
        chocolateService.editChocolateImage(name, image);
    }

    @GetMapping("/show/chocolate")
    public ChocolateDto showChocolate(@RequestParam("name") String name){
        return chocolateService.showChocolate(name);
    }

    @GetMapping("/show/chocolate/image")
    public void showChocolateImage(@RequestParam("name") String name,
                                   HttpServletResponse response)throws IOException{
        chocolateService.showChocolateImage(name, response);
    }
}