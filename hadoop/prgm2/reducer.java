package temp;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.OutputCollector;

public class reducer extends MapReduceBase implements Reducer<Text,IntWritable,Text,IntWritable>{
	public void reduce(Text key,Iterator<IntWritable> temperatures,OutputCollector<Text,IntWritable> values,Reporter r)throws IOException{
		int mintemp = Integer.MAX_VALUE;
		while(temperatures.hasNext()){
			int temp = temperatures.next().get();
			mintemp = Math.min(mintemp,temp);
		}
		values.collect(key,new IntWritable(mintemp));
	}
}