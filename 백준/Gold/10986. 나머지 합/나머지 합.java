import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] sumArr = new long[N];
		st = new StringTokenizer(br.readLine());
		
		sumArr[0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < N; i++) {
			sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		long ans = 0;
		long[] remainArr = new long[M];
		for(int i = 0; i < N; i++) {
			int remainder = (int) (sumArr[i] % M);
			if(remainder == 0) ans++;
			
			remainArr[remainder]++; // 나머지 배열에 개수 증가
		}
		
		// (S[j] - S[i]) % M = 0
		// (S[j] % M) - (S[i] % M) = 0
		// S[j] % M = S[i] % M
		// 즉, 나머지가 같은 것 2개를 묶으면 나머지 0이 된다
		
		for(int i = 0; i < M; i++) {
			// 같은 나머지를 같은 수 2개를 묶어 조합
			if(remainArr[i] > 1) {
				long cnt = remainArr[i];
				ans += (cnt * (cnt - 1)) / 2;
			}
		}
		
		System.out.println(ans);
	}
}	
