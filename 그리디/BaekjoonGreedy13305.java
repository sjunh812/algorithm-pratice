package sjh.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1km�� 1L�� �⸧ ���
 * ���ú� �⸧�� ����
 */

public class BaekjoonGreedy13305 {
		
	int cityCount;
	long[] loadLengths;
	long[] oilPrices;
	
    public void solution() throws Exception {
    	long result = 0;
    	
    	input();
    	
    	for(int i = 0; i < cityCount - 1; i++) {  
    		long loadLength = loadLengths[i];
    		int j = i + 1;
		
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
        loadLengths = new long[cityCount - 1];	
        oilPrices = new long[cityCount];
        
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