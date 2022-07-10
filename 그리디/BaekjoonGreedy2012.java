package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BaekjoonGreedy2012 {

	PriorityQueue<Integer> pq = new PriorityQueue<>();
	
    public void solution() throws Exception {  
    	input();
    	
    	long result = 0;
    	int i = 1;
    	
    	while(!pq.isEmpty()) {
    		result += Math.abs(pq.poll() - i++);
    	}
    	
    	System.out.println(result);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy2012().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	int rank = Integer.parseInt(br.readLine());
        	
        	pq.offer(rank);
        }
    }

}