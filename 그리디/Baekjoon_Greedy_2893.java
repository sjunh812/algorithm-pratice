import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ����
 * ����̴� ���� �������忡�� ������ ����ϰ� �ִ�. ����̴� ���� �������Կ� ������ ��Ȯ�ϰ� Nų�α׷��� ����ؾ� �Ѵ�.
 * �������忡�� ����� ������ ������ ����� �ִ�. ������ 3ų�α׷� ������ 5ų�α׷� ������ �ִ�.
 * ����̴� ������ ������, �ִ��� ���� ������ ��� ������ �Ѵ�. ���� ���, 18ų�α׷� ������ ����ؾ� �� ��, 3ų�α׷� ���� 6���� �������� ������,
 * 5ų�α׷� 3���� 3ų�α׷� 1���� ����ϸ�, �� ���� ������ ������ ����� �� �ִ�.
 * ����̰� ������ ��Ȯ�ϰ� Nų�α׷� ����ؾ� �� ��, ���� �� ���� �������� �Ǵ��� �� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 *
 * �Է�
 * ù° �ٿ� N�� �־�����. (3 �� N �� 5000)
 *
 * ���
 * ����̰� ����ϴ� ������ �ּ� ������ ����Ѵ�. ����, ��Ȯ�ϰ� Nų�α׷��� ���� �� ���ٸ� -1�� ����Ѵ�.
 */

public class Main {

	public int index = 0;
    public void solution() throws Exception {
        int kg = input();
        int a = kg / 5;
        int b = 0;
        int result = -1;
        
        for(int i = a; i >= 0; i--) {
        	a = i;
        	int _kg = kg - i * 5;
        	
        	if(_kg % 3 == 0) {
        		b = _kg / 3;
        		break;
        	} 
        }
        
        
        if(a + b != 0) result = a + b;
        
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public int input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

}