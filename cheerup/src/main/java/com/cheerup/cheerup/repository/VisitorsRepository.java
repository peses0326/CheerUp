package com.cheerup.cheerup.repository;

import com.cheerup.cheerup.model.Visitors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitorsRepository extends JpaRepository<Visitors, Long> {
    List<Visitors> findAll();
}