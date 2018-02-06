/**
 * 
 */
package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constant.Constant;

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
	public static void waitForElement(By.ByXPath xpath, int second) {
		second = second * 1000;
		for (int count = 0; count < second; count += 500) {
			Constant.WEBDRIVER.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
			if (ExpectedConditions.presenceOfElementLocated(xpath) != null) {
				break;
			}
		}

	}

	// wait for element refresh
	public static void waitElement(By element) {
		new WebDriverWait(Constant.WEBDRIVER, 3000).until(ExpectedConditions.presenceOfElementLocated(element));
	}

}
