package sjh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * S = A[0] × B[0] + ... + A[N-1] × B[N-1]
 */

public class BaekjoonGreedy1026 {
	
	int[] a;
	int[] b;
	
    public void solution() throws Exception {
    	int result = 0;
    	
    	input();
    	
    	// a 오름차순
        Arrays.sort(a);
        
        // b 내림차순
        Integer[] tmp = Arrays.stream(b).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder()); 
        
        for(int i = 0; i < a.length; i++) {
        	result += (a[i] * tmp[i]);
        }
        
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1026().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	a[i] = Integer.parseInt(st.nextToken());
        }
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	b[i] = Integer.parseInt(st2.nextToken());
        }
    }

}