package com.filestoring.FileStorage.business;

import com.filestoring.FileStorage.entity.FileStorageSystem;
import com.filestoring.FileStorage.repository.IFileStorageSystemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class FileStorageSystemBO {

    @Autowired
    private IFileStorageSystemRepository fileStorageSystemRepository;

    private static final Logger logger = LoggerFactory.getLogger(FileStorageSystemBO.class);
    @Value("${filepath.file}")
    private String filepath;

    public String saveFile(MultipartFile multipartFile) throws IOException {
        FileStorageSystem fileStorageSystem = new FileStorageSystem();
        fileStorageSystem.setFilename(multipartFile.getOriginalFilename());
        fileStorageSystem.setFiletype(multipartFile.getContentType());
        fileStorageSystem.setFilepath(filepath+multipartFile.getOriginalFilename());
        fileStorageSystem = fileStorageSystemRepository.save(fileStorageSystem);
        if(fileStorageSystem != null){
            multipartFile.transferTo(new File(filepath+multipartFile.getOriginalFilename()));
            logger.info("File Saved in the Give Path Successfully");
            return "File Stored Successfully";
        }
        return "Error in Saving File";
    }


    public byte[] getFile(String filename){
        FileStorageSystem fileStorageSystem = fileStorageSystemRepository.findByFilename(filename).orElseThrow(() -> new RuntimeException("File Not Found for the Given Name" + filename));
        logger.info("File Found found the location");
        String localFilepath = fileStorageSystem.getFilepath();
        try {
            byte[] fileData = Files.readAllBytes(new File(localFilepath).toPath());
            return fileData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
