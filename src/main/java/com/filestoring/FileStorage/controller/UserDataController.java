package com.filestoring.FileStorage.controller;

import com.filestoring.FileStorage.entity.UserData;
import com.filestoring.FileStorage.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("user")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping(value = "saveUserDetails"/*,consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE*/)
    public ResponseEntity savaUser(@RequestPart UserData userData, @RequestPart MultipartFile multipartFile){
        return userDataService.saveUserDetails(userData,multipartFile);
    }

    @PostMapping("getUserImageByUsernameAndId")
    public ResponseEntity getUserImage(@RequestBody UserData userData){
        return userDataService.getUserImage(userData);
    }
}
