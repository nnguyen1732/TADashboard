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
		SP("SampleRepository");
		private final String value;

		REPO(final String newValue) {
			value = newValue;
		}

		public String getValue() {
			return value;
		}
	}
	
	public static enum Account {
		VALID_ID("Administrator"), VALID_PASS("") ;
		private final String user;

		Account(final String username) {
			user = username;
		}

		public String getValue() {
			return user;
		}
	}

}