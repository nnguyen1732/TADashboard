/**
 * 
 */
package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constant.Constant;
import constant.Constant.*;


/**
 * @author an.son
 *
 */
public class Utilities {

	// locate project path
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	// wait for element exist
	public static void waitForElement(By element, int second) {
		second = second * 1000;
		for (int count = 0; count < second; count += 500) {
			Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Timeout.milisecond_wait.getValue(), TimeUnit.MILLISECONDS);
			if (checkElementExist(element)) {
				break;
			}
		}

	}

	// wait for element refresh
	public static void waitElement(By element) {
		new WebDriverWait(Constant.WEBDRIVER, Timeout.wait_time.getValue())
				.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	// check element exist or not
	public static boolean checkElementExist(By element) {
		if (Constant.WEBDRIVER.findElement(element).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	// locate object with time-out
	public static WebElement findElement(By element, long timeout) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	//get browser form message
	public static String getErrorFormMsg() {
		return Constant.WEBDRIVER.switchTo().alert().getText();
	}

}
