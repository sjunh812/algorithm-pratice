package sjh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 
 * ����
 * �� ���� ȸ�ǽ��� �ִµ� �̸� ����ϰ��� �ϴ� N���� ȸ�ǿ� ���Ͽ� ȸ�ǽ� ���ǥ�� ������� �Ѵ�. 
 * �� ȸ�� I�� ���� ���۽ð��� ������ �ð��� �־��� �ְ�, �� ȸ�ǰ� ��ġ�� �ʰ� �ϸ鼭 ȸ�ǽ��� ����� �� �ִ� ȸ���� �ִ� ������ ã�ƺ���.
 * ��, ȸ�Ǵ� �ѹ� �����ϸ� �߰��� �ߴܵ� �� ������ �� ȸ�ǰ� ������ �Ͱ� ���ÿ� ���� ȸ�ǰ� ���۵� �� �ִ�. 
 * ȸ���� ���۽ð��� ������ �ð��� ���� ���� �ִ�. �� ��쿡�� �������ڸ��� ������ ������ �����ϸ� �ȴ�.
 * 
 * �Է�
 * ù° �ٿ� ȸ���� �� N(1 �� N �� 100,000)�� �־�����. 
 * ��° �ٺ��� N+1 �ٱ��� �� ȸ���� ������ �־����µ� �̰��� ������ ���̿� �ΰ� ȸ���� ���۽ð��� ������ �ð��� �־�����. 
 * ���� �ð��� ������ �ð��� 231-1���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.
 * 
 * ���
 * ù° �ٿ� �ִ� ����� �� �ִ� ȸ���� �ִ� ������ ����Ѵ�.
*/
public class BaekjoonGreedy1931 {
	
    public void solution() throws Exception {
        int[][] input = input();        
        
        // 2���� �迭���� 0��° �� ���� 1��° �� ����(���� �迭����)
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
    		// ����(" ") �������� ���ڿ��� �Է¹����� : StringTokenizer �̿�
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		result[i][0] = Integer.parseInt(st.nextToken());
    		result[i][1] = Integer.parseInt(st.nextToken());
    	}
        
        return result;
    }

}