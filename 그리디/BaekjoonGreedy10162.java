package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekjoonGreedy10162 {
	
	int t;
	
    public void solution() throws Exception {
    	input();
    	
    	boolean success = false;
    	int[] result = {0, 0, 0};
    	int n = t;
    	
    	// 300, 60, 10
    	while(true) {
    		if(n % 10 != 0) {
    			break;
    		}
    		
    		if(n >= 300) {
    			result[0] = n / 300;
    			n = n % 300;
    		} else if(n >= 60) {
    			result[1] = n / 60;
    			n = n % 60;
    		} else if(n >= 10) {
    			result[2] = n / 10;
    			n = n % 10;
    		}
    		
    		if(n == 0) {
    			success = true;
    			break;
    		}
    	}
    	
    	if(success) {
    		for(int i = 0; i < result.length; i++) {
    			System.out.print(result[i]);
    			if(i == result.length - 1) {
    				System.out.println();
    			} else {
    				System.out.print(" ");
    			}
    		}
    	} else {
    		System.out.println(-1);
    	}
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy10162().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
    }
    
}