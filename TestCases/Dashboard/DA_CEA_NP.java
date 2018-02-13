/**
 * 
 */
package Dashboard;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import Dashboard.DataObjects.Account;
import Dashboard.DataObjects.REPO;
import common.Utilities;

/**
 * @author an.son
 *
 */
public class DA_CEA_NP extends TestBase {

	@Test
	private void DAMPTC014() {
		System.out.println(
				"DA_MP_TC014_Verify when \"New Page\" control/form is brought up to focus all other control within Dashboard page are locked and disabled");
		LoginPage login = new LoginPage();
		MainPage mainpage = login.open().Login(REPO.SP.getValue(), Account.ID.getValue(), Account.BLANK.getValue());
		mainpage.gotoDashboardAddPage();
		boolean ActualResult = mainpage.isControlIsClickable(mainpage.getLnkSetting());
		Assert.assertFalse(ActualResult, "Control on MainPage is not met unclickable required attribute");
	}

	@Test
	private void DAMPTC015() {
		System.out.println(
				"DA_MP_TC015_Verify user is able to add additional pages besides \"Overview\" page successfully");
		String pageName = Utilities.UniqueObjectString("Pg_", 6);
		LoginPage login = new LoginPage();
		MainPage mainpage = login.open().Login(REPO.SP.getValue(), Account.ID.getValue(), Account.BLANK.getValue());
		mainpage.gotoDashboardAddPage();
		mainpage.setTextToAddPageTxtPageName(pageName);
		mainpage.clickAddPageBtn();
		String actualNextName = mainpage.getNextTagNameByIndex(2);	
		mainpage.deleteMultiPage(2);
		Assert.assertEquals(actualNextName, pageName, "The new page is not exactly created next to the right of \"Overview\" tag");

	}
// UNCOMPLETE----------------------------------------------------------------------------------------
	@Test
	private void DAMPTC016() {
		System.out.println(
				"DA_MP_TC016_Verify the newly added main parent page is positioned at the location specified as set with \"Displayed After\" field of \"New Page\" form on the main page bar/\"Parent Page\" dropped down menu");
		String pageName1 = Utilities.UniqueObjectString("Pg_", 6);
		LoginPage login = new LoginPage();
		MainPage mainpage = login.open().Login(REPO.SP.getValue(), Account.ID.getValue(), Account.BLANK.getValue());
		mainpage.gotoDashboardAddPage();
		mainpage.setTextToAddPageTxtPageName(pageName1);
		mainpage.clickAddPageBtn();
		String pageName2= Utilities.UniqueObjectString("Pg_", 6);
		mainpage.gotoDashboardAddPage();
		mainpage.setTextToAddPageTxtPageName(pageName2);
		mainpage.selectCbbOption(pageName1);
		mainpage.clickAddPageBtn();	
		String actualNextName = mainpage.getNextTagNameByIndex(3);
		String expectedName = mainpage.getNextTagNameByIndex(mainpage.getTagIndexByName(pageName1)+1);
		mainpage.deleteMultiPage(3);
		Assert.assertEquals(actualNextName, expectedName, "The new page is not exactly created next to the right of \"Overview\" tag");
	}
	
	@Test
	private void DAMPTC017() {
		System.out.println(
				"DA_MP_TC016_Verify the newly added main parent page is positioned at the location specified as set with \"Displayed After\" field of \"New Page\" form on the main page bar/\"Parent Page\" dropped down menu");
		String pageName = Utilities.UniqueObjectString("Pg_", 6);
		LoginPage login = new LoginPage();
		MainPage mainpage = login.open().Login(REPO.SP.getValue(), Account.ID.getValue(), Account.BLANK.getValue());
		mainpage.gotoDashboardAddPage();
		mainpage.setTextToAddPageTxtPageName(pageName);
		mainpage.clickAddPageBtn();
		login = mainpage.Logout();
		mainpage = login.open().Login(REPO.SP.getValue(), Account.ID_TEST.getValue(), Account.BLANK.getValue());
		boolean pagepresent = mainpage.isNewPagePresent(pageName);
		login = mainpage.Logout();
		mainpage = login.Login(REPO.SP.getValue(), Account.ID.getValue(), Account.BLANK.getValue());
		mainpage.deleteMultiPage(2);
		Assert.assertTrue(pagepresent, "The new page does not display with other username with different account type");
	}
	
	@Test
	private void DAMPTC018() {
		System.out.println(
				"DA_MP_TC016_Verify the newly added main parent page is positioned at the location specified as set with \"Displayed After\" field of \"New Page\" form on the main page bar/\"Parent Page\" dropped down menu");
		String pageName= Utilities.UniqueObjectString("Pg_", 6);
		LoginPage login = new LoginPage();
		MainPage mainpage = login.open().Login(REPO.SP.getValue(), Account.ID.getValue(), Account.BLANK.getValue());
		mainpage.gotoDashboardAddPage();
		mainpage.setTextToAddPageTxtPageName(pageName);
		mainpage.clickAddPageBtn();	
		pageName= Utilities.UniqueObjectString("Pg_", 6);
		mainpage.gotoDashboardAddPage();
		mainpage.setTextToAddPageTxtPageName(pageName);
		mainpage.clickAddPageBtn();	
		//String actualNextName = mainpage.getNextTagName(2);
		//Assert.assertEquals(actualNextName, pageName, "The new page is not exactly created next to the right of \"Overview\" tag");
	}
}
