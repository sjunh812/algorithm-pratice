package sjh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy11000 {

	LinkedList<Lecture> lectures = new LinkedList<>();
	
	public class Lecture implements Comparable<Lecture> {
		
		long start;
		long end;
		
		public Lecture(long start, long end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Lecture o) {
			if(this.start > o.start) return 1;
			else if(this.start < o.start) return -1;
				
			return 0;
		}
		
	}
	
    public void solution() throws Exception {  
    	input();
    	Collections.sort(lectures);
    	
    	int result = 0;
    	Lecture compare = null;
    	
    	while(!lectures.isEmpty()) {
    		LinkedList<Lecture> temp = new LinkedList<>();
    		int size = lectures.size();
    		
    		for(int i = 0; i < size; i++) {
				Lecture l = lectures.poll();
				
				if(i == 0) {
					compare = l;
				} else {
					if(compare.end <= l.start) {
						compare = l;
					} else {
						temp.offer(compare);
					}
				}
			}

			lectures = temp;
    		result++;
    	}
    	
    	System.out.println(result);
    	
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy11000().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());	
        
        for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	long start = Long.parseLong(st.nextToken());
        	long end = Long.parseLong(st.nextToken());
        	lectures.add(new Lecture(start, end));
        }
    }

}