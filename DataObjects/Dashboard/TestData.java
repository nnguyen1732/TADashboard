/**
 * 
 */
package Dashboard;

import org.testng.annotations.DataProvider;

/**
 * @author an.son
 *
 */
public class TestData {

	@DataProvider(name = "LonginAuthority")
	public static Object[][] loginData() {
		return new Object[][] { {"Administrator","","passed"},{"test","test", "failed"} };
	}
}
