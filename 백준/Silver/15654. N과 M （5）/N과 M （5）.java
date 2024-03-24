import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] result, arr, visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		visited = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		perm(0);
		System.out.println(sb);
	}
	
	public static void perm(int count) {
		if(count == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for(int i=0; i<N; i++) {
			if(visited[i] == 1) continue;
			else{
				visited[i] = 1;
				result[count] = arr[i];
				perm(count+1);
				visited[i] = 0;
			}
		}
	}
}