package matrix;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class reducer extends Reducer<Text,Text,Text,Text>{
	public void reduce(Text key,Iterable<Text> values,Context context)throws IOException,InterruptedException{
		HashMap<Integer,Float> hashA = new HashMap<>();
		HashMap<Integer,Float> hashB = new HashMap<>();
		for(Text item:values){
			String value[] = item.toString().split(",");
			System.out.println(key.toString()+","+item.toString());
			if(value[0].equals("A")){
				hashA.put(Integer.parseInt(value[1]),Float.parseFloat(value[2]));
			}
			else{
				hashB.put(Integer.parseInt(value[1]),Float.parseFloat(value[2]));				
			}
		}
		System.out.println("hash a : "+hashA+"\nhash b : "+hashB);
		int n = Integer.parseInt(context.getConfiguration().get("n"));
		float result=0.0f;
		for(int i=0;i<n;i++){
			float a = hashA.containsKey(i)?hashA.get(i):0.0f;
			float b = hashB.containsKey(i)?hashB.get(i):0.0f;
			result+=a*b;
		}
		if(result!=0.0f)
			context.write(null,new Text(key.toString()+","+Float.toString(result)));

	}
}