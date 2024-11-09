package com.filestoring.FileStorage.service;

import com.filestoring.FileStorage.business.UserDataBO;
import com.filestoring.FileStorage.entity.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserDataService {
    @Autowired
    private UserDataBO userDataBO;

    public ResponseEntity<UserData> saveUserDetails(UserData userData, MultipartFile multipartFile) {
        try {
            if (userDataBO.saveUserDetailsWithImage(userData,multipartFile)!= null)
                return new ResponseEntity<>(userData, HttpStatus.CREATED);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.internalServerError().body(userData);
    }

    public ResponseEntity getUserImage(UserData userData) {
        userData = userDataBO.getUserImageByUsernameAndId(userData);
        if(userData != null){
            return ResponseEntity.ok().contentType(MediaType.valueOf(/*userData.getFileType()*/"image/jpeg")).body(userData.getFileData());
        }
        return ResponseEntity.notFound().build();
    }
}
