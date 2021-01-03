package utiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Propertie {

	
	public String getDataFromFile(String propertyName)
	{
		 FileReader reader = null;
			try {
				reader = new FileReader("./configFiles/config.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		      
			    java.util.Properties p = new java.util.Properties(); 
			    try {
					p.load(reader);
					return p.getProperty(propertyName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
    
   return null;
	}
	
	public void writeIntoFile(String key ,String value, String fileName)
	{
		try {
			Properties properties = new Properties();
			properties.setProperty(key, value);
		

			File file = new File("./configFiles/"+fileName+".properties");
			FileOutputStream fileOut = new FileOutputStream(file);
			properties.store(fileOut, "Favorite Things");
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
