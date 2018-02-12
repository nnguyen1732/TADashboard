/**
 * 
 */
package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
			Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Timeout.milisecond_wait.getValue(),
					TimeUnit.MILLISECONDS);
			if (checkElementExist(element)) {
				break;
			}
		}

	}

	// wait for element refresh
	public static void waitElement(By element) {
		new WebDriverWait(Constant.WEBDRIVER, Timeout.long_time.getValue())
				.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	public static void waitElementNotExit(By element) {
		new WebDriverWait(Constant.WEBDRIVER, Timeout.short_time.getValue())
				.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}

	// check element exist or not
	public static boolean checkElementExist(By element) {
		if (Constant.WEBDRIVER.findElement(element).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	// locate object with time-out
	public static WebElement findElement(By element, long timeout) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	// get browser form message
	public static String getBrowserFormMsg() {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.Timeout.short_time.getValue());
		wait.until(ExpectedConditions.alertIsPresent());
		return Constant.WEBDRIVER.switchTo().alert().getText();
	}

	public static void clickPopup() {
		Constant.WEBDRIVER.switchTo().alert().accept();
	}
	
	public static String generateUniqueString(String entity) {
		return entity + new String().hashCode();
	}
	
	public static String UniqueObjectID(String entity) {
		return generateUniqueString(entity).substring(0, 12);
	}
}
