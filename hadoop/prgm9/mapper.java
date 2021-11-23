package oddeve;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>{
	public void map(LongWritable slno,Text data,OutputCollector<Text,IntWritable> values,Reporter r)throws IOException{
		String numbers[] = data.toString().split(" ");
		for(String number:numbers){
			int num = Integer.parseInt(number);
			if(num%2==0){
				values.collect(new Text("even"),new IntWritable(num));
			}
			else{
				values.collect(new Text("odd"),new IntWritable(num));
			}
		}
	}
}