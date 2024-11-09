package com.filestoring.FileStorage.repository;

import com.filestoring.FileStorage.entity.FileStorageSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IFileStorageSystemRepository extends JpaRepository<FileStorageSystem,Long> {

    Optional<FileStorageSystem> findByFilename(String filename);

}
