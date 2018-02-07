/**
 * 
 */
package Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constant.Constant.*;
import common.Utilities;
import common.Utilities.*;

/**
 * @author an.son
 *
 */
public class GeneralPage {
	// locator
	private static final By ProfileName = By.xpath("//a[@href='#Welcome']");

	public GeneralPage() {
		// TODO Auto-generated constructor stub
	}

	// element
	protected WebElement LocateProfile() {
		return Utilities.findElement(ProfileName, Timeout.short_time.getValue());
	}

	public String getProfileText() {
		return this.LocateProfile().getText();
	}

}
