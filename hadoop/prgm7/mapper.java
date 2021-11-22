package earthquake;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.OutputCollector;

public class mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,FloatWritable>{
	public void map(LongWritable key,Text data,OutputCollector<Text,FloatWritable> values,Reporter r) throws IOException{
		String array[]=data.toString().split(","); 
		if (array.length!=12) {
			return;
		}
		values.collect(new Text(array[11]),new FloatWritable(Float.parseFloat(array[6])));
	}
}