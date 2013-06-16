package com.bmsus.sanity;

import com.bmsus.utils.*;

import java.io.IOException;


public class SanityFunctionRepository {
	
	private GenericFuntions gf;

	SanityFunctionRepository(String scriptName) {
		this.gf = new GenericFuntions(scriptName);
	}
	
	//Function to Login to BMSUS as User
	public boolean loginToBMSUS(String userName, String passWord)
	throws IOException, InterruptedException {
		
		login.loginuser(userName, passWord);
		System.out.println(configuration.selenium.getHtmlSource() );
		String confirm = configuration.selenium.getConfirmation();
		System.out.println("confirm is --------------------------"+confirm);
		System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
		//	popuswindows.allpageloads();
			(new screenshots()).takeAScreenShotOfTheApp();
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
		
	//	configuration.selenium.deselectPopUp();
	//	Thread.sleep(2000);
	//	configuration.selenium.close();
	//	GenericFuntions.writeSummaryPass("Login");
		return true;
	}
	
	
	//Function to Check KOL Details in Profile.
	public boolean profileDetailsKOL(String userName, String passWord, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		String prefix = "";
		String fName = "";
		String mName = "";
		String lName = "";
		String suffix = "";
		String preferredName = "";
		String gender = "";
		String title = "";
		String speciality = "";
		String secondSpeciality = "";
		String tertiarySpeciality = "";
		String markDelete = "";
		String deleteReason = "";
		String bestDay = "";
		String bestTime = "";
		String secBestDay = "";
		String secBestTime = "";
		
		// Retrieving single row Data from Profile_details for specific ID
		String profileData = new String();
        String filePath = ("Data/profile_details.xls");
        profileData = lib.getExcelDataSingle(filePath,"profile_details",OLID);
        if(profileData!=null){
                        
	        System.out.println("Profile Data is "+profileData);
	        profileData = profileData.replace("|", ":");
	        System.out.println("Profile Data is "+profileData);
	        String[] profileDataArray = profileData.split(":");
	        for(int i=0;i<profileDataArray.length;i++)
	        	System.out.println("Data---"+profileDataArray[i]); 
	        
	        if(profileDataArray[2]!=null)
	        	prefix = profileDataArray[2].replace("\"", ""); 
	        if(profileDataArray[3]!=null)
	        	fName = profileDataArray[3].replace("\"", ""); 
	        if(profileDataArray[4]!=null)
	        	mName = profileDataArray[4].replace("\"", ""); 
	        if(profileDataArray[5]!=null)
	        	lName = profileDataArray[5].replace("\"", "");
	        if(profileDataArray[6]!=null)
	        	suffix = profileDataArray[6].replace("\"", ""); 
	        if(profileDataArray[7]!=null)
	        	preferredName = profileDataArray[7].replace("\"", "");
	        if(profileDataArray[8]!=null)
	        	gender = profileDataArray[8].replace("\"", "");
	        if(profileDataArray[9]!=null)
	        	title = profileDataArray[9].replace("\"", "");
	        if(profileDataArray[10]!=null)
	        	speciality = profileDataArray[10].replace("\"", "");
	        if(profileDataArray[11]!=null)
	        	secondSpeciality = profileDataArray[11].replace("\"", "");
	        if(profileDataArray[12]!=null)
	        	tertiarySpeciality = profileDataArray[12].replace("\"", "");
	        if(profileDataArray[16]!=null)
	        	markDelete = profileDataArray[16].replace("\"", "");
	        if(profileDataArray[17]!=null)
	        	deleteReason = profileDataArray[17].replace("\"", "");
	        if(profileDataArray[18]!=null)
	        	bestDay = profileDataArray[18].replace("\"", "");
	        if(profileDataArray[19]!=null)
	        	bestTime = profileDataArray[19].replace("\"", "");
	        if(profileDataArray[20]!=null)
	        	secBestDay = profileDataArray[20].replace("\"", "");
	        if(profileDataArray[21]!=null)
	        	secBestTime = profileDataArray[21].replace("\"", "");
	        
        }		
		System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.PROFILE_DETAILS_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			if(!((EnvInitialization.SALUTATION).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.SALUTATION).equals(prefix))
					gf.writePass("Verify", "salutation sucessfull ." + prefix + ".");
				else
					gf.writeFail("Verify", "salutation Failed ." + prefix + ".");
			}
			if(!((EnvInitialization.FIRST_NAME).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.FIRST_NAME).equals(fName))
					gf.writePass("Verify", "fName sucessfull ." + fName + ".");
				else
					gf.writeFail("Verify", "fName Failed ." + fName + ".");
			}
			if(!((EnvInitialization.MIDDLE_NAME).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.MIDDLE_NAME).equals(mName))
					gf.writePass("Verify", "mName sucessfull ." + mName + ".");
				else
					gf.writeFail("Verify", "mName Failed ." + mName + ".");
			}
			if(!((EnvInitialization.LAST_NAME).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.LAST_NAME).equals(lName))
					gf.writePass("Verify", "lName sucessfull ." + lName + ".");
				else
					gf.writeFail("Verify", "lName Failed ." + lName + ".");
			}
			if(!((EnvInitialization.SUFFIX).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.SUFFIX).equals(suffix))
					gf.writePass("Verify", "suffix sucessfull ." + suffix + ".");
				else
					gf.writeFail("Verify", "suffix Failed ." + suffix + ".");
			}
			if(!((EnvInitialization.PREFFERED_NAME).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.PREFFERED_NAME).equals(preferredName))
					gf.writePass("Verify", "preferredName sucessfull ." + preferredName + ".");
				else
					gf.writeFail("Verify", "preferredName Failed ." + preferredName + ".");
			}
			if(!((EnvInitialization.GENDER).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.GENDER).equals(gender))
					gf.writePass("Verify", "gender sucessfull ." + gender + ".");
				else
					gf.writeFail("Verify", "gender Failed ." + gender + ".");
			}
			if(!((EnvInitialization.PROFILE_TITLE).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.PROFILE_TITLE).equals(title))
					gf.writePass("Verify", "Title sucessfull ." + title + ".");
				else
					gf.writeFail("Verify", "Title Failed ." + title + ".");
			}
			if(!((EnvInitialization.SPECIALITY).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.SPECIALITY).equals(speciality))
					gf.writePass("Verify", "speciality sucessfull ." + speciality + ".");
				else
					gf.writeFail("Verify", "speciality Failed ." + speciality + ".");
			}
			if(!((EnvInitialization.SEC_SPECIALITY).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.SEC_SPECIALITY).equals(secondSpeciality))
					gf.writePass("Verify", "secondSpeciality sucessfull ." + secondSpeciality + ".");
				else
					gf.writeFail("Verify", "secondSpeciality Failed ." + secondSpeciality + ".");
			}
			if(!((EnvInitialization.TER_SPECIALITY).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.TER_SPECIALITY).equals(tertiarySpeciality))
					gf.writePass("Verify", "tertiarySpeciality sucessfull ." + tertiarySpeciality + ".");
				else
					gf.writeFail("Verify", "tertiarySpeciality Failed ." + tertiarySpeciality + ".");
			}
			if(!((EnvInitialization.MARK_AS_DELETE).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.MARK_AS_DELETE).equals(markDelete))
					gf.writePass("Verify", "markDelete sucessfull ." + markDelete + ".");
				else
					gf.writeFail("Verify", "markDelete Failed ." + markDelete + ".");
			}
			if(!((EnvInitialization.DELETE_REASON).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.DELETE_REASON).equals(deleteReason))
					gf.writePass("Verify", "deleteReason sucessfull ." + deleteReason + ".");
				else
					gf.writeFail("Verify", "deleteReason Failed ." + deleteReason + ".");
			}
			if(!((EnvInitialization.DAY_TO_CONTACT).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.DAY_TO_CONTACT).equals(bestDay))
					gf.writePass("Verify", "bestDay sucessfull ." + bestDay + ".");
				else
					gf.writeFail("Verify", "bestDay Failed ." + bestDay + ".");
			}
			if(!((EnvInitialization.TIME_TO_CONTACT).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.TIME_TO_CONTACT).equals(bestTime))
					gf.writePass("Verify", "bestTime sucessfull ." + bestTime + ".");
				else
					gf.writeFail("Verify", "bestTime Failed ." + bestTime + ".");
			}
			if(!((EnvInitialization.SEC_DAY_TO_CONTACT).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.SEC_DAY_TO_CONTACT).equals(secBestDay))
					gf.writePass("Verify", "secBestDay sucessfull ." + secBestDay + ".");
				else
					gf.writeFail("Verify", "secBestDay Failed ." + secBestDay + ".");
			}
			if(!((EnvInitialization.SEC_TIME_TO_CONTACT).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.SEC_TIME_TO_CONTACT).equals(secBestTime))
					gf.writePass("Verify", "bestTime sucessfull ." + secBestTime + ".");
				else
					gf.writeFail("Verify", "bestTime Failed ." + secBestTime + ".");
			}			
			
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}

		return true;
	}
	
	//Function to validate data in Biography Tab
	public boolean biographyKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String clinicalIntersts = "";
		String biography = "";
		String cv = "";
		String cvData = "";
		// Retrieving single row Data from Profile_details for specific ID
		String biographyData = new String();
        String filePath = ("Data/biography.xls");
        biographyData = lib.getExcelDataSingle(filePath,"biography",OLID);
        if(biographyData!=null){
        	System.out.println("Biography Data is "+biographyData);
            biographyData = biographyData.replace("|", ":");
            System.out.println("Biography Data is "+biographyData);
            String[] biographyDataArray = biographyData.split(":");
            for(int i=0;i<biographyDataArray.length;i++)
            	System.out.println("Data---"+biographyDataArray[i]);
            
            if(biographyDataArray[2]!=null)
            	clinicalIntersts = biographyDataArray[2].replace("\"", ""); 
	        if(biographyDataArray[3]!=null)
	        	biography = biographyDataArray[3].replace("\"", ""); 
	        if(biographyDataArray[4]!=null)
	        	cv = biographyDataArray[4].replace("\"", ""); 
	        if(biographyDataArray[5]!=null)
	        	cvData = biographyDataArray[5].replace("\"", "");
            
        }
         
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.BIOGRAPHY_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			if(!((EnvInitialization.CLINICAL_AREAS_INTEREST).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.CLINICAL_AREAS_INTEREST).equals(clinicalIntersts))
					gf.writePass("Verify", "CLINICAL_AREAS_INTEREST sucessfull ." + clinicalIntersts + ".");
				else
					gf.writeFail("Verify", "CLINICAL_AREAS_INTEREST Failed ." + clinicalIntersts + ".");
			}
			if(!((EnvInitialization.BIOGRAPHY).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.BIOGRAPHY).equals(biography))
					gf.writePass("Verify", "BIOGRAPHY sucessfull ." + biography + ".");
				else
					gf.writeFail("Verify", "BIOGRAPHY Failed ." + biography + ".");
			}
			if(!((EnvInitialization.CV).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.CV).equals(cv))
					gf.writePass("Verify", "CV sucessfull ." + cv + ".");
				else
					gf.writeFail("Verify", "CV Failed ." + cv + ".");
			}
			if(!((EnvInitialization.CV_DATE).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.CV_DATE).equals(cvData))
					gf.writePass("Verify", "CV_DATE sucessfull ." + cvData + ".");
				else
					gf.writeFail("Verify", "CV_DATE Failed ." + cvData + ".");
			}
			
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
        return true;
	}
	
	//Function to validate data in Identifiers Tab
	public boolean identifiersKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String customerNumber = "";
		String profileSource = "";
		String photoFileName = "";

		// Retrieving single row Data from Profile_details for specific ID
		String identifiersData = new String();
        String filePath = ("Data/identifiers.xls");
        identifiersData = lib.getExcelDataSingle(filePath,"identifiers",OLID);
        if(identifiersData!=null){
        	System.out.println("identifiers Data is "+identifiersData);
        	identifiersData = identifiersData.replace("|", ":");
            System.out.println("identifiers Data is "+identifiersData);
            String[] identifiersDataArray = identifiersData.split(":");
            for(int i=0;i<identifiersDataArray.length;i++)
            	System.out.println("Data---"+identifiersDataArray[i]);
            
            if(identifiersDataArray[2]!=null)
            	customerNumber = identifiersDataArray[2].replace("\"", ""); 
	        if(identifiersDataArray[6]!=null)
	        	profileSource = identifiersDataArray[6].replace("\"", ""); 
	        if(identifiersDataArray[8]!=null)
	        	photoFileName = identifiersDataArray[8].replace("\"", ""); 
            
        }
         
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.IDENTIFIERS_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			if(!((EnvInitialization.CUSTOMER_NUMBER).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.CUSTOMER_NUMBER).equals(customerNumber))
					gf.writePass("Verify", "CUSTOMER_NUMBER sucessfull ." + customerNumber + ".");
				else
					gf.writeFail("Verify", "CUSTOMER_NUMBER Failed ." + customerNumber + ".");
			}
			if(!((EnvInitialization.BIOGRAPHY).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.PROFILE_SOURCE).equals(profileSource))
					gf.writePass("Verify", "PROFILE_SOURCE sucessfull ." + profileSource + ".");
				else
					gf.writeFail("Verify", "PROFILE_SOURCE Failed ." + profileSource + ".");
			}
			if(!((EnvInitialization.PHOTO_FILENAME).equalsIgnoreCase("NA"))){
				
				if(configuration.selenium.getText(EnvInitialization.PHOTO_FILENAME).equals(photoFileName))
					gf.writePass("Verify", "PHOTO_FILENAME sucessfull ." + photoFileName + ".");
				else
					gf.writeFail("Verify", "PHOTO_FILENAME Failed ." + photoFileName + ".");
			}
			
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
        return true;
	}
	
	//Function to validate data in Education Tab
	public boolean educationKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String degree = "";
		String type = "";
		String description = "";
		String degreeInstitution = "";
		String beginYear = "";
		String endYear = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.EDUCATION_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from Education for specific ID
	   		String filePath1 = ("Data/education.xls");
	        String[] educationData = lib.getExcelDataMultiple(filePath1,"education",OLID);
	        int rowNum = 0;
	        for(int i=0;i<educationData.length;i++){
	        	
		        	if(educationData[i]!=null){
		        	
		        		System.out.println("Data---"+educationData[i]);
				
		        		degree = "";
		        		type = "";
		        		description = "";
		        		degreeInstitution = "";
		        		beginYear = "";
		        		endYear = "";
	
						educationData[i] = educationData[i].replace("|", ":");
			            System.out.println("identifiers Data is "+educationData[i]);
			            String[] educationDataArray = educationData[i].split(":");
			            for(int j=0;j<educationDataArray.length;j++)
			            	System.out.println("Data---"+educationDataArray[j]);
			            
			            if(educationDataArray[2]!=null)
			            	degree = educationDataArray[2].replace("\"", ""); 
				        if(educationDataArray[3]!=null)
				        	type = educationDataArray[3].replace("\"", ""); 
				        if(educationDataArray[4]!=null)
				        	description = educationDataArray[4].replace("\"", ""); 
				        if(educationDataArray[5]!=null)
				        	degreeInstitution = educationDataArray[5].replace("\"", ""); 
				        if(educationDataArray[6]!=null)
				        	beginYear = educationDataArray[6].replace("\"", ""); 
				        if(educationDataArray[7]!=null)
				        	endYear = educationDataArray[7].replace("\"", "");
				  }
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", degree);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(degree))
					gf.writePass("Verify", "degree  "+(i+1)+" sucessfull ." + degree + ".");
				else
					gf.writeFail("Verify", "degree  "+(i+1)+"  Failed ." + degree + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(type))
					gf.writePass("Verify", "type  "+(i+1)+" sucessfull ." + type + ".");
				else
					gf.writeFail("Verify", "type  "+(i+1)+"  Failed ." + type + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(description))
					gf.writePass("Verify", "description  "+(i+1)+" sucessfull ." + description + ".");
				else
					gf.writeFail("Verify", "description  "+(i+1)+"  Failed ." + description + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(degreeInstitution))
					gf.writePass("Verify", "degreeInstitution  "+(i+1)+" sucessfull ." + degreeInstitution + ".");
				else
					gf.writeFail("Verify", "degreeInstitution  "+(i+1)+"  Failed ." + degreeInstitution + ".");
				
				if(configuration.selenium.getText(xpath+"td[11]").equals(beginYear))
					gf.writePass("Verify", "beginYear  "+(i+1)+" sucessfull ." + beginYear + ".");
				else
					gf.writeFail("Verify", "beginYear  "+(i+1)+"  Failed ." + beginYear + ".");
				
				if(configuration.selenium.getText(xpath+"td[13]").equals(endYear))
					gf.writePass("Verify", "endYear  "+(i+1)+" sucessfull ." + endYear + ".");
				else
					gf.writeFail("Verify", "endYear  "+(i+1)+"  Failed ." + endYear + ".");	
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Career History Tab
	public boolean careerHistoryKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String position = "";
		String department = "";
		String institutionName = "";
		String yearsOfHistory = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.CAREER_HISTORY_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from Education for specific ID
	   		String filePath1 = ("Data/career_history.xls");
	        String[] careerHistoryData = lib.getExcelDataMultiple(filePath1,"career_history",OLID);
	        int rowNum = 0;
	        for(int i=0;i<careerHistoryData.length;i++){
	        	
		        	if(careerHistoryData[i]!=null){
		        	
		        		System.out.println("Data---"+careerHistoryData[i]);
				
		        		position = "";
		        		department = "";
		        		institutionName = "";
		        		yearsOfHistory = "";
	
		        		careerHistoryData[i] = careerHistoryData[i].replace("|", ":");
			            System.out.println("identifiers Data is "+careerHistoryData[i]);
			            String[] careerHistoryDataArray = careerHistoryData[i].split(":");
			            for(int j=0;j<careerHistoryDataArray.length;j++)
			            	System.out.println("Data---"+careerHistoryDataArray[j]);
			            
			            if(careerHistoryDataArray[2]!=null)
			            	position = careerHistoryDataArray[2].replace("\"", ""); 
				        if(careerHistoryDataArray[3]!=null)
				        	department = careerHistoryDataArray[3].replace("\"", ""); 
				        if(careerHistoryDataArray[4]!=null)
				        	institutionName = careerHistoryDataArray[4].replace("\"", ""); 
				        if(careerHistoryDataArray[5]!=null)
				        	yearsOfHistory = careerHistoryDataArray[5].replace("\"", ""); 
				  }
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", position);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(position))
					gf.writePass("Verify", "position  "+(i+1)+" sucessfull ." + position + ".");
				else
					gf.writeFail("Verify", "position  "+(i+1)+"  Failed ." + position + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(department))
					gf.writePass("Verify", "department  "+(i+1)+" sucessfull ." + department + ".");
				else
					gf.writeFail("Verify", "department  "+(i+1)+"  Failed ." + department + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(institutionName))
					gf.writePass("Verify", "institutionName  "+(i+1)+" sucessfull ." + institutionName + ".");
				else
					gf.writeFail("Verify", "institutionName  "+(i+1)+"  Failed ." + institutionName + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(yearsOfHistory))
					gf.writePass("Verify", "yearsOfHistory  "+(i+1)+" sucessfull ." + yearsOfHistory + ".");
				else
					gf.writeFail("Verify", "yearsOfHistory  "+(i+1)+"  Failed ." + yearsOfHistory + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Address Tab
	public boolean addressKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String addressType = "";
		String addressPreferred = "";
		String addressLine1 = "";
		String addressLine2 = "";
		String addressCity = "";
		String state = "";
		String postalCode = "";
		String country = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.ADDRESS_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from Education for specific ID
	   		String filePath1 = ("Data/address.xls");
	        String[] addressData = lib.getExcelDataMultiple(filePath1,"address",OLID);
	        int rowNum = 0;
	        for(int i=0;i<addressData.length;i++){
	        	
		        	if(addressData[i]!=null){
		        	
		        		System.out.println("Data---"+addressData[i]);
				
		        		addressType = "";
		        		addressPreferred = "";
		        		addressLine1 = "";
		        		addressLine2 = "";
		        		addressCity = "";
		        		state = "";
		        		postalCode = "";
		        		country = "";
	
		        		addressData[i] = addressData[i].replace("|", ":");
			            System.out.println("identifiers Data is "+addressData[i]);
			            String[] addressDataArray = addressData[i].split(":");
			            for(int j=0;j<addressDataArray.length;j++)
			            	System.out.println("Data---"+addressDataArray[j]);
			            
			            if(addressDataArray[2]!=null)
			            	addressType = addressDataArray[2].replace("\"", ""); 
				        if(addressDataArray[3]!=null)
				        	addressPreferred = addressDataArray[3].replace("\"", ""); 
				        if(addressDataArray[4]!=null)
				        	addressLine1 = addressDataArray[4].replace("\"", ""); 
				        if(addressDataArray[5]!=null)
				        	addressLine2 = addressDataArray[5].replace("\"", "");
				        if(addressDataArray[6]!=null)
				        	addressCity = addressDataArray[6].replace("\"", ""); 
				        if(addressDataArray[7]!=null)
				        	state = addressDataArray[7].replace("\"", ""); 
				        if(addressDataArray[8]!=null)
				        	postalCode = addressDataArray[8].replace("\"", ""); 
				        if(addressDataArray[9]!=null)
				        	country = addressDataArray[9].replace("\"", ""); 
				  }
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", addressType);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(addressType))
					gf.writePass("Verify", "addressType  "+(i+1)+" sucessfull ." + addressType + ".");
				else
					gf.writeFail("Verify", "addressType  "+(i+1)+"  Failed ." + addressType + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(addressPreferred))
					gf.writePass("Verify", "addressPreferred  "+(i+1)+" sucessfull ." + addressPreferred + ".");
				else
					gf.writeFail("Verify", "addressPreferred  "+(i+1)+"  Failed ." + addressPreferred + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(addressLine1))
					gf.writePass("Verify", "addressLine1  "+(i+1)+" sucessfull ." + addressLine1 + ".");
				else
					gf.writeFail("Verify", "addressLine1  "+(i+1)+"  Failed ." + addressLine1 + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(addressLine2))
					gf.writePass("Verify", "yearsOfHistory  "+(i+1)+" sucessfull ." + addressLine2 + ".");
				else
					gf.writeFail("Verify", "yearsOfHistory  "+(i+1)+"  Failed ." + addressLine2 + ".");
				
				if(configuration.selenium.getText(xpath+"td[11]").equals(addressCity))
					gf.writePass("Verify", "addressCity  "+(i+1)+" sucessfull ." + addressCity + ".");
				else
					gf.writeFail("Verify", "addressCity  "+(i+1)+"  Failed ." + addressCity + ".");
				
				if(configuration.selenium.getText(xpath+"td[13]").equals(state))
					gf.writePass("Verify", "state  "+(i+1)+" sucessfull ." + state + ".");
				else
					gf.writeFail("Verify", "state  "+(i+1)+"  Failed ." + state + ".");
				
				if(configuration.selenium.getText(xpath+"td[15]").equals(postalCode))
					gf.writePass("Verify", "postalCode  "+(i+1)+" sucessfull ." + postalCode + ".");
				else
					gf.writeFail("Verify", "postalCode  "+(i+1)+"  Failed ." + postalCode + ".");
				
				if(configuration.selenium.getText(xpath+"td[17]").equals(country))
					gf.writePass("Verify", "country  "+(i+1)+" sucessfull ." + country + ".");
				else
					gf.writeFail("Verify", "country  "+(i+1)+"  Failed ." + country + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Contact Information Tab
	public boolean contactInformationKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String contactInfo = "";
		String contactType = "";
		String contactName = "";
		String preferredContact = "";
		String contactLocation = "";
		
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.CONTACT_INFORMATION_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from Education for specific ID
	   		String filePath1 = ("Data/contact_information.xls");
	        String[] contactData = lib.getExcelDataMultiple(filePath1,"contact_information",OLID);
	        int rowNum = 0;
	        for(int i=0;i<contactData.length;i++){
	        	
		        	if(contactData[i]!=null){
		        	
		        		System.out.println("Data---"+contactData[i]);
				
		        		contactInfo = "";
		        		contactType = "";
		        		contactName = "";
		        		preferredContact = "";
		        		contactLocation = "";
	
		        		contactData[i] = contactData[i].replace("|", ":");
			            System.out.println("contactData Data is "+contactData[i]);
			            String[] contactDataArray = contactData[i].split(":");
			            for(int j=0;j<contactDataArray.length;j++)
			            	System.out.println("Data---"+contactDataArray[j]);
			            
			            if(contactDataArray[2]!=null)
			            	contactInfo = contactDataArray[2].replace("\"", ""); 
			            if(contactDataArray[3]!=null)
				        	contactType = contactDataArray[3].replace("\"", ""); 
				        if(contactDataArray[4]!=null)
				        	contactName = contactDataArray[4].replace("\"", ""); 
				        if(contactDataArray[5]!=null)
				        	preferredContact = contactDataArray[5].replace("\"", "");
				        if(contactDataArray[6]!=null)
				        	contactLocation = contactDataArray[6].replace("\"", ""); 
				  }
		        	
		        
		        if (contactInfo.contains("@"))
		        	contactInfo = "link="+contactInfo;
		        System.out.println("contactInfo newly constrcted is-----------"+contactInfo);	
		        	
		        if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", contactInfo);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(contactInfo))
					gf.writePass("Verify", "contactInfo  "+(i+1)+" sucessfull ." + contactInfo + ".");
				else
					gf.writeFail("Verify", "contactInfo  "+(i+1)+"  Failed ." + contactInfo + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(contactType))
					gf.writePass("Verify", "contactType  "+(i+1)+" sucessfull ." + contactType + ".");
				else
					gf.writeFail("Verify", "contactType  "+(i+1)+"  Failed ." + contactType + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(preferredContact))
					gf.writePass("Verify", "preferredContact  "+(i+1)+" sucessfull ." + preferredContact + ".");
				else
					gf.writeFail("Verify", "preferredContact  "+(i+1)+"  Failed ." + preferredContact + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(contactLocation))
					gf.writePass("Verify", "contactLocation  "+(i+1)+" sucessfull ." + contactLocation + ".");
				else
					gf.writeFail("Verify", "contactLocation  "+(i+1)+"  Failed ." + contactLocation + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Additional Contacts Tab
	public boolean additionalContactsKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String contactName = "";
		String contactRole = "";
		String contactInfo = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.ADDITIONAL_CONTACTS_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from Education for specific ID
	   		String filePath1 = ("Data/additional_contacts.xls");
	        String[] contactData = lib.getExcelDataMultiple(filePath1,"additional_contacts",OLID);
	        int rowNum = 0;
	        for(int i=0;i<contactData.length;i++){
	        	
		        	if(contactData[i]!=null){
		        	
		        		System.out.println("Data---"+contactData[i]);
				
		        		contactName = "";
		        		contactRole = "";
		        		contactInfo = "";
	
		        		contactData[i] = contactData[i].replace("|", ":");
			            System.out.println("contactData Data is "+contactData[i]);
			            String[] contactDataArray = contactData[i].split(":");
			            for(int j=0;j<contactDataArray.length;j++)
			            	System.out.println("Data---"+contactDataArray[j]);
			            
			            if(contactDataArray[1]!=null)
			            	contactName = contactDataArray[1].replace("\"", ""); 
			            if(contactDataArray[2]!=null)
			            	contactRole = contactDataArray[2].replace("\"", ""); 
				        if(contactDataArray[3]!=null)
				        	contactInfo = contactDataArray[3].replace("\"", ""); 
				  }
		        
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", contactName);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(contactName))
					gf.writePass("Verify", "contactName  "+(i+1)+" sucessfull ." + contactName + ".");
				else
					gf.writeFail("Verify", "contactName  "+(i+1)+"  Failed ." + contactName + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(contactRole))
					gf.writePass("Verify", "contactRole  "+(i+1)+" sucessfull ." + contactRole + ".");
				else
					gf.writeFail("Verify", "contactRole  "+(i+1)+"  Failed ." + contactRole + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(contactInfo))
					gf.writePass("Verify", "contactInfo  "+(i+1)+" sucessfull ." + contactInfo + ".");
				else
					gf.writeFail("Verify", "contactInfo  "+(i+1)+"  Failed ." + contactInfo + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Societies Tab
	public boolean societiesKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String description = "";
		String board = "";
		String title = "";
		String years = "";
		String clientName = PropertyFinder.getPropertyFilename(EnvInitialization.CLIENT);
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.SOCIETIES_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from Education for specific ID
	   		String filePath1 = ("Data/societies.xls");
	        String[] societiesData = lib.getExcelDataMultiple(filePath1,"societies",OLID);
	        int rowNum = 0;
	        for(int i=0;i<societiesData.length;i++){
	        	
		        	if(societiesData[i]!=null){
		        	
		        		System.out.println("Data---"+societiesData[i]);
				
		        		description = "";
		        		board = "";
		        		title = "";
		        		years = "";
	
		        		societiesData[i] = societiesData[i].replace("|", ":");
			            System.out.println("societiesData Data is "+societiesData[i]);
			            String[] societiesDataArray = societiesData[i].split(":");
			            for(int j=0;j<societiesDataArray.length;j++)
			            	System.out.println("Data---"+societiesDataArray[j]);
			            
			            if(clientName.equals("HEMO")){
			            	
			            	if(societiesDataArray[2]!=null)
				            	board = societiesDataArray[2].replace("\"", "");
			            	if(societiesDataArray[3]!=null)
				            	description = societiesDataArray[3].replace("\"", "");
			            	
			            }
			            else{
			            	
			            	if(societiesDataArray[2]!=null)
				            	description = societiesDataArray[2].replace("\"", ""); 
				            if(societiesDataArray[3]!=null)
				            	board = societiesDataArray[3].replace("\"", ""); 
			            }
				        if(societiesDataArray[4]!=null)
				        	title = societiesDataArray[4].replace("\"", "");
				        if(societiesDataArray[5]!=null)
				        	years = societiesDataArray[5].replace("\"", ""); 
				  }
		        
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", description);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(description))
					gf.writePass("Verify", "description  "+(i+1)+" sucessfull ." + description + ".");
				else
					gf.writeFail("Verify", "description  "+(i+1)+"  Failed ." + description + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(board))
					gf.writePass("Verify", "board  "+(i+1)+" sucessfull ." + board + ".");
				else
					gf.writeFail("Verify", "board  "+(i+1)+"  Failed ." + board + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(title))
					gf.writePass("Verify", "title  "+(i+1)+" sucessfull ." + title + ".");
				else
					gf.writeFail("Verify", "title  "+(i+1)+"  Failed ." + title + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(years))
					gf.writePass("Verify", "years  "+(i+1)+" sucessfull ." + years + ".");
				else
					gf.writeFail("Verify", "years  "+(i+1)+"  Failed ." + years + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Industry Activites Tab
	public boolean industryActivitiesKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String type = "";
		String description = "";
		String years = "";
		String position = "";
		String clientName = PropertyFinder.getPropertyFilename(EnvInitialization.CLIENT);
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.INDUSTRY_ACTIVITIES_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from Education for specific ID
	   		String filePath1 = ("Data/societies.xls");
	        String[] industryActivitiesData = lib.getExcelDataMultiple(filePath1,"societies",OLID);
	        int rowNum = 0;
	        for(int i=0;i<industryActivitiesData.length;i++){
	        	
		        	if(industryActivitiesData[i]!=null){
		        	
		        		System.out.println("Data---"+industryActivitiesData[i]);
				
		        		type = "";
		        		description = "";
		        		years = "";
		        		position = "";
	
		        		industryActivitiesData[i] = industryActivitiesData[i].replace("|", ":");
			            System.out.println("societiesData Data is "+industryActivitiesData[i]);
			            String[] industryActivitiesDataArray = industryActivitiesData[i].split(":");
			            for(int j=0;j<industryActivitiesDataArray.length;j++)
			            	System.out.println("Data---"+industryActivitiesDataArray[j]);
			            	
			           	if(industryActivitiesDataArray[2]!=null)
			           		type = industryActivitiesDataArray[2].replace("\"", ""); 
				        if(industryActivitiesDataArray[3]!=null)
				        	description = industryActivitiesDataArray[3].replace("\"", ""); 
				        if(clientName.equals("HEMO")){
				        	if(industryActivitiesDataArray[4]!=null)
					        	position = industryActivitiesDataArray[4].replace("\"", ""); 
				        	if(industryActivitiesDataArray[5]!=null)
					        	years = industryActivitiesDataArray[5].replace("\"", "");
				        }
				        else{
					        if(industryActivitiesDataArray[4]!=null)
					        	years = industryActivitiesDataArray[4].replace("\"", "");
					        if(industryActivitiesDataArray[5]!=null)
					        	position = industryActivitiesDataArray[5].replace("\"", "");
				        }
				  }
		        
		        	
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", type);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(type))
					gf.writePass("Verify", "type  "+(i+1)+" sucessfull ." + type + ".");
				else
					gf.writeFail("Verify", "type  "+(i+1)+"  Failed ." + type + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(description))
					gf.writePass("Verify", "description  "+(i+1)+" sucessfull ." + description + ".");
				else
					gf.writeFail("Verify", "description  "+(i+1)+"  Failed ." + description + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(years))
					gf.writePass("Verify", "years  "+(i+1)+" sucessfull ." + years + ".");
				else
					gf.writeFail("Verify", "years  "+(i+1)+"  Failed ." + years + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(position))
					gf.writePass("Verify", "position  "+(i+1)+" sucessfull ." + position + ".");
				else
					gf.writeFail("Verify", "position  "+(i+1)+"  Failed ." + position + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Presentations Tab
	public boolean presentationsKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String title = "";
		String type = "";
		String event = "";
		String sponsor = "";
		String role = "";
		String date = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.PRESENTATIONS_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from Education for specific ID
	   		String filePath1 = ("Data/presentation.xls");
	        String[] presentationsData = lib.getExcelDataMultiple(filePath1,"presentation",OLID);
	        int rowNum = 0;
	        for(int i=0;i<presentationsData.length;i++){
	        	
		        	if(presentationsData[i]!=null){
		        	
		        		System.out.println("Data---"+presentationsData[i]);
				
		        		title = "";
		        		type = "";
		        		event = "";
		        		sponsor = "";
		        		role = "";
		        		date = "";
	
		        		presentationsData[i] = presentationsData[i].replace("|", ":");
			            System.out.println("contactData Data is "+presentationsData[i]);
			            String[] presentationsDataArray = presentationsData[i].split(":");
			            for(int j=0;j<presentationsDataArray.length;j++)
			            	System.out.println("Data---"+presentationsDataArray[j]);
			            
			            if(presentationsDataArray[2]!=null)
			            	title = presentationsDataArray[2].replace("\"", ""); 
			            if(presentationsDataArray[3]!=null)
			            	type = presentationsDataArray[3].replace("\"", ""); 
				        if(presentationsDataArray[4]!=null)
				        	event = presentationsDataArray[4].replace("\"", ""); 
				        if(presentationsDataArray[5]!=null)
				        	sponsor = presentationsDataArray[5].replace("\"", ""); 
			            if(presentationsDataArray[6]!=null)
			            	role = presentationsDataArray[6].replace("\"", ""); 
				        if(presentationsDataArray[7]!=null)
				        	date = presentationsDataArray[7].replace("\"", ""); 
				  }
		        
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", title);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(title))
					gf.writePass("Verify", "title  "+(i+1)+" sucessfull ." + title + ".");
				else
					gf.writeFail("Verify", "title  "+(i+1)+"  Failed ." + title + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(type))
					gf.writePass("Verify", "type  "+(i+1)+" sucessfull ." + type + ".");
				else
					gf.writeFail("Verify", "type  "+(i+1)+"  Failed ." + type + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(event))
					gf.writePass("Verify", "contactInfo  "+(i+1)+" sucessfull ." + event + ".");
				else
					gf.writeFail("Verify", "contactInfo  "+(i+1)+"  Failed ." + event + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(sponsor))
					gf.writePass("Verify", "sponsor  "+(i+1)+" sucessfull ." + sponsor + ".");
				else
					gf.writeFail("Verify", "sponsor  "+(i+1)+"  Failed ." + sponsor + ".");
				
				if(configuration.selenium.getText(xpath+"td[11]").equals(role))
					gf.writePass("Verify", "role  "+(i+1)+" sucessfull ." + role + ".");
				else
					gf.writeFail("Verify", "role  "+(i+1)+"  Failed ." + role + ".");
				
				if(configuration.selenium.getText(xpath+"td[13]").equals(date))
					gf.writePass("Verify", "date  "+(i+1)+" sucessfull ." + date + ".");
				else
					gf.writeFail("Verify", "date  "+(i+1)+"  Failed ." + date + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Committees Tab
	public boolean committeesKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String type = "";
		String description = "";
		String position = "";
		String years = "";
		String organization = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.COMMITTEES_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from Education for specific ID
	   		String filePath1 = ("Data/committees.xls");
	        String[] committeesData = lib.getExcelDataMultiple(filePath1,"committees",OLID);
	        int rowNum = 0;
	        for(int i=0;i<committeesData.length;i++){
	        	
		        	if(committeesData[i]!=null){
		        	
		        		System.out.println("Data---"+committeesData[i]);
				
		        		type = "";
		        		description = "";
		        		position = "";
		        		years = "";
		        		organization = "";
	
		        		committeesData[i] = committeesData[i].replace("|", ":");
			            System.out.println("contactData Data is "+committeesData[i]);
			            String[] committeesDataArray = committeesData[i].split(":");
			            for(int j=0;j<committeesDataArray.length;j++)
			            	System.out.println("Data---"+committeesDataArray[j]);
			            
			            if(committeesDataArray[2]!=null)
			            	type = committeesDataArray[2].replace("\"", ""); 
			            if(committeesDataArray[3]!=null)
			            	description = committeesDataArray[3].replace("\"", ""); 
				        if(committeesDataArray[4]!=null)
				        	position = committeesDataArray[4].replace("\"", ""); 
				        if(committeesDataArray[5]!=null)
				        	years = committeesDataArray[5].replace("\"", ""); 
			            if(committeesDataArray[6]!=null)
			            	organization = committeesDataArray[6].replace("\"", ""); 
				  }
		        
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", type);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(type))
					gf.writePass("Verify", "type  "+(i+1)+" sucessfull ." + type + ".");
				else
					gf.writeFail("Verify", "type  "+(i+1)+"  Failed ." + type + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(description))
					gf.writePass("Verify", "description  "+(i+1)+" sucessfull ." + description + ".");
				else
					gf.writeFail("Verify", "description  "+(i+1)+"  Failed ." + description + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(position))
					gf.writePass("Verify", "position  "+(i+1)+" sucessfull ." + position + ".");
				else
					gf.writeFail("Verify", "position  "+(i+1)+"  Failed ." + position + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(years))
					gf.writePass("Verify", "years  "+(i+1)+" sucessfull ." + years + ".");
				else
					gf.writeFail("Verify", "years  "+(i+1)+"  Failed ." + years + ".");
				
				if(configuration.selenium.getText(xpath+"td[11]").equals(organization))
					gf.writePass("Verify", "role  "+(i+1)+" sucessfull ." + organization + ".");
				else
					gf.writeFail("Verify", "role  "+(i+1)+"  Failed ." + organization + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Editorial Boards Tab
	public boolean editorialBoardsKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String journal = "";
		String position = "";
		String years = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.EDITORIAL_BOARDS_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from Education for specific ID
	   		String filePath1 = ("Data/editorial_boards.xls");
	        String[] editorialBoardsData = lib.getExcelDataMultiple(filePath1,"editorial_boards",OLID);
	        int rowNum = 0;
	        for(int i=0;i<editorialBoardsData.length;i++){
	        	
		        	if(editorialBoardsData[i]!=null){
		        	
		        		System.out.println("Data---"+editorialBoardsData[i]);
				
		        		journal = "";
		        		position = "";
		        		years = "";
	
		        		editorialBoardsData[i] = editorialBoardsData[i].replace("|", ":");
			            System.out.println("contactData Data is "+editorialBoardsData[i]);
			            String[] editorialBoardsDataArray = editorialBoardsData[i].split(":");
			            for(int j=0;j<editorialBoardsDataArray.length;j++)
			            	System.out.println("Data---"+editorialBoardsDataArray[j]);
			            
			            if(editorialBoardsDataArray[2]!=null)
			            	journal = editorialBoardsDataArray[2].replace("\"", ""); 
				        if(editorialBoardsDataArray[3]!=null)
				        	position = editorialBoardsDataArray[3].replace("\"", ""); 
				        if(editorialBoardsDataArray[4]!=null)
				        	years = editorialBoardsDataArray[4].replace("\"", ""); 
				  }
		        
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", journal);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(journal))
					gf.writePass("Verify", "journal  "+(i+1)+" sucessfull ." + journal + ".");
				else
					gf.writeFail("Verify", "journal  "+(i+1)+"  Failed ." + journal + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(position))
					gf.writePass("Verify", "position  "+(i+1)+" sucessfull ." + position + ".");
				else
					gf.writeFail("Verify", "position  "+(i+1)+"  Failed ." + position + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(position))
					gf.writePass("Verify", "years  "+(i+1)+" sucessfull ." + years + ".");
				else
					gf.writeFail("Verify", "years  "+(i+1)+"  Failed ." + years + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Grants Tab
	public boolean grantsKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String description = "";
		String number = "";
		String startDate = "";
		String endDate = "";
		String role = "";
		String institution = "";
		String fundingAgency = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.GRANTS_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from Education for specific ID
	   		String filePath1 = ("Data/grants.xls");
	        String[] grantsData = lib.getExcelDataMultiple(filePath1,"grants",OLID);
	        int rowNum = 0;
	        for(int i=0;i<grantsData.length;i++){
	        	
		        	if(grantsData[i]!=null){
		        	
		        		System.out.println("Data---"+grantsData[i]);
				
		        		description = "";
		        		number = "";
		        		startDate = "";
		        		endDate = "";
		        		role = "";
		        		institution = "";
		        		fundingAgency = "";
	
		        		grantsData[i] = grantsData[i].replace("|", ":");
			            System.out.println("grantsData Data is "+grantsData[i]);
			            String[] grantsDataArray = grantsData[i].split(":");
			            for(int j=0;j<grantsDataArray.length;j++)
			            	System.out.println("Data---"+grantsDataArray[j]);
			            
			            if(grantsDataArray[2]!=null)
			            	description = grantsDataArray[2].replace("\"", ""); 
				        if(grantsDataArray[3]!=null)
				        	number = grantsDataArray[3].replace("\"", ""); 
				        if(grantsDataArray[4]!=null)
				        	startDate = grantsDataArray[4].replace("\"", ""); 
				        if(grantsDataArray[5]!=null)
				        	endDate = grantsDataArray[5].replace("\"", ""); 
				        if(grantsDataArray[6]!=null)
				        	role = grantsDataArray[6].replace("\"", ""); 
				        if(grantsDataArray[7]!=null)
				        	institution = grantsDataArray[7].replace("\"", ""); 
				        if(grantsDataArray[8]!=null)
				        	fundingAgency = grantsDataArray[8].replace("\"", ""); 
				  }
		        
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", description);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(description))
					gf.writePass("Verify", "description  "+(i+1)+" sucessfull ." + description + ".");
				else
					gf.writeFail("Verify", "description  "+(i+1)+"  Failed ." + description + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(number))
					gf.writePass("Verify", "number  "+(i+1)+" sucessfull ." + number + ".");
				else
					gf.writeFail("Verify", "number  "+(i+1)+"  Failed ." + number + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(startDate))
					gf.writePass("Verify", "startDate  "+(i+1)+" sucessfull ." + startDate + ".");
				else
					gf.writeFail("Verify", "startDate  "+(i+1)+"  Failed ." + startDate + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(endDate))
					gf.writePass("Verify", "endDate  "+(i+1)+" sucessfull ." + endDate + ".");
				else
					gf.writeFail("Verify", "endDate  "+(i+1)+"  Failed ." + endDate + ".");
				
				if(configuration.selenium.getText(xpath+"td[11]").equals(role))
					gf.writePass("Verify", "role  "+(i+1)+" sucessfull ." + role + ".");
				else
					gf.writeFail("Verify", "role  "+(i+1)+"  Failed ." + role + ".");
				
				if(configuration.selenium.getText(xpath+"td[13]").equals(institution))
					gf.writePass("Verify", "institution  "+(i+1)+" sucessfull ." + institution + ".");
				else
					gf.writeFail("Verify", "institution  "+(i+1)+"  Failed ." + institution + ".");
				
				if(configuration.selenium.getText(xpath+"td[15]").equals(fundingAgency))
					gf.writePass("Verify", "fundingAgency  "+(i+1)+" sucessfull ." + fundingAgency + ".");
				else
					gf.writeFail("Verify", "fundingAgency  "+(i+1)+"  Failed ." + fundingAgency + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Patents Tab
	public boolean patentsKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String uspto = "";
		String number = "";
		String assignee = "";
		String fillingDate = "";
		String title = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.PATENTS_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from patents for specific ID
	   		String filePath1 = ("Data/patents.xls");
	        String[] patentsData = lib.getExcelDataMultiple(filePath1,"patents",OLID);
	        int rowNum = 0;
	        for(int i=0;i<patentsData.length;i++){
	        	
		        	if(patentsData[i]!=null){
		        	
		        		System.out.println("Data---"+patentsData[i]);
				
		        		uspto = "";
		        		number = "";
		        		assignee = "";
		        		fillingDate = "";
		        		title = "";
	
		        		patentsData[i] = patentsData[i].replace("|", ":");
			            System.out.println("patentsData Data is "+patentsData[i]);
			            String[] patentsDataArray = patentsData[i].split(":");
			            for(int j=0;j<patentsDataArray.length;j++)
			            	System.out.println("Data---"+patentsDataArray[j]);
			            
			            if(patentsDataArray[2]!=null)
			            	uspto = patentsDataArray[2].replace("\"", ""); 
				        if(patentsDataArray[3]!=null)
				        	number = patentsDataArray[3].replace("\"", ""); 
				        if(patentsDataArray[4]!=null)
				        	assignee = patentsDataArray[4].replace("\"", ""); 
				        if(patentsDataArray[5]!=null)
				        	fillingDate = patentsDataArray[5].replace("\"", ""); 
				        if(patentsDataArray[6]!=null)
				        	title = patentsDataArray[6].replace("\"", ""); 
				  }
		        
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", uspto);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(uspto))
					gf.writePass("Verify", "uspto  "+(i+1)+" sucessfull ." + uspto + ".");
				else
					gf.writeFail("Verify", "uspto  "+(i+1)+"  Failed ." + uspto + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(number))
					gf.writePass("Verify", "number  "+(i+1)+" sucessfull ." + number + ".");
				else
					gf.writeFail("Verify", "number  "+(i+1)+"  Failed ." + number + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(assignee))
					gf.writePass("Verify", "assignee  "+(i+1)+" sucessfull ." + assignee + ".");
				else
					gf.writeFail("Verify", "assignee  "+(i+1)+"  Failed ." + assignee + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(fillingDate))
					gf.writePass("Verify", "fillingDate  "+(i+1)+" sucessfull ." + fillingDate + ".");
				else
					gf.writeFail("Verify", "fillingDate  "+(i+1)+"  Failed ." + fillingDate + ".");
				
				if(configuration.selenium.getText(xpath+"td[11]").equals(title))
					gf.writePass("Verify", "title  "+(i+1)+" sucessfull ." + title + ".");
				else
					gf.writeFail("Verify", "title  "+(i+1)+"  Failed ." + title + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Honors Tab
	public boolean honorsKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String description = "";
		String sponsor = "";
		String position = "";
		String year = "";
		String type = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.HONORS_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from honors for specific ID
	   		String filePath1 = ("Data/honors.xls");
	        String[] honorsData = lib.getExcelDataMultiple(filePath1,"honors",OLID);
	        int rowNum = 0;
	        for(int i=0;i<honorsData.length;i++){
	        	
		        	if(honorsData[i]!=null){
		        	
		        		System.out.println("Data---"+honorsData[i]);
				
		        		description = "";
		        		sponsor = "";
		        		position = "";
		        		year = "";
		        		type = "";
	
		        		honorsData[i] = honorsData[i].replace("|", ":");
			            System.out.println("honorsData Data is "+honorsData[i]);
			            String[] honorsDataArray = honorsData[i].split(":");
			            for(int j=0;j<honorsDataArray.length;j++)
			            	System.out.println("Data---"+honorsDataArray[j]);
			            
			            if(honorsDataArray[2]!=null)
			            	description = honorsDataArray[2].replace("\"", ""); 
				        if(honorsDataArray[3]!=null)
				        	sponsor = honorsDataArray[3].replace("\"", ""); 
				        if(honorsDataArray[4]!=null)
				        	position = honorsDataArray[4].replace("\"", ""); 
				        if(honorsDataArray[5]!=null)
				        	year = honorsDataArray[5].replace("\"", ""); 
				        if(honorsDataArray[6]!=null)
				        	type = honorsDataArray[6].replace("\"", ""); 
				  }
		        
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", description);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(description))
					gf.writePass("Verify", "description  "+(i+1)+" sucessfull ." + description + ".");
				else
					gf.writeFail("Verify", "description  "+(i+1)+"  Failed ." + description + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(sponsor))
					gf.writePass("Verify", "sponsor  "+(i+1)+" sucessfull ." + sponsor + ".");
				else
					gf.writeFail("Verify", "sponsor  "+(i+1)+"  Failed ." + sponsor + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(position))
					gf.writePass("Verify", "position  "+(i+1)+" sucessfull ." + position + ".");
				else
					gf.writeFail("Verify", "position  "+(i+1)+"  Failed ." + position + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(year))
					gf.writePass("Verify", "year  "+(i+1)+" sucessfull ." + year + ".");
				else
					gf.writeFail("Verify", "year  "+(i+1)+"  Failed ." + year + ".");
				
				if(configuration.selenium.getText(xpath+"td[11]").equals(type))
					gf.writePass("Verify", "type  "+(i+1)+" sucessfull ." + type + ".");
				else
					gf.writeFail("Verify", "type  "+(i+1)+"  Failed ." + type + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Abstract Tab
	public boolean abstractKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String title = "";
		String abstractNumber = "";
		String date = "";
		String meeting = "";
		String abstractDes = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.ABSTRACT_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from abstract for specific ID
	   		String filePath1 = ("Data/abstract.xls");
	        String[] abstractData = lib.getExcelDataMultiple(filePath1,"abstract",OLID);
	        int rowNum = 0;
	        for(int i=0;i<abstractData.length;i++){
	        	
		        	if(abstractData[i]!=null){
		        	
		        		System.out.println("Data---"+abstractData[i]);
				
		        		title = "";
		        		abstractNumber = "";
		        		date = "";
		        		meeting = "";
		        		abstractDes = "";
	
		        		abstractData[i] = abstractData[i].replace("|", ":");
			            System.out.println("abstractData Data is "+abstractData[i]);
			            String[] abstractDataArray = abstractData[i].split(":");
			            for(int j=0;j<abstractDataArray.length;j++)
			            	System.out.println("Data---"+abstractDataArray[j]);
			            
			            if(abstractDataArray[1]!=null)
			            	title = abstractDataArray[1].replace("\"", ""); 
				        if(abstractDataArray[2]!=null)
				        	abstractNumber = abstractDataArray[2].replace("\"", ""); 
				        if(abstractDataArray[3]!=null)
				        	date = abstractDataArray[3].replace("\"", ""); 
				        if(abstractDataArray[4]!=null)
				        	meeting = abstractDataArray[4].replace("\"", ""); 
				        if(abstractDataArray[5]!=null)
				        	abstractDes = abstractDataArray[5].replace("\"", ""); 
				  }
		        
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", title);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(title))
					gf.writePass("Verify", "title  "+(i+1)+" sucessfull ." + title + ".");
				else
					gf.writeFail("Verify", "title  "+(i+1)+"  Failed ." + title + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(abstractNumber))
					gf.writePass("Verify", "abstractNumber  "+(i+1)+" sucessfull ." + abstractNumber + ".");
				else
					gf.writeFail("Verify", "abstractNumber  "+(i+1)+"  Failed ." + abstractNumber + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(date))
					gf.writePass("Verify", "date  "+(i+1)+" sucessfull ." + date + ".");
				else
					gf.writeFail("Verify", "date  "+(i+1)+"  Failed ." + date + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(meeting))
					gf.writePass("Verify", "meeting  "+(i+1)+" sucessfull ." + meeting + ".");
				else
					gf.writeFail("Verify", "meeting  "+(i+1)+"  Failed ." + meeting + ".");
				
				if(configuration.selenium.getText(xpath+"td[11]").equals(abstractDes))
					gf.writePass("Verify", "abstractDes  "+(i+1)+" sucessfull ." + abstractDes + ".");
				else
					gf.writeFail("Verify", "abstractDes  "+(i+1)+"  Failed ." + abstractDes + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Publications Tab
	public boolean publicationsKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String medline = "";
		String authorPosition = "";
		String author = "";
		String title = "";
		String journal = "";
		String reference = "";
		String date = "";
		String type = "";
		String trailFlag = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.PUBLICATIONS_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from publications for specific ID
	   		String filePath1 = ("Data/publications.xls");
	        String[] publicationsData = lib.getExcelDataMultiple(filePath1,"publications",OLID);
	        int rowNum=0;
	        for(int i=0;i<publicationsData.length;i++){
	        	
		        	if(publicationsData[i]!=null){
		        	
		        		System.out.println("Data---"+publicationsData[i]);
				
		        		medline = "";
		        		authorPosition = "";
		        		author = "";
		        		title = "";
		        		journal = "";
		        		reference = "";
		        		date = "";
		        		type = "";
		        		trailFlag = "";
	
		        		publicationsData[i] = publicationsData[i].replace("|", ":");
			            System.out.println("publicationsData Data is "+publicationsData[i]);
			            String[] publicationsDataArray = publicationsData[i].split(":");
			            for(int j=0;j<publicationsDataArray.length;j++)
			            	System.out.println("Data---"+publicationsDataArray[j]);
			            
			            if(publicationsDataArray[2]!=null)
			            	medline = publicationsDataArray[2].replace("\"", ""); 
				        if(publicationsDataArray[3]!=null)
				        	authorPosition = publicationsDataArray[3].replace("\"", ""); 
				        if(publicationsDataArray[4]!=null)
				        	author = publicationsDataArray[4].replace("\"", ""); 
				        if(publicationsDataArray[5]!=null)
				        	title = publicationsDataArray[5].replace("\"", ""); 
				        if(publicationsDataArray[6]!=null)
				        	journal = publicationsDataArray[6].replace("\"", ""); 
				        if(publicationsDataArray[7]!=null)
				        	reference = publicationsDataArray[7].replace("\"", ""); 
				        if(publicationsDataArray[8]!=null)
				        	date = publicationsDataArray[8].replace("\"", ""); 
				        if(publicationsDataArray[9]!=null)
				        	type = publicationsDataArray[9].replace("\"", ""); 
				        if(publicationsDataArray[10]!=null)
				        	trailFlag = publicationsDataArray[10].replace("\"", "");
				  }
		        if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", medline);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
			//	String xpath = "//tbody/tr["+(i+1)+"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(medline))
					gf.writePass("Verify", "medline  "+(i+1)+" sucessfull ." + medline + ".");
				else
					gf.writeFail("Verify", "medline  "+(i+1)+"  Failed ." + medline + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(authorPosition))
					gf.writePass("Verify", "authorPosition  "+(i+1)+" sucessfull ." + authorPosition + ".");
				else
					gf.writeFail("Verify", "authorPosition  "+(i+1)+"  Failed ." + authorPosition + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(author))
					gf.writePass("Verify", "author  "+(i+1)+" sucessfull ." + author + ".");
				else
					gf.writeFail("Verify", "author  "+(i+1)+"  Failed ." + author + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(title))
					gf.writePass("Verify", "title  "+(i+1)+" sucessfull ." + title + ".");
				else
					gf.writeFail("Verify", "title  "+(i+1)+"  Failed ." + title + ".");
				
				if(configuration.selenium.getText(xpath+"td[11]").equals(journal))
					gf.writePass("Verify", "journal  "+(i+1)+" sucessfull ." + journal + ".");
				else
					gf.writeFail("Verify", "journal  "+(i+1)+"  Failed ." + journal + ".");
				
				if(configuration.selenium.getText(xpath+"td[13]").equals(reference))
					gf.writePass("Verify", "reference  "+(i+1)+" sucessfull ." + reference + ".");
				else
					gf.writeFail("Verify", "reference  "+(i+1)+"  Failed ." + reference + ".");
				
				if(configuration.selenium.getText(xpath+"td[15]").equals(date))
					gf.writePass("Verify", "date  "+(i+1)+" sucessfull ." + date + ".");
				else
					gf.writeFail("Verify", "date  "+(i+1)+"  Failed ." + date + ".");
				
				if(configuration.selenium.getText(xpath+"td[17]").equals(type))
					gf.writePass("Verify", "type  "+(i+1)+" sucessfull ." + type + ".");
				else
					gf.writeFail("Verify", "type  "+(i+1)+"  Failed ." + type + ".");
				
				if(configuration.selenium.getText(xpath+"td[19]").equals(trailFlag))
					gf.writePass("Verify", "trailFlag  "+(i+1)+" sucessfull ." + trailFlag + ".");
				else
					gf.writeFail("Verify", "trailFlag  "+(i+1)+"  Failed ." + trailFlag + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Topic ExpertiseKOL Tab
	public boolean topicExpertiseKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String topicDescription = "";
		String topicFrequency = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.TOPIC_EXPERTISE_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from topic_expertise for specific ID
	   		String filePath1 = ("Data/topic_expertise.xls");
	        String[] topicData = lib.getExcelDataMultiple(filePath1,"topic_expertise",OLID);
	        int rowNum = 0;
	        for(int i=0;i<topicData.length;i++){
	        	
		        	if(topicData[i]!=null){
		        	
		        		System.out.println("Data---"+topicData[i]);
				
		        		topicDescription = "";
		        		topicFrequency = "";
	
		        		topicData[i] = topicData[i].replace("|", ":");
			            System.out.println("topicData Data is "+topicData[i]);
			            String[] topicDataArray = topicData[i].split(":");
			            for(int j=0;j<topicDataArray.length;j++)
			            	System.out.println("Data---"+topicDataArray[j]);
			            
			            if(topicDataArray[2]!=null)
			            	topicDescription = topicDataArray[2].replace("\"", ""); 
				        if(topicDataArray[3]!=null)
				        	topicFrequency = topicDataArray[3].replace("\"", ""); 
				  }
		        
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", topicDescription);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(topicDescription))
					gf.writePass("Verify", "topicDescription  "+(i+1)+" sucessfull ." + topicDescription + ".");
				else
					gf.writeFail("Verify", "topicDescription  "+(i+1)+"  Failed ." + topicDescription + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(topicFrequency))
					gf.writePass("Verify", "topicFrequency  "+(i+1)+" sucessfull ." + topicFrequency + ".");
				else
					gf.writeFail("Verify", "topicFrequency  "+(i+1)+"  Failed ." + topicFrequency + ".");
				rowNum++;
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in Interest DescriptionKOL Tab
	public boolean interestDescriptionKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String interestDescription = "";
		String interestFrequency = "";
		String clientName = PropertyFinder.getPropertyFilename(EnvInitialization.CLIENT);
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.INTEREST_DESCRIPTION_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from interest_description for specific ID
	   		String filePath1 = ("Data/interest_description.xls");
	        String[] interestDescriptionData = lib.getExcelDataMultiple(filePath1,"interest_description",OLID);
	        int rowNum = 0;
	        for(int i=0;i<interestDescriptionData.length;i++){
	        	
		        	if(interestDescriptionData[i]!=null){
		        	
		        		System.out.println("Data---"+interestDescriptionData[i]);
				
		        		interestDescription = "";
		        		interestFrequency = "";
	
		        		interestDescriptionData[i] = interestDescriptionData[i].replace("|", ":");
			            System.out.println("topicData Data is "+interestDescriptionData[i]);
			            String[] interestDescriptionDataArray = interestDescriptionData[i].split(":");
			            for(int j=0;j<interestDescriptionDataArray.length;j++)
			            	System.out.println("Data---"+interestDescriptionDataArray[j]);
			            
			            if(clientName.equals("HEMO")){
			            	
			            	if(interestDescriptionDataArray[3]!=null)
			            		interestDescription = interestDescriptionDataArray[3].replace("\"", ""); 
					        if(interestDescriptionDataArray[2]!=null)
					        	interestFrequency = interestDescriptionDataArray[2].replace("\"", ""); 
			            }
			            else{
			            	
			            	if(interestDescriptionDataArray[2]!=null)
			            		interestDescription = interestDescriptionDataArray[2].replace("\"", ""); 
					        if(interestDescriptionDataArray[3]!=null)
					        	interestFrequency = interestDescriptionDataArray[3].replace("\"", "");
			            }
				  }
		        
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", interestDescription);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(interestDescription))
					gf.writePass("Verify", "interestDescription  "+(i+1)+" sucessfull ." + interestDescription + ".");
				else
					gf.writeFail("Verify", "interestDescription  "+(i+1)+"  Failed ." + interestDescription + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(interestFrequency))
					gf.writePass("Verify", "interestFrequency  "+(i+1)+" sucessfull ." + interestFrequency + ".");
				else
					gf.writeFail("Verify", "interestFrequency  "+(i+1)+"  Failed ." + interestFrequency + ".");
				rowNum++;	
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
	//Function to validate data in All Trails Tab
	public boolean trailsKOL(String userName, String passWord, String fName, String lName, String OLID)
	throws Exception {
		
		DataLibrary lib = new DataLibrary();
		
		String sponsor = "";
		String status = "";
		String name = "";
		String theraphy = "";
		String diseaseState = "";
		String startDate = "";
		String endDate = "";
		String phase = "";
		String enrollment = "";
		String trailRole = "";
		
        System.out.println(configuration.selenium.getTitle());
		if (configuration.selenium.getTitle().equalsIgnoreCase(EnvInitialization.PAGE_TITLE)) {
			gf.writePass("Verify", "Login sucessfull. Welcome " + userName
			+ ".");
			
			String KOLName = lName+", "+fName;
			System.out.println("Nme Search String is "+KOLName);
			(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("rightPane");
			Thread.sleep(3000);
			configuration.selenium.click("link="+KOLName);
			configuration.selenium.waitForPageToLoad("30000");
			configuration.selenium.selectWindow("null");
			configuration.selenium.click(EnvInitialization.TRAILS_TAB);
			configuration.selenium.selectFrame(EnvInitialization.INNER_FRAME);
			Thread.sleep(3000);
			configuration.selenium.selectFrame(EnvInitialization.BASIC_ATTRIBUTES_FRAME);
			
			// Retrieving multiple rows Data from Trails for specific ID
	   		String filePath1 = ("Data/trials.xls");
	        String[] trailsdata = lib.getExcelDataMultiple(filePath1,"trials",OLID);
	        int rowNum = 0;
	        for(int i=0;i<trailsdata.length;i++){
	        	
		        	if(trailsdata[i]!=null){
		        	
		        		System.out.println("Data---"+trailsdata[i]);
				
		        		sponsor = "";
		        		status = "";
		        		name = "";
		        		theraphy = "";
		        		diseaseState = "";
		        		startDate = "";
		        		endDate = "";
		        		phase = "";
		        		enrollment = "";
		        		trailRole = "";
	
		        		trailsdata[i] = trailsdata[i].replace("|", ":");
			            System.out.println("trailsdata Data is "+trailsdata[i]);
			            String[] trailsdataArray = trailsdata[i].split(":");
			            for(int j=0;j<trailsdataArray.length;j++)
			            	System.out.println("Data---"+trailsdataArray[j]);
			            	
		            	if(trailsdataArray[1]!=null)
		            		sponsor = trailsdataArray[1].replace("\"", ""); 
				        if(trailsdataArray[2]!=null)
				        	status = trailsdataArray[2].replace("\"", "");
				        if(trailsdataArray[3]!=null)
				        	name = trailsdataArray[3].replace("\"", ""); 
				        if(trailsdataArray[4]!=null)
				        	theraphy = trailsdataArray[4].replace("\"", "");
				        if(trailsdataArray[5]!=null)
				        	diseaseState = trailsdataArray[5].replace("\"", ""); 
				        if(trailsdataArray[6]!=null)
				        	startDate = trailsdataArray[6].replace("\"", "");
				        if(trailsdataArray[7]!=null)
				        	endDate = trailsdataArray[7].replace("\"", ""); 
				        if(trailsdataArray[8]!=null)
				        	phase = trailsdataArray[8].replace("\"", "");
				        if(trailsdataArray[9]!=null)
				        	enrollment = trailsdataArray[9].replace("\"", ""); 
				        if(trailsdataArray[16]!=null)
				        	trailRole = trailsdataArray[16].replace("\"", "");
			            
				  }
		        
	        	if(i==0){
		        	rowNum = allgrids.rowNumber("sortable", sponsor);	
		        }
		        String xpath = "//tbody/tr["+ rowNum +"]/";
				System.out.println("xpath newly constrcted is-----------"+xpath);
				
				if(configuration.selenium.getText(xpath+"td[3]").equals(sponsor))
					gf.writePass("Verify", "sponsor  "+(i+1)+" sucessfull ." + sponsor + ".");
				else
					gf.writeFail("Verify", "sponsor  "+(i+1)+"  Failed ." + sponsor + ".");
				
				if(configuration.selenium.getText(xpath+"td[5]").equals(status))
					gf.writePass("Verify", "status  "+(i+1)+" sucessfull ." + status + ".");
				else
					gf.writeFail("Verify", "status  "+(i+1)+"  Failed ." + status + ".");
				
				if(configuration.selenium.getText(xpath+"td[7]").equals(name))
					gf.writePass("Verify", "name  "+(i+1)+" sucessfull ." + name + ".");
				else
					gf.writeFail("Verify", "name  "+(i+1)+"  Failed ." + name + ".");
				
				if(configuration.selenium.getText(xpath+"td[9]").equals(theraphy))
					gf.writePass("Verify", "theraphy  "+(i+1)+" sucessfull ." + theraphy + ".");
				else
					gf.writeFail("Verify", "theraphy  "+(i+1)+"  Failed ." + theraphy + ".");
				
				if(configuration.selenium.getText(xpath+"td[11]").equals(diseaseState))
					gf.writePass("Verify", "diseaseState  "+(i+1)+" sucessfull ." + diseaseState + ".");
				else
					gf.writeFail("Verify", "diseaseState  "+(i+1)+"  Failed ." + diseaseState + ".");
				
				if(configuration.selenium.getText(xpath+"td[13]").equals(startDate))
					gf.writePass("Verify", "startDate  "+(i+1)+" sucessfull ." + startDate + ".");
				else
					gf.writeFail("Verify", "startDate  "+(i+1)+"  Failed ." + startDate + ".");
				
				if(configuration.selenium.getText(xpath+"td[15]").equals(endDate))
					gf.writePass("Verify", "endDate  "+(i+1)+" sucessfull ." + endDate + ".");
				else
					gf.writeFail("Verify", "endDate  "+(i+1)+"  Failed ." + endDate + ".");
				
				if(configuration.selenium.getText(xpath+"td[17]").equals(phase))
					gf.writePass("Verify", "phase  "+(i+1)+" sucessfull ." + phase + ".");
				else
					gf.writeFail("Verify", "phase  "+(i+1)+"  Failed ." + phase + ".");
				
				if(configuration.selenium.getText(xpath+"td[19]").equals(enrollment))
					gf.writePass("Verify", "enrollment  "+(i+1)+" sucessfull ." + enrollment + ".");
				else
					gf.writeFail("Verify", "enrollment  "+(i+1)+"  Failed ." + enrollment + ".");
				
				if(configuration.selenium.getText(xpath+"td[21]").equals(trailRole))
					gf.writePass("Verify", "trailRole  "+(i+1)+" sucessfull ." + trailRole + ".");
				else
					gf.writeFail("Verify", "trailRole  "+(i+1)+"  Failed ." + trailRole + ".");
				rowNum++;	
	        }
	        
        	(new screenshots()).takeAScreenShotOfTheApp();
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.selectFrame("relative=up");
			configuration.selenium.click("link=Home");
			Thread.sleep(3000);	        
			
		} else {
			gf.writeFail("Verify", "Login Failed with the " + userName + ".");
			return false;
		}
       
        return true;
	}
	
}
