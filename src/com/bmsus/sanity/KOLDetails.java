package com.bmsus.sanity;

import com.bmsus.utils.*;
import com.thoughtworks.selenium.SeleneseTestCase;
import org.testng.annotations.Test;

public class KOLDetails extends SeleneseTestCase {
	
	@Test(sequential = true)
	public void testKOLDetails() throws Exception {
		
		cleaning.cleaner(EnvInitialization.BROWSER_IE);
		String[] data = new String[4];
        DataLibrary lib = new DataLibrary();
        String filePath = (EnvInitialization.DATA_SANITY);
        data = lib.getExcelData(filePath, EnvInitialization.DATA_SHEET_USERLOGIN, 2);
        try{
        	String currentScriptName = this.getClass().getSimpleName();
            SanityFunctionRepository sfr = new SanityFunctionRepository( currentScriptName);
            login.loginuser(data[0], data[1]);
            System.out.println("Sanity Data arry length is-------"+data.length);
            for(int i=2;i<data.length;i++){
            	boolean flag = sfr.profileDetailsKOL(data[0], data[1], data[i]);
                if (!flag)
    				throw new Exception(); 
            }
        	configuration.selenium.deselectPopUp();
    		Thread.sleep(2000);
    		configuration.selenium.close();
    		GenericFuntions.writeSummaryPass("KOL Profile Details");
            
        }
        catch(Exception ex)
        {
            cleaning.Errorwriter(ex);
        }
	
	}
}

