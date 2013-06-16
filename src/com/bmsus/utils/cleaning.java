package com.bmsus.utils;

import java.io.IOException;

import junit.framework.TestCase;

import org.testng.Reporter;


public class cleaning extends TestCase {
	public static int buildflag=0;
	EnvInitialization env = new EnvInitialization();
	public static String studyname = null;

	public static void cleaner(String browser) {
		if (configuration.selenium != null)
			configuration.stopSelenium();
		if (browser.contains("firefox"))
		{
			EnvInitialization.BROWSER = "*firefox";
			configuration cfg = new configuration();
			configuration.selenium.open("/hemo/");
			
		}
		else
		{
			EnvInitialization.BROWSER = "*iehta";
			configuration cfg = new configuration();
			configuration.selenium.open("/hemo/");
		}
		
	
		
		configuration.selenium.waitForPageToLoad("10000");
		configuration.selenium.windowMaximize();

	}

	public void buildcheck()
	{
		
		configuration.selenium.open("/version.txt");
		String xe=configuration.selenium.getBodyText();
		System.out.println(xe);
		
	}
	
	public static void cleanerdb() {
		try {
			Runtime.getRuntime().exec("db.bat > db.log ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String str[]) {
		//cleanerdb();
		cleanerdb();
		try {
			Runtime.getRuntime().exec("net stop tomcat6 ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Errorwriter(Exception ex) {
		assertEquals(true, false);
		   configuration.stopSelenium();
		   ex.printStackTrace();
	}
	public static String popupid() {
		String a[] = configuration.selenium.getAllWindowNames();
		String popupwind = null;
		

		for (String w : a)
			if (w.contains("selenium_blank"))
				return popupwind = w;
		for (String w1 : a)
			if (w1.contains("undefined"))
				return popupwind = w1;	
		for (String w2 : a)
			if (w2.contains(EnvInitialization.PAGE_TITLE))
				return popupwind = w2;
				
		return popupwind;
	}

}
