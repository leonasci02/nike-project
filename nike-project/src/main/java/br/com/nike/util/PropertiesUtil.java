package br.com.nike.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	public static String getProjectProperty(String string) throws FileNotFoundException, IOException {
		Properties properties  = new Properties();
		properties.load(new FileInputStream("properties/project.properties"));
		return properties.getProperty(string);
	}
	
}
