import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, result;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] started;
    static int[] dr = {-1, 0, 1}, dc = {1, 1, 1}; // 오른쪽 위, 오른쪽, 오른쪽 아래
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        started = new boolean[R];
        
        for(int r=0; r<R; r++) {
        	String str = br.readLine();
        	for(int c=0; c<C; c++) {
        		map[r][c] = str.charAt(c);
        	}
        }
        
        result = 0;
        for(int r=0; r<R; r++) {
        	visited[r][0] = true;
        	pipe(r, r, 0);
        }
        
        System.out.println(result);
    } // main

	public static void pipe(int start, int r, int c) {
		
		if(c == C-1) {
			result++;
			started[start] = true;
			return;
		}
		
		for(int d=0; d<3; d++) {
			int nr = r + dr[d], nc = c+ dc[d];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == '.') {
				if(started[start]) return;

				visited[nr][nc] = true;
				pipe(start, nr, nc);
			}
		}
	}
} // class