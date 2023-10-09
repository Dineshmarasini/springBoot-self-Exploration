package com.api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired(required = true)
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("thumbnail") MultipartFile file ){
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
		
	try {
		
		//validation
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain the file");
		   }
		if(!file.getContentType().equals("image/png")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Must be in the png type");
		   }
		//File upload code
	   boolean f= fileUploadHelper.isFileUpload(file); 
	   
	   if(f) {
		   return ResponseEntity.ok("File uploaded succcessfully");
	   }
		
  }
		catch (Exception e) {
			 e.printStackTrace();
		}
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong  !!!");
	}

}
