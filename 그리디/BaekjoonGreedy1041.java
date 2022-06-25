package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy1041 {

	long n;
	PriorityQueue<Face> pq = new PriorityQueue<>();
	
	public class Face implements Comparable<Face> {
		
		char alphabet;
		long value;
		
		public Face(char alphabet, long value) {
			this.alphabet = alphabet;
			this.value = value;
		}

		@Override
		public int compareTo(Face o) {
			if(this.value > o.value) return 1;
			else if(this.value < o.value) return -1;
			else return 0;
		}
		
	}
	
    public void solution() throws Exception {
    	input();
    	
    	long result = 0;
    	ArrayList<Face> list = new ArrayList<>();
    	char minAlpha = ' ';
    	
    	if(n == 1) {
    		for(int i = 0; i < 5; i++) {
    			result += pq.poll().value;
    		}
    	} else {
    		while(list.size() != 3) {
        		Face face = pq.poll();
        		
        		if(list.isEmpty()) {
        			minAlpha = face.alphabet;
        		} else {
        			if(face.alphabet == getFacingAlphabet(minAlpha)) {
        				face = pq.poll();
        			} 
        			
        			if(list.size() == 2) {
        				if(face.alphabet == getFacingAlphabet(list.get(1).alphabet)) {
            				face = pq.poll();
            				
                			if(face.alphabet == getFacingAlphabet(minAlpha)) {
                				face = pq.poll();
                			} 
            			} 
        			}
        	 	} 
        		
        		list.add(face);
        	}
    		
    		result = 4 * (list.get(0).value + list.get(1).value + list.get(2).value)
    				+ (8 * n - 12) * (list.get(0).value + list.get(1).value)
    				+ (5 * n * n - 16 * n + 12) * list.get(0).value;
    	}
    
    	
    	System.out.println(result);
    }
    
	public char getFacingAlphabet(char alphabet) {
		char result;
		
		switch(alphabet) {
			case 'A' :
				result = 'F';
				break;
			case 'B' :
				result = 'E';
				break;
			case 'C' :
				result = 'D';
				break;
			case 'D' :
				result = 'C';
				break;
			case 'E' :
				result = 'B';
				break;
			default :
				result = 'A';
				break;
		}
		
		return result;
	}

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1041().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F'};
    	
        for(int i = 0; i < 6; i++) {        	
        	pq.add(new Face(alphabets[i], Long.parseLong(st.nextToken())));
        }
    }
    
}