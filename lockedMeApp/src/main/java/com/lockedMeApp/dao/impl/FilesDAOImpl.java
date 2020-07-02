package com.lockedMeApp.dao.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import java.nio.file.*;


import com.lockedMeApp.dao.FilesDAO;
import com.lockedMeApp.exceptions.BusinessException;
import com.lockedMeApp.modal.Files;

public class FilesDAOImpl implements FilesDAO{
	
	private String dir = Paths.get("").toAbsolutePath().toString()+"/fileFolder/";
	private File filesdir = new File(dir);

	@Override
	public void addFile(Files file) throws BusinessException, IOException {
		File f = new File(dir + file.getFname());
	      
		if (f.createNewFile()) {
			System.out.println("File created: " + f.getName());
		} else {
					    
			throw new BusinessException("File Name already exists");
		}
				
	}

	@Override
	public void getFilesByFilename(String fname) throws BusinessException, IOException {
		File f = new File(dir + fname);
		
		if (f.getPath().equals(f.getCanonicalPath())) {
			System.out.println(f + " exists");
		}else {
			throw new BusinessException("File does not exists");
		}
	}

	@Override
	public void deleteFile(String fname) throws BusinessException, IOException {
		File f = new File(dir + fname);
		if (f.exists() && f.getCanonicalPath().endsWith(f.getName())){
			System.out.println(f + "exists");
			f.delete();
			System.out.println(fname + "deleted successfully");
		}else{
			throw new BusinessException("File does not exists");
		}
		/*if(f.delete()){
			
			System.out.println(fname + "deleted successfully");
		}else {
			throw new BusinessException("File does not exists");
		}*/
		
		
		/*if (f.getPath().equals(f.getCanonicalPath())) {
			System.out.println(f + "exists");
			f.delete();
			System.out.println(fname + "deleted successfully");
		}else {
			throw new BusinessException("File does not exists");
		}
		*/
	}

	@Override
	public void getAllFiles() throws BusinessException {
		File[] files = filesdir.listFiles();
		
		if(files.length < 1) {
			throw new BusinessException("Directory does not exists or Direcotry is empty");
		}
		System.out.println ("Files in the folder are :");
		
		for (File file : files)
        {
            if (file.isFile() && !file.isHidden())
            {   
                System.out.println(file.getName());
            }
           
        }
		
	}
	

}
