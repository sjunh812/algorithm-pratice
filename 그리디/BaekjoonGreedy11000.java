package sjh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy11000 {
	
	ArrayList<Lecture> lectures = new ArrayList<>();
	
	public class Lecture implements Comparable<Lecture> {
		
		int start;
		int end;
		
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			if(this.start > o.start) return 1;
			else if(this.start < o.start) return -1;
			else {
				if(this.end > o.end) return 1;
				else if(this.end < o.end) return -1;
			}
			return 0;
		}
		
	}
	
    public void solution() throws Exception {  	
    	input();
    	Collections.sort(lectures);
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	
    	for(Lecture l : lectures) {
    		if(pq.isEmpty()) pq.offer(l.end);
    		else {
    			if(pq.peek() <= l.start) {
    				pq.poll();
    				pq.offer(l.end);
    			} else {
    				pq.offer(l.end);
    			}
    		}
    	}
    	
    	System.out.println(pq.size());
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy11000().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	lectures.add(new Lecture(start, end));
        }
    }

}