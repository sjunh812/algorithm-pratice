package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekjoonGreedy2812 {
	
	int N;
	int K;
	
	int[] arr;
	Stack<Integer> stack = new Stack<>();
	
	public void solution() throws Exception {
    	input();
    	
    	int count = 0;
    	
    	for(int i = 0; i < arr.length; i++) {
    		while(count < K && !stack.isEmpty() && stack.peek() < arr[i]) {
    			stack.pop();
    			count++;
    		}
    		
    		stack.push(arr[i]);
    	}
    	
    	for(int i = 0; i < stack.size(); i++) {
    		System.out.print(stack.elementAt(i));
    	}
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy2812().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String[] strs = br.readLine().split("");
        arr = new int[strs.length];
        
        for(int i = 0; i < strs.length; i++) {
        	arr[i] = Integer.parseInt(strs[i]);
        }
    }
    
}