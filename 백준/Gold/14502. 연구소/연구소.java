import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static int[][] map, copy;
	static boolean[][] visited;
	static int R, C, result;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	map = new int[R][C];
    	copy = new int[R][C];
    	
    	for(int r=0; r<R; r++) {
    		st = new StringTokenizer(br.readLine());
    		for(int c=0; c<C; c++) {
    			map[r][c] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	wall(0);
    	System.out.println(result);
	} // main

	public static void wall(int count) {
		if(count == 3) {
			// 벽을 다 세웠다면 방문배열 초기화하고 방문체크
			visited = new boolean[R][C];
			// 복사맵
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					copy[i][j] = map[i][j];
				}
			}
			
			// 바이러스 퍼뜨리기
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(map[r][c] == 2) virus(r, c);
				}
			}
			
			// 안전영역 찾기
			int sum = 0;
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(copy[r][c] == 0) sum++;
					result = Math.max(result, sum);
				}
			}
			return;
		} // 탈출조건
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] == 0) {
					map[r][c] = 1;
					wall(count+1);
					map[r][c] = 0; // 벽 복원
				}
			}
		} // 재귀
	} // wall

	public static void virus(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int pr = arr[0], pc = arr[1];
			for(int d=0; d<4; d++) {
				int nr = pr + dr[d], nc = pc + dc[d];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C 
						&& !visited[nr][nc] && copy[nr][nc] == 0) {
					copy[nr][nc] = 2;
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		} // while
	} // virus
} // class