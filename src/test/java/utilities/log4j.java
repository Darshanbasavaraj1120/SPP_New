package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class log4j {
	
	public Logger logger;
	public void log() {
	
		logger=Logger.getLogger("SPP Testing");
		PropertyConfigurator.configure("Log4j.properties");
	}

}
