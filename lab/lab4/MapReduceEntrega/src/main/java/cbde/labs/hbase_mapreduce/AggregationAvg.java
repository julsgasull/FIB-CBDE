package cbde.labs.hbase_mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;

import java.io.IOException;

public class AggregationAvg extends JobMapReduce {

	public AggregationAvg() {
		this.input = null;
		this.output = null;
	}
	
	public boolean run() throws IOException, ClassNotFoundException, InterruptedException {
		Configuration configuration = new Configuration();
		// Define the new job and the name it will be given
		Job job = Job.getInstance(configuration, "AggregationAvg");
		AggregationAvg.configureJob(job, this.input, this.output);
	    // Let's run it!
	    return job.waitForCompletion(true);
	}

	public static void configureJob(Job job, String pathIn, String pathOut) throws IOException, ClassNotFoundException, InterruptedException {
        job.setJarByClass(AggregationAvg.class);

        // Configure the rest of parameters required for this job
        // Take a look at the provided examples: Projection, AggregationSum and CartesianProduct
    }
}
