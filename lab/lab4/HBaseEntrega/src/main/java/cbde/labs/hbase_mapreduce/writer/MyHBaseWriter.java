package cbde.labs.hbase_mapreduce.writer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.BufferedMutator;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;

import wineinfo.avro.WineInfo;

public class MyHBaseWriter implements MyWriter {

    private Configuration config;
    private Connection connection;

    protected int key;

    protected HashMap<String,String> data;

    protected BufferedMutator buffer;

    public MyHBaseWriter() {
        this.key = 0;
        this.reset();
    }

    public void open(String tableName) throws IOException {
        this.config = HBaseConfiguration.create();
        config.set("hadoop.security.authentication", "simple");
        config.set("hadoop.security.authorization","false");
        config.set("hbase.security.authentication", "simple");
        config.set("hbase.security.authorization","false");
	config.set("hbase.zookeeper.quorum","PROVIDE HERE YOUR HOSTNAME OR IP");

        this.connection = ConnectionFactory.createConnection(this.config);
        this.buffer = this.connection.getBufferedMutator(TableName.valueOf(tableName));
    }

    protected String nextKey() {
        return String.valueOf(this.key);
    }

    protected String toFamily(String attribute) {
        return "all";
    }

    public void put(WineInfo w) {
        data.put("type", w.getType().toString());
        data.put("region", w.getRegion().toString());
        data.put("alc", w.getAlc().toString());
        data.put("m_acid", w.getMAcid().toString());
        data.put("ash", w.getAsh().toString());
        data.put("alc_ash", w.getAlcAsh().toString());
        data.put("mgn", w.getMgn().toString());
        data.put("t_phenols", w.getTPhenols().toString());
        data.put("flav", w.getFlav().toString());
        data.put("nonflav_phenols", w.getNonflavPhenols().toString());
        data.put("proant", w.getProant().toString());
        data.put("col", w.getCol().toString());
        data.put("hue", w.getHue().toString());
        data.put("od280od315", w.getOd280od315().toString());
        data.put("proline", w.getProline().toString());
    }

    public void reset() {
        data = new HashMap<String, String>();
    }

    public int flush() throws IOException {
        String rowKey = this.nextKey();
        System.out.println("Row with key "+rowKey+" outputted");

        // Create a new Put object with an incremental key
        Put put = new Put(rowKey.getBytes());

        // Now get all the columns
        Set<Entry<String,String>> entries = this.data.entrySet();
        int length = 0;
        for (Entry<String, String> entry : entries) {
            // Add the value in the Put object
            String attribute = entry.getKey();
            String family = this.toFamily(attribute);
            String value = entry.getValue();
            put.addColumn(family.getBytes(), attribute.getBytes(), value.getBytes());

            length += value.length();
        }
        // Insert it!
        this.buffer.mutate(put);

        this.key++;
        this.reset();
        return length;
    }

    public void close() throws IOException {
        this.buffer.flush();
        this.buffer.close();
        this.connection.close();
    }

}
