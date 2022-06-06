package sjh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ����
 * �������࿡�� ATM�� 1��ۿ� ����. 
 * ���� �� ATM�տ� N���� ������� ���� ���ִ�. 
 * ����� 1������ N������ ��ȣ�� �Ű��� ������, i�� ����� ���� �����ϴµ� �ɸ��� �ð��� Pi���̴�.
 * ������� ���� ���� ������ ����, ���� �����ϴµ� �ʿ��� �ð��� ���� �޶����� �ȴ�. 
 * ���� ���, �� 5���� �ְ�, P1 = 3, P2 = 1, P3 = 4, P4 = 3, P5 = 2 �� ��츦 �����غ���. 
 * [1, 2, 3, 4, 5] ������ ���� ���ٸ�, 1�� ����� 3�и��� ���� ���� �� �ִ�. 
 * 2�� ����� 1�� ����� ���� ���� �� ���� ��ٷ��� �ϱ� ������, 3+1 = 4���� �ɸ��� �ȴ�. 
 * 3�� ����� 1��, 2�� ����� ���� ���� ������ ��ٷ��� �ϱ� ������, �� 3+1+4 = 8���� �ʿ��ϰ� �ȴ�. 
 * 4�� ����� 3+1+4+3 = 11��, 5�� ����� 3+1+4+3+2 = 13���� �ɸ��� �ȴ�. 
 * �� ��쿡 �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� 3+4+8+11+13 = 39���� �ȴ�.
 * ���� [2, 5, 1, 4, 3] ������ ���� ����, 2�� ����� 1�и���, 5�� ����� 1+2 = 3��, 1�� ����� 1+2+3 = 6��, 4�� ����� 1+2+3+3 = 9��, 3�� ����� 1+2+3+3+4 = 13���� �ɸ��� �ȴ�. 
 * �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� 1+3+6+9+13 = 32���̴�. �� ������� �� �ʿ��� �ð��� ���� �ּҷ� ���� ���� ����.
 * ���� �� �ִ� ����� �� N�� �� ����� ���� �����ϴµ� �ɸ��� �ð� Pi�� �־����� ��, �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է�
 * ù° �ٿ� ����� �� N(1 �� N �� 1,000)�� �־�����. 
 * ��° �ٿ��� �� ����� ���� �����ϴµ� �ɸ��� �ð� Pi�� �־�����. (1 �� Pi �� 1,000)
 * 
 * ���
 * ù° �ٿ� �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� �ּڰ��� ����Ѵ�.
 */
public class BaekjoonGreedy11399 {
	
	int[] times;

    public void solution() throws Exception {
    	input();
    	
    	int sum = 0;
    	int result = 0;
    	
        Arrays.sort(times);
        
        for(int i = 0; i < times.length; i++) {
        	int time = times[i];
        	sum += time;
        	result += sum;
        }
        
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy11399().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        times = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {    	
        	times[i] = Integer.parseInt(st.nextToken());
        }
    }

}