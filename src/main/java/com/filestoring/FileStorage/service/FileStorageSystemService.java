package com.filestoring.FileStorage.service;

import com.filestoring.FileStorage.business.FileStorageSystemBO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileStorageSystemService {

    private static final Logger logger = LogManager.getLogger(FileStorageSystemService.class);
    @Autowired
    private FileStorageSystemBO fileStorageSystemBO;

    public ResponseEntity saveFile(MultipartFile multipartFile){
        String result = null;
        try {
            if(multipartFile != null) {
                logger.info("Started Saving File in Service");
                result = fileStorageSystemBO.saveFile(multipartFile);

                return new ResponseEntity(result, HttpStatus.CREATED);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity(result, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity getFile(String filename){
        logger.info("Searching file");
        byte[] data = fileStorageSystemBO.getFile(filename);
        if(data != null){

            return ResponseEntity.ok().contentType(MediaType.valueOf("image/jpeg")).body(data);
        }
        return new ResponseEntity(filename,HttpStatus.NOT_FOUND);
    }

}
