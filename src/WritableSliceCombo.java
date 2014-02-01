import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.*;

public class WritableSliceCombo implements WritableComparable<WritableSliceCombo> {

		  private Integer first;
		  private Integer second;
		  
		  public WritableSliceCombo() {
		    set(new Integer(0), new Integer(0) );
		  }

		  public WritableSliceCombo(Integer first, Integer second) {
		    set(first, second);
		  }
		  
		  public void set(Integer integer, Integer integer2) {
		    this.first = integer;
		    this.second = integer2;
		  }
		  
		  public Integer getFirst() {
		    return first;
		  }

		  public Integer getSecond() {
		    return second;
		  }

		  @Override
		  public void write(DataOutput out) throws IOException {
			  out.write(first);
			  out.write(second);
		  }

		  @Override
		  public void readFields(DataInput in) throws IOException {
	        first = in.readInt();
            second = in.readInt();
		  }
		  
		  @Override
		  public int hashCode() {
		    return first.hashCode() * 163 + second.hashCode();
		  }
		  
		  @Override
		  public boolean equals(Object o) {
		    if (o instanceof WritableSliceCombo) {
		      WritableSliceCombo sc = (WritableSliceCombo) o;
		      return first.equals(sc.first) && second.equals(sc.second);
		    }
		    return false;
		  }

		  @Override
		  public String toString() {
		    return first.toString() + "," + second.toString();
		  }
		  
		  @Override
		  public int compareTo(WritableSliceCombo sc) {
		    int cmp = first.compareTo(sc.first);
		    if (cmp != 0) {
		      return cmp;
		    }
		    return second.compareTo(sc.second);
		  }
		
}