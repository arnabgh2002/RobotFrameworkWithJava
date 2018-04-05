/**
 * 
 */
package Pages;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ScriptException;
import com.github.markusbernhardt.selenium2library.Selenium2Library;
import com.github.markusbernhardt.selenium2library.keywords.BrowserManagement;
import com.github.markusbernhardt.selenium2library.keywords.Element;
import com.github.markusbernhardt.selenium2library.locators.ElementFinder;
import com.sun.tools.javac.util.List;

import Utils.CustomLibForWebElements;
import Utils.FrameWorkConstants;
import Utils.lib;

/**
 * @author Arnab
 *
 */
public class Leads {


	private String firstNameTextBox=FrameWorkConstants.XPATH+"~"+"//label[text()='First Name']/following::input[1]";
	private String firstNameSalutation=FrameWorkConstants.XPATH+"~"+"//label[text()='First Name']/following::select[1]";
	private String lastName=FrameWorkConstants.XPATH+"~"+"//label[text()='Last Name']/following::input[1]";
	private String phone=FrameWorkConstants.XPATH+"~"+"//label[text()='Phone']/following::input[1]";
	private String email=FrameWorkConstants.XPATH+"~"+"//label[text()='Email']/following::input[1]";
	private String company=FrameWorkConstants.XPATH+"~"+"//label[text()='Company']/following::input[1]";
	private String leadSource=FrameWorkConstants.XPATH+"~"+"//label[text()='Lead Source']/following::select[1]";
	private String street=FrameWorkConstants.XPATH+"~"+"//label[text()='Street']/following::textarea[1]";
	private String city=FrameWorkConstants.XPATH+"~"+"//label[text()='City']/following::input[1]";
	private String stateProvince=FrameWorkConstants.XPATH+"~"+"//label[text()='State/Province']/following::input[1]";
	private String zipPostalCode=FrameWorkConstants.XPATH+"~"+"//label[text()='Zip/Postal Code']/following::input[1]";
	private String country=FrameWorkConstants.XPATH+"~"+"//label[text()='Country']/following::input[1]";
	private String leadStatus=FrameWorkConstants.XPATH+"~"+"//label[text()='Lead Status']/following::select[1]";
	
	//Convert Lead WebElements
	private String accountName=FrameWorkConstants.XPATH+"~"+"//select[@title='Account Name']";
	private String doNotCreateOpportunity=FrameWorkConstants.ID+"~"+"nooppti";
	
	//buttons
	private String saveButton=FrameWorkConstants.XPATH+"~"+"(//input[@title='Save'])[1]";
	private String saveAndNewButton=FrameWorkConstants.XPATH+"~"+"(//input[@title='Save & New'])[1]";
	private String cancel=FrameWorkConstants.XPATH+"~"+"(//input[@title='Cancel'])[1]";
	
	//Convert button on the Leads page
	private String convertButton=FrameWorkConstants.NAME+"~"+"convert";
	
	//convert button once you are in the lead conversion page
	private String convert=FrameWorkConstants.XPATH+"~"+"(//input[@value='Convert' and @name='save'])[1]";
	
	//Lightning Components 
	private String firstNameTextBoxLT=FrameWorkConstants.XPATH+"~"+"//span[text()='First Name']/following::input[1]";
	private String firstNameSalutationLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Salutation']/following::a[1]";
	private String lastNameLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Last Name']/following::input[1]";
	private String phoneLT=FrameWorkConstants.XPATH+"~"+"(//span[text()='Phone']/following::input[1])[2]";
	private String emailLT=FrameWorkConstants.XPATH+"~"+"(//span[text()='Email']/following::input[1])[2]";
	private String companyLT=FrameWorkConstants.XPATH+"~"+"(//span[text()='Company']/following::input[1])[2]";
	private String leadSourceLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Lead Source']/following::a[1]";
	private String streetLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Street']/following::textarea[1]";
	private String cityLT=FrameWorkConstants.XPATH+"~"+"//span[text()='City']/following::input[1]";
	private String stateProvinceLT=FrameWorkConstants.XPATH+"~"+"//span[text()='State/Province']/following::input[1]";
	private String zipPostalCodeLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Zip/Postal Code']/following::input[1]";
	private String countryLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Country']/following::input[1]";
	private String leadStatusLT=FrameWorkConstants.XPATH+"~"+"(//span[text()='Lead Status']/following::a[1])[2]";
	
	private String saveButtonLT=FrameWorkConstants.XPATH+"~"+"//*[@title='Save']";  // xpath (//span[text()='Save'])[2]
	
	public String createLead(){
		String leadFullName="";
		
		HashMap<String,String> hm;
		String FileLoc="C:\\Workspace\\com.myproject.TesRobotPOC\\ExcelFiles\\SFDC_Data_File.xlsx";
		String ExcelReadQuery="Select * from Leads where TestName='createLead'";
		
//		String sqlQuery1="insert into robot_poc.LeadsTable(LeadFullName,LeadFirstName,LeadLastName)"
//		  		+ "values (?,?,?);";
		
		try{
			//Reading Test Data from Excel
			hm=lib.GetDataFromExcel(FileLoc,ExcelReadQuery);
			
			if(FrameWorkConstants.sfdcView.equals("Lightning")){
				Thread.sleep(2000);
				leadFullName=createLeadInLightningView(hm);
			}else if(FrameWorkConstants.sfdcView.equals("Classic")){
				Thread.sleep(2000);
				leadFullName=createLeadInClassicView(hm);
			}else{
				System.out.println("Cannot Create Lead as the SFDC View Selection is Invalid. Valid View are Lightning or Classic");
			}
			System.out.println("Created Lead Name :-"+leadFullName);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return leadFullName;
	}
	
	public String createLeadInClassicView(HashMap<String,String> hm){
		String leadFullName="";
		
		try{

			String fName=hm.get("First Name"+FrameWorkConstants.i);
			String lName=hm.get("Last Name"+FrameWorkConstants.i)+lib.random();
			leadFullName=fName+" "+lName;
			if(hm.get("First Name"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(firstNameTextBox, fName);
			}
			
			if(hm.get("Last Name"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(lastName, lName);
			}
			
			if(hm.get("Phone"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(phone, hm.get("Phone"+FrameWorkConstants.i));
			}
			
			if(hm.get("Email"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(email, hm.get("Email"+FrameWorkConstants.i));
			}
			
			if(hm.get("Lead Source"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.selectDropdownValueByVisibleText(leadSource, hm.get("Lead Source"+FrameWorkConstants.i));
			}
			
			if(hm.get("Street"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(street, hm.get("Street"+FrameWorkConstants.i));
				
			}
			
			if(hm.get("City"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(city, hm.get("City"+FrameWorkConstants.i));
				
			}
			
			if(hm.get("State/Province"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(stateProvince, hm.get("State/Province"+FrameWorkConstants.i));
				
			}
			
			if(hm.get("Zip/Postal Code"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(zipPostalCode, hm.get("Zip/Postal Code"+FrameWorkConstants.i));
				
			}
			
			if(hm.get("Country"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(country, hm.get("Country"+FrameWorkConstants.i));
			}
			
			if(hm.get("Lead Status"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.selectDropdownValueByVisibleText(leadStatus, hm.get("Lead Status"+FrameWorkConstants.i));
			}
			
			if(hm.get("Company"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.setText(company, hm.get("Company"+FrameWorkConstants.i));
			}
			
			FrameWorkConstants.extdSel2Lib.click(saveButton);
			
//			PreparedStatement statement = FrameWorkConstants.mysqlConnect.connect().prepareStatement(sqlQuery1);
//			  
//			statement.setString(1, leadFullName);
//			statement.setString(2, fName);
//			statement.setString(3, lName);
//		    // execute the preparedstatement
//			statement.execute();
//			System.out.println("Inserted Newly Created Laed record in DB");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return leadFullName;
	}
	
	public String createLeadInLightningView(HashMap<String,String> hm){
		String leadFullName="";
		
		try{

			String fName=hm.get("First Name"+FrameWorkConstants.i);
			String lName=hm.get("Last Name"+FrameWorkConstants.i)+lib.random();
			leadFullName=fName+" "+lName;
			if(hm.get("First Name"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(firstNameTextBoxLT, fName);
			}
			
			if(hm.get("Last Name"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(lastNameLT, lName);
			}
			
			if(hm.get("Phone"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(phoneLT, hm.get("Phone"+FrameWorkConstants.i));
			}
			
			if(hm.get("Email"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(emailLT, hm.get("Email"+FrameWorkConstants.i));
			}
			
			if(hm.get("Lead Source"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.selectingPickListValue(leadSourceLT, hm.get("Lead Source"+FrameWorkConstants.i));
			}
			
			if(hm.get("Street"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(streetLT, hm.get("Street"+FrameWorkConstants.i));
				
			}
			
			if(hm.get("City"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(cityLT, hm.get("City"+FrameWorkConstants.i));
				
			}
			
			if(hm.get("State/Province"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(stateProvinceLT, hm.get("State/Province"+FrameWorkConstants.i));
				
			}
			
			if(hm.get("Zip/Postal Code"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(zipPostalCodeLT, hm.get("Zip/Postal Code"+FrameWorkConstants.i));
				
			}
			
			if(hm.get("Country"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.setText(countryLT, hm.get("Country"+FrameWorkConstants.i));
			}
			
			if(hm.get("Lead Status"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.selectingPickListValue(leadStatusLT, hm.get("Lead Status"+FrameWorkConstants.i));
			}
			
			if(hm.get("Company"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.setText(companyLT, hm.get("Company"+FrameWorkConstants.i));
			}
			
			FrameWorkConstants.extdSel2Lib.click(saveButtonLT);
			

			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return leadFullName;
	}
	
	public boolean convertLead(){
		boolean result=false;
		HashMap<String,String> hm;
		String FileLoc="C:\\Workspace\\com.myproject.TesRobotPOC\\ExcelFiles\\SFDC_Data_File.xlsx";
		String ExcelReadQuery="Select * from Leads where TestName='convertLead'";
		
		String sqlQuery="UPDATE robot_poc.LeadsTable SET Converted='Yes' "
				+ "WHERE LeadFullName in(?);";
		
		try{
			//Reading Excel For Test Data
			hm=lib.GetDataFromExcel(FileLoc,ExcelReadQuery);
			
			FrameWorkConstants.extdSel2Lib.click(convertButton);
			
			Thread.sleep(3000);
			FrameWorkConstants.extdSel2Lib.selectDropdownValueByVisibleText(accountName, hm.get("AccountName"+FrameWorkConstants.i));
			if(hm.get("doNotCreateOpportunity"+FrameWorkConstants.i).equalsIgnoreCase("Yes")){
				FrameWorkConstants.extdSel2Lib.click(doNotCreateOpportunity);
			}
			
			Thread.sleep(3000);
			FrameWorkConstants.extdSel2Lib.click(convert);
			
//			PreparedStatement statement = FrameWorkConstants.mysqlConnect.connect().prepareStatement(sqlQuery);
//			  
//			statement.setString(1, leadFullName);
//			statement.setString(2, fName);
//			statement.setString(3, lName);
//		    // execute the preparedstatement
//			statement.execute();
			
			result=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
