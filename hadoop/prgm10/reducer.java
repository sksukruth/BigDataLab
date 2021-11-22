package insurance;
import java.util.Iterator;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.MapReduceBase;

public class reducer extends MapReduceBase implements Reducer<Text,IntWritable,Text,IntWritable>{
	public void reduce(Text key,Iterator<IntWritable> buildings,OutputCollector<Text,IntWritable> values,Reporter r) throws IOException{
		int count=0;
		while(buildings.hasNext()){
			count+=buildings.next().get();
		}
		values.collect(key,new IntWritable(count));
	}
}