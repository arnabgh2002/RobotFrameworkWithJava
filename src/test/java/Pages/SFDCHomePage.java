/**
 * 
 */
package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.ScriptException;
import com.github.markusbernhardt.selenium2library.Selenium2Library;
import com.github.markusbernhardt.selenium2library.keywords.BrowserManagement;
import com.github.markusbernhardt.selenium2library.keywords.Element;
import com.github.markusbernhardt.selenium2library.locators.ElementFinder;
import com.sun.tools.javac.util.List;

import Utils.CustomLibForWebElements;
import Utils.FrameWorkConstants;

/**
 * @author Arnab
 * Description :- SFDC Home Page
 */

public class SFDCHomePage {

	private String user=FrameWorkConstants.XPATH+"~"+"//*[@class='slds-dropdown-trigger slds-dropdown-trigger--click slds-m-left--x-small']"; // lightning
	private String userNavigationButton=FrameWorkConstants.ID+"~"+"userNavButton"; // Classic View
	
	//Classic View Components
	private String homeTab=FrameWorkConstants.XPATH+"~"+"//a[@title='Home Tab']";
	private String chatterTab=FrameWorkConstants.XPATH+"~"+"//a[@title='Chatter Tab']";
	private String campaignsTab=FrameWorkConstants.XPATH+"~"+"//a[@title='Campaigns Tab - Selected']";
	private String leadsTab=FrameWorkConstants.XPATH+"~"+"//a[@title='Leads Tab']";	
	private String accountsTab=FrameWorkConstants.XPATH+"~"+"//a[@title='Accounts Tab']";
	private String contactsTab=FrameWorkConstants.XPATH+"~"+"//a[@title='Contacts Tab']";
	private String opportunitiesTab=FrameWorkConstants.XPATH+"~"+"//a[@title='Opportunities Tab - Selected']";
	private String forecastsTab=FrameWorkConstants.XPATH+"~"+"//a[@title='Forecasts Tab - Selected']";
	private String contractsTab=FrameWorkConstants.XPATH+"~"+"//a[@title='Contracts Tab - Selected']";
	private String casesTab=FrameWorkConstants.XPATH+"~"+"//a[@title='Cases Tab']";
	
	//Global Search 
	private String searchTextBox=FrameWorkConstants.ID+"~"+"phSearchInput";
	private String searchButton=FrameWorkConstants.ID+"~"+"phSearchButton";
	private String searchAllButton=FrameWorkConstants.ID+"~"+"searchAll";
	
	private String newButton=FrameWorkConstants.XPATH+"~"+"//input[@title='New']";
	private String newButtonLT=FrameWorkConstants.XPATH+"~"+"//div[@title='New']";
	
	private String lightingAlertClose=FrameWorkConstants.ID+"~"+"tryLexDialogX";
	
	private String appLauncherClassicView=FrameWorkConstants.XPATH+"~"+"//div[@title='App Menu']";
	
	//SFDC Lightning Components
	private String appLauncher=FrameWorkConstants.XPATH+"~"+"//div[@class='slds-icon-waffle']";
	private String contactTabLT=FrameWorkConstants.XPATH+"~"+"(//span[text()='Contacts'])[1]";
	private String leadTabLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Leads']";
	private String campaignsTabLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Campaigns']";
	private String chatterTabLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Chatter']";
	private String accountsTabLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Accounts']";
	private String opportunitiesTabLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Opportunities']";
	private String casesTabLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Cases']";
	
	//global search Lightning view
	private String searchTextBoxLT=FrameWorkConstants.XPATH+"~"+"//*[@title='Search Salesforce']";
	private String showMoreLt=FrameWorkConstants.XPATH+"~"+"(//span[text()='Show More'])[2]";
	private String detailsLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Details']";
	
	/**
	 * @author Arnab
	 * Description :- Navigate to Contact Page
	 */
	public void NavigateToContactPage(){
		try{
			if(FrameWorkConstants.sfdcView.equals("Lightning")){
				Thread.sleep(10000);
				FrameWorkConstants.extdSel2Lib.click(contactTabLT);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButtonLT);
			}else if(FrameWorkConstants.sfdcView.equals("Classic")){
				Thread.sleep(2000);
				lightningPopupClose();
				FrameWorkConstants.extdSel2Lib.click(contactsTab);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButton);
			}else{
				System.out.println("NavigateToContactPage() --> sfdcView is not valid");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void NavigateToLeadsPage(){
		try{
			if(FrameWorkConstants.sfdcView.equals("Lightning")){
				Thread.sleep(10000);
				FrameWorkConstants.extdSel2Lib.click(leadTabLT);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButtonLT);
			}else if(FrameWorkConstants.sfdcView.equals("Classic")){
				Thread.sleep(2000);
				lightningPopupClose();
				FrameWorkConstants.extdSel2Lib.click(leadsTab);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButton);
			}else{
				System.out.println("NavigateToLeadsPage() --> sfdcView is not valid");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void NavigateToChatterPage(){
		try{
			
			if(FrameWorkConstants.sfdcView.equals("Lightning")){
				Thread.sleep(10000);
				FrameWorkConstants.extdSel2Lib.click(chatterTabLT);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButtonLT);
			}else if(FrameWorkConstants.sfdcView.equals("Classic")){
				Thread.sleep(2000);
				lightningPopupClose();
				FrameWorkConstants.extdSel2Lib.click(chatterTab);
				Thread.sleep(2000);
			}else{
				System.out.println("NavigateToChatterPage() --> sfdcView is not valid");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void NavigateToCampaignPage(){
		try{
			
			if(FrameWorkConstants.sfdcView.equals("Lightning")){
				Thread.sleep(10000);
				FrameWorkConstants.extdSel2Lib.click(campaignsTabLT);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButtonLT);
			}else if(FrameWorkConstants.sfdcView.equals("Classic")){
				Thread.sleep(2000);
				lightningPopupClose();
				FrameWorkConstants.extdSel2Lib.click(campaignsTab);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButton);
			}else{
				System.out.println("NavigateToCampaignPage() --> sfdcView is not valid");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void NavigateToAccountsPage(){
		try{
			
			if(FrameWorkConstants.sfdcView.equals("Lightning")){
				Thread.sleep(10000);
				FrameWorkConstants.extdSel2Lib.click(accountsTabLT);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButtonLT);
			}else if(FrameWorkConstants.sfdcView.equals("Classic")){
				Thread.sleep(2000);
				lightningPopupClose();
				FrameWorkConstants.extdSel2Lib.click(accountsTab);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButton);
			}else{
				System.out.println("NavigateToAccountsPage() --> sfdcView is not valid");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void NavigateToOpportunitiesPage(){
		try{
			if(FrameWorkConstants.sfdcView.equals("Lightning")){
				Thread.sleep(10000);
				FrameWorkConstants.extdSel2Lib.click(opportunitiesTabLT);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButtonLT);
			}else if(FrameWorkConstants.sfdcView.equals("Classic")){
				Thread.sleep(2000);
				lightningPopupClose();
				FrameWorkConstants.extdSel2Lib.click(opportunitiesTab);				
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButton);
			}else{
				System.out.println("NavigateToOpportunitiesPage() --> sfdcView is not valid");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void NavigateToForecastsPage(){
		try{
			FrameWorkConstants.extdSel2Lib.click(forecastsTab);
			Thread.sleep(2000);
			lightningPopupClose();
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void NavigateToCasesPage(){
		try{
			if(FrameWorkConstants.sfdcView.equals("Lightning")){
				Thread.sleep(10000);
				FrameWorkConstants.extdSel2Lib.click(casesTabLT);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButtonLT);
			}else if(FrameWorkConstants.sfdcView.equals("Classic")){
				Thread.sleep(2000);
				lightningPopupClose();
				FrameWorkConstants.extdSel2Lib.click(casesTab);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(newButton);
			}else{
				System.out.println("NavigateToCasesPage() --> sfdcView is not valid");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean globalSearch(String searchRecord,String searchRecordType){
		boolean result=false;
		try{
			
			if(FrameWorkConstants.sfdcView.equals("Lightning")){
				Thread.sleep(2000);				
				result=globalSearchInLightningView(searchRecord, searchRecordType);
			}else if(FrameWorkConstants.sfdcView.equals("Classic")){
				Thread.sleep(2000);
				result=globalSearchInClassic(searchRecord, searchRecordType);
			}else{
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean globalSearchInClassic(String searchRecord,String searchRecordType){
		
		boolean result=false;
		try{
			//clear the text box 
			FrameWorkConstants.extdSel2Lib.clearText(searchTextBox);
			Thread.sleep(2000);
			FrameWorkConstants.extdSel2Lib.setText(searchTextBox, searchRecord);
			Thread.sleep(2000);
			FrameWorkConstants.extdSel2Lib.click(searchButton);
			Thread.sleep(2000);
			FrameWorkConstants.extdSel2Lib.click(searchAllButton);
			Thread.sleep(1000);
			if(searchRecordType.equalsIgnoreCase("Contacts")){
				FrameWorkConstants.extdSel2Lib.browserManagement.getCurrentWebDriver().findElement(By.xpath("(//*[text()='Contacts'])[2]")).click();
				Thread.sleep(2000);
			}else if(searchRecordType.equalsIgnoreCase("Leads")){
				FrameWorkConstants.extdSel2Lib.browserManagement.getCurrentWebDriver().findElement(By.xpath("(//*[text()='Leads'])[2]")).click();
				Thread.sleep(2000);
			}else if(searchRecordType.equalsIgnoreCase("Cases")){
				FrameWorkConstants.extdSel2Lib.browserManagement.getCurrentWebDriver().findElement(By.xpath("(//*[text()='Cases'])[2]")).click();
				Thread.sleep(2000);
			}else if(searchRecordType.equalsIgnoreCase("Accounts")){
				FrameWorkConstants.extdSel2Lib.browserManagement.getCurrentWebDriver().findElement(By.xpath("(//*[text()='Accounts'])[2]")).click();
				Thread.sleep(2000);
			}else if(searchRecordType.equalsIgnoreCase("Opportunities")){
				FrameWorkConstants.extdSel2Lib.browserManagement.getCurrentWebDriver().findElement(By.xpath("(//*[text()='Opportunities'])[2]")).click();
				Thread.sleep(2000);
			}
			
			if(FrameWorkConstants.extdSel2Lib.browserManagement.getCurrentWebDriver().findElements(By.xpath("//*[text()='"+searchRecord+"']")).size()>0){
				FrameWorkConstants.extdSel2Lib.browserManagement.getCurrentWebDriver().findElement(By.xpath("//*[text()='"+searchRecord+"']")).click();
				result=true;
				System.out.println("Search Record Found");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean globalSearchInLightningView(String searchRecord,String searchRecordType){
		boolean result=false;
		
		try{
			FrameWorkConstants.extdSel2Lib.clearText(searchTextBoxLT);
			Thread.sleep(2000);
			FrameWorkConstants.extdSel2Lib.setText(searchTextBoxLT, searchRecord);
			Thread.sleep(2000);
			FrameWorkConstants.extdSel2Lib.getWebElement(searchTextBoxLT).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			FrameWorkConstants.extdSel2Lib.click(showMoreLt);
			Thread.sleep(2000);
			
			if(searchRecordType.equalsIgnoreCase("Leads")){
				FrameWorkConstants.extdSel2Lib.driver.findElement(By.xpath("(//a[@title='Leads'])[2]")).click();
				Thread.sleep(2000);
			}else if(searchRecordType.equalsIgnoreCase("Contacts")){
				FrameWorkConstants.extdSel2Lib.driver.findElement(By.xpath("(//a[@title='Contacts'])[2]")).click();
				Thread.sleep(2000);
			}else if(searchRecordType.equalsIgnoreCase("Cases")){
				FrameWorkConstants.extdSel2Lib.driver.findElement(By.xpath("(//a[@title='Cases'])[2]")).click();
				Thread.sleep(2000);
			}else if(searchRecordType.equalsIgnoreCase("Accounts")){
				FrameWorkConstants.extdSel2Lib.driver.findElement(By.xpath("(//a[@title='Accounts'])[2]")).click();
				Thread.sleep(2000);
			}else if(searchRecordType.equalsIgnoreCase("Opportunities")){
				FrameWorkConstants.extdSel2Lib.driver.findElement(By.xpath("(//a[@title='Opportunities'])[2]")).click();
				Thread.sleep(2000);
			}else{
				System.out.println("Not a valid search type::-"+searchRecordType);
			}
			
			if(FrameWorkConstants.extdSel2Lib.driver.findElements(By.xpath("//a[@title='"+searchRecord+"']")).size()>0){
				FrameWorkConstants.extdSel2Lib.driver.findElement(By.xpath("//a[@title='"+searchRecord+"']")).click();
				result=true;
				System.out.println("Record Found");
				FrameWorkConstants.extdSel2Lib.click(detailsLT);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public void lightningPopupClose(){
		
		try{
//			Alert lightningAlert=FrameWorkConstants.extdSel2Lib.driver.switchTo().alert();
//			lightningAlert.accept();
			Thread.sleep(2000);
			FrameWorkConstants.extdSel2Lib.click(lightingAlertClose);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void appLauncher(String appName){
		
		try{
			if(FrameWorkConstants.sfdcView.equals("Classic")){
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.click(appLauncherClassicView);
				try{
					FrameWorkConstants.extdSel2Lib.driver.findElement(By.xpath("//a[text()='"+appName+"']")).click();
					System.out.println("Application Found and Selected");
				}catch(NoSuchElementException e1){
					Thread.sleep(2000);
					if(FrameWorkConstants.extdSel2Lib.driver.findElement(By.xpath("//Span[text()='"+appName+"']")).isDisplayed()){
						System.out.println("Application Found.");
					}else{
						System.out.println("AppName="+appName+" not present");
					}
					
				}
			}else if(FrameWorkConstants.sfdcView.equals("Lightning")){
				FrameWorkConstants.extdSel2Lib.click(appLauncher);
				Thread.sleep(20000);			
				FrameWorkConstants.extdSel2Lib.browserManagement.getCurrentWebDriver().findElement(By.xpath("//*[@class='appTileTitle' and @title='"+appName+"']")).click();
				
			}else{
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String SFDCViewSelection(String view) throws Exception{
		FrameWorkConstants.sfdcView=view;
		Thread.sleep(10000);
		
		try{
			if(FrameWorkConstants.extdSel2Lib.isDisplayed(user)){
				System.out.println("Application is in Lightning view. Setting LTFlag=true");
				FrameWorkConstants.LTFlag=true;
			}
		}catch(NoSuchElementException e1){
//			e1.printStackTrace();
		}
		try{
			if(FrameWorkConstants.extdSel2Lib.isDisplayed(userNavigationButton)){
				System.out.println("Application is in Classic View. Set ClsFlag=true");
				FrameWorkConstants.ClsFlag=true;
			}
		}catch(NoSuchElementException e2){
//			e2.printStackTrace();
		}
		
		if(view.equals("Classic")){
			if(FrameWorkConstants.ClsFlag){
				System.out.println("No Need to change to classic as the application is in classic view");
			}else{
				System.out.println("Chanhing to Classic View::");
				FrameWorkConstants.extdSel2Lib.click(user);
				Thread.sleep(3000);
				//using Action call as there are pseudo elements eg:- ::before
				Actions action=new Actions(FrameWorkConstants.extdSel2Lib.driver);
				action.moveToElement(FrameWorkConstants.extdSel2Lib.driver.findElement(By.xpath("//*[text()='Switch to Salesforce Classic']"))).click().perform();
				Thread.sleep(3000);
			}
			
		}else if (view.equals("Lightning")){
			
			if(FrameWorkConstants.LTFlag){
				System.out.println("No Need to Change in Lightning view.Application is in Lightning view");
			}else{
				System.out.println("Chanhing to Lightning View::");
				FrameWorkConstants.extdSel2Lib.click(userNavigationButton);
				Thread.sleep(2000);
				FrameWorkConstants.extdSel2Lib.driver.findElement(By.xpath("//a[text()='Switch to Lightning Experience']")).click();
				Thread.sleep(6000);
			}					
		}else{
			System.out.println("Wrong input. FrameWorkConstants.sfdcView="+FrameWorkConstants.sfdcView);
		}
		return FrameWorkConstants.sfdcView;
	}
	
}
