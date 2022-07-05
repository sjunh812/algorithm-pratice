package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy25315 {
	
	int n;	// 베기 횟수
	PriorityQueue<Cut> pq = new PriorityQueue<>();
	
    public void solution() throws Exception {
    	input();
    	
    	long result = 0;
    	
    	while(!pq.isEmpty()) {
    		Cut c1 = pq.poll();
    		int m = 0;

    		Iterator<Cut> it = pq.iterator();
    		while(it.hasNext()) {
    			Cut c2 = it.next();
    			if(check(c1, c2)) m++;
    		}
    		
    		result += (m + 1) * c1.w;
    	}
    	
    	System.out.println(result);
    }
    
    public int ccw(Point p1, Point p2, Point p3) {
        long tmp = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y;
        tmp -= (p1.y * p2.x + p2.y * p3.x + p3.y * p1.x);
 
        if (tmp < 0)
            return -1;
        if (tmp > 0)
            return 1;
        return 0;
    }
    
    public boolean check(Cut c1, Cut c2) {
    	int a1 = ccw(c1.p1, c1.p2, c2.p1) * ccw(c1.p1, c1.p2, c2.p2);
    	int a2 = ccw(c2.p1, c2.p2, c1.p1) * ccw(c2.p1, c2.p2, c1.p2);
    	
    	return (a1 < 0) && (a2 < 0);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy25315().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	long p1x = Long.parseLong(st.nextToken());
        	long p1y = Long.parseLong(st.nextToken());
        	long p2x = Long.parseLong(st.nextToken());
        	long p2y = Long.parseLong(st.nextToken());
        	long w = Long.parseLong(st.nextToken());

        	pq.add(new Cut(new Point(p1x, p1y), new Point(p2x, p2y), w));	
        }
    }
    
    public class Point {
    	
    	long x;
    	long y;
    	
    	public Point(long x, long y) {
    		this.x = x;    	
    		this.y = y;
    	}
    	
    }
    
    public class Cut implements Comparable<Cut> {
    	
    	Point p1;
    	Point p2;
    	long w;
    	
    	public Cut(Point p1, Point p2, long w) {
    		this.p1 = p1;
    		this.p2 = p2;
    		this.w = w;
    	}

		@Override
		public int compareTo(Cut o) {
			if(this.w > o.w) return 1;
			else if(this.w < o.w) return -1;
			return 0;
		}
    	
    }
    
}