import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValues {
	
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
