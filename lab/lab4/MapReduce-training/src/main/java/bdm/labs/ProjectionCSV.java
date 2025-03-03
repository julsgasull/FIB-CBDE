package bdm.labs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ProjectionCSV extends JobMapReduce {

    public ProjectionCSV() {
        this.input = null;
        this.output = null;
    }

    public boolean run() throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();

        // Define the new job and the name it will be given
        Job job = Job.getInstance(configuration, "ProjectionFromCSV");
        ProjectionCSV.configureJob(job,this.input,this.output);
        // Let's run it!
        return job.waitForCompletion(true);
    }

    public static void configureJob(Job job, String pathIn, String pathOut) throws IOException, ClassNotFoundException, InterruptedException {
        job.setJarByClass(ProjectionCSV.class);

        // Configure the rest of parameters required for this job
        
    }

}
