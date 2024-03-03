import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int K = Integer.parseInt(br.readLine());
        int[][] ground = new int[6][2];
        int rMax = 0, cMax = 0;
        int rIdx = 0, cIdx = 0;
        
        for(int i=0; i<6; i++){
        	st = new StringTokenizer(br.readLine());
        	ground[i][0] = Integer.parseInt(st.nextToken());
        	ground[i][1] = Integer.parseInt(st.nextToken());
        	
        	if(ground[i][0] == 1 || ground[i][0] == 2) {
        		if(ground[i][1] > rMax) {
        			rMax = ground[i][1]; 
        			rIdx = i;
        		}
        	} else if(ground[i][0] == 3 || ground[i][0] == 4) {
        		if(ground[i][1] > cMax) {
        			cMax = ground[i][1]; 
        			cIdx = i;
        		}
        	}
        }
        // 전체 사각형 넓이
        int bigBox = rMax * cMax;
        
        // 작은 사각형 넓이
        int smallBox = ground[(rIdx+3) % 6][1] * ground[(cIdx+3) % 6][1]; 
        
        System.out.println((bigBox-smallBox)*K);
    }
}