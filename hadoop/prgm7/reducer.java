package earthquake;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.OutputCollector;

public class reducer extends MapReduceBase implements Reducer<Text,FloatWritable,Text,FloatWritable>{
	public void reduce(Text key,Iterator<FloatWritable> latitudes,OutputCollector<Text,FloatWritable> values,Reporter r) throws IOException{
		while(latitudes.hasNext()){
			values.collect(key,latitudes.next());
		}
	}
}
