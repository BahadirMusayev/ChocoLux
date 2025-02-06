package com.example.chocolux.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDtoInput {
    private String fullName;
    private Long phoneNumber;
    private String email;
    private String message;
}
