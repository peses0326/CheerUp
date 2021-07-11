package com.cheerup.cheerup.repository;

import com.cheerup.cheerup.model.Ip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IpRepository extends JpaRepository<Ip, Long> {
    List<Ip> findAllByOrderByTotalVisitorsDesc();
}
