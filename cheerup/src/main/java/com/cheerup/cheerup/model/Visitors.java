package com.cheerup.cheerup.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Visitors {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long totalVisitors;

    public Visitors(long totalVisitors) {
        this.totalVisitors = totalVisitors;
    }
}