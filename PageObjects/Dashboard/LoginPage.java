/**
 * 
 */
package Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Dashboard.DataObjects.Account;
import Dashboard.DataObjects.REPO;
import common.Utilities;
import constant.Constant;
import constant.Constant.Timeout;

/**
 * @author an.son
 *
 */
public class LoginPage {
	
	private final By cbbRepo = By.xpath("//*[@id=\"repository\"]");
	private final By txtUsername = By.xpath("//input[@id=\"username\" and @class=\"input\"]");
	private final By txtPassword = By.xpath("//input[@id=\"password\" and @class=\"input\"]");
	private final By btnLogin = By.xpath("//div[@class=\"btn-login\"]");
		
		private WebElement getCbbRepository() {
			return Constant.WEBDRIVER.findElement(cbbRepo);
		}
		
		private WebElement getTxtID() {
			return Constant.WEBDRIVER.findElement(txtUsername);
		}
		
		private WebElement getTxtPW() {
			return Constant.WEBDRIVER.findElement(txtPassword);
		}
		
		private WebElement getBtnLogin() {
			return Constant.WEBDRIVER.findElement(btnLogin);
		}
		
		private Select selectCbbRepository() {
			return new Select(getCbbRepository());
		}
			
		public LoginPage open() {
			// TODO Auto-generated constructor stub
			Constant.WEBDRIVER.navigate().to(Constant.DASHBOARD_URL);
			Utilities.waitElement(cbbRepo);
			return this;
		}
		
		public MainPage Login(String Repo, String ID, String password) {
			Utilities.waitElement(btnLogin);
			this.selectCbbRepository().selectByVisibleText(Repo);
			this.getTxtID().sendKeys(ID);
			this.getTxtPW().sendKeys(password);
			this.getBtnLogin().click();	
			return new MainPage();
		}
		
		

}
