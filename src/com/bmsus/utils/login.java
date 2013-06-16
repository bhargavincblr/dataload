package com.bmsus.utils;


public class login {

	/**
	 * @param args
	 */
	private static  GenericFuntions gf = new GenericFuntions("");
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static  void loginuser(String userName,String passWord)
	{
		try
		{
		gf.typeIntoTextBox("userName", userName);
		
		gf.typeIntoTextBox("userPassword", passWord);
		configuration.selenium.click("Submit2");
		Thread.sleep(2000);
				
		popuswindows.allpageloads();
		
		}catch(Exception e)
		{
			try
			{
			gf.writeFail("Verifying login"+userName, "Faied and exception occured");
			}catch(Exception e1)
			{
				e.printStackTrace();
			}
			
		}
	}

}
