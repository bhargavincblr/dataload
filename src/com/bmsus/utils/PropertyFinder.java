package com.bmsus.utils;

public class PropertyFinder {
	
	public static String getPropertyFilename(String propertyName){
		String propvalue = "";
		if(propertyName.equals("HEMO")){
			propvalue = "hemo";
			System.out.println("In Property finder[------"+EnvInitialization.CLIENT);
		}
		else if(propertyName.equals("SEAGEN")){
			propvalue = "seagen";
			System.out.println("In Property finder[------"+EnvInitialization.CLIENT);
		}
			return propvalue;
	}

}
