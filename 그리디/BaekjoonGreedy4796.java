package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * ķ������ p�� ��, l�� ���ȸ� ���(v��¥�� �ް�)
 */
public class BaekjoonGreedy4796 {
	
	ArrayList<Camping> list = new ArrayList<>();
	
	public class Camping {
		
		int l;
		int p;
		int v;
		
		public Camping(int l, int p, int v) {
			this.l = l;
			this.p = p;
			this.v = v;
		}
		
	}
	
    public void solution() throws Exception {
    	input();
    	
    	int i = 1;
    	
    	for(Camping camping : list) {
    		int result = 0;
    		
    		if(camping.v > camping.p) {
    			result += (camping.v / camping.p) * camping.l;
    			int remain = camping.v % camping.p;
    			
    			if(camping.l >= remain) {
    				result += remain;
    			} else {
    				result += camping.l;
    			}
    		} else if(camping.v == camping.p) {
    			result = camping.l;
    		} else {
    			if(camping.l >= camping.v) {
    				result += camping.v;
    			} else {
    				result += camping.l;
    			}
    		}
    		
    		System.out.println("Case " + i++ + ": " + result);
    	}
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy4796().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int l = Integer.parseInt(st.nextToken());
        	int p = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	if(l == 0 && p == 0 && v == 0) break;
        	else list.add(new Camping(l, p, v));
        }
    }
    
}