package com.cheerup.cheerup.repository;

import com.cheerup.cheerup.model.Saying;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SayingRepository extends JpaRepository<Saying, Long> {
    Saying findByNum(Long num);
}