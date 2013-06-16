package com.bmsus.utils;

import java.util.ArrayList;
import java.util.Iterator;

public class allgrids {

	private static final boolean Object = false;

	/**
	 * This method is used to get number of rows in a grid
	 * 
	 * @param gridId
	 *            Unique Identifier of a grid
	 * @return Number of rows in the grid
	 */
	public static int getNoOfRowsInGrid(String gridId) {
		int row = 1;
		// int noOfRows;
		while (configuration.selenium.isElementPresent("//table[@id='" + gridId
				+ "']/tbody/tr[" + row + "]")) {
			row++;
		}

		return (row);
	}

	/**
	 * This method is used to get number of rows in a grid
	 * 
	 * @param gridId
	 *            Unique Identifier of a grid
	 * @return Number of rows in the grid
	 */
	public static int getNoOfRowsInGrid_ID(String gridId) {
		int row = 1;
		while (configuration.selenium.isElementPresent("//table[@id='" + gridId
				+ "']/tbody/tr[" + row + "]")) {
			row++;
		}

		return (row);
	}

	public static int getNoOfRowsInGrid_class(String classname) {
		int row = 1;
		while (configuration.selenium.isElementPresent("//table[@class='" + classname
				+ "']/tbody/tr[" + row + "]")) {
			row++;
		}

		return (row);
	}
	/**
	 * This method is used to get number of rows in a grid
	 * 
	 * @param gridId
	 *            Unique Identifier of a grid
	 * @return Number of rows in the grid
	 */
	public int getNoOfRowsInGrid_GJ(String gridId) {
		int row = 1;
		int noOfRows;
		while (configuration.selenium.isElementPresent("//table[@id='" + gridId
				+ "']/tbody/tr[" + row + "]")) {
			row++;
		}
		noOfRows = row == 1 ? 0 : row - 2;

		// count-2 because tr index start from 1 and count for header and return
		// 0 if there is no row i.e count=1
		return (noOfRows);
	}

	/**
	 * This method is used to select any row of a grid
	 * 
	 * @param gridId
	 *            Unique identifier of a grid
	 * @param rowNo
	 *            Row index
	 */
	public static void selectRowInGrid(String gridId, int rowNo) {
		configuration.selenium.click("//table[@class='" + gridId
				+ "']/tbody/tr[" + rowNo + "]/td[1]");

	}

	/**
	 * Returns text present at a specified cell in a grid
	 * 
	 * @param gridId
	 *            Unique identifier of grid
	 * @param row
	 *            : Row number of the cell
	 * @param column
	 *            : Column number of the cell
	 * @return text string
	 */
	public static String getTextInGridAt(String gridId, int row, int column) {
		String gridText = configuration.selenium.getTable(gridId + "." + "1"
				+ "." + "1");
		return gridText;

	}

	/**
	 * This method returns data in a the selected row of a grid
	 * 
	 * @param gridId
	 *            Unique identifier of the grid
	 * @param rowNo
	 *            Index of the row
	 * @param noOfColumn
	 *            Number of columns in the grid
	 * @return ArrayList of data in the specified row
	 */
	public static ArrayList<String> getGridRow(String gridId, int rowNo,
			int noOfColumn) {
		ArrayList<String> row = new ArrayList<String>();
		for (int column = 0; column < noOfColumn; column++) {
			int index = column;
			row.add(index, configuration.selenium.getTable(gridId + "." + rowNo
					+ "." + column));

		}
		return row;
	}

	public static String completexpath(String tableid, String search,
			String linkname, int columnnumber,String controltype) throws Exception {
		ArrayList object = new ArrayList();

		int rows = getNoOfRowsInGrid(tableid);
		System.out.println("Total Rows:"+rows);
		int stringincrementer = 0;
		for (int i = 1; i < rows; i++) {

			String temp = configuration.selenium.getText("//table[@id='"
					+ tableid + "']/tbody/tr[" + i + "]/td[2]");

			if (temp.contains(search)) {

				object.add("xpath=id('" + tableid + "')/tbody/tr[" + i + "]");

			}

		}

		Iterator i = object.iterator();
		String temp=null;
		while (i.hasNext()) {
			
			 temp = i.next() + "/td["+columnnumber+"]/"+controltype;
			
			if (!temp.contains("null")) {
				boolean present = configuration.selenium.isElementPresent(temp);

				if (present) {
					
					String review = configuration.selenium.getText(temp);
					System.out.println("narayana123:"+review);
					if (review.contains(linkname))
						{
						System.out.println("FInal"
								+ configuration.selenium.getText(temp) + ":"
								+ temp);
					return temp;
						}
				}
			}
		}
		return null;

	}
	
	public static int rowNumber(String tableClass, String search)throws Exception {
		
		int rows = getNoOfRowsInGrid_class(tableClass);
		int i=1;
		for (; i < rows; i++) {

			String temp = configuration.selenium.getText("//table[@class='"
					+ tableClass + "']/tbody/tr[" + i + "]/td[3]");

			if (temp.equals(search))
				break;
	
		}
		return i;
		
	}
	
	
	public static String completexpath_class(String tableid, String search,
			String linkname, int columnnumber,String controltype) throws Exception {
		ArrayList object = new ArrayList();

		int rows = getNoOfRowsInGrid_class(tableid);
		int stringincrementer = 0;
		for (int i = 1; i < rows; i++) {

			String temp = configuration.selenium.getText("//table[@class='"
					+ tableid + "']/tbody/tr[" + i + "]/td[2]");

			if (temp.contains(search)) {

				object.add("xpath=//table[@class='"+tableid+"']/tbody/tr["+i+"]");

			}

		}

		Iterator i = object.iterator();
		String temp=null;
		while (i.hasNext()) {
			 if(controltype.equals(""))
				 temp = i.next() + "/td["+columnnumber+"]";
			 else
				 temp = i.next() + "/td["+columnnumber+"]/"+controltype;
			
			if (!temp.contains("null")) {
				boolean present = configuration.selenium.isElementPresent(temp);

				if (present) {
					String review = configuration.selenium.getText(temp);
					System.out.println("narayana123:"+temp);
					if (review.contains(linkname))
						{
						System.out.println("FInal"
								+ configuration.selenium.getText(temp) + ":"
								+ temp);
					return temp;
						}
				}
			}
		}
		return null;

	}
}
