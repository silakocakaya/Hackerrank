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

class ResultIsFullScreen {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    	
    	String str = s.trim();
    	double sqrt = Math.sqrt(str.length());
    	int row = new BigDecimal(sqrt).setScale(0,RoundingMode.FLOOR).intValue();
    	int column = new BigDecimal(sqrt).setScale(0,RoundingMode.CEILING).intValue();
    	
    	if(row*column < str.length()) {
    		row++;
    	}
    	char[][] matrix = new char[row][column];
    	
    	char[] arr = str.toCharArray();
    	int indRow = 0;
    	int max = row*column;
    	for(int i = 0; i < max; i++) {
    		
    		int indCol = column;
    		if(i != 0 && i%indCol == 0) {
    			indRow++;
    		}
    		if(i < arr.length) {
    			matrix[indRow][i%indCol] = arr[i];
    		} else {
    			matrix[indRow][i%indCol] = ' ';
    		}
    	}
    	
    	StringBuilder out = new StringBuilder("");
    	for (int i = 0; i < column; i++) {
			
        	for (int j = 0; j < row; j++) {
        		
        		if(matrix[j][i] != ' ') {
        			out.append(matrix[j][i]);
        		}
    		}
        	out.append(" ");
		}
    	
    	return out.toString();
    }

}

public class IsFullScreen {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();

    	String s = "chillout";
        String result = ResultIsFullScreen.encryption(s);

        System.out.println(result);
    }
}
