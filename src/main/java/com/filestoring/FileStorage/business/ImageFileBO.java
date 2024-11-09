package com.filestoring.FileStorage.business;

import com.filestoring.FileStorage.entity.ImageFileData;
import com.filestoring.FileStorage.repository.ImageFileRepository;
import com.filestoring.FileStorage.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class ImageFileBO {

    @Autowired
    private ImageFileRepository imageFileRepository;

    public String saveImageToDB(MultipartFile imageFile)  {
        if(imageFile != null) {
            ImageFileData imageFileData = null;
            try {
                imageFileData = imageFileRepository.save(ImageFileData.builder()
                        .filename(imageFile.getOriginalFilename())
                        .fileType(imageFile.getContentType())
                                .imageData(imageFile.getBytes()).build());
//                        .imageData(ImageUtils.compressImage(imageFile.getBytes())).build());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(imageFileData != null){
                return "File Uploaded Successfully " + imageFile.getOriginalFilename();
            }
        }
        return "Error in Uploading Image File";
    }

    public byte[] downloadImage(String filename){
         ImageFileData imageFileData = imageFileRepository.findByFilename(filename)
                 .orElseThrow(() ->new RuntimeException("Image Not Available For the Given Name"));
//         return ImageUtils.decompressImage(imageFileData.getImageData());
        byte[] bytes = imageFileData.getImageData();
         return bytes;
    }

}
