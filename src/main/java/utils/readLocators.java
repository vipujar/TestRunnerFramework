package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class readLocators {
	public static Properties mergedProperties = new Properties();
	
	static{
	List<Properties> obj=new ArrayList<Properties>();
	String locatorPath=System.getProperty("user.dir")+"\\"+"src"+"\\"+"test"+"\\"+"java"+"\\";
	System.out.println("%%%%%"+locatorPath);
	 File directoryPath = new File(locatorPath);
     //List of all files and directories
     String contents[] = directoryPath.list();
     FileInputStream objfile;
     for(String content:contents) {
	 try {
		objfile = new FileInputStream(locatorPath+"\\"+content+"\\"+"locator.properties");
		
		Properties tempProperty=new Properties();
		tempProperty.load(objfile);
		mergedProperties.putAll(tempProperty);
	 } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
     }
	}
	
	


}
