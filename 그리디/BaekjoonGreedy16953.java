package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BaekjoonGreedy16953 {
	
	long a;
	long b;
	
    public void solution() throws Exception {
    	input();
    	
    	int result = 0;
    	long c = b;
    	
    	while(true) {
    		result++;
    		
    		if(c <= a) {
    			if(c < a) result = -1;
    			break;
    		}
    		
    		if(c % 10 == 1) {
    			c = c / 10;
    		} else if(c % 2 == 0) {
    			c /= 2;
    		} else {
    			result = -1;
    			break;
    		}
    		
			System.out.print(c + " ");
    	}
    	System.out.println("");
    	
    	System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy16953().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }

}