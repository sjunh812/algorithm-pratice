package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekjoonGreedy2217 {

	int[] weights;
	
    public void solution() throws Exception {  
    	input();
    	
    	Arrays.sort(weights);
    	
    	int max = 0;
    	
    	for(int i = 0; i < weights.length; i++) {
    		int weight = weights[i];
    		int sum = weight * (weights.length - i);
    		
    		if(max < sum) {
    			max = sum;
    		}
    	}
    	
    	System.out.println(max);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy2217().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        weights = new int[n];
        
        for(int i = 0; i < n; i++) {
        	weights[i] = Integer.parseInt(br.readLine());
        }
    }

}