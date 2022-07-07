package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy25312 {
	
	long m;
	PriorityQueue<Beverage> pq = new PriorityQueue<>();
	
	class Beverage implements Comparable<Beverage> {
		
		int w;	// 용량
		int v;	// 설탕량
		
		public Beverage(int w, int v) {
			this.w = w;
			this.v = v;
		}

		@Override
		public int compareTo(Beverage o) {
			double per = (double)v / w;
			double comparePer = (double)o.v / o.w;
			
			if(per < comparePer) return 1;
			else if(per > comparePer) return -1;
			return 0;
		}
		
	}
	
    public void solution() throws Exception {
    	input();
    	
    	long a = 0;
    	long b = 1;
    	
    	while(!pq.isEmpty()) {
    		Beverage beverage = pq.poll();

    		if(m >= beverage.w) {
    			a += b * beverage.v;
    			m -= beverage.w;
    		} else {
    			a = a * beverage.w + b * m * beverage.v;
    			b *=  beverage.w;
    			break;
    		}
    	}
    	
    	long gcd = gcd(a, b);
    	System.out.println(a / gcd + "/" + b / gcd);
    }
    
    public long gcd(long a, long b) {
    	long _a = a;
    	long _b = b;
    	long gcd = 1;
    	long i = 2;
    	
    	while(_a >= i && _b >= i) {
    		if(_a % i == 0 && _b % i == 0) {
    			gcd *= i;
    			_a /= i;
    			_b /= i;
    			i = 2;
    		} else {
    			i++;
    		}
    	}
    	
    	return gcd;
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy25312().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int w = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	pq.add(new Beverage(w, v));
        }
    }
    
}