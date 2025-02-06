package com.example.chocolux.dao.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private Long phoneNumber;
    private String email;
    private String message;
    private String testimonial;

    @OneToOne(mappedBy = "userEntity")
    @JsonManagedReference
    private UserImageEntity userImageEntity;
    public UserEntity(){
    }
}
