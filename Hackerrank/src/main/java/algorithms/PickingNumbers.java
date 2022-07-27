package algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultPickingNumbers {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
    	
    	int pickNum;
    	int longest = 1;
    	for (int i = 0; i < a.size(); i++) {
			
    		pickNum = a.get(i);
        	int minSize = 1;
        	int maxSize = 1;
    		
    		for (int j = i+1; j < a.size(); j++) {
				
    			if(pickNum == a.get(j)) {
    				minSize++;
    				maxSize++;
    			}
    			if(pickNum - a.get(j) == 1) {
    				minSize++;
    			}
    			if(pickNum - a.get(j) == -1) {
    				maxSize++;
    			}
			}
    		
    		if(minSize > longest) longest = minSize;
    		if(maxSize > longest) longest = maxSize;
		}

    	return longest;
    }

}

public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());*/

    	List<Integer> a = Arrays.asList(4,6,5,3,3,1,4,8,7,45,3,67,4);
        int result = ResultPickingNumbers.pickingNumbers(a);

        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
