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

//https://www.hackerrank.com/challenges/bigger-is-greater/problem
class Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */
	//Sondan baslayarak 2'li kontroller yap, bir onceki daha kucuk ise kucuk olani pivot olarak belirle,
	//Pivot sonrasi yani pivottan buyuk en kucuk elemani, buraya insert et ve string'in kalanini sortla
    public static String biggerIsGreater(String w) {
    
    	int length = w.length();
    	
    	for(int k = length-1; k>=1; k--) {
    		
        	for(int i=k; i>=1; i--) {
        			
    			if(w.charAt(i-1) <  w.charAt(i)) {
    				
    				char pivot = w.charAt(i-1);
    				char min = w.charAt(i);
    				int index = 0;
    				StringBuilder lastStr = new StringBuilder(w.substring(i,length));
    				for(int j= 0; j < lastStr.length(); j++) {
    					
    					if(lastStr.charAt(j) < min && lastStr.charAt(j) > pivot) {
    						min = lastStr.charAt(j);
    						index = j;
    					}
    				}
    				lastStr.deleteCharAt(index);
    				lastStr.append(w.charAt(i-1));
    				String lastString = lastStr.toString();
    				char[] wLast = lastString.toCharArray();
    				Arrays.sort(wLast);
    				String sorted = new String(wLast);
					return w.substring(0,i-1) + min + sorted;
    			}
        	}
    	}
    	
    	return "no answer"; 
    }

}

public class BiggerIsGreater {
    public static void main(String[] args) throws IOException {
    	
    	//System.out.println(Result.biggerIsGreater("ezxuqpj"));
    	
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\sila.kaya\\workspaceWork\\Hackerrank\\src\\main\\resources\\input01.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\sila.kaya\\workspaceWork\\Hackerrank\\src\\main\\resources\\output01.txt"));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
    
}
