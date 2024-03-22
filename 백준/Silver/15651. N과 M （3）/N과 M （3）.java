import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		perm(0);
		System.out.println(sb);
	}
	
	public static void perm(int count) {
		// 기저 조건
		if(count == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀
		for(int i=1; i<=N; i++) {
			result[count] = i;
			perm(count+1);
		}
	}
}
