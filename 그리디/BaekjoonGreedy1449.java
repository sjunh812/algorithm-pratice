package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy1449 {

	int l;
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	
    public void solution() throws Exception {  
    	input();
    	
    	float start = 0f;
    	float end = 0f;
    	int result = 0;
    	
    	
    	while(!pq.isEmpty()) {
    		int spot = pq.poll();
    	
    		if(result == 0 || spot - 0.5f < start || spot + 0.5f > end) {
    			result++;
        		start = spot - 0.5f;
        		end = start + l;
    		}
    	}
    	
    	System.out.println(result);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1449().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());              
        for(int i = 0; i < n; i++) {
        	pq.add(Integer.parseInt(st.nextToken()));
        }
    }

}