package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy2720 {
	
	int[] exchanges;
	int[] amounts = {25, 10, 5, 1};
	
    public void solution() throws Exception {
    	input();
    
    	
    	for(int exchange : exchanges) {
    		int ex = exchange;
    		
    		for(int amount : amounts) {    			
    			if(ex >= amount) {
    				System.out.print(ex / amount);
    				ex = ex % amount;
    			} else {
    				System.out.print(0);
    			}
    			
    			if(amount != 1) {
    				System.out.print(" ");
    			} else {
    				System.out.println();
    			}
    		}
    	}
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy2720().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        exchanges = new int[n];
        
        for(int i = 0; i < n; i++) {
        	exchanges[i] = Integer.parseInt(br.readLine());
        }
    }
    
}