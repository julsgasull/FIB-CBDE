package cbde.labs.hbase_mapreduce.writer;

import java.io.IOException;
import wineinfo.avro.WineInfo;

public interface MyWriter {

    public void open(String file) throws IOException;

    public void put(WineInfo w);

    public void reset();

    public int flush() throws IOException;

    public void close() throws IOException;

}
