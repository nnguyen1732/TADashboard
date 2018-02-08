/**
 * 
 */
package Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import constant.Constant;
import constant.Constant.*;
import common.Utilities;

/**
 * @author an.son
 *
 */
public class MainPage {
	// locator
	private static final By ProfileName = By.xpath("//a[@href=\"#Welcome\"]");
	private static final By btnLogOut = By.xpath("//a[@href=\"logout.do\"]");

	public MainPage() {
		// TODO Auto-generated constructor stub
		if (ExpectedConditions.alertIsPresent() == null)
			Utilities.waitElement(ProfileName);

	}

	// element
	protected WebElement lblProfileName() {
		return Utilities.findElement(ProfileName, Timeout.long_time.getValue());
	}

	protected WebElement getBtnLogOut() {
		return Utilities.findElement(btnLogOut, Timeout.short_time.getValue());
	}

	public String getProfileText() {
		return this.lblProfileName().getText();
	}

	public void clickProfileName() {
		lblProfileName().click();
		Utilities.waitElement(btnLogOut);
	}

	public LoginPage Logout() {
		clickProfileName();
		getBtnLogOut().click();
		Utilities.waitElementNotExit(btnLogOut);
		return new LoginPage();
	}
	
	
}