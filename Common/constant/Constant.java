/**
 * 
 */
package constant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author an.son
 *
 */
public class Constant {
	
	public static WebDriver WEBDRIVER;
	public static final String DASHBOARD_URL = "http://localhost:54000/TADashboard";
	public static final String USERNAME = "administration";
	public static final String PASSWORD = "";
	//public static WebDriverWait WEBDRIVEWAIT = new WebDriverWait(WEBDRIVER, Timeout.long_time.getValue());
	
	public static enum Timeout {
		short_time(5), long_time(20), wait_time(1), milisecond_wait(200) ;
		private final long TimeOut;

		Timeout(final long time) {
			TimeOut = time;
		}

		public long getValue() {
			return TimeOut;
		}
	}
	
}
