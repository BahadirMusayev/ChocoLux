package com.example.chocolux.dao.repository;

import com.example.chocolux.dao.entity.UserTestimonialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTestimonialRepository extends JpaRepository<UserTestimonialEntity, Integer> {
}
