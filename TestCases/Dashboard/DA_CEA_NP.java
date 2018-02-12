/**
 * 
 */
package Dashboard;

import org.testng.Assert;
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
		String pageName= Utilities.UniqueObjectString("Pg_", 6);
		LoginPage login = new LoginPage();
		MainPage mainpage = login.open().Login(REPO.SP.getValue(), Account.ID.getValue(), Account.BLANK.getValue());
		mainpage.gotoDashboardAddPage();
		mainpage.setTextToAddPageTxtPageName(pageName);
		mainpage.clickAddPageBtn();	
		String actualNextName = mainpage.getNextTagName();
		Assert.assertEquals(actualNextName, pageName, "The new page is not exactly created next to the right of \"Overview\" tag");
	}

}
