/**
 * 
 */
package Dashboard;

import org.testng.Assert;
import org.testng.annotations.Test;
import Dashboard.DataObjects.Account;
import Dashboard.DataObjects.REPO;


/**
 * @author an.son
 *
 */
public class DA_CEA_NP extends TestBase {

	@Test
	private void DA_LOGIN_TC014() {
		System.out.println(
				"DA_LOGIN_TC014	Verify when \"New Page\" control/form is brought up to focus all other control within Dashboard page are locked and disabled");
		LoginPage login = new LoginPage();
		MainPage mainpage = login.open().Login(REPO.SP.getValue(), Account.ID.getValue(), Account.BLANK.getValue());
		mainpage.gotoDashboard_AddPage();
		boolean ActualResult = mainpage.checkControlIsClickable(mainpage.lblProfileName());
		// Assert.assertEquals(ActualResult, false, "The message does not display as
		// expected ");
		Assert.assertFalse(ActualResult, "Control on MainPage is not met unclickable required attribute");
	}

}
