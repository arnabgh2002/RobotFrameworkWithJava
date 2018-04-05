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
public class Accounts {

	//Classic Web  Components
	 
	//Lightning Web Components
	private String accountNameLT=FrameWorkConstants.XPATH+"~"+"(//span[text()='Account Name'])[2]/following::input[1]";
	private String phoneLT=FrameWorkConstants.XPATH+"~"+"(//span[text()='Phone'])[2]/following::input[1]";
	private String billingStreetLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Billing Street']/following::textarea[1]";
	private String billingCityLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Billing City']/following::input[1]";
	private String billingZipPostalCodeLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Billing Zip/Postal Code']/following::input[1]";
	private String billingStateProvinceLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Billing State/Province']/following::input[1]";
	private String billingCountryLT=FrameWorkConstants.XPATH+"~"+"//span[text()='Billing Country']/following::input[1]";
}
