package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy1041 {

	long n;
	PriorityQueue<Long> pq = new PriorityQueue<>();
	
    public void solution() throws Exception {
    	input();
    	
    	long result;
    	long[] arr = {pq.poll(), pq.poll(), pq.poll()};
    	
    	if(n == 1) {
    		result = arr[0] + arr[1] + arr[2] + pq.poll() + pq.poll();
    	} else {
    		result = 4 * (arr[0] + arr[1] + arr[2])
			+ (8 * n - 12) * (arr[0] + arr[1])
			+ (5 * n * n - 16 * n + 12) * arr[0];
    	}
    	
    	System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1041().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
        for(int i = 0; i < 6; i++) {        	
        	pq.add(Long.parseLong(st.nextToken()));
        }
    }
}