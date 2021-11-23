package matrix;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.conf.*;

public class mapper extends Mapper<LongWritable,Text,Text,Text>{
	public void map(LongWritable slno,Text data,Context context)throws IOException,InterruptedException{
		Configuration conf = context.getConfiguration();
		int m = Integer.parseInt(conf.get("m"));
		int p = Integer.parseInt(conf.get("p"));

		String array[] = data.toString().split(",");
		if(array[0].equals("A")){
			for(int i=0;i<p;i++){
				Text key = new Text(array[1]+","+i);
				Text value = new Text("A,"+array[2]+","+array[3]);
				context.write(key,value);
			}
		}
		else{
			for(int i=0;i<m;i++){
				Text key = new Text(i+","+array[2]);
				Text value = new Text("B,"+array[1]+","+array[3]);
				context.write(key,value);
			}
		}
	}
}