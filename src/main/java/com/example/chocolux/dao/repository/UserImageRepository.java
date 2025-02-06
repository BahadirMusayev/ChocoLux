package com.example.chocolux.dao.repository;

import com.example.chocolux.dao.entity.UserImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserImageRepository extends JpaRepository<UserImageEntity, Integer> {
}
