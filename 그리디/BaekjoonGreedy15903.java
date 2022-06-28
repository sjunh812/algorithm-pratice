package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy15903 {
	
	int n;	// 카드수 
	int m;	// 놀이횟수
	PriorityQueue<Long> a = new PriorityQueue<>();	// 카드리스트
	
    public void solution() throws Exception {
    	input();
    	
    	for(int i = 0; i < m ; i++) {
    		long a1 = a.poll();
    		long a2 = a.poll();
    		long a3 = a1 + a2;
    		
    		a.add(a3);
    		a.add(a3);
    	}
    	
    	long result = 0;
    	while(!a.isEmpty()) {
    		result += a.poll();
    	}
    	
    	System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy15903().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	a.add(Long.parseLong(st.nextToken()));
        }
    }
    
}