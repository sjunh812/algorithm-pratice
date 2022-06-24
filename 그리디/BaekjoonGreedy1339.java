package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class BaekjoonGreedy1339 {
	
	Map<Character, Integer> map = new HashMap<>();
	
    public void solution() throws Exception {
    	input();
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    	
    	// 1. Map을 순회하면서 PriorityQueue에 집어넣기
    	Iterator<Character> iterator = map.keySet().iterator();
    	while(iterator.hasNext()) {
    		char key = iterator.next();
    		int value = map.get(key);
    		System.out.println(key + ", " + value);
    		pq.add(value);
    	}
    	
    	// 2. PriorityQueue의 값을 poll()하면서 결과 값 계산
    	int result = 0;
    	int number = 9;
    	while(!pq.isEmpty()) {
    		result += number * pq.poll();
    		number--;
    	}
    	
    	System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1339().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	String str = br.readLine();
        	
        	for(int j = 0; j < str.length(); j++) {
        		char c = str.charAt(j);
        		int value = (int) Math.pow(10, str.length() - 1 - j);
        		
        		if(map.containsKey(c)) {
        			int oldValue = map.get(c);
        			map.replace(c, oldValue + value);
        		} else {
        			map.put(c, value);
        		}
        	}
        }
    }

}