package com.lockedMeApp.bo.impl;


import java.io.IOException;
import java.util.List;

import com.lockedMeApp.bo.FilesBO;
import com.lockedMeApp.dao.FilesDAO;
import com.lockedMeApp.dao.impl.FilesDAOImpl;
import com.lockedMeApp.exceptions.BusinessException;
import com.lockedMeApp.modal.Files;

public class FilesBOImpl implements FilesBO {
	
	private FilesDAO dao;
	public FilesDAO getDao() {
		if(dao==null) {
			dao = new FilesDAOImpl();
		}
		return dao;
	}

	@Override
	public void addFile(Files file) throws BusinessException, IOException {
		
		if(file == null) {
			throw new BusinessException("File cannot be Null");
		}else if(!file.getFname().matches("[\\w,\\s-]+\\.[A-Za-z]{3}")) {
			//System.out.println("Invalid");
			throw new BusinessException("File Name is invalid");
		}
			
		getDao().addFile(file);
		
	}

	@Override
	public void getFilesByFilename(String fname) throws BusinessException, IOException {
		getDao().getFilesByFilename(fname);
	}

	@Override
	public void deleteFile(String fname) throws BusinessException, IOException {
		getDao().deleteFile(fname);
		
	}


}
