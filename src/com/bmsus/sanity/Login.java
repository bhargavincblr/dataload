package com.bmsus.sanity;

import com.bmsus.utils.*;
import com.thoughtworks.selenium.SeleneseTestCase;
import org.testng.annotations.Test;

public class Login extends SeleneseTestCase {
	
	@Test(sequential = true)
	public void testLogin() throws Exception {
		
		cleaning.cleaner(EnvInitialization.BROWSER_IE);
		String[] data = new String[4];
        DataLibrary lib = new DataLibrary();
        String filePath = (EnvInitialization.DATA_SANITY);
        data = lib.getExcelData(filePath, EnvInitialization.DATA_SHEET_USERLOGIN, 2);
        try{
        	String currentScriptName = this.getClass().getSimpleName();
            SanityFunctionRepository sfr = new SanityFunctionRepository( currentScriptName);
            boolean flag = sfr.loginToBMSUS(data[0], data[1]);
            if (!flag)
				throw new Exception();            
        }
        catch(Exception ex)
        {
            cleaning.Errorwriter(ex);
        }
	
	}
}

