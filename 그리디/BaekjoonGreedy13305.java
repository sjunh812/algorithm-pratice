package sjh;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1km�� 1L�� �⸧ ���
 * ���ú� �⸧�� ����
 */

public class BaekjoonGreedy13305 {
		
	int cityCount;
	int[] loadLengths;
	int[] oilPrices;
	
    public void solution() throws Exception {
    	int result = 0;
    	
    	input();
    	
    	for(int i = 0; i < cityCount - 1; i++) {  
    		int loadLength = loadLengths[i];
    		int j = i + 1;
    		System.out.println("���� ���α��� : " + loadLength);
		
    		for(; j < cityCount - 1; j++) {
    			if(oilPrices[i] < oilPrices[j]) {
    				loadLength += loadLengths[j];
    			} else {
    				break;
    			}
    			
            }
    		
    		System.out.println(oilPrices[i] * loadLength);
			result += (oilPrices[i] * loadLength);
			i = j - 1;
        }
    	
    	System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new BaekjoonGreedy13305().solution();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cityCount = Integer.parseInt(br.readLine());
        loadLengths = new int[cityCount - 1];	
        oilPrices = new int[cityCount];
        
        // ���ð� ���α��� �迭
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cityCount - 1; i++) {
        	loadLengths[i] = Integer.parseInt(st.nextToken());
        }
        
        // ���ú� �⸧�� �迭
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < cityCount; i++) {
        	oilPrices[i] = Integer.parseInt(st2.nextToken());
        }
    }

}