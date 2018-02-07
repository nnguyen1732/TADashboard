/**
 * 
 */
package Dashboard;

/**
 * @author an.son
 *
 */
public class DataObjects {

	public static enum REPO {
		SP("SampleRepository"), DB("Dashboard");
		private final String value;

		REPO(final String newValue) {
			value = newValue;
		}

		public String getValue() {
			return value;
		}
	}

	public static enum Account {
		VALID_ID("administrator"), VALID_PASS(""), INVALID_ID("Test"), INVALID_PASS("123"), VALID_TEST_ID(
				"test"), VALID_TEST_PASS("test"), INVALID_TEST_PASS("TEST");
		private final String user;

		Account(final String username) {
			user = username;
		}

		public String getValue() {
			return user;
		}
	}

}
