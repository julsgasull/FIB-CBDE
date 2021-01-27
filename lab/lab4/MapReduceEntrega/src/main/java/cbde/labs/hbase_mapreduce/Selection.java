package cbde.labs.hbase_mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Selection extends JobMapReduce {

	public static class SelectionMapper extends Mapper<Text, Text, Text, Text> {

		public void map(Text key, Text value, Mapper.Context context) throws IOException, InterruptedException {
			if (key.toString().equals("type_1")) {
				// Obtain the parameters sent during the configuration of the job
				String[] selection = context.getConfiguration().getStrings("selection");
				// Since the value is a CSV, just get the lines split by commas
				String[] values = value.toString().split(",");
				String selectionValue = Utils.getAttribute(values, selection[0]);
				// Get the CSV position of the attributes, do the selection and emit it
				StringBuilder newValue = new StringBuilder(selectionValue);
				for (int i = 1; i < selection.length; i++) {
					selectionValue = Utils.getAttribute(values, selection[i]);
					newValue.append("," + selectionValue);
				}
				context.write(key, new Text(newValue.toString()));
			}
		}
	}


	public Selection() {
		this.input = null;
		this.output = null;
	}
	
	public boolean run() throws IOException, ClassNotFoundException, InterruptedException {
		Configuration configuration = new Configuration();
		// Define the new job and the name it will be given
		Job job = Job.getInstance(configuration, "Selection");
		configureJob(job,this.input, this.output);
	    // Let's run it!
	    return job.waitForCompletion(true);
	}

    public static void configureJob(Job job, String pathIn, String pathOut) throws IOException, ClassNotFoundException, InterruptedException {
		job.setJarByClass(Selection.class);
		// Set the mapper class it must use
		job.setMapperClass(Selection.SelectionMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		// No combiner or reducer classes for this example

		// The output will be LongWritable and Text
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		// The files and formats the job will read from/write to
		job.setInputFormatClass(SequenceFileInputFormat.class);
		FileInputFormat.addInputPath(job, new Path(pathIn));
		FileOutputFormat.setOutputPath(job, new Path(pathOut));
		// These are the parameters that we are sending to the job

		// també es pot afegir com a primer value el "type", però com que és key, no l'hem posat per redundància
		job.getConfiguration().setStrings("selection", 	 "region", "alc", "m_acid", "ash",
																		"alc_ash", "mgn", "t_phenols", "flav",
																		"nonflav_phenols", "proant", "col", "hue",
																		"od280/od315", "proline"
		);
    }
}
