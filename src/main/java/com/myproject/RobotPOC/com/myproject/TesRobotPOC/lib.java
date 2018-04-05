package com.myproject.RobotPOC.com.myproject.TesRobotPOC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.gargoylesoftware.htmlunit.ScriptException;
import com.codoid.products.exception.*;
import com.codoid.products.fillo.*;
import com.codoid.products.parser.*;
import com.codoid.products.utils.*;
import com.github.markusbernhardt.selenium2library.Selenium2Library;
import com.github.markusbernhardt.selenium2library.keywords.BrowserManagement;
import com.github.markusbernhardt.selenium2library.keywords.Element;
import com.github.markusbernhardt.selenium2library.locators.ElementFinder;


public class lib {

	/**Author :- Arnab Ghosh
	 * Description :- Method to Read from Excel using Fillo (an Excel API for Java)
	 * @param FileLoc
	 * @param strQuery
	 * @param Attribute
	 * @return
	 */
	public String ReadExcelData(String FileLoc,String strQuery,String Attribute){
		String result="";
		Fillo fillo=new Fillo();
		//Connection connection=fillo.getConnection(FileLoc); //"C:\\Test.xlsx"
		try{			
			Connection connection=fillo.getConnection(FileLoc); //"C:\\Test.xlsx"
			//Connection connection=fillo.getConnection("C:\\TestRobotExcel.xlsx");
			//String strQuery="Select * from Sheet1 where ID=100 and name='John'";
			Recordset recordset=connection.executeQuery(strQuery);
			 
			while(recordset.next()){
			System.out.println(recordset.getField(Attribute));
			//System.out.println(recordset.toString());
			
			}
			result=recordset.getField(Attribute).toString(); 
			recordset.close();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	/**Author:- Arnab Ghosh
	 * Description :- Method to Write to Excel using Fillo (an Excel API for Java)
	 * @param FileLoc
	 * @param strQuery
	 */
	public void WriteToExcel(String FileLoc,String strQuery){
		
		try{
			Fillo fillo=new Fillo();
			Connection connection=fillo.getConnection(FileLoc);
			//String strQuery="INSERT INTO sheet4(Name,Country) VALUES('Peter','UK')";
			 
			connection.executeUpdate(strQuery);
			 
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**Author:- Arnab Ghosh
	 * Description :- Method to Update to Excel using Fillo (an Excel API for Java)
	 * @param FileLoc
	 * @param strQuery
	 */
	public void UpdateValuesInExcel(String FileLoc,String strQuery){
		
		try{
			Fillo fillo=new Fillo();
			Connection connection=fillo.getConnection(FileLoc);
			//String strQuery="Update Sheet1 Set Country='US' where ID=100 and name='John'";
			 
			connection.executeUpdate(strQuery);
			 
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
