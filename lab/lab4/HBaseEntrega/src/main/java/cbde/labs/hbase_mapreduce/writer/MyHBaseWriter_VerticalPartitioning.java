package cbde.labs.hbase_mapreduce.writer;

public class MyHBaseWriter_VerticalPartitioning extends MyHBaseWriter {

	protected String toFamily(String attribute) {
		return null;
	}
		
}
