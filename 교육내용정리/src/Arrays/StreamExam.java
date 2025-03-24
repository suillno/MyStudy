package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExam {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		int[] list2 = {1,2,3,4,5,6};
		
		int ln = Arrays.stream(list2).sum();

		
		
		
	}

}
