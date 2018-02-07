package Dashboard;



import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * @author test
 *
 */
public class TestCases extends TestBase {

	@Test
	private void TC01() {
		LoginPage login = new LoginPage();
		login.open().login(DataObjects.REPO.SP, DataObjects.Account.VALID_ID, DataObjects.Account.VALID_PASS);
		
	}
}
