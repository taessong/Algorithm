class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
        for(int d = 0; d < 4; d++) {
            int nr = h + dr[d];
            int nc = w + dc[d];
            
            if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) continue;
            
            String color = board[h][w];
            if(board[nr][nc].equals(color)) answer++;
        }
        
        return answer;
    }
}