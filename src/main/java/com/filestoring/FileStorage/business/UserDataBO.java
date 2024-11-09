package com.filestoring.FileStorage.business;

import com.filestoring.FileStorage.entity.UserData;
import com.filestoring.FileStorage.repository.IUserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class UserDataBO {

    @Autowired
    private IUserDataRepository userDataRepository;

    public UserData saveUserDetailsWithImage(UserData userData, MultipartFile multipartFile) throws IOException {
        if(userData!= null) {
            userData.setFilename(multipartFile.getOriginalFilename());
            userData.setFileType(multipartFile.getContentType());
            userData.setFileData(multipartFile.getBytes());
            userData = userDataRepository.save(userData);
            if(userData != null) {
//                userData.setFileData(null);
                return userData;
            }
        }return null;
    }

    public UserData getUserImageByUsernameAndId(UserData userData){
        userData = userDataRepository.findByUsernameAndUserId(userData.getUsername(), userData.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found for the Given Name and Id"));
        if(userData != null){
            return userData;
        }return null;
    }

}
