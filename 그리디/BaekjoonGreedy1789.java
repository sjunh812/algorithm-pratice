package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekjoonGreedy1789 {
	
	long n;

    public void solution() throws Exception {  
    	input();
    	
    	long sum = 0;
    	long i = 0;
    	
    	while(true) {
    		if(sum + ++i > n) {
    			i--;
    			break;
    		}
    		sum += i;
    	}
    	
    	System.out.println(i);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1789().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
    }

}