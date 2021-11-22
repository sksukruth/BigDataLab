package average;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;

public class driver{
	public static void main(String[] args) throws Exception{
		if(args.length!=2){
			System.out.println("Arguements length not proper");
			System.exit(-1);
		}
		JobConf conf = new JobConf(driver.class);
		conf.setMapperClass(mapper.class);
		conf.setReducerClass(reducer.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(FloatWritable.class);
		FileInputFormat.addInputPath(conf,new Path(args[0]));
		FileOutputFormat.setOutputPath(conf,new Path(args[1]));
		JobClient.runJob(conf);
	}
}
