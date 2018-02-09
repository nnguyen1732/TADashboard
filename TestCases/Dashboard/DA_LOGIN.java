package Dashboard;

import org.testng.Assert;
import org.testng.annotations.Test;

import Dashboard.DataObjects.*;
import common.Utilities;

/**
 * @author test
 *
 */
public class DA_LOGIN extends TestBase {

	@Test
	private void DA_LOGIN_TC001() {
		System.out.println(
				"DA_LOGIN_TC001_Verify user can log in specific repository successfully via Dashboard login page with correct credentials");
		// step 1: Navigate Dashboard login page
		// step 2: Select repository
		// step 3:Enter valid username and password
		// step 4:Click on "Login" button Verify Dashboard Mainpage appears
		LoginPage login = new LoginPage();
		MainPage generalpage = login.open().Login(REPO.SP.getValue(), Account.ID.getValue(), Account.BLANK.getValue());
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
		login.open().Login(REPO.SP.getValue(), Account.INVALID_ID.getValue(), Account.INVALID_PASS.getValue());
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
		login.open().Login(REPO.SP.getValue(), Account.ID.getValue(), Account.INVALID_PASS.getValue());
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
		MainPage generalpage = login.open().Login(REPO.SP.getValue(), Account.ID.getValue(), Account.BLANK.getValue());
		generalpage.lblProfileName().click();
		generalpage.getBtnLogOut().click();
		generalpage = login.open().Login(REPO.DB.getValue(), Account.ID.getValue(), Account.BLANK.getValue());
		Assert.assertEquals(generalpage.getProfileText(), Account.ID.getValue(), "User login failed");
	}

	@Test
	private void DA_LOGIN_TC009() {
		System.out.println("DA_LOGIN_TC009	Verify \"Password\" input is case sensitive");
		LoginPage login = new LoginPage();
		MainPage Main = login.open().Login(REPO.SP.getValue(), Account.TEST_ID.getValue(),
				Account.TEST_PASS.getValue());
		Main.Logout().Login(REPO.SP.getValue(), Account.TEST_ID.getValue(), Account.UPPER_TEST_PASS.getValue());
		String ActualMsg = Utilities.getBrowserFormMsg();
		Utilities.clickPopup();
		String ExpectedMsg = "Username or password is invalid";
		Assert.assertEquals(ActualMsg, ExpectedMsg, "The message message is not displayed as expected ");
	}

	@Test
	private void DA_LOGIN_TC010() {
		System.out.println("DA_LOGIN_TC010	Verify \"Username\" is not case sensitive");
		LoginPage login = new LoginPage();
		MainPage Main = login.open().Login(REPO.SP.getValue(), Account.TEST_ID.getValue(),
				Account.TEST_PASS.getValue());
		Assert.assertEquals(Main.getProfileText(), Account.TEST_ID.getValue(), "User login failed");
		Main.Logout().Login(REPO.SP.getValue(), Account.UPPER_TEST_ID.getValue(), Account.TEST_PASS.getValue());
		String ActualMsg = Main.getProfileText();
		Main.Logout();
		Assert.assertEquals(ActualMsg, Account.TEST_ID.getValue(), "User login failed");
	}

	@Test
	private void DA_LOGIN_TC011() {
		System.out.println("DA_LOGIN_TC011_Verify password with special characters is working correctly");
		LoginPage login = new LoginPage();
		MainPage Main = login.open().Login(REPO.SP.getValue(), Account.TEST_ID.getValue(),
				Account.TEST_PASS.getValue());
		Assert.assertEquals(Main.getProfileText(), Account.TEST_ID.getValue(), "User login failed");
		Main.Logout().Login(REPO.SP.getValue(), Account.UPPER_TEST_ID.getValue(), Account.UPPER_TEST_PASS.getValue());
		String ActualMsg = Main.getProfileText();
		Main.Logout();
		Assert.assertEquals(ActualMsg, Account.TEST_ID.getValue(), "User login failed");
	}

	@Test
	private void DA_LOGIN_TC012() {
		System.out.println("DA_LOGIN_TC012_Verify username with special characters is working correctly");
		LoginPage login = new LoginPage();
		MainPage Main = login.open().Login(REPO.SP.getValue(), Account.SPCHARACTER_ID.getValue(),
				Account.TEST_PASS.getValue());
		String ActualMsg = Main.getProfileText();
		Main.Logout();
		Assert.assertEquals(ActualMsg, Account.TEST_ID.getValue(), "User login failed");
	}

	@Test
	private void DA_LOGIN_TC013() {
		System.out.println(
				"DA_LOGIN_TC013_Verify the page works correctly for the case when no input entered to Password and Username field");
		LoginPage login = new LoginPage();
		login.open().Login(REPO.SP.getValue(), Account.BLANK.getValue(), Account.BLANK.getValue());
		String ActualMsg = Utilities.getBrowserFormMsg();
		String ExpectedMsg = "Please enter username!";
		Assert.assertEquals(ActualMsg, ExpectedMsg, "The message does not display as expected ");
	}

	@Test(dataProvider = "Login Authority", dataProviderClass = TestData.class)
	private void DA_LOGIN_TC_TEST(String Repository, String username, String password, boolean ASD) {
		// System.out.println(TCID);
		// step 1: Navigate Dashboard login page
		// step 2: Select repository
		// step 3:Enter valid username and password
		// step 4:Click on "Login" button Verify Dashboard Mainpage appears
		LoginPage login = new LoginPage();
		MainPage generalpage = login.open().Login(Repository, username, password);
		Assert.assertEquals(generalpage.getProfileText(), Account.ID.getValue(), "User login failed");
	}
}
