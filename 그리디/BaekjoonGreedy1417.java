package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy1417 {
	
	int n;	// 후보수
	int dasom;
	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());	// 국회의원별 투표수를 담은 우선순위큐
	
    public void solution() throws Exception {  
    	input();
    	
    	int result = 0;
    	
    	while(!pq.isEmpty()) {
    		int v = pq.poll();
    		
    		if(v < dasom) {
    			break;
    		} else {
    			result++;
    			dasom++;
    			pq.add(--v);
    		}
    	}
    	
    	System.out.println(result);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1417().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dasom = Integer.parseInt(br.readLine());
        
        for(int i = 1; i < n; i++) {
        	int v = Integer.parseInt(br.readLine());
        	pq.add(v);
        }
    }

}