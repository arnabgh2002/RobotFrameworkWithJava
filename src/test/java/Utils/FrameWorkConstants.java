package Utils;

import java.util.Properties;

import com.codoid.products.fillo.Connection;


public class FrameWorkConstants {
	public static final String XPATH="xpath";
	public static final String NAME="name";
	public static final String ID="id";
	public static final String CLASS="classname";
	public static final String CSS="css";
	public static final String LINKTEXT="linktext";
	public static final String PARTIALLINKTEXT="partialLinkText";
	public static final String TAGNAME="tagName";
	
	public static final int i=1;
	public static final CustomLibForWebElements extdSel2Lib=new CustomLibForWebElements();
	
	public static Properties propertiesData=new Properties();
	
	public static final MysqlConnect mysqlConnect = new MysqlConnect();
	
	public static String sfdcView;
	public static boolean LTFlag=false;
	public static boolean ClsFlag=false;
	
    
    
    
}
