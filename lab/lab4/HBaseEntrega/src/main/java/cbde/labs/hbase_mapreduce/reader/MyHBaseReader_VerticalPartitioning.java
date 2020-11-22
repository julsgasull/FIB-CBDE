package cbde.labs.hbase_mapreduce.reader;

public class MyHBaseReader_VerticalPartitioning extends MyHBaseReader {

	protected String[] scanFamilies() {
		String[] families = new String[1];
		families[0] = "type_reg_flav";
		return families;
	}

}
