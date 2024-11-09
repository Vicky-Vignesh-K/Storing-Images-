package com.filestoring.FileStorage.controller;

import com.filestoring.FileStorage.service.FileStorageSystemService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("fileStorage")
@Slf4j
public class FileStorageSystemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileStorageSystemController.class);

    @Autowired
    private FileStorageSystemService fileStorageSystemService;

    @PostMapping("saveFile")
    public ResponseEntity saveFile(@RequestParam MultipartFile multipartFile){
        LOGGER.info("Started Saving File Calling service Methods");
        return fileStorageSystemService.saveFile(multipartFile);
    }

    @GetMapping("getFile")
    public ResponseEntity getFile(@RequestParam String filename){
        log.info("Getting File Started");
        return fileStorageSystemService.getFile(filename);
    }

}
