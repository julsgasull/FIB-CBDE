package cbde.labs.hbase_mapreduce.writer;

public class MyHBaseWriter_KeyDesign extends MyHBaseWriter {

	protected String nextKey() {
		return data.get("type") + '_' + data.get("region") + '_' + key;
	}
		
}
