package com.example.chocolux.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChocolateDto {
    @NotBlank(message = "The name cannot be empty ")
    private String name;
    @NotNull(message = "The price cannot be empty ")
    private Double price;
}
