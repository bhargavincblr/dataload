package com.bmsus.utils;

import java.io.File;
import java.util.ResourceBundle;

public class testingnara {
	public static void main(String []a)
	{
		
		File f= new File("environment");
		String path=f.getAbsolutePath();
		String SELENIUM_SERVER_HOST = ResourceBundle.getBundle(
		path+"\\environment.properties").getString("SELENIUM_SERVER_HOST");
		System.out.println(	SELENIUM_SERVER_HOST);
		
		
	}
}
