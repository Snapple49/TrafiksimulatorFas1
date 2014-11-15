import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Class GetPropertyValues is a class for handling the file reading for the traffic system. Uses a Properties object to read the file config.properties.
 * 
 * @author Oliver Stein & Alexander Lind
 * 
 */
public class GetPropertyValues {

	/**
	 * Thrown to indicate that the config.properties file contains errorenous data. Extends IllegalArgumentException.
	 */
	private class BadFileDataException extends IllegalArgumentException{
		
		/**
		 * Instantiates a new BadFileDataException with the error message errormsg. 
		 * 
		 * @param errormsg the error message. errormsg is printed to standard error stream.
		 */
		public BadFileDataException(String errormsg){
			System.err.println(errormsg);
		}
	}

	/**
	 * Creates a Properties object, and tries loading the file config.properties to it. Returns the Properties object if the file was successfully loaded and does not contain invalid data.
	 * @throws BadFileDataException if any values are non-integers or invalid integers.
	 * @return an int array with values read from config.properties.
	 */
	public int[] getPropValues() {
		Properties prop = new Properties();
		InputStream iS = getClass().getResourceAsStream("resources/config.properties");
		try {
			prop.load(iS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int i4 = 0;
		int i5 = 0;
		int i6 = 0;
		int i7 = 0;
		
		try {
			getClass().getResource("resources/config.properties").getPath();
			i1 = Integer.parseInt(prop.getProperty("intensity"));
			i2 = Integer.parseInt(prop.getProperty("leftIntensity"));
			i3 = Integer.parseInt(prop.getProperty("period"));
			i4 = Integer.parseInt(prop.getProperty("greenPeriodStraight"));
			i5 = Integer.parseInt(prop.getProperty("greenPeriodTurn"));
			i6 = Integer.parseInt(prop.getProperty("firstLane"));
			i7 = Integer.parseInt(prop.getProperty("secondLane"));
		} catch (NumberFormatException e) {
			throw new BadFileDataException("File contains invalid data! All parameters must be valid integers, see config.properties or README.md");

			
		}
		if(i1 > 0 && i3 > 1 && i4 > 0 && i4 < i3 && i5 > 0 && i5 < i3 && i6 > 0 && i7 > 0){
			int[] result = {i1, i2, i3, i4, i5, i6, i7};
			return result;
		}
		else
			throw new BadFileDataException("File contains invalid data! All parameters must be valid integers, see config.properties or README.md");
	}
}
