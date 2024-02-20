import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		int N = Integer.parseInt(st.nextToken());
    		int K = Integer.parseInt(st.nextToken());
    		
    		int[][] student = new int[7][2];
    		int room = 0;
    		
    		for(int i=0; i<N; i++) {
    			st = new StringTokenizer(br.readLine());
    			int gender = Integer.parseInt(st.nextToken());
    			int grade = Integer.parseInt(st.nextToken());
    			student[grade][gender]++;
    		}
    		
    		for(int i=1; i<7; i++) {
    			for(int j=0; j<2; j++) {
    				if(student[i][j] % K == 0) {
    					room += student[i][j] / K;
    				} else {
    					room += (student[i][j] / K) + 1;
    				}
    			}
    		}
    		System.out.println(room);
    }
}