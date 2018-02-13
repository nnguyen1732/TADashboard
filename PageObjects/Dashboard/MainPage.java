/**
 * 
 */
package Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import constant.Constant;
import constant.Constant.*;
import common.Utilities;

/**
 * @author an.son
 *
 */
public class MainPage {
	// locator
	private static final By ProfileName = By.xpath("//a[@href='#Welcome']");
	private static final By btnLogOut = By.xpath("//a[@href=\"logout.do\"]");
	private static final By lnkSetting = By.xpath("//li[@class=\"mn-setting\"]/a[@href=\"javascript:void(0);\"]");
	private static final By lnkAddPage = By
			.xpath("//li[@class=\"mn-setting\"]//a[contains(@href,\"Dashboard.openAddPageForm\")]");
	private static final By btnAddPage_OK = By.xpath("//input[@id=\"OK\"]");
	private static final By txtPageName = By.xpath("//input[@id='name']");
	private static final By btnAddPageCancel = By.xpath(".//input[@id='Cancel']");
	private static final String tagMainPageLocator = "//div[@id='main-menu']/div[@class='container']/ul/li[%d]/a";
	private static final By lnkDeletePage = By.xpath("//li[@class='mn-setting']//a[@class='delete']");
	private static final By cbbDisplayAfter = By.xpath("//div[@class='pbox']//tr/td/select[@id='afterpage']");
	private static final String tagPageLocator = "//div[@id='main-menu']/div[@class='container']//a[text()='%s']";
	private static final By cbbParent = By.xpath("//select[@id='parent']");
	private static final By cbbColumnNumber = By.xpath("//select[@id='columnnumber']");
	private static final By chkPublic = By.xpath("//input[@id='ispublic']");

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

	protected Select getCbbDisplayAfter() {
		return new Select(Utilities.findElement(cbbDisplayAfter, Timeout.short_time.getValue()));
	}

	protected Select getCbbColumn() {
		return new Select(Utilities.findElement(cbbColumnNumber, Timeout.short_time.getValue()));
	}

	private Select getCbbParent() {
		return new Select(Utilities.findElement(cbbParent, Timeout.short_time.getValue()));
	}

	private WebElement getChkPhublic() {
		return Utilities.findElement(chkPublic, Timeout.short_time.getValue());
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
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Timeout.long_time.getValue());
		clickElement(element);
		clickElement(getLnkSetting());
		clickElement(getlnkDeletePage());
		wait.until(ExpectedConditions.alertIsPresent());
		Constant.WEBDRIVER.switchTo().alert().accept();
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	private Integer getIndexInCbbList(String page) {
		int i = 0;

		while (!getCbbDisplayAfter().getOptions().get(i).getText().equals(page)) {
			i += 1;
		}
		return i;
	}

	public void deleteMultiPage(int index) {
		while (index > 1) {
			this.deletePage(elementLocator(String.format(tagMainPageLocator, index)));
			index--;
		}
	}

	public void selectCbbOption(String page) {
		getCbbDisplayAfter().selectByIndex(this.getIndexInCbbList(page));
	}

	public boolean isNewPagePresent(String name) {
		return Utilities.checkElementExist(By.xpath(String.format(tagPageLocator, name)));
	}

	public void addPage(String name, String parent, String column, String after, String state) {
		if (name == "" || Utilities.isNumber(column))
			Assert.fail("Invalid data input");
		else {
			setTextToAddPageTxtPageName(name);
			if (parent != "") {
				System.out.println("22222222222222222222222222");
				getCbbParent().selectByVisibleText(parent);
			}
			if (!column.equals("")) {
				if (Integer.parseInt(column) > 0)
					try {
						System.out.println("11111111111111111111111");
						getCbbColumn().selectByValue(column);
					} catch (Exception e) {
						Assert.fail("Invalid data input");
					}
			}
			if (after != "") {
				try {
					getCbbDisplayAfter().selectByValue(after);
				} catch (Exception e) {
					Assert.fail("Invalid data input");
				}
			}
			if (state != "" && (state == "on" || state == "off")) {
				if (state == "on" && !getChkPhublic().isSelected()) {
					getChkPhublic().click();
				}
				if (state == "off" && getChkPhublic().isSelected()) {
					getChkPhublic().click();
				}
			} else {
				Assert.fail("Invalid data input");
			}
		}
		// clickElement(get_AddPage_BtnOk());
		// Utilities.waitElement(By.xpath(String.format(tagPageLocator, name)));
	}

	private void hoverOnElement(WebElement element) {
		Actions action = new Actions(Constant.WEBDRIVER);
		action.moveToElement(element);
	}

	public void moveToElementTag(String element) {
		hoverOnElement(
				Utilities.findElement(By.xpath(String.format(tagPageLocator, element)), Timeout.short_time.getValue()));
	}

	public void movetoChildElement(String parent, String child) {
		try {
			moveToElementTag(parent);
			moveToElementTag(child);
			clickElement(Utilities.findElement(By.xpath(String.format(tagPageLocator, child)),
					Timeout.short_time.getValue()));
		} catch (Exception e) {

		}

	}
}