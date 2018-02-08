/**
 * 
 */
package Dashboard;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

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
