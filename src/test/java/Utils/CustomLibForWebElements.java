package Utils;

import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.python.icu.impl.Assert;

import com.gargoylesoftware.htmlunit.ScriptException;
import com.github.markusbernhardt.selenium2library.Selenium2Library;
import com.github.markusbernhardt.selenium2library.keywords.BrowserManagement;
import com.github.markusbernhardt.selenium2library.keywords.Element;
import com.github.markusbernhardt.selenium2library.locators.ElementFinder;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ArrayUtils;

import Utils.lib.*;

/**Author - Arnab Ghosh
 * Description :- This Class will Extend Selenium2Library of Robot so that we can use robot frameworks Selenium2Library's Driver and Elements for Custom coding.
 */
public class CustomLibForWebElements {

	public static final String ROBOT_LIBRARY_SCOPE="GLOBAL";
	public Selenium2Library sel2;
    public BrowserManagement browserManagement;
    public Element element;
    public org.openqa.selenium.WebDriver driver;  //this one is from Selenium, not Selenium2Library
	
    //Creating Constructor to initialize the below variable with Selenium2Lib reference 	
	public CustomLibForWebElements() throws ScriptException {
	    
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
	public void initialBrowserSetup(){		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");	
		
		//driver =new ChromeDriver(options);
//		driver.manage();
	}
	
//	public void OpenBrowserWithRemoteCap(String url,String BrowserName,String remonetUrl) throws Throwable{
//		
////		sel2.getBrowserManagement().openBrowser(remonetUrl, browserName, alias, remoteUrl)
//		try{
//			if(BrowserName.equals("chorme")){
//			DesiredCapabilities capDr = DesiredCapabilities.chrome();
////			browserManagement.openBrowser(url, BrowserName, "NONE", remonetUrl, "NONE", "NONE");
//			driver=new RemoteWebDriver(new URL("http://ec2-52-207-244-122.compute-1.amazonaws.com:4444/wd/hub"), capDr);
//			driver.navigate().to(url);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}
	
	/**This method identifies if the WebElement passed is xpath or id or etc.
	 * @param locator
	 * @return
	 */
	public  WebElement getWebElement(String locator){
		
		WebElement webElement = null;
		String identifyType;
		String objDesc;
		try{
			if(locator.equals(null)){
				System.out.println("Object is null.");
			}else{
				identifyType=locator.split("~")[0].toString().trim();
				objDesc=locator.split("~")[1].toString().trim();
				
				if(identifyType.equalsIgnoreCase("XPATH")){
					webElement = browserManagement.getCurrentWebDriver().findElement(By.xpath(objDesc));
				}else if(identifyType.equalsIgnoreCase("NAME")){
					webElement=browserManagement.getCurrentWebDriver().findElement(By.name(objDesc));
				}else if(identifyType.equalsIgnoreCase("ID")){
					webElement=browserManagement.getCurrentWebDriver().findElement(By.id(objDesc));
				}else if(identifyType.equalsIgnoreCase("CLASS")){
					webElement=browserManagement.getCurrentWebDriver().findElement(By.className(objDesc));
				}else if(identifyType.equalsIgnoreCase("CSS")){
					webElement=browserManagement.getCurrentWebDriver().findElement(By.cssSelector(objDesc));
				}else if(identifyType.equalsIgnoreCase("LINKTEXT")){
					webElement=browserManagement.getCurrentWebDriver().findElement(By.linkText(objDesc));
				}else if(identifyType.equalsIgnoreCase("PARTIALLINKTEXT")){
					webElement=browserManagement.getCurrentWebDriver().findElement(By.partialLinkText(objDesc));
				}else if(identifyType.equalsIgnoreCase("TAGNAME")){
					webElement=browserManagement.getCurrentWebDriver().findElement(By.tagName(objDesc));
				}else{
					System.out.println("Invalid Locator");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void setText(String sObject,String sText){
		
		WebElement webElement=getWebElement(sObject);
		
		try{
			webElement.sendKeys(sText);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void click(String sObject){
		
		WebElement webElement=getWebElement(sObject);
		
		try{
			webElement.click();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void clearText(String sObject){
		
		WebElement webElement=getWebElement(sObject);
		
		try{
			webElement.clear();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void submit(String sObject){
		
		WebElement webElement=getWebElement(sObject);
		
		try{
			webElement.submit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public boolean selectDropdownValueByVisibleText(String sObject,String valueByVisibleText){
		boolean result=false;		
		
		try{
			WebElement webElement=getWebElement(sObject);
			webElement.click();
			Select oSelect= new Select(webElement);
			oSelect.selectByVisibleText(valueByVisibleText);
			result=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean selectDropdownValueByIndex(String sObject,int indexNumber){
		boolean result=false;		
		
		try{
			WebElement webElement=getWebElement(sObject);
			Select oSelect= new Select(webElement);
			oSelect.selectByIndex(indexNumber);
			result=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	public boolean dropDownMultiSelectAdd(String sObject,String value){
		
		boolean result=false;
		
		try{
			if(value!=""){
				WebElement webElement=getWebElement(sObject);
				java.util.List<WebElement> list=webElement.findElements(By.tagName("option"));
				String data[]=value.split(",");
				
				for(int k=0;k<=data.length;k++){
					
					int j=0;
					for(int i=0;i<=list.size();i++){
						
						j++;
						String str=list.get(i).getText();
						System.out.println("Value is List (str) is"+str);
						System.out.println("Value stored in data[] "+data[k]);
						if(str.equalsIgnoreCase(data[k])){
							j--;
							webElement.sendKeys(Keys.CONTROL);
							list.get(i).click();
							
							System.out.println(str+" is selected");
							break;
						}
						if(j==list.size()){
							Assert.fail(data[k]+" is not present");
						}
					}
				}
			}else{
				System.out.println("Please give input values to be selected from dropdown");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public String getText(String sObject){
		String result="";
		try{
			result=getWebElement(sObject).getText();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public String getValueFromJavascriptExecutor(String sObject){
		String value="";
		JavascriptExecutor js;
		try{
			js=(JavascriptExecutor)driver;
			//retriving value with respect to ID
			String idValue=getWebElement(sObject).getAttribute("id");
			value=(String)js.executeScript("return Ext.getCmp('"+idValue+"').getValue()");
		}catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}
	
	public boolean switchToiFrameUsingStandardObjects(String sObject) throws Exception{
		boolean found=false;
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		//getting list total number of frames in the page
		List<WebElement> iframesList=(List<WebElement>) driver.findElements(By.tagName("iframe"));
		if(iframesList.size()==0){
			iframesList=(List<WebElement>) driver.findElements(By.tagName("frame"));
		}
		
		ArrayList<String> iFrameIdList= new ArrayList<String>();
		try{
			
			for(WebElement iframe:iframesList){
				String id=iframe.getAttribute("id");
				if(id.length()>0 && id.startsWith("ext-comp")){
					iFrameIdList.add(iframe.getAttribute("id"));
				}
			}
			System.out.println("Frames - "+iFrameIdList);
		}catch(Exception e){
			
		}
		
		return found;
	}
	
	public boolean isDisplayed(String sObject){		
		boolean result=false;
		WebElement webElement=getWebElement(sObject);
		
		try{
			if(webElement.isDisplayed()){
				result=true;
			}else{
				System.out.println("Object is not displayed:: obj-->"+sObject);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	/**Author:- Arnab Ghosh
	 * Description :- To Select a Picklist value in SFDC Lightning View. In SFDC Lightning the picklist values are rendered via javascript 
	 * 				  and the picklist values are store in the li tags.
	 * @param Locator(WebElement)
	 * @param value
	 */
	public void selectingPickListValue(String sObject,String value){
		
		try{
			WebElement dropdown=getWebElement(sObject);
			dropdown.click();
			FrameWorkConstants.extdSel2Lib.driver.findElement(By.xpath("//li/following::a[text()='"+value+"']")).click();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
