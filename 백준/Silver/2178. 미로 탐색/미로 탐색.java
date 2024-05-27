import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, result;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		bfs();
		System.out.println(result);
	} // main
	public static void bfs(){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0,0});
		visited[0][0] = true;
		result = 1;
		
		loop : while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int[] now = queue.poll();
				int pr = now[0], pc = now[1];
				for(int d=0; d<4; d++) {
					int nr = pr + dr[d], nc = pc + dc[d];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M 
							&& !visited[nr][nc] && map[nr][nc] == 1) {
						// 만약 도착점에 도달했다면
						if(nr == N-1 && nc == M-1) {
							result++;
							break loop;
						}
						visited[nr][nc] = true;
						queue.offer(new int[] {nr, nc});
					}
				} // for dir
			} // for size
			result++;
		} // while queue
	} // bfs
} // class
