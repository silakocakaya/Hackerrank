package algorithms;

class ResultRepeatedString {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
    // Write your code here
    	
    	int len = s.length();
    	long rep = n/len;
    	long mod = n%len;
    	
    	int numOfa = 0;
    	int numOfModa = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == 'a') {
    			numOfa++;
    		}
    		if(mod != 0 && i < mod) {
        		if(s.charAt(i) == 'a') {
        			numOfModa++;
        		}
    		}
    	}
    	return ((rep*numOfa) + numOfModa);

    }

}

public class RepeatedString {

    public static void main(String[] args) {

        String s = "a";

        long n = 1000000000000l;

        long result = ResultRepeatedString.repeatedString(s, n);

        System.out.println(result);
    }
}
