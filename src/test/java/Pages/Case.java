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
 *
 */
public class Case {

	private String newButton=FrameWorkConstants.NAME+"~"+"new";
	private String contactName=FrameWorkConstants.XPATH+"~"+"//label[text()='Contact Name']/following::input[@id='cas3']";
	private String accountName=FrameWorkConstants.XPATH+"~"+"//label[text()='Account Name']/following::input[@id='cas4']";
	private String statusPickList=FrameWorkConstants.XPATH+"~"+"//label[text()='Status']/following::select[1]";
	private String priorityPickList=FrameWorkConstants.XPATH+"~"+"//label[text()='Priority']/following::select[1]";
	private String caseOriginPickList=FrameWorkConstants.XPATH+"~"+"//label[text()='Case Origin']/following::select[1]";
	
	private String DetailsTab=FrameWorkConstants.XPATH+"~"+"//span[@class='optionLabel' and text()='Details']";
	//reading fields from Case Layout
	private String caseNumber=FrameWorkConstants.XPATH+"~"+"//td[text()='Case Number']/following::div[1]";
	
	private String saveButton=FrameWorkConstants.XPATH+"~"+"(//input[@title='Save'])[1]";
	private String saveAndNewButton=FrameWorkConstants.XPATH+"~"+"(//input[@title='Save & New'])[1]";
	private String cancel=FrameWorkConstants.XPATH+"~"+"(//input[@title='Cancel'])[1]";
	
	
	public String createCaseFromCaseTab(String ContactOrAccountName,String recordType){
		String caseNumberSFDC="";
		HashMap<String,String> hm;
		String FileLoc="C:\\Workspace\\com.myproject.TesRobotPOC\\ExcelFiles\\SFDC_Data_File.xlsx";
		String ExcelReadQuery="Select * from Cases where TestName='createCaseFromCaseTab'";
		try{
			
			hm=lib.GetDataFromExcel(FileLoc,ExcelReadQuery);
			
			
//			//clicking new button in Case Tab.
//			FrameWorkConstants.extdSel2Lib.click(newButton);
			Thread.sleep(3000);
			
			//entering Status field
			if(hm.get("Status"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.selectDropdownValueByVisibleText(statusPickList, hm.get("Status"+FrameWorkConstants.i));
				System.out.println("Case Status value entered. Status='"+hm.get("Status"+FrameWorkConstants.i)+"'");
			}
			
			if(recordType.equalsIgnoreCase("Contact")){
				FrameWorkConstants.extdSel2Lib.setText(contactName, ContactOrAccountName);
				System.out.println("Case will be associated with '"+ContactOrAccountName+"' Contact Record");
				Thread.sleep(3000);
			}else if(recordType.equalsIgnoreCase("Account")){
				FrameWorkConstants.extdSel2Lib.setText(accountName, ContactOrAccountName);
				System.out.println("Case will be associated with '"+ContactOrAccountName+"' Account Record");
				Thread.sleep(3000);
			}else{
				System.out.println("Not a Valid Record Type. Hence cannot associate case with any contact or Account");
			}
			
			if(hm.get("Case Origin"+FrameWorkConstants.i).isEmpty()){
				//do nothing
			}else{
				FrameWorkConstants.extdSel2Lib.selectDropdownValueByVisibleText(caseOriginPickList, hm.get("Case Origin"+FrameWorkConstants.i));
				System.out.println("Case Origin value entered. Case Origin='"+hm.get("Case Origin"+FrameWorkConstants.i)+"'");
			}
			
			FrameWorkConstants.extdSel2Lib.click(saveButton);
			Thread.sleep(2000);
			//changing to Details Tab
			FrameWorkConstants.extdSel2Lib.click(DetailsTab);
			caseNumberSFDC=FrameWorkConstants.extdSel2Lib.getText(caseNumber);
			System.out.println("Case Created in SFDC. Case Number='"+caseNumberSFDC+"'");
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return caseNumberSFDC;
	}
	
	public String createCaseFromContactRecord(){
		String caseNumberSFDC="";
		
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return caseNumberSFDC;
	}
}
