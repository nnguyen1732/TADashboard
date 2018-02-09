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

	@DataProvider(name = "Login Authority")
	public static Object[][] loginData() {
		return new Object[][] { {"SampleRepository", "Administrator", "", true },
				{ "SampleRepository", "test", "test", false } };
	}
}
