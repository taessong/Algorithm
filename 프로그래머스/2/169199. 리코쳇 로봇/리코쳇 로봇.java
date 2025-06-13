import java.util.*;

class Solution {
    public int solution(String[] board) {
        int result = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length(); j++) {
                if(board[i].charAt(j) == 'R') result = bfs(board, i, j);
            }
        }
        
        return result;
    }
    
    public static int bfs(String[] board, int i, int j) {
        int answer = 0;
        boolean check = false;
        
        int r = board.length;
        int c = board[0].length();
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        
        boolean[][] visited = new boolean[r][c];
        visited[i][j] = true;
        
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
        
        loop: while(!q.isEmpty()) {
            int size = q.size();
            
            for(int qSize = 0; qSize < size; qSize++) {
                int[] now = q.poll();
                
                for(int d = 0; d < 4; d++) {
                    int nr = now[0] + dr[d];
                    int nc = now[1] + dc[d];
                    
                    if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                    
                    while(nr >= 0 && nr < r && nc >= 0 && nc < c && board[nr].charAt(nc) != 'D') {
                        nr += dr[d];
                        nc += dc[d];
                    }
                    
                    nr -= dr[d];
                    nc -= dc[d];
                    
                    if(board[nr].charAt(nc) == 'G') {
                        check = true;
                        break loop;
                    }
                    
                    if(!visited[nr][nc]) {
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            answer++;
        }
        if(check) return answer + 1;
        else return -1;
    }
}