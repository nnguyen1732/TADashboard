/**
 * 
 */
package Dashboard;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	private static final By lnkSetting = By.xpath("//li[@class=\"mn-setting\"]/a[@href=\"javascript:void(0);\"]");
	private static final By lnkAddPage = By
			.xpath("//li[@class=\"mn-setting\"]//a[contains(@href,\"Dashboard.openAddPageForm\")]");
	private static final By btnAddPage_OK = By.xpath("//input[@id=\"OK\"]");
	private static final By txtPageName = By.xpath("//input[@id='name']");

	public MainPage() {
		// TODO Auto-generated constructor stub
		if (ExpectedConditions.alertIsPresent() == null)
			Utilities.waitElement(ProfileName);

	}

	// element
	protected WebElement lblProfileName() {
		return Utilities.findElement(ProfileName, Timeout.short_time.getValue());
	}

	protected WebElement getBtnLogOut() {
		return Utilities.findElement(btnLogOut, Timeout.short_time.getValue());
	}

	protected WebElement getLnkSetting() {
		return Utilities.findElement(lnkSetting, Timeout.short_time.getValue());
	}

	protected WebElement getLnkAddPage() {
		return Utilities.findElement(lnkAddPage, Timeout.short_time.getValue());
	}

	protected WebElement get_AddPage_BtnOk() {
		return Utilities.findElement(btnAddPage_OK, Timeout.short_time.getValue());
	}
	
	protected WebElement get_AddPage_txtPageName() {
		return Utilities.findElement(txtPageName, Timeout.short_time.getValue());
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

	public void click_lnkSetting() {
		getLnkSetting().click();
		Utilities.waitElement(lnkAddPage);
	}

	public void gotoDashboard_AddPage() {
		click_lnkSetting();
		getLnkAddPage().click();
		Utilities.waitElement(btnAddPage_OK);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public boolean checkControlIsClickable(WebElement element) {
		try {
			clickElement(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}