package com.example.chocolux.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OwnerDto {
    @NotBlank(message = "The Company Name cannot be empty ")
    private String nameCompany;
    private String aboutCompany;
}
