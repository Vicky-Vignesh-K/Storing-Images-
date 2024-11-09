package com.filestoring.FileStorage.controller;

import com.filestoring.FileStorage.service.ImageFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("image")
public class ImageFileController {

    @Autowired
    private ImageFileService imageFileService;

    @PostMapping("uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("image")MultipartFile multipartFile){
        return imageFileService.uploadFile(multipartFile);
    }

    @GetMapping("downloadFile")
    public ResponseEntity downloadFile(@RequestParam String filename){
        return imageFileService.downloadFile(filename);
    }

}
