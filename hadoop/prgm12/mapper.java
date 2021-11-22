package average;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.OutputCollector;
// import org.apache.hadoop

public class mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,FloatWritable> {
	public void map(LongWritable key,Text info,OutputCollector<Text,FloatWritable> values,Reporter r) throws IOException{
		String array[] = info.toString().split("\\t");
		values.collect(new Text(array[3]),new FloatWritable(Float.parseFloat(array[8])));
	}
}