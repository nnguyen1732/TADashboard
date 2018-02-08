package Dashboard;

import org.testng.Assert;
import org.testng.annotations.Test;
import Dashboard.DataObjects.*;
import common.Utilities;
import common.Utilities.*;

/**
 * @author test
 *
 */
public class TestCases extends TestBase {

	@Test
	private void DA_LOGIN_TC001() {
		System.out.println(
				"DA_LOGIN_TC001_Verify user can log in specific repository successfully via Dashboard login page with correct credentials");
		// step 1: Navigate Dashboard login page
		// step 2: Select repository
		// step 3:Enter valid username and password
		// step 4:Click on "Login" button Verify Dashboard Mainpage appears
		LoginPage login = new LoginPage();
		MainPage generalpage = login.open().Login(REPO.SP, Account.ID, Account.PASS);
		Assert.assertEquals(generalpage.getProfileText(), Account.ID.getValue(), "User login failed");
	}

	@Test
	private void DA_LOGIN_TC002() {
		System.out.println(
				"STP_AC_TR002_Verify user fails to log in specific repository via Dashboard login page with incorrect credentials");

		// Step 1:Navigate Dashboard login page
		// Step 2:Select repository
		// Step 3:Enter invalid username and password
		// Step 4:Click on "Login" button
		// Step 5: Verify Dashboard Error message "Username or password is invalid"

		LoginPage login = new LoginPage();
		login.open().Login(REPO.SP, Account.INVALID_ID, Account.INVALID_PASS);
		String ActualMsg = Utilities.getBrowserFormMsg();
		Utilities.clickPopup();
		String ExpectedMsg = "Username or password is invalid";
		Assert.assertEquals(ActualMsg, ExpectedMsg, "The message message is not displayed as expected ");
	}

	@Test
	private void DA_LOGIN_TC003() {
		System.out.println(
				"STP_AC_TR003_Verify user fails to log in specific repository via Dashboard login page with correct username and incorrect password");
		// Step 1:Navigate Dashboard login page
		// Step 2:Select repository
		// Step 3:Enter invalid username and password
		// Step 4:Click on "Login" button
		// Step 5: Verify Dashboard Error message "Username or password is invalid"
		LoginPage login = new LoginPage();
		login.open().Login(REPO.SP, Account.ID, Account.INVALID_PASS);
		String ActualMsg = Utilities.getBrowserFormMsg();
		Utilities.clickPopup();
		String ExpectedMsg = "Username or password is invalid";
		Assert.assertEquals(ActualMsg, ExpectedMsg, "The message message is not displayed as expected ");
	}

	@Test
	private void DA_LOGIN_TC004() {
		System.out.println(
				"STP_AC_TR004_Verify user is able to log in different repositories successfully after logging out current repository");
		/**
		 * step 1: Navigate Dashboard login page step 2: Select repository step 3:Enter
		 * valid username and password step 4:Click on "Login" button Mainpage appears
		 * step 5: Click on "Logout" button step 6: Select a different repository
		 * Dashboard step 7: Enter valid username and password step 8: Click on "Login"
		 * button step 9: Verify Dashboard Mainpage appears
		 */
		LoginPage login = new LoginPage();
		MainPage generalpage = login.open().Login(REPO.SP, Account.ID, Account.PASS);
		// Assert.assertEquals(generalpage.getProfileText(),
		// Account.VALID_ID.getValue(), "User login failed");

		generalpage.lblProfileName().click();
		generalpage.getBtnLogOut().click();

		generalpage = login.open().Login(REPO.DB, Account.ID, Account.PASS);
		Assert.assertEquals(generalpage.getProfileText(), Account.ID.getValue(), "User login failed");

		// Constant.WEBDRIVER.manage().timeouts().implicitlyWait(3000,
		// TimeUnit.MILLISECONDS);
	}

	@Test
	private void DA_LOGIN_TC009() {
		System.out.println("DA_LOGIN_TC009	Verify \"Password\" input is case sensitive");
		// Step 1:Navigate Dashboard login page
		// Step 2:Select repository
		// Step 3:Enter invalid username and password
		// Step 4:Click on "Login" button
		// Step 5: Verify Dashboard Error message "Username or password is invalid"
		LoginPage login = new LoginPage();
		MainPage Main = login.open().Login(REPO.SP, Account.TEST_ID, Account.TEST_PASS);
		Main.Logout().Login(REPO.SP, Account.TEST_ID, Account.UPPER_TEST_PASS);
		String ActualMsg = Utilities.getBrowserFormMsg();
		Utilities.clickPopup();
		String ExpectedMsg = "Username or password is invalid";
		Assert.assertEquals(ActualMsg, ExpectedMsg, "The message message is not displayed as expected ");
	}
	
	@Test
	private void DA_LOGIN_TC010() {
		System.out.println("DA_LOGIN_TC010	Verify \"Username\" is not case sensitive");
		// Step 1:Navigate Dashboard login page
		// Step 2:Select repository
		// Step 3:Enter invalid username and password
		// Step 4:Click on "Login" button
		// Step 5: Verify Dashboard Error message "Username or password is invalid"
		LoginPage login = new LoginPage();
		MainPage Main = login.open().Login(REPO.SP, Account.TEST_ID, Account.TEST_PASS);
		Assert.assertEquals(Main.getProfileText(), Account.TEST_ID.getValue(), "User login failed");
		Main.Logout().Login(REPO.SP, Account.UPPER_TEST_ID, Account.TEST_PASS);
		String ActualMsg = Main.getProfileText();
		Main.Logout();
		Assert.assertEquals(ActualMsg, Account.TEST_ID.getValue(), "User login failed");
	}
	
	@Test
	private void DA_LOGIN_TC011() {
		System.out.println("DA_LOGIN_TC011_Verify password with special characters is working correctly");
		// Step 1:Navigate Dashboard login page
		// Step 2:Select repository
		// Step 3:Enter invalid username and password
		// Step 4:Click on "Login" button
		// Step 5: Verify Dashboard Error message "Username or password is invalid"
		LoginPage login = new LoginPage();
		MainPage Main = login.open().Login(REPO.SP, Account.TEST_ID, Account.TEST_PASS);
		Assert.assertEquals(Main.getProfileText(), Account.TEST_ID.getValue(), "User login failed");
		Main.Logout().Login(REPO.SP, Account.UPPER_TEST_ID, Account.UPPER_TEST_PASS);
		String ActualMsg = Main.getProfileText();
		Main.Logout();
		Assert.assertEquals(ActualMsg, Account.TEST_ID.getValue(), "User login failed");
	}
}
