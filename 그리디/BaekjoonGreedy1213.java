package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy1213 {
	
	String input = "";
	
	public class Info implements Comparable<Info> {

		char c;
		int i;
		
		public Info(char c, int i) {
			this.c = c;
			this.i = i;
		}
		
		@Override
		public int compareTo(Info o) {
			if(this.c > o.c) return 1;
			else if(this.c < o.c) return -1;
			else return 0;
		}
		
	}
	
    public void solution() throws Exception {  	
    	input();
    
    	Map<Character, Integer> map = new HashMap<>();
    
    	// Set Map
    	for(int i = 0; i < input.length(); i++) {
    		char c = input.charAt(i);
    		
    		if(map.containsKey(c)) {
    			map.replace(c, map.get(c) + 1);
    		} else {
    			map.put(c, 1);
    		}
    	}
    	
    	String result = "";
    	boolean isOdd = (input.length() % 2 != 0);	
    	int oddCnt = 0;
    	PriorityQueue<Info> pq = new PriorityQueue<>();
    	
    	// Set PriorityQueue
    	Iterator<Character> iterator = map.keySet().iterator();
    	while(iterator.hasNext()) {
    		char key = iterator.next();
    		int value = map.get(key);
    		
    		if(value % 2 != 0) {
    			oddCnt++;
    		}
    		
    		pq.add(new Info(key, value));
    	}
    	
    	// Check possible
    	if((isOdd & oddCnt > 1) || (!isOdd & oddCnt > 0)) {
    		result = "I'm Sorry Hansoo";
    	} else {
    		String evenStr = "";
    		String oddStr = "";
    		
    		while(!pq.isEmpty()) {
    			Info info = pq.poll();
    			if(info.i % 2 == 0) {
    				for(int i = 0; i < info.i / 2; i++) {
    					evenStr += info.c;
    				}
    			} else if(info.i > 1) {	// 3,5,7..
    				for(int i = 0; i < info.i / 2; i++) {
    					evenStr += info.c;
    				}
    				oddStr += info.c;
    			} else {
    				oddStr += info.c;
    			}
    		}
    
    		result = evenStr + oddStr + new StringBuilder(evenStr).reverse().toString();
    	}
    	
    	System.out.println(result);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1213().solution();
    }
    
    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
    }

}