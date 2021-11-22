package sales;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Reporter;

public class reducer extends MapReduceBase implements Reducer<Text,IntWritable,Text,IntWritable>{
	public void reduce(Text key,Iterator<IntWritable> ones,OutputCollector<Text,IntWritable> values,Reporter r) throws IOException{
		int count=0;
		while(ones.hasNext()){
			count+=ones.next().get();
		}
		values.collect(key,new IntWritable(count));
	}
}