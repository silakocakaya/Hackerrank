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

class ResultBeautifulDays {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

    public static int beautifulDays(int i, int j, int k) {

    	int beautifulDayCount = 0;
    	for(int l = i; l <= j; l++) {
    		
    		int ind = l;
    		String revIndStr = "";
    		while(true) {
    			
    			if(ind == 0) {
    				break;
    			}
    			int x = ind % 10;
    			revIndStr += x;
    			ind = ind / 10;
    		}
    		Integer revInd = Integer.parseInt(revIndStr);
    		
    		if(Math.abs(revInd-l) % k == 0) {
    			
    			beautifulDayCount++;
    		}
    	}
    	return beautifulDayCount;
    }

}

public class BeautifulDays {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    	
    	int result = ResultBeautifulDays.beautifulDays(20, 23, 6);
    	System.out.println(result);
    	
    }
}
