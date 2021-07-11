package com.cheerup.cheerup.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Ip {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long totalVisitors;

    @Column(nullable = false)
    private String Ip;

    public Ip(String receivedIp){
        this.Ip = receivedIp;
    }
}
