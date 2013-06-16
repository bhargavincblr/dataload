package com.bmsus.utils;



import java.io.File;

import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;

/**
 * @author Devarakonda Narasimham Date: 21 Oct 2009 Purpose Creates Selenium for
 *         Executing Test cases
 */
public class configuration {
	static SeleniumServer server1;
	static RemoteControlConfiguration rcc1;
	public configuration() {

		 rcc1 = new RemoteControlConfiguration();
		try {

			rcc1.setPort(EnvInitialization.SELENIUM_SERVER_PORT);
			 server1 = new SeleniumServer(rcc1);
			 
			 rcc1.setTrustAllSSLCertificates(true);
		//	 rcc1.setFirefoxProfileTemplate(new File("C:\\Documents and Settings\\P7106557\\Local Settings\\Application Data\\Mozilla\\Firefox\\Profiles\\y3r53h8t.default"));
		
			server1.start();
			
			
			configuration.startSeleniumClient();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static DefaultSelenium selenium;

	public static DefaultSelenium createSeleniumClient(String url,
			String browser) {
		return new DefaultSelenium(EnvInitialization.SELENIUM_SERVER_HOST,
				EnvInitialization.SELENIUM_SERVER_PORT, EnvInitialization.BROWSER, url);
	}

	public static void startSeleniumClient() {

		selenium = createSeleniumClient(EnvInitialization.BASE_URL,
				EnvInitialization.BROWSER);
		selenium.start();
	}

	
	  public  static void stopSelenium() { try {
		  server1.stop();
		//  server1.boot();
		//rcc1.setPort(0);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} }
	

}
