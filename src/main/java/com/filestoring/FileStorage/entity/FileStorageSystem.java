package com.filestoring.FileStorage.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "file_storage_system")
@Data
public class FileStorageSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long fileId;

    @Column(name = "filepath")
    private String filepath;

    @Column(name = "filename")
    private String filename;

    @Column(name = "filetype")
    private String filetype;
}
