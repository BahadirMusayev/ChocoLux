package com.example.chocolux.dao.repository;

import com.example.chocolux.dao.entity.ChocolateImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChocolateImageRepository extends JpaRepository<ChocolateImageEntity, Integer> {
}
