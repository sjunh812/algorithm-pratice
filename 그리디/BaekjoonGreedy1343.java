package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy1343 {
	
	String input;
	
    public void solution() throws Exception {  
    	input();
    	
    	String result = "";
    	String x = "";
    	
    	for(int i = 0; i < input.length(); i++) {
    		char c = input.charAt(i);
    		
    		if(c == 'X') {
    			x += "X";
    			
    			if(i != input.length() - 1) {
    				char next = input.charAt(i + 1);
    				
    				if(next == '.') {
    					result += convertToPolyomino(x);
    					x = "";
    				}
    			} else {
    				result += convertToPolyomino(x);
    			}
    		} else {
    			result += ".";
    		}
    		
    		if(result.contains("-1")) {
    			result = "-1";
    			break;
    		}
    	}
    	
    	System.out.println(result);
    }
    
    public String convertToPolyomino(String format){
    	String convert = "";
    	int len = format.length();
    	
    	if(len % 2 != 0) {
    		convert = "-1";
    	} else {
    		if(len >= 4) {
    			int remain = len % 4;
    			
    			for(int i = 0; i < len / 4; i++) {
    				convert += "AAAA";
    			}
    			
    			for(int i = 0; i < remain / 2; i++) {
    				convert += "BB";
    			}
    		} else {
    			for(int i = 0; i < len / 2; i++) {
    				convert += "BB";
    			}
    		}
    	}
    	
    	return convert;
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1343().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
    }

}