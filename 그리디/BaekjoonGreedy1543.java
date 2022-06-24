package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekjoonGreedy1543 {

	String document;
	String word;
	
    public void solution() throws Exception {
    	input();
    	
    	int len = word.length();
    	int before = -1;
    	int result = 0;
    	String tmp = "";
    	
    	for(int i = 0; i <= document.length() - len; i++) {    		
    		for(int j = 0; j < len; j++) {
        		char c = document.charAt(i + j);
        		
    			if(word.charAt(j) != c) {
        			tmp = "";
        			break;
        		} else {
        			tmp += c;
        		}
    		}
    		
    		if(!tmp.isEmpty()) {
    			tmp = "";
    			
    			if(before == -1 || before + len <= i) {
    				result++;
    	    		before = i;
    	    		i = i + len -1;
    			}
    		}
    	}
    	
    	System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1543().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        document = br.readLine();
        word = br.readLine();
    }

}