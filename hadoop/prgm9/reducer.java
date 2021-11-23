package oddeve;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class reducer extends MapReduceBase implements Reducer<Text,IntWritable,Text,IntWritable>{
	public void reduce(Text key,Iterator<IntWritable> numbers,OutputCollector<Text,IntWritable> values,Reporter r) throws IOException{
		int sum=0,count=0;
		while(numbers.hasNext()){
			int n = numbers.next().get();
			count++;
			sum+=n;
		}
		values.collect(new Text(key.toString()+" count : "),new IntWritable(count));
		values.collect(new Text(key.toString()+" sum   : "),new IntWritable(sum));
	}
}