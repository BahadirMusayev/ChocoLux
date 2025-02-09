package com.example.chocolux.model;

import com.example.chocolux.validation.ValidEmail;
import com.example.chocolux.validation.ValidPhone;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDtoInput {
    @NotBlank(message = "The Full Name cannot be empty ")
    private String fullName;
    @Digits(integer = 15, fraction = 0, message = "Phone number must contain only digits and be 10 to 15 characters long")
    @Min(value = 10, message = "Phone number must contain only digits and be 10 to 15 characters long")
    @ValidPhone
    private Long phoneNumber;
    @NotBlank(message = "The Email cannot be empty ")
    @Size(min = 5, max = 30, message = "E-mail must be between 5 and 30 characters")
    @ValidEmail
    private String email;
    @NotBlank(message = "The message cannot be empty ")
    private String message;
}
