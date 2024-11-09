package com.filestoring.FileStorage.service;

import com.filestoring.FileStorage.business.ImageFileBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageFileService {

    @Autowired
    private ImageFileBO imageFileBO;

    public ResponseEntity<String> uploadFile(MultipartFile multipartFile) {
        String status = imageFileBO.saveImageToDB(multipartFile);
        return ResponseEntity.ok(status);
    }

    public ResponseEntity downloadFile(String filename) {
        byte[] imageData = imageFileBO.downloadImage(filename);
        if (imageData != null && imageData.length > 0)
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.valueOf("image/jpeg"))
                    .body(imageData);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error in Downloading Image");
    }

}
