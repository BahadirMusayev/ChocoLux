package com.example.chocolux.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chocolates")
public class ChocolateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    @OneToOne(mappedBy = "chocolateEntity")
    @JsonManagedReference
    private ChocolateImageEntity chocolateImageEntity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @JsonBackReference
    private OwnerEntity ownerEntity;

    public ChocolateEntity(){
    }
}
