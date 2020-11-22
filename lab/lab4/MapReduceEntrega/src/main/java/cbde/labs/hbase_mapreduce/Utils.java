package cbde.labs.hbase_mapreduce;

public class Utils {

	private static final String[] attributes = new String[] {
		"type",
		"region",
		"alc",
		"m_acid",
		"ash",
		"alc_ash",
		"mgn",
		"t_phenols",
		"flav",
		"nonflav_phenols",
		"proant",
		"col",
		"hue",
		"od280/od315",
		"proline"
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
