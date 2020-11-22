package cbde.labs.hbase_mapreduce.writer;

public class MyHBaseWriter_VerticalPartitioning extends MyHBaseWriter {
	/*
		Create 'wine2', 'type_reg_flav', 'others'
	*/
	protected String toFamily(String attribute) {
		if (attribute.equals("type") || attribute.equals("region") || attribute.equals("flav"))
			return "type_reg_flav";

		return "others";
	}

}