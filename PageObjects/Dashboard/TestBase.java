package Dashboard;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

	
		@BeforeMethod
		public void beforeMethod() {
//			System.out.println("Run beforeMethod");
//
//			System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
//
//			Constant.WEBDRIVER = new ChromeDriver();

			// Constant.WEBDRIVER.manage().window().maximize();

		}

		@AfterMethod
		public void afterMethod() {
//			System.out.println("Run AfterMethod");
//			Constant.WEBDRIVER.quit();
		}

}
