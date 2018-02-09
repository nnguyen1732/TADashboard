package Railway;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.collections.Lists;

public class test {
	public static Object[][] credentials() {

		return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" } };

	}

	public static Object[][] credentials1() {

		return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" } };

	}

	@DataProvider(name = "AD")
	public static Object[][] test() {
		List<Object[]> result = Lists.newArrayList();
		
		result.addAll(Arrays.asList(credentials()));
		result.addAll(Arrays.asList(credentials1()));
		return result.toArray(new Object[result.size()][]);
	}
}
