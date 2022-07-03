package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekjoonGreedy25315 {
	
	int n;	// 베기 횟수
	int[][] is;	// 각각 베기 좌표 및 가중치(배열의 마지막 원소)
	
    public void solution() throws Exception {
    	input();
    	
    	
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy25315().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        is = new int[n][5];
        
        for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	for(int j = 0; j < 5; j++) {
        		is[i][j] = Integer.parseInt(st.nextToken()); 
        	}
        }
    }
    
}