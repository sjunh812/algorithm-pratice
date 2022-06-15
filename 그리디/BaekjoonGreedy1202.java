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
	PriorityQueue<Jewel> jewels = new PriorityQueue<>();	// 보석 정보(무게,가격)
	PriorityQueue<Long> bags = new PriorityQueue<>();	// 가방 정보(무게)
	
    public class Jewel implements Comparable<Jewel> {
    	
    	int m;	// 무게
    	int v;	// 가격
    	
    	public Jewel(int m, int v) {
    		this.m = m;
    		this.v = v;
    	}

		@Override
		public int compareTo(Jewel o) {
			if(this.v > o.v) 
				return -1;
			else if(this.v < o.v) 
				return 1;
			else {
				if(this.m < o.m) return -1;
				else if(this.m > o.m) return 1;
			}

			return 0;
		}
    
    }
	
    public void solution() throws Exception {  
    	input();
        
        long result = 0;	// 훔칠 수 있는 최대 가격
        
        for(long weight : bags) {        	
        	Iterator<Jewel> it = jewels.iterator();
        	
        	while(it.hasNext()) {
        		Jewel jewel = it.next();
        		int m = jewel.getM();
        		int v = jewel.getV();
        		
        		if(weight >= m) {
        			it.remove();
        			result += v; 
        			break;
        		}
        	}    	
        }

        System.out.println(result); 
    }
    
    public void binarySearch(long key, int low, int high) {
    	int mid;
    	
    	while(low <= high) {
    		mid = (low + high) / 2;
    		
    		if(jewels.)
    	}
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