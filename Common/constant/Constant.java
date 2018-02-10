/**
 * 
 */
package constant;

import org.openqa.selenium.WebDriver;

/**
 * @author an.son
 *
 */
public class Constant {

	public static WebDriver WEBDRIVER;
	public static final String DASHBOARD_URL = "http://10.0.0.1:54001/TADashboard";
	public static final String USERNAME = "administration";
	public static final String PASSWORD = "";
	//public static final 

	public static enum Timeout {
		short_time(5), long_time(20), wait_time(50), milisecond_wait(200);
		private final long TimeOut;

		Timeout(final long time) {
			TimeOut = time;
		}

		public long getValue() {
			return TimeOut;
		}
	}

}
