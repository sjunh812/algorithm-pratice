package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy2437 {
	
	ArrayList<Integer> list = new ArrayList<>();
	
    public void solution() throws Exception {  
    	input();
    	
    	Collections.sort(list);
    
    	int result = 0;
    	int sum = 0;
    	
    	
    	for(int i = 0; i < list.size(); i++) {
    		if(i == 0 && list.get(i) != 1) {
    			result = 1;
    			break;
    		}
    		
    		if(sum + 1 < list.get(i)) {
    			result = sum + 1;
    			break;
    		} else {
    			sum += list.get(i);
    		}
    	
    	}
    	
    	if(result == 0) result = sum + 1;
    	
    	System.out.println(result);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy2437().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	list.add(Integer.parseInt(st.nextToken()));
        }
    }

}