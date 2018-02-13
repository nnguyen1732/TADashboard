/**
 * 
 */
package Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

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
	private static final By lnkSetting = By.xpath("//li[@class=\"mn-setting\"]/a[@href=\"javascript:void(0);\"]");
	private static final By lnkAddPage = By
			.xpath("//li[@class=\"mn-setting\"]//a[contains(@href,\"Dashboard.openAddPageForm\")]");
	private static final By btnAddPage_OK = By.xpath("//input[@id=\"OK\"]");
	private static final By txtPageName = By.xpath("//input[@id='name']");
	private static final By btnAddPageCancel = By.xpath(".//input[@id='Cancel']");
	private static final String tagMainPageLocator = "//div[@id='main-menu']/div[@class='container']/ul/li[%d]/a";
	private static final By lnkDeletePage = By.xpath("//li[@class='mn-setting']//a[@class='delete']");

	public MainPage() {
		// TODO Auto-generated constructor stub
		if (ExpectedConditions.alertIsPresent() == null)
			Utilities.waitElement(ProfileName);

	}

	// element
	protected WebElement lblProfileName() {
		return Utilities.findElement(ProfileName, Timeout.short_time.getValue());
	}

	protected WebElement getlnkDeletePage() {
		return Utilities.findElement(lnkDeletePage, Timeout.short_time.getValue());
	}

	private WebElement elementLocator(String locator) {
		return Utilities.findElement(By.xpath(locator), Timeout.short_time.getValue());
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

	protected WebElement getAddPagetxtPageName() {
		return Utilities.findElement(txtPageName, Timeout.short_time.getValue());
	}

	private WebElement getAddPageBtnCancel() {
		return Utilities.findElement(btnAddPageCancel, Timeout.short_time.getValue());
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

	public void clicklnkSetting() {
		getLnkSetting().click();
		Utilities.waitElement(lnkAddPage);
	}

	public void gotoDashboardAddPage() {
		clicklnkSetting();
		getLnkAddPage().click();
		Utilities.waitElement(btnAddPage_OK);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void setTextToElement(WebElement element, String content) {
		element.sendKeys(content);
	}

	public void setTextToAddPageTxtPageName(String content) {
		setTextToElement(getAddPagetxtPageName(), content);
	}

	public boolean isControlIsClickable(WebElement element) {
		try {
			clickElement(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickAddPageCancel() {
		clickElement(this.getAddPageBtnCancel());
	}

	public void clickAddPageBtn() {
		this.get_AddPage_BtnOk().click();
		Utilities.waitElementNotExit(btnAddPage_OK);
	}

	private String getElementText(WebElement element) {
		return element.getText();
	}

	private String getName(String locator, int index) {
		if (this.getElementText(elementLocator(String.format(locator, index - 1))) != "") {
			try {
				String pageName = this.getElementText(elementLocator(String.format(locator, index)));
				return pageName;
			} catch (Exception e) {
				return String.format("Can not find the next element with [index = %d]", index);
			}
		} else {
			return String.format("Can not find the next element with [index = %d]", index);
		}

	}

	public String getNextTagNameByIndex(int pageIndex) {
		return getName(tagMainPageLocator, pageIndex);
	}

	private Integer getIndexByNameAndStringXpath(String name, String xpath) {
		int index = Constant.WEBDRIVER.findElements(By.xpath(xpath.replace("[%d]", ""))).size();
		String tmp = "";
		for (; index >= 0; index -= 1) {
			tmp = Constant.WEBDRIVER.findElement(By.xpath(String.format(xpath, index))).getText().trim();
			if (name.trim().equals(tmp)) {
				break;
			}
		}
		return index;
	}

	public Integer getTagIndexByName(String name) {
		return getIndexByNameAndStringXpath(name, tagMainPageLocator);
	}

	/*
	 * private Integer IndexOnLeft(int index) { return index - 1; }
	 */

	private void deletePage(WebElement element) {
		clickElement(element);
		clickElement(getLnkSetting());
		clickElement(getlnkDeletePage());
		Constant.WEBDRIVER.switchTo().alert().accept();
		new WebDriverWait(Constant.WEBDRIVER, Timeout.short_time.getValue()).until(ExpectedConditions.invisibilityOf(element));
	}

	public void deleteMultiPage(int index) {
		while (index > 1) {
			System.out.println(index);
			this.deletePage(elementLocator(String.format(tagMainPageLocator, index)));			
			index -- ;
		}
	}
}