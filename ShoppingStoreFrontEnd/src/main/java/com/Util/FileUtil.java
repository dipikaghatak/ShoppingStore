package com.Util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(FileUtil.class);
	/*private static final String imageDirectory = "ShoppingStoreImages";
	private static String rootPath = System.getProperty("catalina.home");*/
	/*private static String rootPath ="D:\\dipika workspace\\Shopping store\\ShoppingStoreFrontEnd\\src\\main\\webapp\\resources\\images";*/
	/*public static boolean  copyfile(MultipartFile file, String fileName)
	{
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				
				File dir = new File(rootPath + File.separator + imageDirectory + fileName);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + fileName);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	
		
	}*/
	 private static String rootPath = System.getProperty("user.dir");
	public static boolean fileCopyNIO(MultipartFile file, String fileName) {
		File dest = new  File(rootPath + File.separator  + fileName);
		System.out.println("where it is uploading ??"+ dest.getAbsolutePath());
		try {
			file.transferTo(dest);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
				
		
	}
	
	
	
	
}
