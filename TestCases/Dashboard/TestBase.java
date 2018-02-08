package Dashboard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.*;
import constant.*;

public class TestBase {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Run beforeMethod");
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Run AfterMethod");
		Constant.WEBDRIVER.quit();
	}

}
