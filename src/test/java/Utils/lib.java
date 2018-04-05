package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

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
	public static String ReadExcelData(String FileLoc,String strQuery,String Attribute){
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
	public static void WriteToExcel(String FileLoc,String strQuery){
		
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
	public static void UpdateValuesInExcel(String FileLoc,String strQuery){
		
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
	
	
	public static HashMap<String,String> GetDataFromExcel(String FileLoc,String Query){
		
		HashMap<String,String> results = new HashMap<String,String>();
		String columnNames="";
		int columnCount=0;
		int rowCount=0;		
		Fillo fillo=new Fillo();
		Recordset recordset=null;
		
		try{			
			Connection connection=fillo.getConnection(FileLoc); //"C:\\Test.xlsx"
			if(null != connection){
				recordset=connection.executeQuery(Query);
				String cellValue=new String("");
				ArrayList<String> columnList=recordset.getFieldNames();
				columnCount=columnList.size();
				rowCount=0;
				
				while(recordset.next()){
					rowCount++;
					columnNames="";
					for(int i=0;i<columnCount;i++){
						String columnName=columnList.get(i);
						if(columnNames==""){
							columnNames=columnName;
						}else{
							columnNames=columnNames+";"+columnName;
						}
						cellValue=(String) recordset.getField(columnName);
						if(cellValue==null) cellValue="";
						results.put(columnName + rowCount,cellValue);
					}
				}
				
			}
			
			if(recordset!=null)recordset.close();
			
			if(null !=connection)connection.close();
			results.put("RowCount", rowCount + "");
			results.put("ColumnCount", columnCount + "");
			results.put("ColumnNames", columnNames);

		}catch(Exception e){
			e.printStackTrace();
		}		
		return results;
	}
	
	public static int random(){
		
		int number=0;
		
		Random rand= new Random();
		for(int i=1;i<=100000;i++){
			number=rand.nextInt((999999-100000)+1)+100000;
		}
		return number;
	}
	
	
	public static void ReadPropertiesData(){
		File configFile = new File("C:\\Workspace\\com.myproject.TesRobotPOC\\PropertiesData.xml");
		//File configFile = new File("config.properties");
		
		try {
			FileInputStream reader = new FileInputStream(configFile);
			//Properties props = new Properties();
			FrameWorkConstants.propertiesData.loadFromXML(reader);
		
			//String url = configData.getProperty("URL");		
			//System.out.print("Login url is: " + url);
			reader.close();
		} catch (FileNotFoundException ex) {
			// file does not exist
		} catch(IOException ex){
			// I/O exception
		}
	}
	
	
	

}
