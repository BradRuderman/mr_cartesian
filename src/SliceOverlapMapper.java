
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.util.Map.Entry;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class SliceOverlapMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String inputLine = value.toString();

		ArrayList<Integer> slices = getArray(inputLine);
		
	      for(int i=0;i<slices.size();i++){
	    	  for (int j=i+1; j < slices.size() - 1; j++){
	    		  context.write(new Text(slices.get(i).toString() + "\t" + slices.get(j).toString()), new IntWritable(1));
	    	  }
	      };
	}
	
   private ArrayList<Integer> getArray(String value){
    	String[] vals = value.toString().split("\\x01")[1].split("\\x02");
    	ArrayList<Integer> slices = new ArrayList<Integer>();
    	for (int i=0;i<vals.length;i++){
    		slices.add(Integer.parseInt(vals[i].split("\\x03")[0]));
    	};
    	return slices;
    }
	    
}