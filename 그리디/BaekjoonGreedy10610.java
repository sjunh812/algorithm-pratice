package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekjoonGreedy10610 {
	
	String n;
	
    public void solution() throws Exception {  	
    	input();
    	
    	String result = "-1";
    	int sum = 0;
    	char[] nchar = n.toCharArray();
    	
    	for(int i = 0; i < n.length(); i++) {
    		int num = Character.getNumericValue(n.charAt(i));
    		sum += num;
    	}
    	
    	if(!n.contains("0") || sum % 3 != 0) {
    		result ="-1"; 
    	} else {
    		Arrays.sort(nchar);
    		result = new StringBuilder(new String(nchar)).reverse().toString();
    	}
    	
		System.out.println(result);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy10610().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
    }

}