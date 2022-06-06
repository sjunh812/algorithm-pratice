package sjh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 
 * 문제
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 * 
 * 입력
 * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 
 * 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 
 * 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
 * 
 * 출력
 * 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
*/
public class BaekjoonGreedy1931 {
	
    public void solution() throws Exception {
        int[][] input = input();        
        
        // 2차원 배열정렬 0번째 열 다음 1번째 열 기준(다중 배열정렬)
		Arrays.sort(input, new Comparator<int[]>() {
		    @Override
			public int compare(int[] o1, int[] o2) {
		    	 if(o1[0] == o2[0]) return o1[1] - o2[1];
		    	 else return o1[0] - o2[0]; 
	           }
	        }
		);
				
		int start = input[0][0];
		int end = input[0][1];
		int result = 1;
		
		for(int i = 1; i < input.length; i++) {
			if(start >= input[i][0]) {
				if(start == end) {
					end = input[i][1];
					result++;
				}
			} else {
				if(end > input[i][1]) {
					start = input[i][0];
					end = input[i][1];
					continue;
				} 
				
				if(end <= input[i][0]) {
					start = input[i][0];
					end = input[i][1];
					result++;
				} 
			}
			
		}
        
        System.out.println(result);
    }
    
    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1931().solution();
    }

    public int[][] input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] result = new int[n][2];
        
        for(int i = 0; i < n; i++) {
    		// 공백(" ") 기준으로 문자열을 입력받을때 : StringTokenizer 이용
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		result[i][0] = Integer.parseInt(st.nextToken());
    		result[i][1] = Integer.parseInt(st.nextToken());
    	}
        
        return result;
    }

}