package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy1946 {
	
	public class Grade implements Comparable<Grade> {
		
		int document;
		int interview;
		
		public Grade(int d, int i) {
			document = d;
			interview = i;
		}

		@Override
		public int compareTo(Grade o) {
			if(this.document > o.document) return 1;
			else if(this.document < o.document) return -1;
			else {
				if(this.interview > o.interview) return 1;
				else if(this.interview < o.interview) return -1;
			}
			return 0;
		}
		
	}
	
    public void solution() throws Exception {  	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int caseCnt = Integer.parseInt(br.readLine());
    	int[] results = new int[caseCnt];
    	
    	for(int i = 0; i < caseCnt; i++) {
    		ArrayList<Grade> grades = new ArrayList<>();
    		int n = Integer.parseInt(br.readLine());
    		
    		for(int j = 0; j < n; j++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			int document = Integer.parseInt(st.nextToken());
    			int interview = Integer.parseInt(st.nextToken());
    			grades.add(new Grade(document, interview));
    		}
    		
    		Collections.sort(grades);
    		results[i] = algorithm(grades);
    	}
    	
    	for(int result : results) {
    		System.out.println(result);
    	}
    }
    
    public int algorithm(ArrayList<Grade> grades) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	
    	for(Grade grade : grades) {
    		if(pq.isEmpty()) {
    			pq.add(grade.interview);
    		} else {
    			if(pq.peek() > grade.interview) {
    				pq.add(grade.interview);
    			}
    		}
    	}
    	
    	return pq.size();
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1946().solution();
    }

}