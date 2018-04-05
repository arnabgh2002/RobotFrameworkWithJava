/**
 * 
 */
package Pages;

import java.util.HashMap;

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
 * Description :- SFDC Home Page
 */

public class Contact {

	//Classic View Components 
	private String firstNameTextBox=FrameWorkConstants.XPATH+"~"+"//label[text()='First Name']/following::input[1]";
	private String firstNameSalutation=FrameWorkConstants.XPATH+"~"+"//label[text()='First Name']/following::select[1]";
	private String lastName=FrameWorkConstants.XPATH+"~"+"//label[text()='Last Name']/following::input[1]";
	private String phone=FrameWorkConstants.XPATH+"~"+"//label[text()='Phone']/following::input[1]";
	private String email=FrameWorkConstants.XPATH+"~"+"//label[text()='Email']/following::input[1]";
	private String leadSource=FrameWorkConstants.XPATH+"~"+"//label[text()='Lead Source']/following::select[1]";
	private String mailingStreet=FrameWorkConstants.XPATH+"~"+"//label[text()='Mailing Street']/following::textarea[1]";
	private String mailingCity=FrameWorkConstants.XPATH+"~"+"//label[text()='Mailing City']/following::input[1]";
	private String mailingStateProvince=FrameWorkConstants.XPATH+"~"+"//label[text()='Mailing State/Province']/following::input[1]";
	private String mailingZipPostalCode=FrameWorkConstants.XPATH+"~"+"//label[text()='Mailing Zip/Postal Code']/following::input[1]";
	private String mailingCountry=FrameWorkConstants.XPATH+"~"+"//label[text()='Mailing Country']/following::input[1]";
	
	private String saveButton=FrameWorkConstants.XPATH+"~"+"(//input[@title='Save'])[1]";
	private String saveAndNewButton=FrameWorkConstants.XPATH+"~"+"(//input[@title='Save & New'])[1]";
	private String cancel=FrameWorkConstants.XPATH+"~"+"(//input[@title='Cancel'])[1]";
	
	private String editButton=FrameWorkConstants.XPATH+"~"+"(//input[@name='edit'])[1]";
	
	//Lightning Components
	private String firstNameTextBoxLT=FrameWorkConstants.XPATH+"~"+"//span[text()='First Name']/following::input[1]";
	private String firstNameSalutationLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Salutation']/following::a[1]";
	private String lastNameLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Last Name']/following::input[1]";
	private String phoneLT=FrameWorkConstants.XPATH+"~"+"(//span[text()='Phone']/following::input[1])[2]";
	private String emailLT=FrameWorkConstants.XPATH+"~"+"(//span[text()='Email']/following::input[1])[2]";
	private String leadSourceLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Lead Source']/following::a[1]";
	private String mailingStreetLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Mailing Street']/following::textarea[1]";
	private String mailingCityLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Mailing City']/following::input[1]";
	private String mailingStateProvinceLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Mailing State/Province']/following::input[1]";
	private String mailingZipPostalCodeLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Mailing Zip/Postal Code']/following::input[1]";
	private String mailingCountryLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Mailing Country']/following::input[1]";
	
	private String saveButtonLT=FrameWorkConstants.XPATH+"~"+"//*[@title='Save']"; //(//span[text()='Save'])[2]
	private String editButtonLT=FrameWorkConstants.XPATH+"~"+"//div[@title='Edit']";
	
	public String createContact(){
		String createdContact="";
		HashMap<String,String> hm;
		String FileLoc="C:\\Workspace\\com.myproject.TesRobotPOC\\ExcelFiles\\SFDC_Data_File.xlsx";
		String Query="Select * from Contact where TestName='createContact'";
				
		try{
			//Reading Test Data from Excel
			hm=lib.GetDataFromExcel(FileLoc,Query);			
			if(FrameWorkConstants.sfdcView.equals("Lightning")){				
				Thread.sleep(2000);
				createdContact=createContactInLightningView(hm);				
			}else if(FrameWorkConstants.sfdcView.equals("Classic")){
				Thread.sleep(2000);
				createdContact=createContactInClassicView(hm);
			}else{
				System.out.println("Cannot Create Contact as the SFDC View Selection is Invalid. Valid View are Lightning or Classic");
			}
			
			System.out.println("Created Contact Name :-"+createdContact);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return createdContact;
	}
	
	public String createContactInClassicView(HashMap<String,String> hm){
		String createdContact="";
		try{
			//entering data
			String contactFirstName=hm.get("First Name"+FrameWorkConstants.i);
			String contactLastName=hm.get("Last Name"+FrameWorkConstants.i)+lib.random();
			createdContact=contactFirstName+" "+contactLastName;
			Thread.sleep(2000);
			if(contactFirstName.isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.setText(firstNameTextBox, contactFirstName);
				System.out.println("Entered First Name='"+contactFirstName+"'");
			}
			
			FrameWorkConstants.extdSel2Lib.setText(lastName, contactLastName);
			System.out.println("Last Name='"+contactLastName+"'");
			if(hm.get("Phone"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.setText(phone, hm.get("Phone"+FrameWorkConstants.i));
				System.out.println("Phone='"+hm.get("Phone"+FrameWorkConstants.i)+"'");
			}
			
			if(hm.get("Email"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.setText(email, hm.get("Email"+FrameWorkConstants.i));
				System.out.println("Email='"+hm.get("Email"+FrameWorkConstants.i)+"'");
			}
			
			if(hm.get("Lead Source"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.selectDropdownValueByVisibleText(leadSource, hm.get("Lead Source"+FrameWorkConstants.i));
				System.out.println("Lead Source='"+hm.get("Lead Source"+FrameWorkConstants.i)+"'");
			}
			
			
			FrameWorkConstants.extdSel2Lib.setText(mailingStreet, hm.get("Mailing Street"+FrameWorkConstants.i));
			FrameWorkConstants.extdSel2Lib.setText(mailingCity, hm.get("Mailing City"+FrameWorkConstants.i));
			FrameWorkConstants.extdSel2Lib.setText(mailingStateProvince, hm.get("Mailing State/Province"+FrameWorkConstants.i));
			FrameWorkConstants.extdSel2Lib.setText(mailingZipPostalCode, hm.get("Mailing Zip/Postal Code"+FrameWorkConstants.i));
			FrameWorkConstants.extdSel2Lib.setText(mailingCountry, hm.get("Mailing Country"+FrameWorkConstants.i));
			
			FrameWorkConstants.extdSel2Lib.click(saveButton);
			System.out.println("Contact is created");
		}catch(Exception e){
			e.printStackTrace();
		}
		return createdContact;
	}
	
	public String createContactInLightningView(HashMap<String,String> hm){
		
		String createdContact="";
		
		try{
			//entering data
			String contactFirstName=hm.get("First Name"+FrameWorkConstants.i);
			String contactLastName=hm.get("Last Name"+FrameWorkConstants.i)+lib.random();
			createdContact=contactFirstName+" "+contactLastName;
			Thread.sleep(2000);
			if(contactFirstName.isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.setText(firstNameTextBoxLT, contactFirstName);
				System.out.println("Entered First Name='"+contactFirstName+"'");
			}
			
			if(hm.get("Salutation"+FrameWorkConstants.i).isEmpty()){
				//do nothing as there is no Data in Test Data Excel
			}else{
				FrameWorkConstants.extdSel2Lib.selectingPickListValue(firstNameSalutationLT, hm.get("'Salutation'"+FrameWorkConstants.i));
				System.out.println("Salutation="+hm.get("'Salutation'"+FrameWorkConstants.i));
			}
			
			FrameWorkConstants.extdSel2Lib.setText(lastNameLT, contactLastName);
			System.out.println("Last Name='"+contactLastName+"'");
			if(hm.get("Phone"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.setText(phoneLT, hm.get("Phone"+FrameWorkConstants.i));
				System.out.println("Phone='"+hm.get("Phone"+FrameWorkConstants.i)+"'");
			}
			
			if(hm.get("Email"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.setText(emailLT, hm.get("Email"+FrameWorkConstants.i));
				System.out.println("Email='"+hm.get("Email"+FrameWorkConstants.i)+"'");
			}
			
			if(hm.get("Lead Source"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.selectingPickListValue(leadSourceLT, hm.get("Lead Source"+FrameWorkConstants.i));
				System.out.println("Lead Source='"+hm.get("Lead Source"+FrameWorkConstants.i)+"'");
			}
			
			
			FrameWorkConstants.extdSel2Lib.setText(mailingStreetLT, hm.get("Mailing Street"+FrameWorkConstants.i));
			FrameWorkConstants.extdSel2Lib.setText(mailingCityLT, hm.get("Mailing City"+FrameWorkConstants.i));
			FrameWorkConstants.extdSel2Lib.setText(mailingStateProvinceLT, hm.get("Mailing State/Province"+FrameWorkConstants.i));
			FrameWorkConstants.extdSel2Lib.setText(mailingZipPostalCodeLT, hm.get("Mailing Zip/Postal Code"+FrameWorkConstants.i));
			FrameWorkConstants.extdSel2Lib.setText(mailingCountryLT, hm.get("Mailing Country"+FrameWorkConstants.i));
			
			FrameWorkConstants.extdSel2Lib.click(saveButtonLT);
			System.out.println("Contact is created");
		}catch(Exception e){
			e.printStackTrace();
		}
		return createdContact;
	}
	
	public boolean editContact(){
		boolean result=false;
		HashMap<String,String> hm;
		String FileLoc="C:\\Workspace\\com.myproject.TesRobotPOC\\ExcelFiles\\SFDC_Data_File.xlsx";
		String Query="Select * from Contact where TestName='editContact'";
		try{
			hm=lib.GetDataFromExcel(FileLoc,Query);
						
			if(FrameWorkConstants.sfdcView.equals("Lightning")){
				Thread.sleep(2000);
				result=editContactInLightning(hm);
			}else if(FrameWorkConstants.sfdcView.equals("Classic")){
				result=editContactInClassic(hm);
			}else{
				System.out.println("editContact() --> sfdcView is not valid");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	public boolean editContactInClassic(HashMap<String,String> hm){
		
		boolean result=false;
		try{
			FrameWorkConstants.extdSel2Lib.click(editButton);
			Thread.sleep(2000);
			
			if(hm.get("First Name"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(firstNameTextBox);
				FrameWorkConstants.extdSel2Lib.setText(firstNameTextBox, hm.get("First Name"+FrameWorkConstants.i));
			}
			
			if(hm.get("Last Name"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(lastName);
				FrameWorkConstants.extdSel2Lib.setText(lastName, hm.get("Last Name"+FrameWorkConstants.i));
			}
			
			if(hm.get("Phone"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(phone);
				FrameWorkConstants.extdSel2Lib.setText(phone, hm.get("Phone"+FrameWorkConstants.i));
			}
			
			if(hm.get("Email"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(email);
				FrameWorkConstants.extdSel2Lib.setText(email, hm.get("Email"+FrameWorkConstants.i));
				System.out.println("Email is updated. Email='"+hm.get("Email"+FrameWorkConstants.i)+"'");
			}
			
			if(hm.get("Lead Source"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				
				FrameWorkConstants.extdSel2Lib.selectDropdownValueByVisibleText(leadSource, hm.get("Lead Source"+FrameWorkConstants.i));
			}
			
			if(hm.get("Mailing Street"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(mailingStreet);
				FrameWorkConstants.extdSel2Lib.setText(mailingStreet, hm.get("Mailing Street"+FrameWorkConstants.i));
				
			}
			
			if(hm.get("Mailing City"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(mailingCity);
				FrameWorkConstants.extdSel2Lib.setText(mailingCity, hm.get("Mailing City"+FrameWorkConstants.i));
				
			}
			
			if(hm.get("Mailing State/Province"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(mailingStateProvince);
				FrameWorkConstants.extdSel2Lib.setText(mailingStateProvince, hm.get("Mailing State/Province"+FrameWorkConstants.i));
				
			}
			
			if(hm.get("Mailing Zip/Postal Code"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(mailingZipPostalCode);
				FrameWorkConstants.extdSel2Lib.setText(mailingZipPostalCode, hm.get("Mailing Zip/Postal Code"+FrameWorkConstants.i));
				
			}
			
			if(hm.get("Mailing Country"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(mailingCountry);
				FrameWorkConstants.extdSel2Lib.setText(mailingCountry, hm.get("Mailing Country"+FrameWorkConstants.i));
			}
			
			
			FrameWorkConstants.extdSel2Lib.click(saveButton);
			result=true;
			System.out.println("Contact Record Edited in Classic View");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean editContactInLightning(HashMap<String,String> hm){
		boolean result=false;
		
		try{
			
			FrameWorkConstants.extdSel2Lib.click(editButtonLT);
			//entering data			
			Thread.sleep(2000);
			
			if(hm.get("First Name"+FrameWorkConstants.i).isEmpty()){
				//do nothing as there is no data in excel
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(firstNameTextBoxLT);
				FrameWorkConstants.extdSel2Lib.setText(firstNameTextBoxLT, hm.get("First Name"+FrameWorkConstants.i));
				System.out.println("Edited First Name='"+hm.get("First Name"+FrameWorkConstants.i)+"'");
			}
			
			if(hm.get("Last Name"+FrameWorkConstants.i).isEmpty()){
				//do nothing as there is no data in excel
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(lastNameLT);
				FrameWorkConstants.extdSel2Lib.setText(lastNameLT, hm.get("Last Name"+FrameWorkConstants.i));
				System.out.println("Edited Last Name='"+hm.get("Last Name"+FrameWorkConstants.i)+"'");
			}
				
			
			if(hm.get("Salutation"+FrameWorkConstants.i).isEmpty()){
				//do nothing as there is no Data in Test Data Excel
			}else{
				FrameWorkConstants.extdSel2Lib.selectingPickListValue(firstNameSalutationLT, hm.get("'Salutation'"+FrameWorkConstants.i));
				System.out.println("Edited Salutation="+hm.get("'Salutation'"+FrameWorkConstants.i));
			}
			
			
			if(hm.get("Phone"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(phoneLT);
				FrameWorkConstants.extdSel2Lib.setText(phoneLT, hm.get("Phone"+FrameWorkConstants.i));
				System.out.println("Edited Phone='"+hm.get("Phone"+FrameWorkConstants.i)+"'");
			}
			
			if(hm.get("Email"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(emailLT);
				FrameWorkConstants.extdSel2Lib.setText(emailLT, hm.get("Email"+FrameWorkConstants.i));
				System.out.println("Edited Email='"+hm.get("Email"+FrameWorkConstants.i)+"'");
			}
			
			if(hm.get("Lead Source"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.selectingPickListValue(leadSourceLT, hm.get("Lead Source"+FrameWorkConstants.i));
				System.out.println("Edited Lead Source='"+hm.get("Lead Source"+FrameWorkConstants.i)+"'");
			}
			
			if(hm.get("Mailing Street"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(mailingStreetLT);
				FrameWorkConstants.extdSel2Lib.setText(mailingStreetLT, hm.get("Mailing Street"+FrameWorkConstants.i));
				System.out.println("Edited Mailing Street="+hm.get("Mailing Street"+FrameWorkConstants.i));
			}
			
			if(hm.get("Mailing City"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(mailingCityLT);
				FrameWorkConstants.extdSel2Lib.setText(mailingCityLT, hm.get("Mailing City"+FrameWorkConstants.i));
				System.out.println("Edited Mailing City ="+hm.get("Mailing City"+FrameWorkConstants.i));
			}
			
			if(hm.get("Mailing State/Province"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(mailingStateProvinceLT);
				FrameWorkConstants.extdSel2Lib.setText(mailingStateProvinceLT, hm.get("Mailing State/Province"+FrameWorkConstants.i));
				System.out.println("Edited Mailing State Provice ="+hm.get("Mailing State/Province"+FrameWorkConstants.i));
			}
			
			if(hm.get("Mailing Zip/Postal Code"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(mailingZipPostalCodeLT);
				FrameWorkConstants.extdSel2Lib.setText(mailingZipPostalCodeLT, hm.get("Mailing Zip/Postal Code"+FrameWorkConstants.i));
				System.out.println("Edited Mailing Zip Postal Code ="+hm.get("Mailing Zip/Postal Code"+FrameWorkConstants.i));
			}
			
			if(hm.get("Mailing Country"+FrameWorkConstants.i).isEmpty()){
				
			}else{
				FrameWorkConstants.extdSel2Lib.clearText(mailingCountryLT);
				FrameWorkConstants.extdSel2Lib.setText(mailingCountryLT, hm.get("Mailing Country"+FrameWorkConstants.i));
				System.out.println("Edited Mailing Country"+hm.get("Mailing Country"+FrameWorkConstants.i));
			}
			
			
			FrameWorkConstants.extdSel2Lib.click(saveButtonLT);
			System.out.println("Contact Record is Edited in Lightning View");
			result=true;
		}catch(Exception e){
			e.printStackTrace();
		}		
		return result;
	}
}
