package cbde.labs.hbase_mapreduce.reader;

public class MyHBaseReader_KeyDesign extends MyHBaseReader {

	protected String scanStart() { return "type_3_0_"; }
	
	protected String scanStop() { return "type_3_0_a"; }
		
}
