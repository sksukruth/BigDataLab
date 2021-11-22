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
		String array[] = data.toString().split(",");
		String country = array[7];
		if(country.equals("country"))
			return;
		String transaction = array[3];
		values.collect(new Text(country+" , "+transaction),new IntWritable(1));
	}
}