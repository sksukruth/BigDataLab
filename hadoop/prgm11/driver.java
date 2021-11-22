package insurance;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.JobClient;

public class driver{
	public static void main(String[] args) throws Exception{
		if(args.length!=2){
			System.out.println("Arguements length not as expected");
			System.exit(-1);
		}
		JobConf conf = new JobConf(driver.class);
		conf.setMapperClass(mapper.class);
		conf.setReducerClass(reducer.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(conf,new Path(args[0]));
		FileOutputFormat.setOutputPath(conf,new Path(args[1]));

		JobClient.runJob(conf);
	}
}