package average;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.OutputCollector;
// import org.apache.hadoop

public class reducer extends MapReduceBase implements Reducer<Text,FloatWritable,Text,Text> {
	public void reduce(Text key,Iterator<FloatWritable> salaries,OutputCollector<Text,Text> values, Reporter r) throws IOException{
		int count = 0;
		Float total = 0.0F;
		while(salaries.hasNext()){
			total+=salaries.next().get();
			count++;
		}
		String op = "Total employees : "+count+", Total salary : "+total+", Average salary : "+(total/count);
		values.collect(key,new Text(op));
	}
}