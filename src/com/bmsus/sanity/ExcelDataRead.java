package com.bmsus.sanity;

import com.bmsus.utils.*;

public class ExcelDataRead {
	
	public static void main(String args[]) throws Exception {
		
		testExcelDataRead();
		
	}
	
	public static void testExcelDataRead() throws Exception {
		
	//	cleaning.cleaner(EnvInitialization.BROWSER_FIREFOX);
		
		DataLibrary lib = new DataLibrary();
		
		// Retrieving single row Data from Profile_details for specific ID
		String profileData = new String();
        String filePath = ("Data/profile_details.xls");
        profileData = lib.getExcelDataSingle(filePath,"profile_details","90067");
        System.out.println("Profile Data is "+profileData);
        profileData = profileData.replace("|", ":");
        System.out.println("Profile Data is "+profileData);
        String[] profileDataArray = profileData.split(":");
        for(int i=0;i<profileDataArray.length;i++)
        	System.out.println("Data---"+profileDataArray[i]); 
        
     // Retrieving multiple rows Data from Publications for specific ID
   		String filePath1 = ("Data/publications.xls");
        String[] publicationData = lib.getExcelDataMultiple(filePath1,"publications","90067");
        for(int i=0;i<publicationData.length;i++)
        	System.out.println("Data---"+publicationData[i]);
        
        
	}

}
