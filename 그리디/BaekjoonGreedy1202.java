package sjh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy1202 {
	
	int n;	// 보석 수
	int k;	// 가방 수
	ArrayList<Jewel> jewels = new ArrayList<>();	// 보석 정보(무게,가격)
	ArrayList<Long> bags = new ArrayList<>();	// 가방 정보(무게)
	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	
    public class Jewel implements Comparable<Jewel> {
    	
    	int m;	// 무게
    	int v;	// 가격
    	
    	public Jewel(int m, int v) {
    		this.m = m;
    		this.v = v;
    	}

		@Override
		public int compareTo(Jewel o) {
//			if(this.v > o.v) 
//				return -1;
//			else if(this.v < o.v) 
//				return 1;
//			else {
//				if(this.m < o.m) return -1;
//				else if(this.m > o.m) return 1;
//			}
			if(this.m > this.m) return 1;
			else if(this.m < this.m) return -1;
			else return 0;
		}
    
    }
	
    public void solution() throws Exception {  
    	input();
        
    	Collections.sort(bags);	// 무게 오름차순
    	Collections.sort(jewels);	// 무게 오름차순
    	
        long result = 0;	// 훔칠 수 있는 최대 가격
        int start = 0;
        
//        for(long weight : bags) {        	
//        	for(Jewel jewel : jewels) {
//        		int m = jewel.m;
//        		int v = jewel.v;
//        		
//        		if(weight >= m) {
//        			jewels.remove(jewel);
//        			result += v; 
//        			break;
//        		}
//        	}  	
//        }
        
        for(long weight : bags) {
        	for(int i = start; i < jewels.size(); i++) {
        		Jewel jewel = jewels.get(i);
        		
        		if(weight < jewel.m) {
        			start = i;
        			break;
        		} else {
        			pq.add(jewel.v);
        		}
        	}
        	
        	if(!pq.isEmpty()) {
        		result += pq.poll();
        	}
        }

        System.out.println(result); 
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1202().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int m = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	jewels.add(new Jewel(m, v));
        }
        
        for(int i = 0; i < k; i++) {
        	bags.add(Long.parseLong(br.readLine()));
        }
    }

}