import java.io.*;
import java.util.Properties;

public class GetPropertyValues {
	/*
	String result = "";
	Properties prop = new Properties();
	String propFileName = "config.properties";
	 
	InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
	prop.load(inputStream);
	if (inputStream == null) {
	throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
	}
	*/
	public Properties getPropValues() {
		Properties prop = new Properties();
		InputStream iS = getClass().getResourceAsStream("resources/config.properties");
		try {
			prop.load(iS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		getClass().getResource("resources/config.properties").getPath();
		
		
		return prop;
	}
}
