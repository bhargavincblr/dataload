/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmsus.utils;

import com.bmsus.utils.configuration;
import com.thoughtworks.selenium.Selenium;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *]
 * 
 * @author Administrator
 */
public class GenericFuntions {

	private String testScriptName;

	// private String folderPath;

	public GenericFuntions(String scriptName) {
		this.testScriptName = scriptName;

		try {
			/*
			 * openfile openfile1=new openfile(); folderPath =
			 * openfile1.createfolder(); System.out.println(folderPath);
			 */
			createLogFile();
			Debug.message("Beforeeeeeeeeeeeeee");
			createSummaryFile();
			Debug.message("Afterrrrrrrrrrrrrrrrr ");
		} catch (Exception ex) {
			Debug.message("Exception while writting log file - "
					+ ex.getMessage());
		}
	}

	public void createLogFile() throws Exception {
		try {

			if(openfile.timestampfolder==null)
			{	openfile openfile1=new openfile();
			openfile1.createfolder();
			}
				
			Debug.message("Writting log file to result folder");
			Calendar calendar = new GregorianCalendar();
			Date date = calendar.getTime();

			BufferedWriter writer = new BufferedWriter(new FileWriter(
					openfile.timestampfolder + "/" + testScriptName + ".txt"));

			writer.write("Result log here");
			writer.write("Execution started at: " + date + "\r\n\n");
			writer.close();
		} catch (Exception ex) {
			Debug.message("Exception while writting to log file - "
					+ ex.getMessage());
		}
	}

	public void writePass(String action, String Description) throws IOException {

		if(openfile.timestampfolder==null)
		{	openfile openfile1=new openfile();
		openfile1.createfolder();
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				openfile.timestampfolder + "/" + testScriptName + ".txt", true));
		writer.write(action + "=========" + Description + "======" + "PASS"
				+ "\r\n");
		writer.close();
	}

	public void writeFail(String action, String Description) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(
				openfile.timestampfolder + "/" + testScriptName + ".txt", true));
		writer.write(action + "=========" + Description + "======" + "FAIL "
				+ "\r\n");
		writer.close();
	}

	public static void createSummaryFile() {
		try {
			Calendar calendar = new GregorianCalendar();
			Date date = calendar.getTime();

			BufferedWriter writer = new BufferedWriter(new FileWriter(
					openfile.timestampfolder + "/summary" + ".txt", true));
			// writer.write("Result Summary here");
			writer.write("Execution started at: " + date + "\r\n");
			writer.flush();
			writer.close();

		} catch (Exception ex) {
			Debug.message("Exception while writting to log file - "
					+ ex.getMessage());
		}
	}

	public static void writeSummaryPass(String scriptName) throws IOException {
		Debug.message("WritingSummary for [" + scriptName + "]");
		// FileWriter
		// FileOutputStream writer = new FileOutputStream("./Results/Summary/" +
		// "summary" + ".txt", true);

		BufferedWriter writer = new BufferedWriter(new FileWriter(
				openfile.timestampfolder + "/summary" + ".txt", true));

		writer.write(scriptName + "===============TestScript"
				+ "===============" + "PASS " + "\r\n");
		writer.flush();
		writer.close();

	}

	public void writeSummaryFail(String scriptName) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(
				openfile.timestampfolder + "/summary" + ".txt", true));
		writer.write(scriptName + "===============TestScript"
				+ "===============" + "FAIL " + "\r\n");
		writer.flush();
		writer.close();
	}

	public boolean typeIntoTextBox(String locator, String value)
			throws IOException {
		// verify if the button is present on the application
		if (!configuration.selenium.isElementPresent(locator)) {
			Debug.message("Locator of the current element ==>> " + locator);
			Debug.message("Value of the current element ==>> " + value);
			writeFail("Verify", "Text Box " + locator + " is Present or not"
					+ "\r\n");
			return false;
		}

		if (!configuration.selenium.isEditable(locator)) {
			writeFail("Verify", "Text Box " + locator + " is editable or not"
					+ "\r\n");
			return false;
		}
		// type value into the edit box
		configuration.selenium.type(locator, value);
		writePass("Type", "Typed " + value + " into " + locator + " TextBox "
				+ "\r\n");
		return true;
	}

	public boolean typeIntoTextBoxWithName(String locator, String name)
			throws IOException {
		// verify if the button is present on the application
		if (!configuration.selenium.isElementPresent(locator)) {
			Debug.message("Locator of the current element ==>> " + locator);
			Debug.message("Value of the current element ==>> " + name);
			writeFail("Verify", "Text Box " + locator + " is Present or not"
					+ "\r\n");
			return false;
		}

		if (!configuration.selenium.isEditable(locator)) {
			writeFail("Verify", "Text Box " + locator + " is editable or not"
					+ "\r\n");
			return false;
		}
		// type value into the edit box
		configuration.selenium.type(locator, name);
		writePass("Type", "Typed " + name + " into " + locator + " TextBox "
				+ "\r\n");
		return true;
	}

	public boolean typeIntoTextBoxWithId(String locator, String id)
			throws IOException {
		// verify if the button is present on the application
		if (!configuration.selenium.isElementPresent(locator)) {
			Debug.message("Locator of the current element ==>> " + locator);
			Debug.message("Value of the current element ==>> " + id);
			writeFail("Verify", "Text Box " + locator + " is Present or not"
					+ "\r\n");
			return false;
		}

		if (!configuration.selenium.isEditable(locator)) {
			writeFail("Verify", "Text Box " + locator + " is editable or not"
					+ "\r\n");
			return false;
		}
		// type value into the edit box
		configuration.selenium.type(locator, id);
		writePass("Type", "Typed " + id + " into " + locator + " TextBox "
				+ "\r\n");
		return true;
	}

	public boolean clickButtonWithType(String locator) throws IOException {
		// verify if the button is present on the application
		if (!configuration.selenium.isElementPresent("xpath=//input[@type='"
				+ locator + "']")) {
			writeFail("Verify", "Button " + locator + " is Present or not "
					+ "\r\n");
			return false;
		}
		// click on the button
		configuration.selenium.click("xpath=//input[@type='" + locator + "']");
		writePass("Click", "Clicked " + locator + " Button" + "\r\n");
		return true;
	}

	public boolean clickButtonWithValue(String value) throws IOException {
		// verify if the button is present on the application
		Debug.message("Value of the current button == >> " + value);
		if (!configuration.selenium.isElementPresent("xpath=//input[@value='"
				+ value + "']")) {
			writeFail("Verify", "Button " + value + " is Present or not"
					+ "\r\n");
			return false;
		}
		// click on the button
		configuration.selenium.click("xpath=//input[@value='" + value + "']");
		writePass("Click", "Clicked " + value + " Button" + "\r\n");
		return true;
	}
	
	public boolean clickButtonWithName(String name) throws IOException {
		// verify if the button is present on the application
		Debug.message("Value of the current button == >> " + name);
		if (!configuration.selenium.isElementPresent("xpath=//input[@value='"
				+ name + "']")) {
			writeFail("Verify", "Button " + name + " is Present or not"
					+ "\r\n");
			return false;
		}
		// click on the button
		configuration.selenium.click("xpath=//input[@value='" + name + "']");
		writePass("Click", "Clicked " + name + " Button" + "\r\n");
		return true;
	}
	public boolean clickButtonWithid(String id) throws IOException {
		// verify if the button is present on the application
		Debug.message("Value of the current button == >> " + id);
		if (!configuration.selenium.isElementPresent("xpath=//input[@id='" + id
				+ "']")) {
			writeFail("Verify", "Button " + id + " is Present or not" + "\r\n");
			return false;
		}
		// click on the button
		configuration.selenium.click("xpath=//input[@id='" + id + "']");
		writePass("Click", "Clicked " + id + " Button" + "\r\n");
		return true;
	}

	public boolean clickImageWithAlt(String altName) throws IOException {
		// verify if the button is present on the application
		if (!configuration.selenium.isElementPresent("xpath=//img[@alt='"
				+ altName + "']")) {
			writeFail("Verify", "Click " + altName + " on Image" + "\r\n");
			return false;
		}
		configuration.selenium.click("xpath=//img[@alt='" + altName + "']");
		writePass("Checked", "Clicked " + altName + " on Image" + "\r\n");
		return true;
	}

	public boolean clickOnLink(String linkName) throws IOException {
		// verify if the link is present on the application
		if (!configuration.selenium.isElementPresent("link=" + linkName)) {
			writeFail("Verify", "Click" + linkName + "on Link" + "\r\n");
			return false;
		}
		configuration.selenium.click("link=" + linkName);
		writePass("Checked", "Clicked " + linkName + " on Link" + "\r\n");
		return true;
	}

	public boolean clickOnCustomLink(String linkName) throws IOException {
		// verify if the link is present on the application
		if (!configuration.selenium.isElementPresent("link=" + "*" + linkName
				+ "*")) {
			writeFail("Verify", "Click on Link" + "\r\n");
			return false;
		}
		configuration.selenium.click("link=" + "*" + linkName + "*");
		writePass("Checked", "Clicked on Link" + "\r\n");
		return true;
	}

	/*
	 * public boolean checkBox( String id) throws IOException { if
	 * (!configuration.selenium.isElementPresent(id)) { writeFail("Verify",
	 * "Check Box is Present or not"); return false; }
	 * 
	 * configuration.selenium.click("xpath=//input[@type='" + "checkbox" + "'" +
	 * " and @id='" + id + "']"); // configuration.selenium.click(locator);
	 * writePass("Checked", "Clicked on check box!!!"); return true; }
	 */
	public boolean checkBox(String name) throws IOException {
		if (!configuration.selenium.isElementPresent(name)) {
			writeFail("Verify", "Check Box is Present or not");
			return false;
		}

		configuration.selenium.click("xpath=//input[@type='" + "checkbox" + "'"
				+ " and @name='" + name + "']");
		// configuration.selenium.click(locator);
		writePass("Checked", "Clicked on check box!!!");
		return true;
	}

	public boolean radioButtonWithValue(String locator, String value)
			throws IOException {
		if (!configuration.selenium.isElementPresent("xpath=//input[@type='"
				+ locator + "'" + " and @value='" + value + "']")) {
			writeFail("Verify", "Radio Button is Present or not");
			return false;
		}

		configuration.selenium.click("xpath=//input[@type='" + locator + "'"
				+ " and @value='" + value + "']");
		// selenium.click(value);
		// selenium.check(value);
		writePass("Checked", "Clicked on Radio Button !!!");
		return true;
	}

	public boolean radioButtonWithId(String locator, String id)
			throws IOException {
		if (!configuration.selenium.isElementPresent("xpath=//input[@type='"
				+ locator + "'" + " and @value='" + id + "']")) {
			writeFail("Verify", "Radio Button is Present or not");
			return false;
		}

		configuration.selenium.click("xpath=//input[@type='" + locator + "'"
				+ " and @value='" + id + "']");
		// selenium.click(value);
		// selenium.check(value);
		writePass("Checked", "Clicked on Radio Button !!!");
		return true;
	}

	public boolean dropDownItem(String selecLocator, String optionLocator)
			throws IOException {
		// verify if the button is present on the application
		if (!configuration.selenium.isElementPresent("xpath=//select[@name='"
				+ selecLocator + "']")) {
			writeFail("Verify", "Click " + selecLocator + " on Link" + "\r\n");
			return false;
		}
		configuration.selenium.select(selecLocator, optionLocator);
		writePass("Checked", "Clicked " + selecLocator + " on drop down"
				+ "\r\n");
		return true;
	}

	public boolean dropDownItemWithId(String selecLocator, String optionLocator)
			throws IOException {
		// verify if the button is present on the application
		if (!configuration.selenium.isElementPresent("xpath=//select[@id='"
				+ selecLocator + "']")) {
			writeFail("Verify", "Click " + selecLocator + " on Link" + "\r\n");
			return false;
		}
		configuration.selenium.select(selecLocator, optionLocator);
		writePass("Checked", "Clicked " + selecLocator + " on drop down"
				+ "\r\n");
		return true;
	}

	public boolean typeIntoTextArea(String locator, String value)
			throws IOException {
		if (!configuration.selenium.isElementPresent("xpath=//textarea[@name='"
				+ locator + "']")) {
			writeFail("Verify", "text area " + locator + " is Present or not "
					+ "\r\n");
			return false;
		}

		configuration.selenium.type(
				"xpath=//textarea[@name='" + locator + "']", value);
		writePass("TextArea", "Entered the text area with value " + value + ".");
		return true;

	}

	public boolean typeIntoTextAreaWithName(String locator, String name)
			throws IOException {
		if (!configuration.selenium.isElementPresent("xpath=//textarea[@name='"
				+ locator + "']")) {
			writeFail("Verify", "text area " + locator + " is Present or not "
					+ "\r\n");
			return false;
		}

		configuration.selenium.type(
				"xpath=//textarea[@name='" + locator + "']", name);
		writePass("TextArea", "Entered the text area with value " + name + ".");
		return true;

	}

	public boolean typeIntoTextFile(String locator, String id)
			throws IOException {
		if (!configuration.selenium.isElementPresent("xpath=//file[@id='"
				+ locator + "']")) {
			writeFail("Verify", "File " + locator + " is Present or not "
					+ "\r\n");
			return false;
		}

		configuration.selenium.type("xpath=//file[@id='" + locator + "']", id);
		writePass("TextArea", "Entered the text area with value " + id + ".");
		return true;

	}

	public boolean clickImageWithTitle(String titleName) throws IOException {
		// verify if the button is present on the application
		if (!configuration.selenium.isElementPresent(titleName)) {
			writeFail("Verify", "Click " + titleName + " on Image using title"
					+ "\r\n");
			return false;
		}
		configuration.selenium.click(titleName);
		writePass("Checked", "Clicked " + titleName + " on Image using title"
				+ "\r\n");
		return true;
	}

	public boolean selectFrame(String value) throws IOException {
		// verify if the button is present on the application
		Debug.message("Value of the current button == >> " + value);
		if (!configuration.selenium.isElementPresent("xpath=//input[@value='"
				+ value + "']")) {
			writeFail("Verify", "Button " + value + " is Present or not"
					+ "\r\n");
			return false;
		}
		// click on the button
		configuration.selenium.click("xpath=//input[@value='" + value + "']");
		writePass("Click", "Clicked " + value + " Button" + "\r\n");
		return true;
	}

	public boolean checkBoxCustom(String id) throws IOException {
		// verify if the button is present on the application
		Debug.message("id of the current check box == >> " + id);
		if (!configuration.selenium
				.isElementPresent("xpath=//id(/'studyListTbl/')///tbody///tr[2]///td[6]///following-sibling::td[2]")) {
			writeFail("Verify", "check box " + id + " is Present or not"
					+ "\r\n");
			return false;
		}
		// click on the button
		configuration.selenium
				.isElementPresent("xpath=//id('studyListTbl')/tbody/tr[2]/td[6]///following-sibling::td[2]");
		// configuration.selenium.isElementPresent("xpath=//input[@id="//id('studyListTbl')//tbody//tr[2]//td[8]");
		writePass("Click", "checked " + id + " Button" + "\r\n");
		return true;
	}
	// id('studyListTbl')/tbody/tr[2]/td[8]

}
