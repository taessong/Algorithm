import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Monkey {
		int r;
		int c;
		int kCnt; // 남은 k를 나타내는 변수
		int time; // 소요된 시간
		
		public Monkey(int r, int c, int kCnt, int time) {
			this.r = r;
			this.c = c;
			this.kCnt = kCnt;
			this.time = time;
		}
	} // Monkey
	
	static int K, C, R, min;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static int[] hdr = {-2, -2, 2, 2, -1, 1, -1, 1}, hdc = {-1, 1, -1, 1, -2, -2, 2, 2};
	static boolean[][][] visited;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	K = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	C = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	map = new int[R][C];
    	visited = new boolean[K+1][R][C];
    	min = 987654321;
    	
    	for(int r=0; r<R; r++) {
    		st = new StringTokenizer(br.readLine());
    		for(int c=0; c<C; c++) {
    			map[r][c] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	min = jump();
    	if(min == 987654321) System.out.println(-1);
    	else System.out.println(min);
    } // main

	public static int jump() {
		Queue<Monkey> queue = new LinkedList<>();
		queue.offer(new Monkey(0, 0, K, 0));
		visited[K][0][0] = true;
		
		while(!queue.isEmpty()) {
			Monkey monkey = queue.poll();
			if(monkey.r == R-1 && monkey.c == C-1) {
				return monkey.time;
				// 가장 먼저 조건을 만족한다는 것은 가장 빨리 도착했다는 것!!
			}
			
			for(int d=0; d<4; d++) {
				int nr = monkey.r + dr[d];
				int nc = monkey.c + dc[d];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C 
						&& !visited[monkey.kCnt][nr][nc] && map[nr][nc] != 1) {
					queue.offer(new Monkey(nr, nc, monkey.kCnt, monkey.time+1));
					visited[monkey.kCnt][nr][nc] = true;
				}
			} // for 4방향
			
			if(monkey.kCnt > 0) {
				for(int d=0; d<8; d++) {
					int nr = monkey.r + hdr[d];
					int nc = monkey.c + hdc[d];
					if(nr >= 0 && nr < R && nc >= 0 && nc < C 
							&& !visited[monkey.kCnt-1][nr][nc] && map[nr][nc] != 1) {
						// 말처럼 점프했다면 k-- 시켜주기
						queue.offer(new Monkey(nr, nc, monkey.kCnt-1, monkey.time+1));
						visited[monkey.kCnt-1][nr][nc] = true;
					}
				} // for 8방향
			} 
		} // while queue
		return min;
	} // jump
} // class