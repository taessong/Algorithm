import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		int result = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j=a; j<a+10; j++) {
				for(int l=b; l<b+10; l++) {
					paper[j][l] = 1;
				}
			}
		}
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(paper[i][j] == 1) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
