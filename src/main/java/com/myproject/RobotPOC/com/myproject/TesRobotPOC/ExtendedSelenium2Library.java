package com.myproject.RobotPOC.com.myproject.TesRobotPOC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ScriptException;
import com.github.markusbernhardt.selenium2library.Selenium2Library;
import com.github.markusbernhardt.selenium2library.keywords.BrowserManagement;
import com.github.markusbernhardt.selenium2library.keywords.Element;
import com.github.markusbernhardt.selenium2library.locators.ElementFinder;
import com.sun.tools.javac.util.List;

/**Author - Arnab Ghosh
 * Description :- This Class will Extend Selenium2Library of Robot so that we can use robot frameworks Selenium2Library's Driver and Elements for Custom coding.
 */
public class ExtendedSelenium2Library {

	private Selenium2Library sel2;
    private BrowserManagement browserManagement;
    private Element element;
    private org.openqa.selenium.WebDriver driver;  //this one is from Selenium, not Selenium2Library
	
    //Creating Constructor to initialize the below variable with Selenium2Lib reference 	
	public ExtendedSelenium2Library() throws ScriptException {
	    
		try {
			sel2 = (Selenium2Library) Selenium2Library.getLibraryInstance();
		} catch (javax.script.ScriptException e) {
			e.printStackTrace();
		}
		browserManagement = sel2.getBrowserManagement();
        driver=browserManagement.getCurrentWebDriver();
        element = sel2.getElement();   
	}
	
	/** Author:- Arnab Ghosh
	 * Description:- Browser Setup method specifies the Chrome Driver Path
	 * 
	 */
	public void browserSetup(){		
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");	
		
	}
	
	/**Author:- Arnab Ghosh
	 * Desctiption :- Custom Login method without using Selenium2Library Keywords.
	 * @param userNme
	 * @param password
	 * @throws Throwable
	 */
	public void SFDCLogin(String userNme,String password) throws Throwable{
		
		System.out.println(browserManagement.getTitle());	
		
		java.util.List<WebElement> elementsUserName =ElementFinder.find(
                browserManagement.getCurrentWebDriver(), "//input[@name='username']");

		elementsUserName.get(0).sendKeys(userNme);
		
		java.util.List<WebElement> elementsPassword =ElementFinder.find(
                browserManagement.getCurrentWebDriver(), "//input[@id='password']");
		elementsPassword.get(0).sendKeys(password);
		
		java.util.List<WebElement> elementsSubmitButton =ElementFinder.find(
                browserManagement.getCurrentWebDriver(), "//input[@name='Login']");
		elementsSubmitButton.get(0).submit();
				
	}
		
}
