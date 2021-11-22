package insurance;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.MapReduceBase;

public class mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>{
	public void map(LongWritable slno,Text data,OutputCollector<Text,IntWritable> values,Reporter r) throws IOException{
		IntWritable one = new IntWritable(1);
		String construction = data.toString().split(",")[16];
		if(construction.equals("construction"))
			return;
		values.collect(new Text(construction),one);
	}
}