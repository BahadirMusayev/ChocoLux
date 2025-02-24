package com.example.chocolux.dao.repository;

import com.example.chocolux.dao.entity.ChocolateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChocolateRepository extends JpaRepository<ChocolateEntity, Integer> {
    ChocolateEntity findByNameIgnoreCase(String name);
}
