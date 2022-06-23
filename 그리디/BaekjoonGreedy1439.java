package sjh;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekjoonGreedy1439 {
	
	String input;
	
    public void solution() throws Exception {  	
    	input();
    	
    	int oneCnt = 0;
    	int zeroCnt = 0;
    	char[] charInput = input.toCharArray();
    	char before = ' ';
    	
    	for(int i = 0; i < charInput.length; i++) {
    		char c = charInput[i];
    		
    		if(i != 0) {
    			if(before != c) {
    				if(before == '1') oneCnt++;
    				else zeroCnt++;
    			}
    		} 
    		
    		if(i == charInput.length - 1) {
    			if(c == '1') oneCnt++;
				else zeroCnt++;
    		}
    		
    		before = c;
    	}
    	
    	if(oneCnt > zeroCnt) System.out.println(zeroCnt);
    	else System.out.println(oneCnt);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1439().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
    }

}