package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy1049 {
	
	int n;
	int m;
	int pack = -1;
	int each = -1;
	
    public void solution() throws Exception {  
    	input();
    	
    	int _n = n;
    	int result = 0;
    	
    	if(pack > each * 6) pack = each * 6;
    	
    	while(true) {
    		if(_n >= 6) {
    			result += (_n / 6) * pack;
    			_n = _n % 6;
    		} else {
    			if(_n * each > pack) result += pack;
    			else result += _n * each;
    	
    			break;
    		}
    	}
    	
    	System.out.println(result);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1049().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int p = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	
        	if(pack == -1 || pack > p) pack = p;
        	if(each == -1 || each > e) each = e;
        }
    }

}