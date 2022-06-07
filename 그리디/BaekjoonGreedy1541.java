package sjh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * ����
 * �����̴� ����� +, -, �׸��� ��ȣ�� ������ ���� �������. �׸��� ���� �����̴� ��ȣ�� ��� ������.
 * �׸��� ���� �����̴� ��ȣ�� ������ �ļ� �� ���� ���� �ּҷ� ������� �Ѵ�.
 * ��ȣ�� ������ �ļ� �� ���� ���� �ּҷ� ����� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է�
 * ù° �ٿ� ���� �־�����. ���� ��0��~��9��, ��+��, �׸��� ��-�������� �̷���� �ְ�, ���� ó���� ������ ���ڴ� �����̴�. 
 * �׸��� �����ؼ� �� �� �̻��� �����ڰ� ��Ÿ���� �ʰ�, 5�ڸ����� ���� ���ӵǴ� ���ڴ� ����. ���� 0���� ������ �� �ִ�. �Է����� �־����� ���� ���̴� 50���� �۰ų� ����.
 * 
 * ���
 * ù° �ٿ� ������ ����Ѵ�.
 */

public class BaekjoonGreedy1541 {
		
    public void solution() throws Exception {
    	String input = input();    	
    	ArrayList<String> list = new ArrayList<>();
    	String item = "";
    	
    	for(int i = 0; i < input.length(); i++) {
    		char c = input.charAt(i);
    		
    		if(c != '-' && c != '+') {
    			item += c;
    	    	if(i == input.length()-1) list.add(item);
    		} else {    		
    			list.add(item);
    			list.add(String.valueOf(c));
    			item = "";
    		}
    	}
    	
    	int result = 0;
    	int sum = 0;
    	boolean bracket = false;
    	
    	for(int i = 0; i < list.size(); i++) {
    		String it = list.get(i);
    		
    		if(!bracket) {
    			if(it.equals("-")) bracket = true;
    			else if(!it.equals("+")) result += Integer.parseInt(it);
    		} else {
    			if(!it.equals("+") && !it.equals("-")) {
    				sum += Integer.parseInt(it);
    				
    				if(i == list.size() - 1) {
    					result -= sum;
    				} else if(list.get(i+1).equals("-")) {
    					bracket = false;
    					result -= sum;
    					sum = 0;
    				}
    			} 
    		}
    	}
    	
    	System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy1541().solution();
    }

    public String input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        if(input.length() > 50) return input.substring(0, 50);	
        
        return input;
    }

}