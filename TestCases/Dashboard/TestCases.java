package Dashboard;



import org.testng.annotations.Test;
import Dashboard.DataObjects.*;

/**
 * @author test
 *
 */
public class TestCases extends TestBase {

	@Test
	private void TC01() {
		LoginPage login = new LoginPage();
		login.open().login(REPO.SP, Account.VALID_ID, Account.VALID_PASS);
		
	}
}
