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
		ID("administrator"), BLANK(""), INVALID_ID("Test"), INVALID_PASS("123"), TEST_ID("test"), TEST_PASS(
				"test"), UPPER_TEST_PASS(
						"TEST"), UPPER_TEST_ID("TEST"), SPCHARACTER_TEST_PASS("test@#"), SPCHARACTER_ID("test@!"), ID_TEST("john");
		private final String user;

		Account(final String username) {
			user = username;
		}

		public String getValue() {
			return user;
		}
	}
	
	public static enum DataType {
		BLANK(""), ON("on"), OFF("off");
		private final String datatype;

		DataType(final String data) {
			datatype = data;
		}

		public String getValue() {
			return datatype;
		}
	}

}
