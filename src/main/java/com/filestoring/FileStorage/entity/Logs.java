package com.filestoring.FileStorage.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
@Data
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;

    @Column(name = "timestamp",nullable = false)
    private LocalDateTime localDateTime;

    @Column(name = "logger",nullable = false)
    private String logger;

    @Column(name = "message",columnDefinition = "TEXT",nullable = false)
    private String message;

    @Column(name = "exception",columnDefinition = "TEXT")
    private String exception;

}
