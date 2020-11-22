package cbde.labs.hbase_mapreduce;

import java.io.IOException;

import cbde.labs.hbase_mapreduce.reader.MyHBaseReader;
import cbde.labs.hbase_mapreduce.reader.MyHBaseReader_KeyDesign;
import cbde.labs.hbase_mapreduce.reader.MyHBaseReader_VerticalPartitioning;
import cbde.labs.hbase_mapreduce.reader.MyReader;
import cbde.labs.hbase_mapreduce.writer.MyHBaseWriter;
import cbde.labs.hbase_mapreduce.writer.MyHBaseWriter_KeyDesign;
import cbde.labs.hbase_mapreduce.writer.MyHBaseWriter_VerticalPartitioning;
import cbde.labs.hbase_mapreduce.writer.MyWriter;
import wineinfo.avro.WineInfo;
import wineinfo.data_model.Generator;

public class Main {

	private static MyReader input;
	private static MyWriter output;
	private static String file;

    public static void read() throws IOException {
        input.open(file);
        String line = input.next();
        while (line != null) {
            if (!line.equals("")) {
                System.out.println(line);
            }
            line = input.next();
        }
        input.close();
    }

    public static void write(long number) throws IOException {
        output.open(file);
        for (int inst = 0; inst < number; ++inst) {
            WineInfo w = Generator.generateNewInstance(System.currentTimeMillis());
            output.put(w);
            output.flush();
        }
        output.close();
    }

	public static void main(String[] args) {
		try {
			if (args[0].equals("-write")) {
                if (args[1].equals("-hbase-all")) {
                    output = new MyHBaseWriter();
                    file = args[3]; //here, file is replaced for the table name in HBase
                }
                else if (args[1].equals("-hbase-vertical-partitioning")) {
                    output = new MyHBaseWriter_VerticalPartitioning();
                    file = args[3]; //here, file is replaced for the table name in HBase
                }
                else if (args[1].equals("-hbase-key-design")) {
                    output = new MyHBaseWriter_KeyDesign();
                    file = args[3]; //here, file is replaced for the table name in HBase
                }
                write(Integer.parseInt(args[2]));

            }
			else if (args[0].equals("-read")) {
                if (args[1].equals("-hbase-all")) {
                    input = new MyHBaseReader();
                }
                else if (args[1].equals("-hbase-vertical-partitioning")) {
                    input = new MyHBaseReader_VerticalPartitioning();
                }
                else if (args[1].equals("-hbase-key-design")) {
                    input = new MyHBaseReader_KeyDesign();
                }
                file = args[2]; //here, file is replaced for the table name in HBase
                read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
