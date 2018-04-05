/**
 * 
 */
package Pages;

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

/**
 * @author Arnab
 *
 */
public class LoginSFDC {

	/**Author:- Arnab Ghosh
	 * Desctiption :- Custom Login method without using Selenium2Library Keywords.
	 * @param userNme
	 * @param password
	 * @throws Throwable
	 */
	private String userNameObj=FrameWorkConstants.XPATH+"~"+"//input[@name='username']";
	private String passwordObj=FrameWorkConstants.XPATH+"~"+"//input[@id='password']";
	private String loginButton=FrameWorkConstants.XPATH+"~"+"//input[@name='Login']";
	
	
	public void SFDCLogin(String userNme,String password){
			
		try{
			
//			System.out.println(browserManagement.getTitle());
//			System.out.println(browserManagement.getCurrentWebDriver());
			FrameWorkConstants.extdSel2Lib.setText(userNameObj,userNme);
			FrameWorkConstants.extdSel2Lib.setText(passwordObj,password);
			FrameWorkConstants.extdSel2Lib.submit(loginButton);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
}
