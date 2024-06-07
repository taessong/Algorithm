import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Person {
		int r;
		int c;
		int isBreak;
		int time;
		
		Person(){}
		
		Person(int r, int c, int isBreak, int time){
			this.r = r;
			this.c = c;
			this.isBreak = isBreak;
			this.time = time;
		}
	} // class Person
	
	public static int N, M;
	public static int[][] map;
	public static boolean[][][] visited;
	public static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[2][N][M];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.valueOf(str.charAt(c)) - '0';
			}
		}
		
		int result = walk();
		System.out.println(result);
	} // main
	
	public static int walk() {
		Queue<Person> queue = new LinkedList<>();
		queue.offer(new Person(0, 0, 0, 1));
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Person person = queue.poll();
			
			// 만약 목적지에 도착했다면 최단경로 리턴
			if(person.r == N-1 && person.c == M-1) 
				return person.time;
			
			for(int d=0; d<4; d++) {
				int nr = person.r + dr[d];
				int nc = person.c + dc[d];
				
				// 범위 안에 있고 방문하지 않았는데
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					// 길을 만나면
					if(map[nr][nc] == 0 && !visited[person.isBreak][nr][nc]) {
						visited[person.isBreak][nr][nc] = true;
						queue.offer(new Person(nr, nc, person.isBreak, person.time + 1));
					}
					// 벽을 만나고 벽을 아직 뚫지 않았다면
					else if(map[nr][nc] == 1 && !visited[person.isBreak][nr][nc] && person.isBreak == 0) {
						visited[person.isBreak+1][nr][nc] = true;
						queue.offer(new Person(nr, nc, person.isBreak+1, person.time + 1));
					}
				}
			}
		}
		// 목적지에 도달하지 못하면 -1 리턴
		return -1;
	} // walk()
}

// 방문배열을 3차원으로 작성한다고 가정 -> 한번 벽을 부수고 3차원 방문배열에 방문 처리를 해주면? 이미 방문 배열이 더러워져 있지 않나??
