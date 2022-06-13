package sjh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class BaekjoonGreedy25287 {

	ArrayList<ArrayList<Integer>> perList = new ArrayList<>();
		
    public void solution() throws Exception {
//    	input();
//    	
//    	ArrayList<String> result = new ArrayList<>();
//    	
//    	for(ArrayList<Integer> per : perList) {
//    		int center = per.size() / 2;
//    		
//    		if(per.size() % 2 == 0) {	// ¦
//    			for(int i = 0; i < per.size(); i++) {
//    				int n = per.get(i);
//    				
//    				if(i < center) {
//    					if(n > center) {
//    						per.set(i, per.size() - n + 1);
//    					}
//    				} else if(center <= i) {
//    					if(n <= center) {
//    						per.set(i, per.size() - n + 1);
//    					}
//    				} 
//    			}
//    			
//    			if(check(per)) {
//					result.add("YES");
//				} else {
//					result.add("NO");
//				}
//    		} else {	// Ȧ
//    			for(int i = 0; i < per.size(); i++) {
//    				int n = per.get(i);
//    				
//    				if(i < center) {
//    					if(n > center + 1) {
//    						per.set(i, per.size() - n + 1);
//    					}
//    				} else if(center < i) {
//    					if(n < center + 1) {
//    						per.set(i, per.size() - n + 1);
//    					}
//    				} 
//    			}
//    			
//    			if(check(per)) {
//    				result.add("YES");
//    			} else {
//    				per.set(center, per.size() - per.get(center) + 1);
//    				if(check(per)) {
//    					result.add("YES");
//    				} else {
//    					result.add("NO");
//    				}
//    			}
//    		}
//    	}
//    	
//    	for(String str : result) {
//			System.out.println(str);
//		}
    	
    	ArrayList<String> result = new ArrayList<>();
    	
    	input();
    	
    	for(ArrayList<Integer> per : perList) {
    		int resultLen = result.size();
    		
    		for(int j = 0; j < per.size(); j++) {
    			int i = per.get(j);
    			int i2 = cal(per.size(), i);
    			
    			if(j == 0) {
    				if(i > i2) per.set(j, i2);
    			} else {
    				int i0 = per.get(j - 1);
    				
    				if(i < i2) {
    					if(i0 < i) {
        					
        				} else if(i0 == i) {
        					
        				} else {
        					if(i0 < i2) {
        						per.set(j, i2);
        					} else if(i0 > i2) {
        						result.add("NO");
        						break;
        					} else {
        						per.set(j, i2);
        					}
        				}
    				} else {
    					if(i0 < i2) {
    						per.set(j, i2);
        				} else if(i0 == i2) {
        					per.set(j, i2);
        				} else {
        					if(i0 < i) {
        						
        					} else if(i0 > i) {
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
    
    public Boolean check(ArrayList<Integer> list) {
    	for(int i = 0; i < list.size() - 1; i++) {
    		if(list.get(i) > list.get(i + 1)) {
    			return false;
    		}
    	}
    	
    	return true;
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