package com.lockedMeApp.dao;

import java.io.IOException;
import java.util.List;

import com.lockedMeApp.exceptions.BusinessException;
import com.lockedMeApp.modal.Files;

public interface FilesDAO {
	
	public void addFile(Files file) throws BusinessException, IOException;
	
	public void getFilesByFilename(String fname) throws BusinessException, IOException;
	
	public void deleteFile(String fname) throws BusinessException, IOException;
	
	public void getAllFiles() throws BusinessException;

}
