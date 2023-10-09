package com.api.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	
	public final String Upload_dir="/Users/dineshmarasini/Desktop/springSTS/BootWithRESTAPI/src/main/resources/static/image";
	
	public boolean isFileUpload(MultipartFile multipartFile) {
		
		boolean f =false;
		
		try {
//			InputStream iStream=multipartFile.getInputStream();
//			byte data[]=new byte[iStream.available()];
//			iStream.read(data);
//			
//			//Write
//			FileOutputStream fileOutputStream=new FileOutputStream(Upload_dir+"\\"+multipartFile.getOriginalFilename());
//			fileOutputStream.write(data);
//			fileOutputStream.flush();
//			fileOutputStream.close();
		
			 Files.copy(multipartFile.getInputStream(),Paths.get( Upload_dir+File.separator+multipartFile.getOriginalFilename() ), StandardCopyOption.REPLACE_EXISTING );
			
			f=true; 
		
			
			
			
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		 return f;
	}
}
