package com.filestoring.FileStorage.repository;

import com.filestoring.FileStorage.entity.ImageFileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageFileRepository extends JpaRepository<ImageFileData,Long> {

    Optional<ImageFileData> findByFilename(String filename);

}
