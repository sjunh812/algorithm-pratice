package sjh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ����
 * �ر԰� ������ �ִ� ������ �� N�����̰�, ������ ������ �ſ� ���� ������ �ִ�.
 * ������ ������ ����ؼ� �� ��ġ�� ���� K�� ������� �Ѵ�. �̶� �ʿ��� ���� ������ �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է�
 * ù° �ٿ� N�� K�� �־�����. (1 �� N �� 10, 1 �� K �� 100,000,000)
 * ��° �ٺ��� N���� �ٿ� ������ ��ġ Ai�� ������������ �־�����. (1 �� Ai �� 1,000,000, A1 = 1, i �� 2�� ��쿡 Ai�� Ai-1�� ���)
 * 
 * ���
 * ù° �ٿ� K���� ����µ� �ʿ��� ���� ������ �ּڰ��� ����Ѵ�.
 */
public class BaekjoonGreedy11047 {
	
	public int[] types;
	public int sum;

    public void solution() throws Exception {
    	input();
    	
    	int result = 0;
    	
        for(int i = types.length - 1; i >= 0; i--) {
        	int type = types[i];
        	
        	if(sum >= type) {
        		result += sum / type;
        		sum = sum % type;
        	}
        }
        
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy11047().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        types = new int[Integer.parseInt(st.nextToken())];
        sum = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < types.length; i++) {
    		types[i] = Integer.parseInt(br.readLine());
    	}
    }

}