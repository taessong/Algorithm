import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums, visited, result;
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		visited = new int[N];
		nums = new int[N];
		for(int i=1; i<=N; i++) {
			nums[i-1] = i;
		}
		
		perm(0);
	}

	public static void perm(int count) {
		// 기저조건
		if(count == M) {
			for(int i=0; i<M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		// 재귀
		// 방문한 곳은 넘어가
		for(int i=0; i<N; i++) {
			if(visited[i] == 1) continue;
			// 방문하지 않은 곳은 값 추가
			visited[i] = 1; // 방문처리
			result[count] = nums[i];
			perm(count+1);
			visited[i] = 0;
			// result배열의 값은 뒤덮히니 원복하지 않아도 됨!
		}
	}
}
