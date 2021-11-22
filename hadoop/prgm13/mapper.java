package sales;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Reporter;

public class mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>{
	public void map(LongWritable slno,Text data,OutputCollector<Text,IntWritable> values,Reporter r) throws IOException{
		String country = data.toString().split(",")[7];
		if(country.equals("country"))
			return;
		values.collect(new Text(country),new IntWritable(1));
	}
}