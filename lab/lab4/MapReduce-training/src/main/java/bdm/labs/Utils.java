package bdm.labs;

public class Utils {

	private static final String[] attributes = new String[] {
			"age","workclass","fnlwgt","education","education_num","marital_status","relationship",
			"race","sex","capital_gain","capital_loss","hours_per_week","native_country"
	};

	public static String getAttribute(String[] row, String attribute) {
		for (int i = 0; i < attributes.length; i++) {
			if (attributes[i].equals(attribute)) {
				return row[i];
			}
		}
		return null;
	}
	
}
