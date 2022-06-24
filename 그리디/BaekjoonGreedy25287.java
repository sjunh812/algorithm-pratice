package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BaekjoonGreedy25287 {

	ArrayList<ArrayList<Integer>> perList = new ArrayList<>();	// 순열 리스트
		
    public void solution() throws Exception {    
    	input();
    	
    	ArrayList<String> result = new ArrayList<>();
    	
    	for(ArrayList<Integer> per : perList) {
    		int resultLen = result.size();
    		
    		for(int j = 0; j < per.size(); j++) {
    			int i = per.get(j);	// case 1(기존)
    			int i2 = cal(per.size(), i);	// case 2(연산)
    			
    			if(j == 0) {
    				if(i > i2) per.set(j, i2);
    			} else {
    				int i0 = per.get(j - 1);	// 이전 값
    				
    				if(i < i2) {
    					if(i0 > i) {	
        					if(i0 > i2) {	
        						result.add("NO");
        						break;
        					} else {
        						per.set(j, i2);
        					}
        				}
    				} else {
    					if(i0 <= i2) {
    						per.set(j, i2);
        				} else {
        					if(i0 > i) {
        						result.add("NO");
        						break;
        					}
        				}
    				}
    			}
    		}
    		
    		if(result.size() == resultLen) {
    			result.add("YES");
    		}  		
    	}
    	
    	for(String str : result) {
    		System.out.println(str);
    	}
    }
    
    public int cal(int n, int i) {
    	return n - i + 1;
    }
   
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy25287().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	int len = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	ArrayList<Integer> list = new ArrayList<>();
        	
        	for(int j = 0; j < len; j++) {
        		list.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	perList.add(list);
        }
    }

}