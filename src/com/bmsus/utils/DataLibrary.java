/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmsus.utils;

import java.io.File;
import jxl.*;
import java.util.*;


/**
 * 
 * @author Administrator
 */
public class DataLibrary {
	public static Workbook workBook;

	// To do should be pushed to other file for initilization file
	public String[] getExcelData(String filePath, String sheetName, int rowNum)
			throws Exception {

		String[] data = null;

		workBook = Workbook.getWorkbook(new File(filePath));
		Sheet sheet = workBook.getSheet(sheetName);
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		Debug.message("no of rows == > " + sheet.getRows());
		Debug.message("no of cols == > " + sheet.getColumns());
		data = new String[cols];
		int j = 1;
		if (rows <= rowNum) {

			// for (int j = 1; j < rowNum; j++) //{
			for (int i = 0; i < cols; i++) {
				data[i] = sheet.getCell(i, j).getContents();
				Debug.message("Data == > " + data[i].toString());
				Debug.message("int i value in dataLibrary ==>> " + i);
			}
			// }
			/*
			 * for (int i = 0; i < cols; i++) { data[i] = sheet.getCell(i,
			 * (rowNum - 1)).getContents(); Debug.message("Data == > " +
			 * data[i].toString());
			 * Debug.message("int i value in dataLibrary ==>> " + i); }
			 */
		} else {
			Debug.message("Row number exceeds the expected one's ");
		}
		// workBook.close();
		return data;
	}
	
	
	// To retrieve the single row data identified by given string.
	public String getExcelDataSingle(String filePath, String sheetName, String searchString)
			throws Exception {

		String userIdComp = null;
		workBook = Workbook.getWorkbook(new File(filePath));
		Sheet sheet = workBook.getSheet(sheetName);
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		Debug.message("no of rows == > " + sheet.getRows());
		Debug.message("no of cols == > " + sheet.getColumns());
		int j = 0;
		for(int z=1; z< rows;z++) {
			
			userIdComp = sheet.getCell(j, z).getContents();
			if (userIdComp.contains(searchString))
				break;
			else
				userIdComp = null;
		}
		return userIdComp;
	}
	
	// To retrieve the Multiple rows data identified by given string.
	public String[] getExcelDataMultiple(String filePath, String sheetName, String searchString)
			throws Exception {

		String searchComp = null;
		String[] tempdata = null;
		workBook = Workbook.getWorkbook(new File(filePath));
		Sheet sheet = workBook.getSheet(sheetName);
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		Debug.message("no of rows == > " + sheet.getRows());
		Debug.message("no of cols == > " + sheet.getColumns());
		tempdata = new String[rows];
		int j = 0;
		int i = 0;
		for(int z=1; z< rows;z++) {
			
			searchComp = sheet.getCell(j, z).getContents();
			if (searchComp.contains(searchString)){
				tempdata[i] = searchComp;
				i++;			
			}
						
		}
		String[] data = new String[i];
		for(int y=0;y<i;y++)
			data[y] = tempdata[y];
		return data;
	}
	

}
