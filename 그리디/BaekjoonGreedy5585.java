package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekjoonGreedy5585 {
	
	int price;
	int[] units = {500, 100, 50, 10, 5, 1};
	
    public void solution() throws Exception {  
    	input();
    	
    	int result = 0;
    	int exchange = 1000 - price;
    	
    	for(int unit : units) {
    		if(exchange >= unit) {
    			result += exchange / unit;
    			exchange = exchange % unit;
    		}
    	}
    	
    	System.out.println(result);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy5585().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        price = Integer.parseInt(br.readLine());
    }

}