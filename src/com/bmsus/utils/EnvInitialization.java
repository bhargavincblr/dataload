/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bmsus.utils;

import java.io.File;
import java.util.ResourceBundle;

/**
 * 
 * @author Devarakonda Narasimham Date: 21 Oct 2009 Purpose: This class
 *         Initializes all the environment Variables
 * 
 */
public class EnvInitialization {
	public static final String SELENIUM_SERVER_HOST = ResourceBundle.getBundle(
			"environment/environment").getString("SELENIUM_SERVER_HOST");
	public static final int SELENIUM_SERVER_PORT = Integer
			.parseInt(ResourceBundle.getBundle("environment/environment")
					.getString("SELENIUM_SERVER_PORT"));
	public static final String BASE_URL = ResourceBundle.getBundle(
			"environment/environment").getString("BASE_URL");

	public static  String BROWSER ;

	public static final String DATE_FORMAT_RESULT = ResourceBundle.getBundle(
			"environment/environment").getString("DATE_FORMAT_RESULT");
	public static final String RESULT_FILE = ResourceBundle.getBundle(
			"environment/environment").getString("RESULT_FILE");
	public static final String FOLDER_ERROR = ResourceBundle.getBundle(
			"environment/environment").getString("FOLDER_ERROR");
	public static final String CLIENT = ResourceBundle.getBundle(
	"environment/environment").getString("CLIENT");
	
	static String propertyName = PropertyFinder.getPropertyFilename(CLIENT);
	static String resouceProperty = "environment/"+propertyName;
		
	// Below environment variables created for ProjectSpecification objects
	
	public static final String BROWSER_FIREFOX =ResourceBundle.getBundle(
	"environment/objectrepository").getString("BROWSER_FIREFOX");
	
	public static final String BROWSER_IE =ResourceBundle.getBundle(
	"environment/objectrepository").getString("BROWSER_IE");
	
	public static final String PAGE_TITLE =ResourceBundle.getBundle(
	"environment/objectrepository").getString("PAGE_TITLE");
	
	public static final String DATA_SANITY =ResourceBundle.getBundle(
	"environment/objectrepository").getString("DATA_SANITY");
	
	public static final String DATA_PROFILE_DETAILS =ResourceBundle.getBundle(
	"environment/objectrepository").getString("DATA_PROFILE_DETAILS");
	
	public static final String DATA_SHEET_USERLOGIN =ResourceBundle.getBundle(
	"environment/objectrepository").getString("DATA_SHEET_USERLOGIN");
	
	public static final String DATA_SHEET_BIOGRAPHY =ResourceBundle.getBundle(
	"environment/objectrepository").getString("DATA_SHEET_BIOGRAPHY");
	
	public static final String DATA_SHEET_IDENTIFIERS =ResourceBundle.getBundle(
	"environment/objectrepository").getString("DATA_SHEET_IDENTIFIERS");
	
	public static final String PROFILE_DETAILS_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_PROFILE_DETAILS_TAB");
	
	public static final String INNER_FRAME =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_INNER_FRAME");
	
	public static final String BASIC_ATTRIBUTES_FRAME =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_BASIC_ATTRIBUTES_FRAME");
	
	public static final String LAST_NAME =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_LAST_NAME");
	
	public static final String FIRST_NAME =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_FIRST_NAME");
	
	public static final String MIDDLE_NAME =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_MIDDLE_NAME");
	
	public static final String SALUTATION =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_SALUTATION");
	
	public static final String SUFFIX =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_SUFFIX");
	
	public static final String PREFFERED_NAME =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_PREFFERED_NAME");
	
	public static final String GENDER =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_GENDER");
	
	public static final String PROFILE_TITLE =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_TITLE");
	
	public static final String SPECIALITY =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_SPECIALITY");
	
	public static final String SEC_SPECIALITY =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_SEC_SPECIALITY");
	
	public static final String TER_SPECIALITY =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_TERTIARY_SPECIALITY");
	
	public static final String MARK_AS_DELETE =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_MARK_AS_DELETE");
	
	public static final String DELETE_REASON =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_DELETE_REASON");
	
	public static final String DAY_TO_CONTACT =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_DAY_TO_CONTACT");
	
	public static final String TIME_TO_CONTACT =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_TIME_TO_CONTACT");
	
	public static final String SEC_DAY_TO_CONTACT =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_SEC_DAY_TO_CONTACT");
	
	public static final String SEC_TIME_TO_CONTACT =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_SEC_TIME_TO_CONTACT");
	
	public static final String BIOGRAPHY_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_BIOGRAPHY_TAB");
	
	public static final String CLINICAL_AREAS_INTEREST =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_CLINICAL_AREAS_INTEREST");
	
	public static final String BIOGRAPHY =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_BIOGRAPHY");
	
	public static final String CV =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_CV");
	
	public static final String CV_DATE =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_CV_DATE");
	
	public static final String IDENTIFIERS_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_IDENTIFIERS_TAB");
	
	public static final String CUSTOMER_NUMBER =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_CUSTOMER_NUMBER");
	
	public static final String PROFILE_SOURCE =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_PROFILE_SOURCE");
	
	public static final String PHOTO_FILENAME =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_PHOTO_FILENAME");
	
	public static final String EDUCATION_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_EDUCATION_TAB");
	
	public static final String CAREER_HISTORY_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_CAREER_HISTORY_TAB");
	
	public static final String ADDRESS_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_ADDRESS_TAB");
	
	public static final String CONTACT_INFORMATION_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_CONTACT_INFORMATION_TAB");
	
	public static final String ADDITIONAL_CONTACTS_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_ADDITIONAL_CONTACTS_TAB");
	
	public static final String SOCIETIES_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_SOCIETIES_TAB");
	
	public static final String INDUSTRY_ACTIVITIES_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_INDUSTRY_ACTIVITIES_TAB");
	
	public static final String PRESENTATIONS_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_PRESENTATIONS_TAB");
	
	public static final String COMMITTEES_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_COMMITTEES_TAB");
	
	public static final String EDITORIAL_BOARDS_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_EDITORIAL_BOARDS_TAB");
	
	public static final String GRANTS_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_GRANTS_TAB");
	
	public static final String PATENTS_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_PATENTS_TAB");
	
	public static final String HONORS_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_HONORS_TAB");
	
	public static final String ABSTRACT_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_ABSTRACT_TAB");
	
	public static final String PUBLICATIONS_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_PUBLICATIONS_TAB");
	
	public static final String TOPIC_EXPERTISE_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_TOPIC_EXPERTISE_TAB");
	
	public static final String INTEREST_DESCRIPTION_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_INTEREST_DESCRIPTION_TAB");
	
	public static final String TRAILS_TAB =ResourceBundle.getBundle(
	resouceProperty).getString(EnvInitialization.CLIENT+"_TRAILS_TAB");
		
}