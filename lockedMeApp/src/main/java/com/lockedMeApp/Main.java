package com.lockedMeApp;

import java.io.IOException;
import java.util.Scanner;

import com.lockedMeApp.bo.FilesBO;
import com.lockedMeApp.bo.impl.FilesBOImpl;
import com.lockedMeApp.dao.FilesDAO;
import com.lockedMeApp.dao.impl.FilesDAOImpl;
import com.lockedMeApp.exceptions.BusinessException;
import com.lockedMeApp.modal.Files;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to LockedMe.com v1.0");
		
		System.out.println("-----------------------------------------");
		
		Scanner scanner=new Scanner(System.in);
		
		FilesBO filebo = new FilesBOImpl();
		FilesDAO filedo = new FilesDAOImpl();
		
		int chMain = 0;
		int chSub = 0;
		do {
			System.out.println("-----------------------------------------");	
		    System.out.println("Main Menu");
		    System.out.println("1) List files in directory");
		    System.out.println("2) Sub Menu");
		    System.out.println("3) Exit");
		    System.out.println("-----------------------------------------");
		try {
			
			chMain = Integer.parseInt(scanner.nextLine());
			
		}catch(NumberFormatException e){
			System.out.println(e.getMessage());
		}
		
	      switch(chMain) //Switch expression
	      {
	         //Case statements
	         case 1:
	        	 
			try {
				filedo.getAllFiles();
			} catch (BusinessException e1) {
				System.out.println(e1.getMessage());
			} 
			chMain=0;
	         break;
	         
	         case 2:
	        	 do {
	        		    System.out.println("-----------------------------------------");
	        			System.out.println("Sub Menu");
	        			System.out.println("1) Create File");
	        			System.out.println("2) Delete File");
	        			System.out.println("3) Search File");
	        			System.out.println("4) Go to Main Menu");
	        			System.out.println("-----------------------------------------");
	        			try {
	        				chSub = Integer.parseInt(scanner.nextLine());
	        			}catch(NumberFormatException e){
	        				System.out.println(e.getMessage());
	        			}
	        	 
	         switch(chSub)
	         {
	            case 1:
	            	Files files = new Files();
	        		System.out.println("Enter filename");
	        		
	        		files.setFname(scanner.nextLine());
	        		
	        			try {
	        				filebo.addFile(files);
	        			} catch (BusinessException e) {
	        				
	        				System.out.println (e.getMessage());
	        			} catch (IOException e) {
	        				
	        				System.out.println (e.getMessage());
	        			}
	        			chSub=0;
	            break;
	            case 2:
	            	try {
	        			try {
	        				filebo.deleteFile(scanner.nextLine());
	        			} catch (IOException e) {
	        				e.getMessage();
	        			}
	        		} catch (BusinessException e) {
	        			
	        			System.out.println (e.getMessage());
	        		}
	            	chSub=0;
	            break;
	            case 3:
	            	try {
	        			try {
	        				filebo.getFilesByFilename(scanner.nextLine());
	        			} catch (IOException e) {
	        				e.getMessage();
	        			}
	        		} catch (BusinessException e) {
	        			
	        			System.out.println (e.getMessage());
	        		}
	            	chSub=0;
		        break;
	            case 4:
	            	System.out.println("Going to Main Menu");
			        break;
	            default: System.out.println("Please enter valid Sub Menu Option");
	         }
	         }while(chSub!=4);
	        	  break;
	         case 3:
	        	 System.out.println("Thank you for visiting LockedMe.com...");
	    	         
	    	  break;
	         //Default case statement
	         default: System.out.println("Please enter valid Main Menu Option");
	     }
	   
		}while(chMain!=3);
		
		scanner.close();
	}
	

}
