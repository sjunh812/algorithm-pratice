package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class BaekjoonGreedy1715 {
	
	// 1. 정렬 사용(ArrayList)
	ArrayList<Integer> cards = new ArrayList<>();
	
	// 2. 우선순위 큐 사용(PriorityQueue)
	PriorityQueue<Integer> pq = new PriorityQueue<>(); 

    public void solution() throws Exception {  
    	input();
    
    	long result = 0;

		Collections.sort(cards);	
    	
    	while(true) {
    		if(cards.size() > 1) {
    			int sum = cards.get(0) + cards.get(1);
    			cards.remove(0);
    			cards.remove(0);
    			partSort(sum);
    			result += sum;
    		} else {
    			break;
    		}
    	}
    	
    	System.out.println(result);
    }
    
    public void solution2() throws Exception {
    	input2();
        
    	int result = 0;	
    	
    	while(true) {
    		if(pq.size() > 1) {
    			int sum = pq.poll() + pq.poll();
    			pq.add(sum);
    			result += sum;
    		} else {
    			break;
    		}
    	}
    	
    	System.out.println(result);
    }
    
    public void partSort(int add) {
    	int put = -1;
    	
    	for(int i = 0; i < cards.size(); i++) {
    		if(cards.get(i) >= add) {
    			put = i;
    			break;
    		}
    	}
    	
    	if(put == -1) {
        	cards.add(add);
    	} else {
        	cards.add(put, add);	
    	}
    }
    
    public static void main(String[] args) throws Exception {
//        new BaekjoonGreedy1715().solution();
        new BaekjoonGreedy1715().solution2();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	cards.add(Integer.parseInt(br.readLine()));
        }
    }
    
    public void input2() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	pq.add(Integer.parseInt(br.readLine()));
        }
    }

}