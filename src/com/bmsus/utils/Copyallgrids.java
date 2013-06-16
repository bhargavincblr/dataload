package com.bmsus.utils;

import java.util.ArrayList;
import java.util.Iterator;

import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;
public class Copyallgrids extends SeleneseTestCase {
	
	private static final boolean Object = false;

	/**
	 * This method is used to get number of rows
	 * in a grid
	 * @param gridId Unique Identifier of a grid
	 * @return Number of rows in the grid
	 */
	public    int getNoOfRowsInGrid(String gridId){
		int row=1;
		//int noOfRows;
		while(selenium.isElementPresent("//table[@id='"+gridId+"']/tbody/tr["+row+"]")){
			row++;
		 }
	   
		return (row); 
	}
	/**
	 * This method is used to get number of rows
	 * in a grid
	 * @param gridId Unique Identifier of a grid
	 * @return Number of rows in the grid
	 */
	public  int getNoOfRowsInGrid_ID(String gridId){
		int row=1;
		while(selenium.isElementPresent("//table[@id='"+gridId+"']/tbody/tr["+row+"]")){
			row++;
		 }
		
	    
		return (row); 
	}
	/**
	 * This method is used to get number of rows
	 * in a grid
	 * @param gridId Unique Identifier of a grid
	 * @return Number of rows in the grid
	 */
	public  int getNoOfRowsInGrid_GJ(String gridId){
		int row=1;
		int noOfRows;
		while(selenium.isElementPresent("//table[@id='"+gridId+"']/tbody/tr["+row+"]")){
			row++;
		 }
		noOfRows=row==1?0:row-2;
    
	    //count-2 because tr index start from 1 and count for header and return 0 if there is no row i.e count=1
		return (noOfRows); 
	}
	
	
	/**
	 * This method is used to select any row of a grid
	 * @param gridId Unique identifier of a grid
	 * @param rowNo Row index
	 */
	public  void selectRowInGrid(String gridId,int rowNo){
		selenium.click("//table[@class='"+gridId+"']/tbody/tr["+rowNo+"]/td[1]");
		
	}
		
	/**
	 * Returns text present at a specified cell in a grid
	 * @param gridId  Unique identifier of grid
	 * @param row :   Row number of the cell
	 * @param column: Column number of the cell
	 * @return text string
	 */
	public  String getTextInGridAt(String gridId,int row,int column){
		String gridText=selenium.getTable(gridId+"."+"1"+"."+"1");
		return gridText;
		
	}
	
	/**
	 * This method returns data in a the selected row of a grid
	 * @param gridId Unique identifier of the grid
	 * @param rowNo  Index of the row
	 * @param noOfColumn Number of columns in the grid
	 * @return ArrayList of data in the specified row
	 */
	public  ArrayList<String> getGridRow(String gridId,int rowNo,int noOfColumn){
		ArrayList<String> row=new ArrayList<String>();
		for(int column=0;column<noOfColumn;column++){
		    int index=column;
			row.add(index, selenium.getTable(gridId+"."+rowNo+"."+column));
		
		}
		return row;
	}
	


	
	


	
}





