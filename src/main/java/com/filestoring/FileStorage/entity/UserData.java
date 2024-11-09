package com.filestoring.FileStorage.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_details")
@Data
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_email")
    private String email;
    @Column(name = "filename")
    private String filename;
    @Column(name = "file_Type")
    private String fileType;

    @Lob
    @Column(name = "file_data",columnDefinition="MEDIUMBLOB")
    private byte[] fileData;


//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getFilename() {
//        return filename;
//    }
//
//    public void setFilename(String filename) {
//        this.filename = filename;
//    }
//
//    public String getFileType() {
//        return fileType;
//    }
//
//    public void setFileType(String fileType) {
//        this.fileType = fileType;
//    }
//
//    public byte[] getFileData() {
//        return fileData;
//    }
//
//    public void setFileData(byte[] fileData) {
//        this.fileData = fileData;
//    }
}
