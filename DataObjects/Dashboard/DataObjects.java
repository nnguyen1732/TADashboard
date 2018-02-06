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

}
