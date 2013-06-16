package com.bmsus.utils;


public class popuswindows {

	public static void popup(String name) {
		configuration.selenium.waitForPopUp(name,"80000");
		configuration.selenium.selectPopUp(name);
		//configuration.selenium.windowMaximize();
		//configuration.selenium.windowFocus();
		
	}
	
	public static  void allpageloads()
	{
	configuration.selenium.waitForPageToLoad("80000");
	// popuswindows.allpageloads();
	}

}
