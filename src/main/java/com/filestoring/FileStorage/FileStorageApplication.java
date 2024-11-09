package com.filestoring.FileStorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackages = "com.filestoring.FileStorage")
public class FileStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileStorageApplication.class, args);
	}

}
