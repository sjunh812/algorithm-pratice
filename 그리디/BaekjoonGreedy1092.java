package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy1092 {
	
	int n;	// 크레인 수
	int m;	// 박스 수
	
	ArrayList<Integer> cranes = new ArrayList<>();
	ArrayList<Integer> boxes = new ArrayList<>();
	
    public void solution() throws Exception {  
    	input();
    	
    	Collections.sort(cranes);
    	Collections.reverse(cranes);
    	
    	Collections.sort(boxes);
    	Collections.reverse(boxes);
    	
    	int result = 0;
    	
    	if(cranes.get(0) < boxes.get(0)) {
    		result = -1;
    	} else {
        	while(!boxes.isEmpty()) {
        		result++;   		
        		int n = 0;
        		
        		for(int i = 0; i < cranes.size(); i++) {
        			int crane = cranes.get(i);
        			
        			for(int j = n; j < boxes.size(); j++) {
        				int box = boxes.get(j);
        				
        				if(crane >= box) {
        					boxes.remove(j);
        					break;
        				} else {
        					n = j;
        				}
        			}
        		}
        	}	
    	}
    	
    	System.out.println(result);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1092().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
     	StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	cranes.add(Integer.parseInt(st.nextToken()));
        }
        
        m = Integer.parseInt(br.readLine());
     	StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
        	boxes.add(Integer.parseInt(st2.nextToken()));
        }
    }

}