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
	static int R, C;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	map = new int[R][C];
    	
    	for(int r=0; r<R; r++) {
    		st = new StringTokenizer(br.readLine());
    		for(int c=0; c<C; c++) {
    			map[r][c] = Integer.parseInt(st.nextToken());
    		}
    	}
    	System.out.println(iceberg());
	} // main

    public static void melt() {
    	// 빙산 녹일 때 새롭게 복사 배열 생성
    	copy = new int[R][C];

    	for(int r=0; r<R; r++) {
    		for(int c=0; c<C; c++) {
    			if(map[r][c] != 0) {
    				int tmp = map[r][c];
    				for(int d=0; d<4; d++) {
    					int nr = r + dr[d], nc = c + dc[d];
    					if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) map[r][c]--; 
    				} // for dir
    				copy[r][c] = map[r][c]; // 복사맵에 빙산 녹이고
    				map[r][c] = tmp; // 원래 맵은 다시 복원
    			}
    		}
    	}

    	// 한사이클 돈 후의 배열을 원본 배열에 덮어씌우기
    	for(int r=0; r<R; r++) {
    		for(int c=0; c<C; c++) {
    			// 만약 음수면 0으로
    			if(copy[r][c] < 0) map[r][c] = 0;
    			else map[r][c] = copy[r][c];
    		}
    	}
    } // melt
    
    public static int iceberg() {
    	Queue<int[]> queue = new LinkedList<>();
    	int time = 0; 
    	
    	while(true) {
    		melt(); // 빙산 한 번 녹여
    		int zeroCnt = 0, sumIce = 0;
    		visited = new boolean[R][C]; // 방문 배열 초기화
    		
    		for(int r=0; r<R; r++) {
    			for(int c=0; c<C; c++) {
    				if(map[r][c] == 0) zeroCnt++;
    				
    				else if(!visited[r][c]) { // 0이 아니고 방문하지 않았다면
    					queue.offer(new int[] {r, c});
    					visited[r][c] = true;
    					
    					while(!queue.isEmpty()) {
    						int[] arr = queue.poll();
    						int pr = arr[0], pc = arr[1];
    						
    						for(int d=0; d<4; d++) {
    							int nr = pr + dr[d], nc = pc + dc[d];
    							if(nr >= 0 && nr < R && nc >= 0 && nc < C 
    									&& !visited[nr][nc] && map[nr][nc] != 0) {
    								queue.offer(new int[] {nr, nc});
    								visited[nr][nc] = true;
    							}
    						}
    					} // while queue
    					sumIce++; // 빙산 탐색 끝내고 개수 1개 증가
    				}
    			}
    		}
    		time++;
    		if(zeroCnt == R*C) return 0; // 모두 녹았으면 0
    		else if(sumIce >= 2) return time; // 빙산이 2개 이상으로 나뉘면 time 
    	} // while 
    } // iceberg
} // class