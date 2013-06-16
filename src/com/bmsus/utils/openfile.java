package com.bmsus.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class openfile {



	public static boolean status;
//	File folder;
	static String timestampfolder=null;
	
	
	 public static String createfolder(){
			String timestamp = null;
			
		try {

			String DATE_FORMAT_RESULT = EnvInitialization.DATE_FORMAT_RESULT;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(EnvInitialization.DATE_FORMAT_RESULT);
			timestamp = EnvInitialization.RESULT_FILE
					+ sdf.format(cal.getTime());
			timestampfolder=timestamp;
			 new File(timestamp).mkdir();
			 
			 System.out.println(timestamp);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
		
		return timestamp;
	}
	 public static void main(String  args[] )
		{
		  
		 createfolder();
		
		}
	 
	 
	
	 

}
